package com.kodilla.ecommercee.domains;

import com.kodilla.ecommercee.repositories.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void testProductSave() {
        //Given
        Product paperProduct = new Product("Dziennik", "gazeta", 10L);
        Product gameProduct = new Product("Baldur", "gra", 25L);

        List<Product> listPapers = new ArrayList<>();
        listPapers.add(paperProduct);

        List<Product> listGames = new ArrayList<>();
        listGames.add(gameProduct);

        //When
        productRepository.save(paperProduct);
        productRepository.save(gameProduct);

        long id = paperProduct.getId();
        long id2 = gameProduct.getId();

        //Then
        Assert.assertNotEquals(0, id);
        Assert.assertNotEquals(0, id2);

        //CleanUp
        productRepository.deleteAll();
    }

    @Test
    public void testReadProduct() {
        //Given
        Product paperProduct = new Product("Dziennik", "gazeta", 10L);
        Product gameProduct = new Product("Baldur", "gra", 25L);

        List<Product> listPapers = new ArrayList<>();
        listPapers.add(paperProduct);

        List<Product> listGames = new ArrayList<>();
        listGames.add(gameProduct);

        //When
        productRepository.save(paperProduct);
        productRepository.save(gameProduct);

        String description = paperProduct.getDescription();
        String description2 = gameProduct.getDescription();

        //Then
        Assert.assertEquals("gazeta", description);
        Assert.assertEquals("gra", description2);

        //CleanUp
        productRepository.deleteAll();
    }

    @Test
    public void testUpdateProduct() {
        //Given
        Product paperProduct = new Product("Dziennik", "gazeta", 10L);
        productRepository.save(paperProduct);
        String oldDescription = paperProduct.getDescription();

        //When
        paperProduct.setDescription("gazeta2");
        productRepository.save(paperProduct);
        String newDescription = paperProduct.getDescription();

        //Then
        Assert.assertEquals("gazeta", oldDescription);
        Assert.assertEquals("gazeta2", newDescription);

        //CleanUp
        productRepository.deleteAll();
    }

    @Test
    public void deleteProduct() {
        //Given
        Product paperProduct = new Product("Dziennik", "gazeta", 10L);
        Product paperProduct2 = new Product("Dziennik2", "gazeta2", 15L);
        Product paperProduct3 = new Product("Dziennik3", "gazeta3", 20L);
        productRepository.save(paperProduct);
        productRepository.save(paperProduct2);
        productRepository.save(paperProduct3);
        long currentProducts = productRepository.count();

        System.out.println(currentProducts);
        //When
        productRepository.delete(paperProduct3);
        long id = paperProduct3.getId();

        long productsAfterDeletion = productRepository.count();

        System.out.println(productsAfterDeletion);
        //Then
        Assert.assertEquals(3, currentProducts);
        Assert.assertEquals(2, productsAfterDeletion);

        //CleanUp
        productRepository.deleteAll();

    }
}