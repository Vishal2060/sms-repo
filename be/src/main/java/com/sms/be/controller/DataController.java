package com.sms.be.controller;

import com.sms.be.configuration.validation.constraint.ValidDateRange;
import com.sms.be.configuration.validation.constraint.ValidSortFields;
import com.sms.be.model.Data;
import com.sms.be.model.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@RequestMapping("data")
@CrossOrigin
@ResponseBody
@Validated
public interface DataController {

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    Data getEntity(@PathVariable("id") @Positive Integer id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ValidDateRange
    Page<Data> getData(

            @RequestParam(name = "page", defaultValue = "1")
            @Positive
                    Integer pageNumber,

            @RequestParam(name = "size", defaultValue = "10")
            @Min(value = 10)
                    Integer pageSize,

            @RequestParam(name = "search", required = false)
                    String search,

            @RequestParam(name = "sort", required = false)
            @ValidSortFields(message = "Invalid Sort Fields")
                    String sort,

            @RequestParam(name = "fromStartDate", required = false)
            @DateTimeFormat(pattern = "M/d/yyyy")
            @PastOrPresent
                    LocalDate fromStartDate,

            @RequestParam(name = "toStartDate", required = false)
            @DateTimeFormat(pattern = "M/d/yyyy")
            @PastOrPresent
                    LocalDate toStartDate,

            @RequestParam(name = "fromEndDate", required = false)
            @DateTimeFormat(pattern = "M/d/yyyy")
            @PastOrPresent
                    LocalDate fromEndDate,

            @RequestParam(name = "toEndDate", required = false)
            @DateTimeFormat(pattern = "M/d/yyyy")
            @PastOrPresent
                    LocalDate toEndDate
    );

}
