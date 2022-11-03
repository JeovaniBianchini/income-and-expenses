package com.bianchinijeovani.incomeandexpenses.dtos;

import com.bianchinijeovani.incomeandexpenses.models.Category;

import java.util.List;
import java.util.List;

public class SummaryTotalOfMonthDto {

    private String totalExpenses;
    private String totalIncomes;
    private String totalFinal;
    private List<CategoryDto> totalByCategorys;

    public SummaryTotalOfMonthDto(){
    }

    public SummaryTotalOfMonthDto(String totalExpenses, String totalIncomes, String totalFinal, List<CategoryDto> totalByCategorys) {
        this.totalExpenses = totalExpenses;
        this.totalIncomes = totalIncomes;
        this.totalFinal = totalFinal;
        this.totalByCategorys = totalByCategorys;
    }

    public String getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(String totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public String getTotalIncomes() {
        return totalIncomes;
    }

    public void setTotalIncomes(String totalIncomes) {
        this.totalIncomes = totalIncomes;
    }

    public String getTotalFinal() {
        return totalFinal;
    }

    public void setTotalFinal(String totalFinal) {
        this.totalFinal = totalFinal;
    }

    public List<CategoryDto> getTotalByCategorys() {
        return totalByCategorys;
    }

    public void setTotalByCategorys(List<CategoryDto> totalByCategorys) {
        this.totalByCategorys = totalByCategorys;
    }
}
