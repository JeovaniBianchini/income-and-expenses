package com.bianchinijeovani.incomeandexpenses.services;

import com.bianchinijeovani.incomeandexpenses.dtos.IncomeDto;
import com.bianchinijeovani.incomeandexpenses.models.Income;
import com.bianchinijeovani.incomeandexpenses.repositorys.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    @Transactional
    public Income save(Income income){
        return incomeRepository.save(income);

    }

    public List<Income> findAll(){
        return incomeRepository.findAll();
    }

    public Optional<Income> findById(Long id){
        return incomeRepository.findById(id);
    }

    public void delete(Long id) {
        incomeRepository.deleteById(id);
    }

}
