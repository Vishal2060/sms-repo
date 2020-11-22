package com.sms.be.service;

import com.sms.be.model.Data;
import com.sms.be.model.Page;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.List;

public interface DataService {
    void saveData(Data data);
    Data getEntity(Integer id);
    Page<Data> getData(Integer pageNumber, Integer pageSize, String search, String sort, LocalDate fromStartDate, LocalDate toStartDate, LocalDate fromEndDate, LocalDate toEndDate);
}
