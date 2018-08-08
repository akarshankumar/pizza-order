package com.pizza.order.pizzaorder.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PizzaOrderRepositoryTest {

    @InjectMocks
    PizzaOrderRepository pizzaOrderRepository;

    @Test
    public void getOrderListFromTextFile() {
        assertNull(pizzaOrderRepository.getOrderListFromTextFile(null));
        assertNull(pizzaOrderRepository.getOrderListFromTextFile(""));
    }
}