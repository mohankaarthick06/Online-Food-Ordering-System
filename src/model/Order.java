

import java.time.LocalDateTime;
import java.util.*;

public class Order {
    private final int id;
    private final Customer customer;
    private final Restaurant restaurant;
    private final List<OrderItem> items = new ArrayList<>();
    private double totalAmount;
    
    private LocalDateTime createdAt;

    public Order(int id, Customer customer, Restaurant restaurant) {
        this.id = id;
        this.customer = customer;
        this.restaurant = restaurant;
    
        this.createdAt = LocalDateTime.now();
    }

    public int getId() { return id; }
    public Customer getCustomer() { return customer; }
    public Restaurant getRestaurant() { return restaurant; }
    public List<OrderItem> getItems() { return items; }
    public double getTotalAmount() { return totalAmount; }
   

    public void addItem(MenuItem menuItem, int qty) {
        if (!menuItem.isAvailable()) throw new IllegalArgumentException("Item not available");
        items.add(new OrderItem(menuItem, qty));
        recalcTotal();
    }

    private void recalcTotal() {
        totalAmount = items.stream().mapToDouble(OrderItem::getTotal).sum();
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", customer=" + customer.getName() +
                ", restaurant=" + restaurant.getName() + ", total=" + totalAmount +
                ", status=" + status + '}';
    }

    /* Nested classes for items and status */
    public static class OrderItem {
        private final MenuItem menuItem;
        private int quantity;

        public OrderItem(MenuItem menuItem, int quantity) {
            this.menuItem = menuItem;
            this.quantity = quantity;
        }

        public MenuItem getMenuItem() { return menuItem; }
        public int getQuantity() { return quantity; }
        public double getTotal() { return menuItem.getPrice() * quantity; }
    }

    public enum OrderStatus {
        PLACED, CONFIRMED, PREPARING, OUT_FOR_DELIVERY, DELIVERED, CANCELLED
    }
}

