package model;
public class MenuItem {
    private final int id;
    private String name;
    private String description;
    private double price;
    private boolean available;
    

    public MenuItem(int id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.available = true;
      
    }

    public int getId() 
    { 
       return id;
    }
    public String getName()
     { 
        return name;
    }
    public void setName(String name)
     { 
        this.name = name; 
    }
    public String getDescription()
     { 
        return description;
     }
    public void setDescription(String description) 
    { 
        this.description = description;
     }
    public double getPrice() 
    {
         return price; 
        }
    public void setPrice(double price) 
    { 
        this.price = price;
     }
    public boolean isAvailable() 
    {
         return available;
         }
    public void setAvailable(boolean available) 
    { 
        this.available = available;
    }
    
    @Override
    public String toString() {
        return name + " (₹" + price + ")" + (available ? "" : " [Not available]");
    }
}
