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
        Product gazetaProduct = new Product("Dziennik", "gazeta", 10L);
        Product graProduct = new Product("Baldur", "gra", 25L);

        List<Product> listaGazet = new ArrayList<>();
        listaGazet.add(gazetaProduct);

        List<Product> listaGier = new ArrayList<>();
        listaGier.add(graProduct);

        //When
        productRepository.save(gazetaProduct);
        productRepository.save(graProduct);

        long id = gazetaProduct.getId();
        long id2 = graProduct.getId();

        //Then
        Assert.assertNotEquals(0, id);
        Assert.assertNotEquals(0, id2);

        //CleanUp
        productRepository.deleteAll();
    }

    @Test
    public void testReadProduct() {
        //Given
        Product gazetaProduct = new Product("Dziennik", "gazeta", 10L);
        Product graProduct = new Product("Baldur", "gra", 25L);

        List<Product> listaGazet = new ArrayList<>();
        listaGazet.add(gazetaProduct);

        List<Product> listaGier = new ArrayList<>();
        listaGier.add(graProduct);

        //When
        productRepository.save(gazetaProduct);
        productRepository.save(graProduct);

        String description = gazetaProduct.getDescription();
        String description2 = graProduct.getDescription();

        //Then
        Assert.assertEquals("gazeta", description);
        Assert.assertEquals("gra", description2);

        //CleanUp
        productRepository.deleteAll();
    }

    @Test
    public void testUpdateProduct() {
        //Given
        Product gazetaProduct = new Product("Dziennik", "gazeta", 10L);
        productRepository.save(gazetaProduct);
        String oldDescription = gazetaProduct.getDescription();

        //When
        gazetaProduct.setDescription("gazeta2");
        productRepository.save(gazetaProduct);
        String newDescription = gazetaProduct.getDescription();

        //Then
        Assert.assertEquals("gazeta", oldDescription);
        Assert.assertEquals("gazeta2", newDescription);

        //CleanUp
        productRepository.deleteAll();
    }

    @Test
    public void deleteProduct() {
        //Given
        Product gazetaProduct = new Product("Dziennik", "gazeta", 10L);
        Product gazetaProduct2 = new Product("Dziennik2", "gazeta2", 15L);
        Product gazetaProduct3 = new Product("Dziennik3", "gazeta3", 20L);
        productRepository.save(gazetaProduct);
        productRepository.save(gazetaProduct2);
        productRepository.save(gazetaProduct3);
        long currentProducts = productRepository.count();

        System.out.println(currentProducts);
        //When
        productRepository.delete(gazetaProduct3);
        long id = gazetaProduct3.getId();

        long productsAfterDeletion = productRepository.count();

        System.out.println(productsAfterDeletion);
        //Then
        Assert.assertEquals(3, currentProducts);
        Assert.assertEquals(2, productsAfterDeletion);

        //CleanUp
        productRepository.deleteAll();

    }
}