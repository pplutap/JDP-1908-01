package com.kodilla.ecommercee.domains;

import com.kodilla.ecommercee.exceptions.ProductNotFoundException;
import com.kodilla.ecommercee.repositories.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductEntityTestSuite {

    @Autowired
    ProductRepository repository;

    @Test
    public void productSaveTest() {
        //Given
        Group groupOne = new Group("test groupOne name");
        Product productOne = new Product("test productOne name", "test productOne description", 10L, groupOne);

        //When
        repository.save(productOne);
        long idProductOne = productOne.getId();

        //Then
        Assert.assertNotEquals(0, idProductOne);

        //CleanUp
        repository.deleteById(idProductOne);
    }

    @Test
    public void productReadTest() throws ProductNotFoundException {
        //Given
        Group groupOne = new Group("test groupOne name");
        Product productOne = new Product("test productOne name", "test productOne description", 10L, groupOne);

        //When
        repository.save(productOne);
        long idProductOne = productOne.getId();

        //Then
        Product resultProductOne = repository.findById(idProductOne).orElseThrow(ProductNotFoundException::new);

        Assert.assertEquals("test productOne description", resultProductOne.getDescription());

        //CleanUp
        repository.deleteById(idProductOne);
    }

    @Test
    public void productUpdateTest() throws ProductNotFoundException {
        //Given
        Group groupOne = new Group("test groupOne name");
        Product productOne = new Product("test productOne name", "test productOne description", 10L, groupOne);

        //When
        repository.save(productOne);
        long idProductOne = productOne.getId();

        Product updateProductOne = repository.findById(idProductOne).orElseThrow(ProductNotFoundException::new);
        updateProductOne.setDescription("test update productOne description");

        repository.save(updateProductOne);
        Product resultProduct = repository.findById(idProductOne).orElseThrow(ProductNotFoundException::new);

        //Then
        Assert.assertEquals("test update productOne description", resultProduct.getDescription());

        //CleanUp
        repository.deleteById(idProductOne);
    }

    @Test
    public void productDeleteTest() {
        //Given
        Group groupOne = new Group("test groupOne name");
        Product productOne = new Product("test productOne name", "test productOne description", 10L, groupOne);

        //When
        repository.save(productOne);
        long idProductOne = productOne.getId();
        long countBeforeDeletionProductOne = repository.count();

        //Then
        repository.deleteById(idProductOne);
        long countAfterDeletionProductOne = repository.count();

        Assert.assertEquals(countBeforeDeletionProductOne - 1, countAfterDeletionProductOne);
    }
}