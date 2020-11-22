package com.sms.be.repository.impl;

import com.sms.be.model.Data;
import com.sms.be.model.Page;
import com.sms.be.repository.custom.DataRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataRepositoryImpl implements DataRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Page<Data> getPage(Integer pageNumber, Integer pageSize, String search, String sort, LocalDate fromStartDate, LocalDate toStartDate, LocalDate fromEndDate, LocalDate toEndDate) {

        List<Predicate> listOfPredicate = new ArrayList<>();
        List<Order> orderList = new ArrayList<>();


        CriteriaBuilder criteriaBuilder = entityManager
                .getCriteriaBuilder();
        CriteriaQuery<Data> criteriaQuery = criteriaBuilder.createQuery(Data.class);

        Root<Data> from = criteriaQuery.from(Data.class);


        if (search != null && !search.isEmpty()) {
            Predicate likePredicate = criteriaBuilder.or(
                    criteriaBuilder.like( criteriaBuilder.lower(from.get("city")), "%" + search.toLowerCase() + "%"),
                    criteriaBuilder.like( criteriaBuilder.lower(from.get("color")), "%" + search.toLowerCase() + "%"),
                    criteriaBuilder.like( criteriaBuilder.lower(from.get("status")), "%" + search.toLowerCase() + "%"),
                    criteriaBuilder.like(from.get("price").as(String.class), "%" + search.toLowerCase() + "%")
            );
            listOfPredicate.add(likePredicate);
        }

        if (fromStartDate != null)
            listOfPredicate.add(criteriaBuilder.greaterThanOrEqualTo(from.get("startDate"), fromStartDate));
        if (toStartDate != null)
            listOfPredicate.add(criteriaBuilder.lessThanOrEqualTo(from.get("startDate"), toStartDate));
        if (fromEndDate != null)
            listOfPredicate.add(criteriaBuilder.greaterThanOrEqualTo(from.get("endDate"), fromEndDate));
        if (toEndDate != null)
            listOfPredicate.add(criteriaBuilder.greaterThanOrEqualTo(from.get("endDate"), toEndDate));


        if(sort != null  && !sort.isEmpty()) {
            for (String field : sort.split(",")) {
                Order order;
                if (field.endsWith("-")) {
                    order = criteriaBuilder.desc(from.get(field.replace("-", "").trim()));
                } else {
                    order = criteriaBuilder.asc(from.get(field));
                }

                orderList.add(order);
            }
        }


        CriteriaQuery<Data> select = criteriaQuery.select(from)
                .where(listOfPredicate.toArray(new Predicate[0]))
                .orderBy(orderList);


        TypedQuery<Data> typedQuery = entityManager.createQuery(select);

        int count = typedQuery.getResultList().size();

        typedQuery.setFirstResult((pageNumber - 1) * pageSize);
        typedQuery.setMaxResults(pageSize);

        List<Data> list = typedQuery.getResultList();

        return new Page<>(pageNumber, count, list);
    }
}
