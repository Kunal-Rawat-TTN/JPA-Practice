package com.example.demo.Models.Customers;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String number;
    String type;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;
}
