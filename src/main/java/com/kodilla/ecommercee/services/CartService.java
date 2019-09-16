package com.kodilla.ecommercee.services;

import com.kodilla.ecommercee.domains.Cart;
import com.kodilla.ecommercee.domains.Order;
import com.kodilla.ecommercee.domains.Product;
import com.kodilla.ecommercee.domains.User;
import com.kodilla.ecommercee.exceptions.CartNotFoundException;
import com.kodilla.ecommercee.repositories.CartRepository;
import com.kodilla.ecommercee.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository repository;

    @Autowired
    private OrderRepository orderRepository;

    public Cart getCart(final Long id) throws CartNotFoundException {
        return repository.findById(id).orElseThrow(CartNotFoundException::new);
    }

    public Cart saveCart(final Cart cart) {
        return repository.save(cart);
    }

    public void deleteCart(final Long id) throws CartNotFoundException {
        Cart deleteCart = getCart(id);
        repository.delete(deleteCart);
    }

    public void addProductsToCart(final List<Product> products, final Long id) throws CartNotFoundException {
        Cart updateCart = repository.findById(id).orElseThrow(CartNotFoundException::new);
        for (Product product : products) {
            updateCart.getProducts().add(product);
        }
        repository.save(updateCart);
    }

    public void createOrderByCart(final Long id) throws CartNotFoundException {
        Cart cartForCreateOrder = repository.findById(id).orElseThrow(CartNotFoundException::new);
        Order order = new Order(cartForCreateOrder.getUser());

        order.setProducts(cartForCreateOrder.getProducts());
        orderRepository.save(order);
    }

}
