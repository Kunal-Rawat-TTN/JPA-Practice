package com.example.demo.Models.Customers;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    Set<PhoneNumber> phoneNumbers;

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        if(phoneNumber!=null)
        {
            if(phoneNumbers==null)      phoneNumbers=new HashSet<>();
            phoneNumber.setCustomer(this);
            phoneNumbers.add(phoneNumber);
        }
    }
}
