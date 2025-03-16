package com.example.demo.Models.Payments.CreditCards;

import com.example.demo.Models.Payments.Payment3;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "id")
public class CreditCard3 extends Payment3 {
    String cardNumber;
}
