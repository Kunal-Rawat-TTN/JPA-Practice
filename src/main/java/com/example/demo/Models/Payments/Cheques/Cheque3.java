package com.example.demo.Models.Payments.Cheques;

import com.example.demo.Models.Payments.Payment3;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@PrimaryKeyJoinColumn(name = "id")
public class Cheque3 extends Payment3 {
    String chequeNumber;
}
