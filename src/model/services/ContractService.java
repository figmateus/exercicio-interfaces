package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDateTime;
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
        Date date = contract.getDateContract();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        PaypalService paypal = new PaypalService();

        for(int i = 0;i<months;i++){
            Double valueInterest = paypal.interest(contract.getValue()/months, i);
            Double totalValue =  + paypal.paymentFee(valueInterest);

            Installment installment = new Installment(date)
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
