package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domains.Product;
import com.kodilla.ecommercee.domains.ProductDto;
import com.kodilla.ecommercee.exceptions.ProductNotFoundException;
import com.kodilla.ecommercee.mappers.ProductMapper;
import com.kodilla.ecommercee.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/products")
public class ProductController {
    @Autowired
    ProductService service;

    @Autowired
    ProductMapper mapper;

    @GetMapping(value = "getProducts")
    public List<ProductDto> getProducts() {
        return mapper.mapToProductDtoList(service.getAllProducts());
    }

    @GetMapping(value = "getProduct")
    public ProductDto getProduct(@RequestParam Long productId) throws ProductNotFoundException {
        return mapper.mapToProductDto(service.findProductById(productId));
    }

    @PostMapping(value = "createProduct")
    public void createProduct(@RequestBody ProductDto productDto) {
        service.saveProduct(mapper.mapToProduct(productDto));
    }

    @PutMapping(value = "updateProduct")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) throws ProductNotFoundException {
        Product updatedProduct = service.updateProduct(mapper.mapToProduct(productDto));
        return mapper.mapToProductDto(updatedProduct);
    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(@RequestParam Long productId) throws ProductNotFoundException {
        service.deleteProductById(productId);
    }
}
