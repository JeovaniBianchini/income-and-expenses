package com.bianchinijeovani.incomeandexpenses.controllers;

import com.bianchinijeovani.incomeandexpenses.dtos.IncomeDto;
import com.bianchinijeovani.incomeandexpenses.models.Income;
import com.bianchinijeovani.incomeandexpenses.services.IncomeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(value = "/income")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody  IncomeDto dto){

        var income = new Income();
        income.setDescription(dto.getDescription());
        income.setValue(dto.getValue());
        income.setDate(LocalDate.now());

        return ResponseEntity.status(HttpStatus.CREATED).body(incomeService.save(income));
    }

    @GetMapping
    public List<Income> findAll(){
        return incomeService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Income> findById(@PathVariable(value = "id")Long id){
        return incomeService.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id")Long id){
        incomeService.delete(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody IncomeDto dto){
        Optional<Income> incomeOptional = incomeService.findById(id);
        if(!incomeOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
        }

        var income = incomeOptional.get();
        income.setDescription(dto.getDescription());
        income.setValue(dto.getValue());
        income.setDate(LocalDate.now());

        return ResponseEntity.status(HttpStatus.OK).body(incomeService.save(income));
    }
}
