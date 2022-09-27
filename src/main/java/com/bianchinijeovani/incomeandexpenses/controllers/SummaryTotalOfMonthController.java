package com.bianchinijeovani.incomeandexpenses.controllers;

import com.bianchinijeovani.incomeandexpenses.services.ExpensesService;
import com.bianchinijeovani.incomeandexpenses.services.IncomeService;
import com.bianchinijeovani.incomeandexpenses.services.SummaryTotalOfMonthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/summary")
public class SummaryTotalOfMonthController {

    @Autowired
    private SummaryTotalOfMonthService summaryTotalOfMonthService;




}
