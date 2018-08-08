package com.pizza.order.pizzaorder;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.pizza.order.pizzaorder.service.PizzaOrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class PizzaOrderApplication {

	public static void main(String[] args) {
        ApplicationContext context
                = new AnnotationConfigApplicationContext(PizzaOrderApplication.class);

        PizzaOrderService pizzaOrderService = context.getBean(PizzaOrderService.class);

        if(args.length == 2){
            args = new String[]{args[0], args[1]};
            pizzaOrderService.orderPizza(args[0], args[1]);
        } else {
            System.out.println("Invalid Input and output Parameters");
        }

	}
}
