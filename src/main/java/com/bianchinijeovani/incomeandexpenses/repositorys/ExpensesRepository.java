package com.bianchinijeovani.incomeandexpenses.repositorys;

import com.bianchinijeovani.incomeandexpenses.models.Expenses;
import com.bianchinijeovani.incomeandexpenses.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ExpensesRepository extends JpaRepository<Expenses, Long> {

    boolean existsByDescriptionAndDateBetweenAndUser(String description, LocalDate start, LocalDate end, User user);

    Page<Expenses> findAllByDescription(String description, Pageable pageable);

    String findByDescription(String description);

    boolean existsByDescription(String description);

    Page<Expenses> findByDate(LocalDate localDate, Pageable pageable);

    @Query("SELECT SUM(m.value) FROM Expenses m WHERE m.date = :localDate")
    Double getTotalValue(@Param("localDate") LocalDate localDate);

    List<Expenses> findAllByUser(User user);
}
