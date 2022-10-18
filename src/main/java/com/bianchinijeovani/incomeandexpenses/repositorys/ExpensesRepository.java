package com.bianchinijeovani.incomeandexpenses.repositorys;

import com.bianchinijeovani.incomeandexpenses.models.Category;
import com.bianchinijeovani.incomeandexpenses.models.Expenses;
import com.bianchinijeovani.incomeandexpenses.models.Income;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public interface ExpensesRepository extends JpaRepository<Expenses, Long> {

    boolean existsByDescriptionAndDateBetween(String description, LocalDate start, LocalDate end);

    Page<Expenses> findAllByDescription(String description, Pageable pageable);

    String findByDescription(String description);

    boolean existsByDescription(String description);

    Page<Expenses> findByDate(LocalDate localDate, Pageable pageable);

    @Query("SELECT SUM(m.value) FROM Expenses m WHERE m.date = :localDate")
    Double getTotalValue(@Param("localDate") LocalDate localDate);
}
