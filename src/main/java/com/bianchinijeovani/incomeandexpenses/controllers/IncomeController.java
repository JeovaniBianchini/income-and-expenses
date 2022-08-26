package com.bianchinijeovani.incomeandexpenses.controllers;

import com.bianchinijeovani.incomeandexpenses.dtos.IncomeDto;
import com.bianchinijeovani.incomeandexpenses.models.Income;
import com.bianchinijeovani.incomeandexpenses.services.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/income")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody  IncomeDto dto){

        if (incomeService.existsByDescription(dto.getDescription())){
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("Income already exist");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(incomeService.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<Income>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(incomeService.findAll());
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
