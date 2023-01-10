package javatest.payments;

public class PaymentProcessor {

    private PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public boolean makePayment(double amount){
        PaymentsResponse response = paymentGateway.requestPayment(new PaymentsRequest(amount));
        return response.getStatus() == PaymentsResponse.PaymentStatus.OK;
    }
}
