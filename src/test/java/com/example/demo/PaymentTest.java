package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;


@SpringBootTest
@Rollback(value = false)
public class PaymentTest {

    @Autowired
    PaymentRepository paymentRepository;

    @Test
    void createCreditCardPayment()
    {
        CreditCard creditCard= new CreditCard();
        creditCard.setCardNumber("4y467rjk4y");
        creditCard.setAmount(23.456);
        paymentRepository.save(creditCard);
    }

    @Test
    void createChequePayment()
    {
        Cheque cheque= new Cheque();
        cheque.setChequeNumber("57t5ybnyu84");
        cheque.setAmount(23.456);
        paymentRepository.save(cheque);
    }

}
