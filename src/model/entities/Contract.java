package model.entities;

import java.time.LocalDate;

public class Contract {
    private Integer number;
    private LocalDate date;
    private Double totalValue;
    private  Installment installment;

    public Contract() {
    }

    public Contract(Integer number, LocalDate date, Double totalValue) {
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
    }

    public Contract(Integer number, LocalDate date, Double totalValue,Installment installment) {
        this.installment = installment;
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
    }

    public Integer getContractNumber() {
        return number;
    }

    public void setContractNumber(Integer number) {
        this.number = number;
    }

    public LocalDate getDateContract() {
        return date;
    }

    public void setDateContract(LocalDate date) {
        this.date = date;
    }

    public Double getValue() {
        return totalValue;
    }

    public void setValue(Double totalValue) {
        this.totalValue = totalValue;
    }
}
