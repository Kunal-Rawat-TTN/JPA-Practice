package com.example.demo.Repository;

import com.example.demo.Models.Payments.Payment2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository2 extends JpaRepository<Payment2, Long> {
}
