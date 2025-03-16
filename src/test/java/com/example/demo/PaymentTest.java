package com.example.demo;

import com.example.demo.Models.Payments.Cheques.Cheque;
import com.example.demo.Models.Payments.Cheques.Cheque2;
import com.example.demo.Models.Payments.Cheques.Cheque3;
import com.example.demo.Models.Payments.CreditCards.CreditCard;
import com.example.demo.Models.Payments.CreditCards.CreditCard2;
import com.example.demo.Models.Payments.CreditCards.CreditCard3;
import com.example.demo.Repository.PaymentRepository;
import com.example.demo.Repository.PaymentRepository2;
import com.example.demo.Repository.PaymentRepository3;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;


@SpringBootTest
@Rollback(value = false)
public class PaymentTest {

    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    PaymentRepository2 paymentRepository2;
    @Autowired
    PaymentRepository3 paymentRepository3;

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

    @Test
    void createCreditCardPayment2()
    {
        CreditCard2 creditCard= new CreditCard2();
        creditCard.setCardNumber("4y467rjk4y");
        creditCard.setAmount(23.456);
        paymentRepository2.save(creditCard);
    }

    @Test
    void createChequePayment2()
    {
        Cheque2 cheque= new Cheque2();
        cheque.setChequeNumber("57t5ybnyu84");
        cheque.setAmount(23.456);
        paymentRepository2.save(cheque);
    }

    @Test
    void createCreditCardPayment3()
    {
        CreditCard3 creditCard= new CreditCard3();
        creditCard.setCardNumber("4y467rjk4y");
        creditCard.setAmount(23.456);
        paymentRepository3.save(creditCard);
    }

    @Test
    void createChequePayment3()
    {
        Cheque3 cheque= new Cheque3();
        cheque.setChequeNumber("57t5ybnyu84");
        cheque.setAmount(23.456);
        paymentRepository3.save(cheque);
    }

}
