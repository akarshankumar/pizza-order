package com.pizza.order.pizzaorder.service;

import com.pizza.order.pizzaorder.repository.PizzaOrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.TreeMap;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PizzaOrderServiceTest {

    @InjectMocks
    PizzaOrderService pizzaOrderService;

    @Mock
    PizzaOrderRepository pizzaOrderRepository;

    @Test
    public void orderPizza() {
        assertFalse(pizzaOrderService.orderPizza("",""));
        assertFalse(pizzaOrderService.orderPizza(null,null));
        assertTrue( pizzaOrderService.orderPizza("InputPath", "OutputPath"));
        verify(pizzaOrderRepository, times(1)).getOrderListFromTextFile(anyString());
        verify(pizzaOrderRepository, times(1)).setOrderList(anyString(), any(TreeMap.class));
    }

    @Test
    public void getOrderList() {
        pizzaOrderService.getOrderList("InputPath", "textfile");
        verify(pizzaOrderRepository, times(1)).getOrderListFromTextFile(anyString());
    }
}