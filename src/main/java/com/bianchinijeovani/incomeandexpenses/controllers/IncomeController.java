package com.bianchinijeovani.incomeandexpenses.controllers;

import com.bianchinijeovani.incomeandexpenses.dtos.IncomeDto;
import com.bianchinijeovani.incomeandexpenses.models.Expenses;
import com.bianchinijeovani.incomeandexpenses.models.Income;
import com.bianchinijeovani.incomeandexpenses.services.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/income")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody  IncomeDto dto){

        if (incomeService.existsByDescriptionAndDateBetween(dto.getDescription(), LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()), LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()))){
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("Income already exist");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(incomeService.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<Income>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(incomeService.findAll());
    }

    @GetMapping(value = "/description")
    public ResponseEntity<Page<Income>> findAllByDescription(@RequestParam(defaultValue = " ") String description, Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(incomeService.findAllByDescription(description, pageable));
    }

    @GetMapping(value = "/{year}/{month}")
    public ResponseEntity<Page<Income>> findByDate(@PathVariable(value = "year") int year, @PathVariable(value = "month") int month, Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(incomeService.findByDate(year, month, pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id")Long id){
        Optional<Income> incomeOptional = incomeService.findById(id);
        if (!incomeOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Income not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(incomeOptional.get());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id")Long id){
        Optional<Income> incomeOptional = incomeService.findById(id);
        if(!incomeOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Income not found");
        }
        incomeService.delete(incomeOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Income deleted successfully");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody IncomeDto incomedto){
        Optional<Income> incomeOptional = incomeService.findById(id);
        if (!incomeOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Income not found");
        }

        Income income = incomeService.update(id, incomedto);
        return ResponseEntity.status(HttpStatus.OK).body(income);

    }
}
