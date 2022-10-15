package model.services;

public class PaypalService implements OnlinePaymentService{

    public Double paymentFee(Double amount) {
        Double fee = amount * 0.02;
        return amount + fee;
    }

    public Double interest(Double amount, Integer months) {
        Double installment = amount;
        return amount + (installment * 0.01 * months);
    }
}
