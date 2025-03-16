package com.example.demo;

import com.example.demo.Models.Products.Product;
import com.example.demo.Repository.ProductRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @PersistenceContext
    @Autowired
    private EntityManager entityManager;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    void testingL1Cache()
    {
//        System.out.println("EntityManager HashCode: " + entityManager.hashCode());
//
//        productRepository.findById(1L);  // Hits DB
//        System.out.println("EntityManager HashCode: " + entityManager.hashCode());
//
//        productRepository.findById(1L);  // Should use L1 Cache
//        System.out.println("EntityManager HashCode: " + entityManager.hashCode());
//
//        productRepository.findAll();

//        entityManager.find(Product.class, 1L);  // Hits DB
//        entityManager.find(Product.class, 1L);  // Uses L1 Cache
//        entityManager.find(Product.class, 1L);
        Product newProduct = new Product();
        newProduct.setName("Laptop");
        newProduct.setPrice(1500.00);
        productRepository.save(newProduct);
        System.out.println("EntityManager HashCode: " + entityManager.hashCode());

//        Product product1 = entityManager.find(Product.class, 1L);  // Hits DB
        Product product1 = productRepository.findById(1L).orElseThrow(NullPointerException::new);

        System.out.println("Is product1 managed? " + entityManager.contains(product1));  // Should be true

        Product product2 = productRepository.findById(1L).orElseThrow(NullPointerException::new);
        Product product3 = productRepository.findById(1L).orElseThrow(NullPointerException::new);
//        Product product2 = entityManager.find(Product.class, 1L);  // Should use L1 Cache
//        Product product3 = entityManager.find(Product.class, 1L);  // Should use L1 Cache

        System.out.println("Is product2 managed? " + entityManager.contains(product2));  // Should be true
        System.out.println("Is product3 managed? " + entityManager.contains(product3));  // Should be true

        System.out.println(product1 == product2); // true
        System.out.println(product2 == product3); // true
    }


}
