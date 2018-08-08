package com.pizza.order.pizzaorder.service;

import com.pizza.order.pizzaorder.repository.PizzaOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.TreeMap;

@Service
public class PizzaOrderService {

    @Value("${data.source}")
    private String dataSource;

    @Autowired
    PizzaOrderRepository pizzaOrderRepository;

    public TreeMap<String, String> getOrderList(String inputPath, String inputType) {
        switch (inputType) {
            case "textfile":
                return pizzaOrderRepository.getOrderListFromTextFile(inputPath);
            default:
                return null;
        }
    }

    public boolean orderPizza(String inputPath, String outputPath) {
        if(inputPath == null || inputPath.isEmpty() && outputPath == null || outputPath.isEmpty()){
            return false;
        }
        TreeMap<String, String> orderList = getOrderList(inputPath, dataSource);
        pizzaOrderRepository.setOrderList(outputPath, orderList);

        return true;
    }
}
