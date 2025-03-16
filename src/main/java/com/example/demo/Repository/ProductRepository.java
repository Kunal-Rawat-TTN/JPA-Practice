package com.example.demo.Repository;

import com.example.demo.Models.Products.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface ProductRepository extends CrudRepository<Product,Long>,PagingAndSortingRepository<Product, Long> {
}
