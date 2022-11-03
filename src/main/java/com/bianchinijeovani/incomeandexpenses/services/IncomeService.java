package com.bianchinijeovani.incomeandexpenses.services;

import com.bianchinijeovani.incomeandexpenses.dtos.IncomeDto;
import com.bianchinijeovani.incomeandexpenses.models.Income;
import com.bianchinijeovani.incomeandexpenses.repositorys.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Optional;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    @Transactional
    public Income save(IncomeDto incomeDto){

        Income income = new Income();
        income.setDescription(incomeDto.getDescription());
        income.setValue(incomeDto.getValue());
        income.setDate(LocalDate.now());
        return incomeRepository.save(income);

    }

    public List<Income> findAll(){
        return incomeRepository.findAll();
    }

    public Optional<Income> findById(Long id){
        return incomeRepository.findById(id);
    }

    @Transactional
    public void delete(Income income){
        incomeRepository.delete(income);
    }

    public boolean existsByDescriptionAndDateBetween(String description, LocalDate start, LocalDate end) {
        return incomeRepository.existsByDescriptionAndDateBetween(description, start, end);
    }

    public Income update(Long id, IncomeDto incomedto) {
        Optional<Income> income = findById(id);
        income.get().setDescription(incomedto.getDescription());
        income.get().setValue(incomedto.getValue());
        income.get().setDate(LocalDate.now());
        return incomeRepository.save(income.get());
    }

    public Page<Income> findAllByDescription(String description, Pageable pageable) {
        return incomeRepository.findAllByDescription(description, pageable);
    }

    public Page<Income> findByDate(int year, int month,  Pageable pageable){

        LocalDate localDate = LocalDate.of(year, month, LocalDate.now().getDayOfMonth());
        return  incomeRepository.findByDate(localDate, pageable);

    }

    public Double getTotalValue(LocalDate localDate){

        return incomeRepository.getTotalValue(localDate);
    }
}
