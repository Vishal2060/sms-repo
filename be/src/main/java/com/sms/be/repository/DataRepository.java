package com.sms.be.repository;

import com.sms.be.model.Data;
import com.sms.be.repository.custom.DataRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Data, Integer>, DataRepositoryCustom {

}
