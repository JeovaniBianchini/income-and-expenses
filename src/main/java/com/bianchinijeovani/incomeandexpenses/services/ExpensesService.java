package com.bianchinijeovani.incomeandexpenses.services;

import com.bianchinijeovani.incomeandexpenses.dtos.ExpensesDto;
import com.bianchinijeovani.incomeandexpenses.dtos.IncomeDto;
import com.bianchinijeovani.incomeandexpenses.models.Expenses;
import com.bianchinijeovani.incomeandexpenses.models.Income;
import com.bianchinijeovani.incomeandexpenses.repositorys.ExpensesRepository;
import com.bianchinijeovani.incomeandexpenses.repositorys.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ExpensesService {

    @Autowired
    private ExpensesRepository expensesRepository;

    public Expenses save(ExpensesDto dto){
        Expenses expenses = new Expenses();
        expenses.setDescription(dto.getDescription());
        expenses.setValue(dto.getValue());
        expenses.setDate(LocalDate.now());
        return expensesRepository.save(expenses);

    }
}
