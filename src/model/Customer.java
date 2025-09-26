package model;
  // Customer class extending User class
public class Customer extends User
 {

    private String address;

    public Customer(int id, String name, String email, String password, String address)
          {  
        
        // using super keyword to call parent class constructor

           super(id, name, email, password);

            this.address=address;
    }
           // getaadress() method

    public String getAddress() 
        {

             return address;
            
        }
            // setaddress() method 
    public void setAddress(String address)
        { 
            this.address=address; 
        
        }
}

