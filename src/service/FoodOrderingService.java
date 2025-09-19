package service;

import model.*;
import java.util.*;

public class FoodOrderingService {
    private final Map<Integer, Customer> customers = new HashMap<>();
    private final Map<Integer, Restaurant> restaurants = new HashMap<>();
    private final Map<Integer, Order> orders = new HashMap<>();

    private int customerId = 1;
    private int restaurantId = 1;
    private int menuItemId = 1;
    private int orderId = 1;

    /* Register new customer */
    public Customer registerCustomer(String name, String email, String password, String address) {
        Customer c = new Customer(customerId++, name, email, password, address);
        customers.put(c.getId(), c);
        return c;
    }
     public Restaurant createRestaurant(String name, String address) {
        Restaurant r = new Restaurant(restaurantId++, name, address);
        restaurants.put(r.getId(), r);
        return r;
    }
     public MenuItem addMenuItem(Restaurant r, String name, String desc, double price) {
        MenuItem m = new MenuItem(menuItemId++, name, desc, price);
        r.addMenuItem(m);
        return m;
    }
