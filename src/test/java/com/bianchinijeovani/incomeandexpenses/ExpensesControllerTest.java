package com.bianchinijeovani.incomeandexpenses;


import com.bianchinijeovani.incomeandexpenses.models.Category;
import com.bianchinijeovani.incomeandexpenses.models.Expenses;
import com.bianchinijeovani.incomeandexpenses.repositorys.CategoryRepository;
import com.bianchinijeovani.incomeandexpenses.repositorys.ExpensesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ExpensesControllerTest {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ExpensesRepository expensesRepository;

    @MockBean
    CategoryRepository categoryRepository;

    @BeforeEach
    void up(){
        Category category = new Category();
        category.setName("moradia");
        categoryRepository.save(category);

        Expenses expenses = new Expenses();
        expenses.setDescription("aluguel");
        expenses.setValue(300.00);
        expenses.setDate(LocalDate.now());
        expenses.setCategory(category);
        expensesRepository.save(expenses);
    }



    @Test
    public void expensesTestGetAll() throws Exception {
        mockMvc.perform(get("/expenses"))
                .andExpect(status().isOk());
    }

    @Test
    public void expensesTestSave() throws Exception {
        Category category1 = new Category();
        category1.setName("b");
        categoryRepository.save(category1);

        Expenses expenses1 = new Expenses();
        expenses1.setDescription("b");
        expenses1.setValue(200.00);
        expenses1.setDate(LocalDate.now());
        expenses1.setCategory(category1);
        expensesRepository.save(expenses1);

        mockMvc.perform(post("/expenses")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(expenses1)))
                .andExpect(status().isCreated());
    }

    @Test
    public void expensesTestDelete() throws Exception {
        mockMvc.perform(delete("/expenses/{id}")
                        .content(objectMapper.writeValueAsString(expensesRepository.findById(Long.valueOf(1)))))
                .andExpect(status().isOk());
    }



}
