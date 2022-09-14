package com.bianchinijeovani.incomeandexpenses.repositorys;

import com.bianchinijeovani.incomeandexpenses.models.Income;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface IncomeRepository extends JpaRepository<Income, Long> {

    boolean existsByDescriptionAndDateBetween(String description, LocalDate start, LocalDate end);

    Page<Income> findAllByDescription(String description, Pageable pageable);
}
