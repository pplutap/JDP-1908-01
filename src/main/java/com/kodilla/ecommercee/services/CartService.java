package com.kodilla.ecommercee.services;

import com.kodilla.ecommercee.domains.Cart;
import com.kodilla.ecommercee.domains.Order;
import com.kodilla.ecommercee.domains.Product;
import com.kodilla.ecommercee.exceptions.CartNotFoundException;
import com.kodilla.ecommercee.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository repository;

    @Autowired
    private OrderService orderService;

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
        updateCart.setProducts(products);
        repository.save(updateCart);
    }

    public void createOrderByCart(final Order order, final Long id) {
        Cart cartForCreateOrder = repository.findById(id).orElseThrow(CartNotFoundException::new);
        order.setProducts(cartForCreateOrder.getProducts());
        orderService.saveOrder(order);
    }

}
