package com.bianchinijeovani.incomeandexpenses.services;

import com.bianchinijeovani.incomeandexpenses.dtos.ExpensesDto;
import com.bianchinijeovani.incomeandexpenses.models.Expenses;
import com.bianchinijeovani.incomeandexpenses.repositorys.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class ExpensesService {

    @Autowired
    private ExpensesRepository expensesRepository;

    @Transactional
    public Expenses save(ExpensesDto dto){

        Expenses expenses = new Expenses();
        expenses.setDescription(dto.getDescription());
        expenses.setValue(dto.getValue());
        expenses.setDate(LocalDate.now());
        return expensesRepository.save(expenses);

    }

    public List<Expenses> findAll(){
        return expensesRepository.findAll();
    }

    public Optional<Expenses> findById(Long id){
        return expensesRepository.findById(id);
    }

    @Transactional
    public void delete(Expenses expenses){
        expensesRepository.delete(expenses);
    }

    public Expenses update(Long id, ExpensesDto obj){
        Optional<Expenses> expenses = findById(id);
        expenses.get().setDescription(obj.getDescription());
        expenses.get().setValue(obj.getValue());
        expenses.get().setDate(LocalDate.now());
        return expensesRepository.save(expenses.get());
    }

    public boolean existsByDescription(String description){
        return expensesRepository.existsByDescription(description);
    }

    public boolean existsByDateBetween(LocalDate start, LocalDate end){


        return expensesRepository.existsByDateBetween(start, end);
    }

}
