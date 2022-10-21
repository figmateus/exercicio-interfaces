package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class ContractService {

    private Contract contract;
    private Integer months;

    public ContractService() {
    }
    public ContractService(Contract contract, Integer months, OnlinePaymentService paymentService) {
        this.contract = contract;
        this.months = months;
    }
    public void processContract(Contract contract, Integer months){
        LocalDate date = contract.getDateContract();
        LocalDate installmentDate;
        PaypalService paypal = new PaypalService();
        for(int i = 0;i<months;i++){
            installmentDate = date.plusMonths(i+1);
            Double valueInterest = paypal.interest(contract.getValue()/months, i);
            Double totalValue =  + paypal.paymentFee(valueInterest);
            Installment installment = new Installment(installmentDate, totalValue);

            System.out.println("--------PARCELA-"+(i+1)+"-------------");
            System.out.println("DATA DA PARCELA: "+installment.getDueDate());
            System.out.println("VALOR: "+installment.getAmount());
            System.out.println("------------------------------");
        }
    }
    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        this.months = months;
    }
}
