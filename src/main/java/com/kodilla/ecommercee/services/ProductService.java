package com.kodilla.ecommercee.services;

import com.kodilla.ecommercee.domains.Product;
import com.kodilla.ecommercee.exceptions.ProductNotFoundException;
import com.kodilla.ecommercee.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;


    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product findProductById(Long productId) throws ProductNotFoundException {
        return repository.findById(productId).orElseThrow(ProductNotFoundException::new);
    }

    public void saveProduct(Product product) {
        repository.save(product);
    }

    public Product updateProduct(Product product) throws ProductNotFoundException {
        Product updatedProduct = repository.findById(product.getId()).orElseThrow(ProductNotFoundException::new);
        updatedProduct.setName(product.getName());
        updatedProduct.setDescription(product.getDescription());
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setGroup(product.getGroup());

        return repository.save(product);
    }

    public void deleteProductById(Long productId) throws ProductNotFoundException {
        Product deletedProduct = repository.findById(productId).orElseThrow(ProductNotFoundException::new);
        repository.delete(deletedProduct);
    }
}
