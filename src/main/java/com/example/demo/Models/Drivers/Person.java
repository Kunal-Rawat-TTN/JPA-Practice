package com.example.demo.Models.Drivers;

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
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String firstName;
    String lastName;
    Integer age;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    License license;


    public Person(String firstName, String lastName, Integer age, License license) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.license = license;
        license.setPerson(this);
    }
}
