package javatest.payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProcessorTest {

    private PaymentGateway gateway;
    private PaymentProcessor paymentProcessor;

    @Before
    public void setup(){
        this.gateway = Mockito.mock(PaymentGateway.class);
        this.paymentProcessor = new PaymentProcessor(gateway);
    }

    @Test
    public void payment_ok(){
        Mockito.when(gateway.requestPayment(Mockito.any())).thenReturn(new PaymentsResponse(PaymentsResponse.PaymentStatus.OK));

        assertTrue(paymentProcessor.makePayment(1000));
    }

    @Test
    public void payment_error(){
        Mockito.when(gateway.requestPayment(Mockito.any())).thenReturn(new PaymentsResponse(PaymentsResponse.PaymentStatus.ERROR));

        assertFalse(paymentProcessor.makePayment(1000));
    }

}