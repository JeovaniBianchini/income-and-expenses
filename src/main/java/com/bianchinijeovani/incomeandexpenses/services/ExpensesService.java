package com.bianchinijeovani.incomeandexpenses.services;

import com.bianchinijeovani.incomeandexpenses.config.security.UserServiceDetailsImpl;
import com.bianchinijeovani.incomeandexpenses.dtos.ExpensesDto;
import com.bianchinijeovani.incomeandexpenses.models.Category;
import com.bianchinijeovani.incomeandexpenses.models.Expenses;
import com.bianchinijeovani.incomeandexpenses.models.User;
import com.bianchinijeovani.incomeandexpenses.repositorys.CategoryRepository;
import com.bianchinijeovani.incomeandexpenses.repositorys.ExpensesRepository;
import com.bianchinijeovani.incomeandexpenses.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ExpensesService {


    @Autowired
    private ExpensesRepository expensesRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceDetailsImpl userServiceDetails;


    @Transactional
    public ExpensesDto saveExpenses(ExpensesDto expensesDto, User user) {
        if (expensesDto.getCategory() == null) {
            expensesDto.setCategory(categoryRepository.findByName("Others"));
        }
        Category category = categoryRepository.findByName(expensesDto.getCategory().getName());

        Expenses expenses = new Expenses();
        expenses.setDescription(expensesDto.getDescription());
        expenses.setValue(expensesDto.getValue());
        expenses.setDate(LocalDate.now());
        expenses.setCategory(category);
        expenses.setUser(user);

        expensesRepository.save(expenses);

        ExpensesDto expensesResponse = new ExpensesDto(expenses.getDescription(), expenses.getValue(), expenses.getCategory(), expenses.getUser().getUserName());
        return expensesResponse;
    }

    public List<Expenses> findAllByUser(User user) {

        return expensesRepository.findAllByUser(user);
    }

    public Optional<Expenses> findById(Long id) {
        return expensesRepository.findById(id);
    }

    public Page<Expenses> findAllByDescription(String description, Pageable pageable) {
        return expensesRepository.findAllByDescription(description, pageable);
    }

    @Transactional
    public void delete(Expenses expenses) {
        expensesRepository.delete(expenses);
    }

    public Expenses update(Long id, ExpensesDto expensesDto) {
        Optional<Expenses> expenses = findById(id);

        expenses.get().setDescription(expensesDto.getDescription());
        expenses.get().setValue(expensesDto.getValue());
        expenses.get().setDate(LocalDate.now());
        expenses.get().setCategory(categoryRepository.findByName(expensesDto.getCategory().getName()));

        return expensesRepository.save(expenses.get());
    }

    public boolean existsByDescriptionAndDateBetweenAndUser(String description, LocalDate start, LocalDate end, User user) {
        return expensesRepository.existsByDescriptionAndDateBetweenAndUser(description, start, end, user);
    }

    public String findByDescription(String description) {
        return expensesRepository.findByDescription(description);
    }

    public Page<Expenses> findByDate(int year, int month, Pageable pageable) {

        LocalDate localDate = LocalDate.of(year, month, LocalDate.now().getDayOfMonth());
        return expensesRepository.findByDate(localDate, pageable);
    }

    public Double getTotalValue(LocalDate localDate) {
        return expensesRepository.getTotalValue(localDate);
    }


}
