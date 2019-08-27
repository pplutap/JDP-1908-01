package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/v1/products")
public class ProductController {
    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<GenericEntity> getProducts() {
        return new ArrayList<GenericEntity>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProduct")
    public GenericEntity getProduct(@RequestParam Long productId) {
        return new GenericEntity("test");
    }

    @RequestMapping(method = RequestMethod.POST, value = "createProduct")
    public void createProduct(@RequestBody GenericEntity productDto) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateProduct")
    public GenericEntity updateProduct(@RequestBody GenericEntity productDto) {
        return new GenericEntity();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void deleteProduct(@RequestParam Long productId) {
    }
}
