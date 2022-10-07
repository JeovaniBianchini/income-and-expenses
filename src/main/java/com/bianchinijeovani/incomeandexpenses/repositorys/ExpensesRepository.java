package com.bianchinijeovani.incomeandexpenses.repositorys;

import com.bianchinijeovani.incomeandexpenses.models.Expenses;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.YearMonth;

public interface ExpensesRepository extends JpaRepository<Expenses, Long> {

    boolean existsByDescription(String description);


    boolean existsByDateBetween(LocalDate start, LocalDate end);
}
