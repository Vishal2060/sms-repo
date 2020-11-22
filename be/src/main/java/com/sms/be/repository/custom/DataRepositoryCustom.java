package com.sms.be.repository.custom;

import com.sms.be.model.Data;
import com.sms.be.model.Page;

import java.time.LocalDate;

public interface DataRepositoryCustom {
    Page<Data> getPage(Integer page, Integer size, String search, String sort, LocalDate fromStartDate, LocalDate toStartDate, LocalDate fromEndDate, LocalDate toEndDate);
}
