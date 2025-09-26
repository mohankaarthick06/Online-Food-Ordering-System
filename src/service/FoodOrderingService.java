package service;

import model.*;
import java.util.*;

public class FoodOrderingService 
{
    private final Map<Integer, Customer> customers = new HashMap<>();

    private final Map<Integer, Restaurant> restaurants = new HashMap<>();

    private final Map<Integer, Order> orders = new HashMap<>();

    private int customerId = 1;

    private int restaurantId = 1;

    private int menuItemId = 1;

    private int orderId = 1;

  
    public Customer registerCustomer(String name, String email, String password, String address) 
        {// register customer
           Customer c=new Customer(customerId++, name, email, password, address);
           customers.put(c.getId(), c);
            return c;
       }

  

    public Restaurant createRestaurant(String name, String address)
        {// restaurant creation
        Restaurant r=new Restaurant(restaurantId++, name, address);

        restaurants.put(r.getId(), r);
        return r;
    }

    // adding menu item

    public MenuItem addMenuItem(Restaurant r, String name, String desc, double price) 
    {
        MenuItem m=new MenuItem(menuItemId++, name, desc, price);

        r.addMenuItem(m);
        
        return m;
    }

   
    public Order placeOrder(Customer customer, Restaurant restaurant, Map<Integer, Integer> menuItemIdToQty) 
    {
        Order order=new Order(orderId++, customer, restaurant);

        for (Map.Entry<Integer,Integer> e : menuItemIdToQty.entrySet()) 
          {
            MenuItem mi=restaurant.getMenuItem(e.getKey());
            if (mi != null)
              {
                order.addItem(mi, e.getValue());
            }
        }

        orders.put(order.getId(), order);
        return order;
    }

    // order status updating
    public void updateOrderStatus(Order order, Order.OrderStatus status)
      {
        order.setStatus(status);
    }

   // listing all orders
    public Collection<Order> listAllOrders()
     {
        return orders.values();
    }
}

