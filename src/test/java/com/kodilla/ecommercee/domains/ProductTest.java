package com.kodilla.ecommercee.domains;

import com.kodilla.ecommercee.repositories.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void testSaveProduct() {
        //Given
        Product paperProduct = new Product("Dziennik", "gazeta", 10L);
        Product gameProduct = new Product("Baldur", "gra", 25L);

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

        productRepository.save(paperProduct);
        productRepository.save(gameProduct);

        Long idPaper = paperProduct.getId();
        Long idGames = gameProduct.getId();

        //When
        String description = productRepository.findById(idPaper).get().getDescription();
        String description2 = productRepository.findById(idGames).get().getDescription();

        //Then
        Assert.assertEquals("gazeta", description);
        Assert.assertEquals("gra", description2);

        //CleanUp
        //productRepository.deleteAll();
        productRepository.deleteById(idPaper);
        productRepository.deleteById(idGames);
    }

    @Test
    public void testUpdateProduct() {
        //Given
        Product paperProduct = new Product("Dziennik", "gazeta", 10L);
        productRepository.save(paperProduct);

        Long idPaper = paperProduct.getId();
        String oldDescription = productRepository.findById(idPaper).get().getDescription();

        //When
        paperProduct.setDescription("gazeta2");
        productRepository.save(paperProduct);
        String newDescription = productRepository.findById(idPaper).get().getDescription();

        //Then
        Assert.assertEquals("gazeta", oldDescription);
        Assert.assertEquals("gazeta2", newDescription);

        //CleanUp
        //productRepository.deleteAll();
        productRepository.deleteById(idPaper);
    }

    @Test
    public void testDeleteProduct() {
        //Given
        Product paperProduct = new Product("Dziennik", "gazeta", 10L);
        Product paperProduct2 = new Product("Dziennik2", "gazeta2", 15L);
        Product paperProduct3 = new Product("Dziennik3", "gazeta3", 20L);

        productRepository.save(paperProduct);
        productRepository.save(paperProduct2);
        productRepository.save(paperProduct3);

        long productsBeforeDeletion = productRepository.count();

        Long idPaper = paperProduct.getId();
        Long idPaper2 = paperProduct2.getId();

        //When
        productRepository.delete(paperProduct3);
        long productsAfterDeletion = productRepository.count();

        //Then
        Assert.assertEquals(3, productsBeforeDeletion);
        Assert.assertEquals(2, productsAfterDeletion);

        //CleanUp
        productRepository.deleteById(idPaper);
        productRepository.deleteById(idPaper2);
    }
}