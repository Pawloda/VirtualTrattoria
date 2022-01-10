package com.damian.virtualtrattoria.repository.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.damian.virtualtrattoria.entity.OrderEntity;
import com.damian.virtualtrattoria.repository.OrderRepository;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {

    @Override
    public OrderEntity createOrder(OrderEntity order) {
        List<OrderEntity> orders = getOrdersFromFile();
        order.setNumber(orders.size() + 1);
        order.setOrderDate(LocalDateTime.now());
        orders.add(order);
        saveOrdersIntoTheFile(orders);
        return order;
    }

    /**
     * It reads previous orders form data file.
     *
     * @return orders put in the list.
     */
    protected List<OrderEntity> getOrdersFromFile() {
        List<OrderEntity> orders = new ArrayList<>();
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/Data.json"));
            orders = gson.fromJson(reader, List.class);
            reader.close();
        } catch(IOException exception) {
            System.out.println("There is no file!");
        }
        return changeNullForEmptyList(orders);
    }

    /**
     * It changes null for empty list if there is no data in the file.
     *
     * @return list with values or empty.
     */
    private List<OrderEntity> changeNullForEmptyList(List<OrderEntity> orders) {
        if(orders == null) {
            orders = new ArrayList<>();
        }
        return orders;
    }

    /**
     * It saves orders in data file or throws exception if there is problem with this file.
     *
     * @param orders with all information.
     */
    protected void saveOrdersIntoTheFile(List<OrderEntity> orders) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Writer writer = Files.newBufferedWriter(Paths.get("src/main/resources/Data.json"));
            gson.toJson(orders, writer);
            writer.close();
        } catch(IOException exception) {
            System.out.println("There is no file!");
        }
    }

}
