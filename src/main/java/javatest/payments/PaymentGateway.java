package javatest.payments;

public interface PaymentGateway {
    PaymentsResponse requestPayment(PaymentsRequest request);
}
