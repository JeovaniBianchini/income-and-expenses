package com.bianchinijeovani.incomeandexpenses.repositorys;

import com.bianchinijeovani.incomeandexpenses.dtos.CategoryDto;
import com.bianchinijeovani.incomeandexpenses.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long > {

    Category findByName(String name);

    boolean existsByName(String name);

    @Query("SELECT NEW com.bianchinijeovani.incomeandexpenses.dtos.CategoryDto(c.name, SUM(e.value)) FROM Category c INNER JOIN c.expenses e WHERE e.date = :localDate GROUP BY c.name")
    List<CategoryDto> getTotalValueExpenses(@Param("localDate")LocalDate localDate);








}
