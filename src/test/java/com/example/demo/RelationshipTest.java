package com.example.demo;

import com.example.demo.Models.Customers.Customer;
import com.example.demo.Models.Customers.PhoneNumber;
import com.example.demo.Repository.CustomerRepository;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

@SpringBootTest
@Rollback(value = false)
public class RelationshipTest {
    @Autowired
    CustomerRepository customerRepository;

    @Test
    void createCustomer()
    {
        Customer customer=new Customer();
        customer.setName("Kunal Rawat");
//        HashSet<PhoneNumber> phoneNumbers= new HashSet<>();

        PhoneNumber p1= new PhoneNumber();
        p1.setType("cell");
        p1.setNumber("1234567890");
//        p1.setCustomer(customer);
//        phoneNumbers.add(p1);

        PhoneNumber p2= new PhoneNumber();
        p2.setType("home");
        p2.setNumber("0987654321");
//        p2.setCustomer(customer);
//        phoneNumbers.add(p2);

        customer.setPhoneNumber(p1);
        customer.setPhoneNumber(p2);

        customerRepository.save(customer);
    }

    @Test
    @Transactional //it will only bring the required data when query is hit but once phone numbers are fetched then it will bring the phone number
    void fetchData()
    {
//        @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        Customer customer = customerRepository.findById(1L).orElseThrow(NullPointerException::new);
        System.out.println(customer.getName());
        customer.getPhoneNumbers().forEach(phoneNumber -> System.out.println(phoneNumber.getNumber()));

    }

    @Test
    void updateData()
    {
//        @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        Customer customer = customerRepository.findById(1L).orElseThrow(NullPointerException::new);
        //Update Cascading
        customer.setName("Akshat Shrivastva");
        System.out.println(customer.getName());
        customer.getPhoneNumbers().forEach(phoneNumber -> phoneNumber.setType("office"));
        customerRepository.save(customer);

    }

    @Test
    void deleteData()
    {
        customerRepository.deleteById(52L);
    }
}
