package javatest.payments;

public class PaymentsResponse {

    enum PaymentStatus {
        OK, ERROR
    }
    private PaymentStatus status;

    public PaymentsResponse(PaymentStatus status) {
        this.status = status;
    }

    public PaymentStatus getStatus() {
        return status;
    }
}
