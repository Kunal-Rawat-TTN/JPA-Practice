package com.example.demo;

import com.example.demo.Models.Customers.Customer;
import com.example.demo.Models.Customers.PhoneNumber;
import com.example.demo.Models.Development.Programmer;
import com.example.demo.Models.Development.Project;
import com.example.demo.Repository.CustomerRepository;
import com.example.demo.Repository.ProgrammerRepository;
import com.example.demo.Repository.ProjectRepository;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
@Rollback(value = false)
public class RelationshipTest {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProgrammerRepository programmerRepository;

    @Autowired
    ProjectRepository projectRepository;

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
//    @Transactional //it will only bring the required data when query is hit but once phone numbers are fetched then it will bring the phone number
    void fetchData()
    {
//        @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        Customer customer = customerRepository.findById(1L).orElseThrow(NullPointerException::new);
        System.out.println(customer.getName());
        customer.getPhoneNumbers().forEach(phoneNumber -> System.out.println(phoneNumber.getNumber()));
//        List<Customer> customers = customerRepository.findAll();
//        customers.forEach(customer -> { customer.getPhoneNumbers().forEach(System.out::println);});

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

    @Test
    void saveProgrammerData()
    {
        Programmer programmer=new Programmer();
        programmer.setName("Kunal Rawat");
        programmer.setSalary(127849);

        Programmer programmer2=new Programmer();
        programmer2.setName("Akshat Rawat");
        programmer2.setSalary(38942);

        Programmer programmer3=new Programmer();
        programmer3.setName("Manvi Rawat");
        programmer3.setSalary(92898);

        Project project1= new Project();
        project1.setName("Spring Boot");

        Project project2= new Project();
        project2.setName("JPA");

        Project project3= new Project();
        project3.setName("Restful");

        Set<Project> projects = new HashSet<>(List.of(project1, project2, project3));
        Set<Project> projects2 = new HashSet<>(List.of(project1, project2));
        Set<Project> projects3 = new HashSet<>(List.of(project2, project3));

        programmer.setProjects(projects);

        programmer2.setProjects(projects2);
        programmer3.setProjects(projects3);

        programmerRepository.saveAll(List.of(programmer,programmer2,programmer3));
    }
}
