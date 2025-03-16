package com.example.demo.Models.Payments;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Payment2 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Double amount;

}
