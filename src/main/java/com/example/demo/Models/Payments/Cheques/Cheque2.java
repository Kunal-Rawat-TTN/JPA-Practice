package com.example.demo.Models.Payments.Cheques;

import com.example.demo.Models.Payments.Payment2;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cheque2 extends Payment2 {
    String chequeNumber;
}
