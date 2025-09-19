package model;
import java.util.*;

public class Restaurant {
    private final int id;
    private String name;
    private String address;
    private final Map<Integer, MenuItem> menu = new HashMap<>();

    public Restaurant(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId()
       { 
          return id; 
    }
    public String getName() 
       { 
          return name; 
    }
    public String getAddress()
       { 
          return address; 
    }
    public Collection<MenuItem> getMenuItems()
      { 
         return menu.values();
     
      }
    public void addMenuItem(MenuItem item) 
       { 
          menu.put(item.getId(), item); 
        }
    public MenuItem getMenuItem(int id) 
        { 
          return menu.get(id); 
        }
    @Override
    public String toString() {
        return "Restaurant{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}


    

 


