package com.sms.be.service.impl;

import com.sms.be.model.Data;
import com.sms.be.model.Page;
import com.sms.be.repository.DataRepository;
import com.sms.be.service.DataService;
import lombok.AllArgsConstructor;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class DataServiceImpl implements DataService {

    private final DataRepository dataRepository;

    @Override
    public void saveData(Data data) {
        dataRepository.save(data);
    }

    @Override
    public Data getEntity(Integer id) {
        return dataRepository.findById(id).orElseThrow(() -> new HibernateException("Data Not Found"));
    }

    @Override
    public Page<Data> getData(Integer pageNumber, Integer pageSize, String search, String sort, LocalDate fromStartDate, LocalDate toStartDate, LocalDate fromEndDate, LocalDate toEndDate) {
        return dataRepository.getPage(pageNumber, pageSize, search, sort, fromStartDate, toStartDate, fromEndDate, toEndDate);
    }
}
