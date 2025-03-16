package com.example.demo.Models.Payments;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Payment3 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Double amount;

}
