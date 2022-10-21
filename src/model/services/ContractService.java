package model.services;

import model.entities.Contract;
import model.entities.Installment;
import java.time.LocalDate;

public class ContractService {

    private Contract contract;
    private Integer months;

    private OnlinePaymentService onlinePaymentService;
    public ContractService() {
    }
    public ContractService(Contract contract, Integer months, OnlinePaymentService paymentService) {
        this.contract = contract;
        this.months = months;
        this.onlinePaymentService = paymentService;
    }
    public void processContract(Contract contract, Integer months){
        LocalDate date = contract.getDateContract();
        LocalDate installmentDate;
        for(int i = 0;i<months;i++){
            installmentDate = date.plusMonths(i+1);
            Double valueInterest = onlinePaymentService.interest(contract.getValue()/months, i);
            Double totalValue =  + onlinePaymentService.paymentFee(valueInterest);
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
