package com.sms.be.controller.impl;

import com.sms.be.controller.DataController;
import com.sms.be.model.Data;
import com.sms.be.model.Page;
import com.sms.be.service.DataService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;

@Controller
@AllArgsConstructor
public class DataControllerImpl implements DataController {

    private final DataService dataService;

    @Override
    public Data getEntity(Integer id) {
        return dataService.getEntity(id);
    }

    @Override
    public Page<Data> getData(Integer pageNumber, Integer pageSize, String search, String sort, LocalDate fromStartDate, LocalDate toStartDate, LocalDate fromEndDate, LocalDate toEndDate) {
        return dataService.getData(pageNumber, pageSize, search, sort, fromStartDate, toStartDate, fromEndDate, toEndDate);
    }
}
