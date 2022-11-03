package com.bianchinijeovani.incomeandexpenses.services;

import com.bianchinijeovani.incomeandexpenses.dtos.CategoryDto;
import com.bianchinijeovani.incomeandexpenses.dtos.SummaryTotalOfMonthDto;
import com.bianchinijeovani.incomeandexpenses.models.Category;
import com.bianchinijeovani.incomeandexpenses.models.Expenses;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SummaryTotalOfMonthService {

    @Autowired
    private IncomeService incomeService;

    @Autowired
    private ExpensesService expensesService;
    
    @Autowired
    private CategoryService categoryService;




    public Object getSummaryTotal(int year, int month) {
        SummaryTotalOfMonthDto summaryTotalOfMonthDto = new SummaryTotalOfMonthDto();

        LocalDate localDate = LocalDate.of(year, month, LocalDate.now().getDayOfMonth());
        Double expenses = expensesService.getTotalValue(localDate);
        Double income = incomeService.getTotalValue(localDate);
        List<CategoryDto> list = categoryService.getTotalValueExpenses(localDate);




        summaryTotalOfMonthDto.setTotalExpenses(String.valueOf(expenses));
        summaryTotalOfMonthDto.setTotalIncomes(String.valueOf(income));
        summaryTotalOfMonthDto.setTotalFinal(String.valueOf(income - expenses));
        summaryTotalOfMonthDto.setTotalByCategorys(list);

        return summaryTotalOfMonthDto;


    }
}
