import model.*;
import service.FoodOrderingService;
import service.ReportService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        FoodOrderingService service = new FoodOrderingService();
        ReportService reportService = new ReportService();

        // Register customers
        Customer alice = service.registerCustomer("Alice", "alice@mail.com", "pwd", "Bangalore");
        
        Customer bob = service.registerCustomer("Bob", "bob@mail.com", "pwd", "Chennai");
        
        Restaurant pizzaHut = service.createRestaurant("Pizza Hut", "Koramangala");
        
        MenuItem margherita = service.addMenuItem(pizzaHut, "Margherita Pizza", "Cheese pizza", 299.0);
        
        MenuItem garlicBread = service.addMenuItem(pizzaHut, "Garlic Bread", "Crispy garlic bread", 99.0);

        // Alice places order
        
        Map<Integer,Integer> cart1 = new HashMap<>();
        
        cart1.put(margherita.getId(), 1);
        
        
        cart1.put(garlicBread.getId(), 2);
        
        Order order1 = service.placeOrder(alice, pizzaHut, cart1);
        
        service.updateOrderStatus(order1, Order.OrderStatus.CONFIRMED);

        // Bob places order
        
        Map<Integer,Integer> cart2 = new HashMap<>();
        
        cart2.put(garlicBread.getId(), 3);
        
        Order order2 = service.placeOrder(bob, pizzaHut, cart2);
        
        service.updateOrderStatus(order2, Order.OrderStatus.DELIVERED);

        // Reports
        
        System.out.println("\nTop selling items:");
        
        Map<String,Integer> top = reportService.topSellingItems(service.listAllOrders(), 5);
        
        top.forEach((item, qty) -> System.out.println(item + " -> sold: " + qty));
    }
}