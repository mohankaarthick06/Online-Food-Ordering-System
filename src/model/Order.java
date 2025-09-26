package model;
import java.time.LocalDateTime;
import java.util.*;


//class order
public class Order 
{
    private final int id;
    private final Customer customer;
    private final Restaurant restaurant;
    private final List<OrderItem> items = new ArrayList<>();
    private double totalAmount;

    private OrderStatus status;

    private LocalDateTime createdAt;

    // constructor

    public Order(int id, Customer customer, Restaurant restaurant) 
    {
        this.id=id;

        this.customer=customer;

        this.restaurant=restaurant;

        this.status=OrderStatus.PLACED;

        this.createdAt=LocalDateTime.now();
    }

    public int getId()
     { // get id method
         return id;

          }
    public Customer getCustomer()
       {// customer method
        return customer;
    }
    public Restaurant getRestaurant() 
    {
         return restaurant;
     }
    public List<OrderItem> getItems() 
    { 
        return items; 
     }
    public double getTotalAmount() 
    {
         return totalAmount; 
     }

    public OrderStatus getStatus() 
    {    // getstatus method

         return status; 
    }
    
    public void setStatus(OrderStatus status)
     { 
        this.status=status; 
    }

    public void addItem(MenuItem menuItem, int qty)
     {
        if (!menuItem.isAvailable())
         throw new IllegalArgumentException("Item not available");

        items.add(new OrderItem(menuItem, qty));

        recalcTotal();
    }

    private void recalcTotal() 
    {
        totalAmount=items.stream().mapToDouble(OrderItem::getTotal).sum();
    }

    @Override
    public String toString()
     {
        return "Order{"+"id=" + id + ",customer="+customer.getName() +
                ",restaurant="+ restaurant.getName()+",total="+totalAmount +
                ",status=" + status + '}';
    }

    
    public static class OrderItem 
    {
        private final MenuItem menuItem;

        private int quantity;

        public OrderItem(MenuItem menuItem, int quantity)
         {// constructor order item
            this.menuItem=menuItem;

            this.quantity=quantity;
        }

        public MenuItem getMenuItem()
        { 
            return menuItem; 
        }
        public int getQuantity() 
        { 
            return quantity; 
        }
        public double getTotal() 
        { 
            return menuItem.getPrice() * quantity;
         }
    }
  // enum for order status
    public enum OrderStatus 
    {
        PLACED, CONFIRMED, PREPARING, OUT_FOR_DELIVERY, DELIVERED, CANCELLED
    }
}

