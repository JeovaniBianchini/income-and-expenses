package com.bianchinijeovani.incomeandexpenses.controllers;

import com.bianchinijeovani.incomeandexpenses.config.security.UserServiceDetailsImpl;
import com.bianchinijeovani.incomeandexpenses.dtos.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserServiceDetailsImpl userServiceDetails;


    @PostMapping(value = "/register")
    public ResponseEntity<Object> save(@Valid @RequestBody UserForm userForm){
        return ResponseEntity.status(HttpStatus.CREATED).body(userServiceDetails.save(userForm));
    }





}
