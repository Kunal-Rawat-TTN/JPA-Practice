package com.example.demo.Models.Payments.CreditCards;

import com.example.demo.Models.Payments.Payment2;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CreditCard2 extends Payment2 {
    String cardNumber;
}
