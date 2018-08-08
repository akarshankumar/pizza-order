package com.pizza.order.pizzaorder.repository;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Repository
public class PizzaOrderRepository {

    public TreeMap<String, String> getOrderListFromTextFile(String inputPath) {
        TreeMap<String, String> pizzaOrder = new TreeMap<>();

        if (inputPath == null || inputPath.isEmpty()) {
            return null;
        }

        try {

            File f = new File(inputPath);
            if (f.exists() && !f.isDirectory()) {

                List<String> lines = FileUtils.readLines(f, "UTF-8");


                for (int i = 1; i < lines.size(); i++) {
                    if (!lines.get(i).isEmpty()) {
                        String[] line = lines.get(i).replace("\t\t", "\t").split("\t");
                        pizzaOrder.put(line[0], line[1]);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return pizzaOrder;
    }

    public void setOrderList(String outputPath, TreeMap<String, String> orderList) {
        File f = new File(outputPath);
            Map<String, String> header = new HashMap<>();
            header.put("Order", "time");
            try {
                FileUtils.writeStringToFile(f, "Order" + "\t\t" + "time" + "\n", true);

                for(Map.Entry<String,String> entry : orderList.entrySet()) {
                    FileUtils.writeStringToFile(f, entry.getKey() + "\t\t" + entry.getValue() + "\n", true);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
