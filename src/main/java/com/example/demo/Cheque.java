package com.example.demo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue(value="ch")
@Getter
@Setter
public class Cheque extends Payment {
    String chequeNumber;
}
