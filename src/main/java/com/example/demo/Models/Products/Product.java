package com.example.demo.Models.Products;

import com.example.demo.Address;
import jakarta.persistence.*;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

    private static final Logger log = LoggerFactory.getLogger(Product.class);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

    @Embedded
    private Address address;
    
//    private Weekday weekday;


    @PrePersist
    void someMethod(){
        log.info("Called From PrePersist");
    }
    @PostPersist
    void someMethod1(){
        log.info("Called from PostPersist");
    }
    @PreUpdate
    void someMethod3(){
        log.info("Called from PreUpdate");
    }

    @PostUpdate
    void someMethod4() {
        log.info("Called from PostUpdate");
    }

    @PreRemove
    void someMethod5() {
        log.info("Called from PreRemove");
    }

    @PostRemove
    void someMethod6() {
        log.info("Called from PostRemove");
    }
}
