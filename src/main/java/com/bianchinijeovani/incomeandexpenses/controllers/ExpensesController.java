package com.bianchinijeovani.incomeandexpenses.controllers;

import com.bianchinijeovani.incomeandexpenses.dtos.ExpensesDto;
import com.bianchinijeovani.incomeandexpenses.models.Expenses;
import com.bianchinijeovani.incomeandexpenses.services.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/expenses")
public class ExpensesController {

    @Autowired
    private ExpensesService expensesService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody ExpensesDto dto){

        if (expensesService.existsByDescriptionAndDateBetween(dto.getDescription(), LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()), LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()))){
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("Expenses already exist");
        }
        if (dto.getCategory() == null){
            dto.setCategory("others");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(expensesService.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<Expenses>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(expensesService.findAll());
    }

    @GetMapping(value = "/description")
    public ResponseEntity<Page<Expenses>> findAllByDescription(@RequestParam String description, Pageable pageable){

        return ResponseEntity.status(HttpStatus.OK).body(expensesService.findAllByDescription(description, pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id")Long id){
        Optional<Expenses> expensesOptional = expensesService.findById(id);
        if (!expensesOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Expenses not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(expensesOptional.get());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id")Long id){
        Optional<Expenses> expensesOptional = expensesService.findById(id);
        if(!expensesOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Expenses not found");
        }
        expensesService.delete(expensesOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Expenses deleted successfully");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody ExpensesDto dto){
        Optional<Expenses> expensesOptional = expensesService.findById(id);
        if (!expensesOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Expenses not found");
        }

        Expenses expenses = expensesService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(expenses);

    }


}
