package com.bianchinijeovani.incomeandexpenses.controllers;

import com.bianchinijeovani.incomeandexpenses.dtos.ExpensesDto;
import com.bianchinijeovani.incomeandexpenses.dtos.UserDto;
import com.bianchinijeovani.incomeandexpenses.dtos.UserForm;
import com.bianchinijeovani.incomeandexpenses.models.Expenses;

import com.bianchinijeovani.incomeandexpenses.models.User;
import com.bianchinijeovani.incomeandexpenses.services.CategoryService;
import com.bianchinijeovani.incomeandexpenses.services.ExpensesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.*;
import java.time.temporal.*;
import java.util.*;

@RestController
@RequestMapping(value = "/expenses")
public class ExpensesController {

    @Autowired
    private ExpensesService expensesService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody ExpensesDto expensesdto, @AuthenticationPrincipal UserDetails user){

        if (expensesService.existsByDescriptionAndDateBetween(expensesdto.getDescription(), LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()), LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()))){
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("Expenses already exist");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(expensesService.save(expensesdto, user));
    }

    @GetMapping
    public ResponseEntity<List<Expenses>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(expensesService.findAll());
    }

    @GetMapping(value = "/description")
    public ResponseEntity<Page<Expenses>> findAllByDescription(@RequestParam String description, Pageable pageable){

        return ResponseEntity.status(HttpStatus.OK).body(expensesService.findAllByDescription(description, pageable));
    }

    @GetMapping(value = "/{year}/{month}")
    public ResponseEntity<Page<Expenses>> findByDate(@PathVariable(value = "year") int year, @PathVariable(value = "month") int month, Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(expensesService.findByDate(year, month, pageable));
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
