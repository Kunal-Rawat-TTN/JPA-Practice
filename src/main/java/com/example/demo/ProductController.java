package com.example.demo;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/page/{pageNo}")
    public List<Product> getAllProducts(@PathVariable Integer pageNo) {
        return productRepository.findAll(PageRequest.of(pageNo, 3)).getContent();
    }


    @GetMapping("/sortAsc")
    public List<Product> getAllProductsAsc() {
        return (List<Product>) productRepository.findAll(Sort.by("id"));
    }

    @GetMapping("/sortAsc2")
    public List<Product> getAllProductsAsc2() {
        return (List<Product>) productRepository.findAll(Sort.by("id").ascending());
    }


    @GetMapping("/sortDesc")
    public List<Product> getAllProductsDesc() {
        return (List<Product>) productRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @GetMapping("/sortDesc2")
    public List<Product> getAllProductsDesc2() {
        return (List<Product>) productRepository.findAll(Sort.by(Sort.Order.desc("id")));
    }


    @GetMapping("/sortDescMul1")
    public List<Product> getAllProductsDescMul1() {
        return (List<Product>) productRepository.findAll(Sort.by(Sort.Direction.DESC, "price", "id"));
    }

    @GetMapping("/sortDescMul2")
    public List<Product> getAllProductsDescMul2() {
        return (List<Product>) productRepository.findAll(Sort.by("price").descending().and(Sort.by("id").descending()));
    }

    @GetMapping("/sortDescMul3")
    public List<Product> getAllProductsDescMul3() {
        return (List<Product>) productRepository.findAll(Sort.by(Sort.Order.desc("price"), Sort.Order.desc("id")));
    }


    @GetMapping("/sortMulDir1")
    public List<Product> getAllProductsDescMulDir1() {
        return (List<Product>) productRepository.findAll(Sort.by(Sort.Order.desc("price"), Sort.Order.asc("id")));
    }

    @GetMapping("/sortMulDir2")
    public List<Product> getAllProductsDescMulDir2() {
        return (List<Product>) productRepository.findAll(Sort.by("price").ascending().and(Sort.by("id").descending()));
    }


    @GetMapping("/sortPage1")
    public List<Product> getAllProductsSortPage1() {
        return productRepository.findAll(PageRequest.of(0, 2, Sort.Direction.DESC, "price", "id")).getContent();
    }

    @GetMapping("/sortPage2")
    public List<Product> getAllProductsSortPage2() {
        return productRepository.findAll(PageRequest.of(0, 2, Sort.by("price")
                .descending()
                .and(Sort.by("id")
                        .descending())))
                .getContent();
    }

    @GetMapping("/sortPage3")
    public List<Product> getAllProductsSortPage3() {
        return productRepository.findAll(PageRequest.of(0, 2, Sort.by(Sort.Order.desc("price"), Sort.Order.desc("id")))).getContent();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        return productRepository.findById(id).map(product -> {
            product.setName(productDetails.getName());
            product.setPrice(productDetails.getPrice());
            return ResponseEntity.ok(productRepository.save(product));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        return productRepository.findById(id).map(product -> {
            productRepository.delete(product);
            return ResponseEntity.ok("Product deleted successfully");
        }).orElse(ResponseEntity.status(404).body("Product not found"));
    }


    //create endpoint
//    {
//        createProduct();
//        Thread.sleep(20000);
//        updateProduct()
//        deleteProd
//
//
//    }


}
/*

List<Author> authors = entityManager.createQuery("SELECT a FROM Author a JOIN FETCH a.books", Author.class).getResultList();

for (Author author : authors) {
        System.out.println("Author: " + author.getName());
        for (Book book : author.getBooks()) {
        System.out.println("  Book: " + book.getTitle());
        }
        }
*/

