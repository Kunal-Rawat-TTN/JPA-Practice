package com.example.demo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue(value="cc")
@Getter
@Setter
public class CreditCard extends Payment {
    String cardNumber;
}
