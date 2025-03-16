package com.example.demo.Repository;

import com.example.demo.Models.Payments.Payment3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository3 extends JpaRepository<Payment3, Long> {
}
