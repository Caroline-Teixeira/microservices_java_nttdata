package com.nttdata.microservices.order.service;

import com.nttdata.microservices.order.client.CatalogClient;
import com.nttdata.microservices.order.dto.ProductDTO;
import com.nttdata.microservices.order.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderService {

    private final List<Order> orders = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Autowired
    private CatalogClient catalogClient;

    public List<Order> findAll() {
        return new ArrayList<>(orders); // Retorna uma cópia para evitar modificações diretas
    }

    public Optional<Order> findById(Long id) {
        return orders.stream().filter(order -> order.getId().equals(id)).findFirst();
    }

    public Order createOrder(Order order) {
        // Verifica se o produto existe no catalog-service
        ProductDTO product = catalogClient.getProductById(order.getProductId());
        if (product == null || product.getId() == null) {
            throw new RuntimeException("Produto não encontrado");
        }
        order.setId(idGenerator.getAndIncrement());
        order.setStatus("PENDING"); // Status inicial
        orders.add(order);
        return order;
    }

    public void deleteById(Long id) {
        orders.removeIf(order -> order.getId().equals(id));
    }
}