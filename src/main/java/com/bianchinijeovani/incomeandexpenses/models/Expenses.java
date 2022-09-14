package com.bianchinijeovani.incomeandexpenses.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import net.bytebuddy.asm.Advice;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;

@Entity
@Table(name = "tb_expenses")
public class Expenses implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "date")
    private LocalDate date;


    @Column(name = "description")
    private String description;
    @Column(name = "value")
    private Double value;
    @Column(name = "category")
    private String category;


    public Expenses(){
    }

    public Expenses(Long id, String description, Double value, LocalDate date, String category) {
        this.id = id;
        this.description = description;
        this.value = value;
        this.date = date;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
