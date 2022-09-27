package com.bianchinijeovani.incomeandexpenses.repositorys;

import com.bianchinijeovani.incomeandexpenses.models.Income;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

public interface IncomeRepository extends JpaRepository<Income, Long> {

    boolean existsByDescriptionAndDateBetween(String description, LocalDate start, LocalDate end);

    Page<Income> findAllByDescription(String description, Pageable pageable);


    Page<Income> findByDate(LocalDate localDate, Pageable pageable);

    List<Income> findAllByDate(LocalDate localDate);



}
