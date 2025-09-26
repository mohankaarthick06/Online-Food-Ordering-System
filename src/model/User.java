package model;

// abstract base class for all users
public abstract class User
 {// initializing variables
    
    private final int id;
    private String name;                           
    private String email;
    private String password;

    public User(int id, String name, String email, String password) 
    {// constructor for user class

        this.id=id;
        this.name=name;                                              
        this.email=email;
        this.password=password;

    }
     // getter methods (get id)
    public int getId()
      {
         return id;                      
    }

    // get name using getter method
    public String getName()  
      {  
        return name;                       
    }


    public void setName(String name) 
       { 
        this.name = name;
     }


    public String getEmail()
       { 
        return email; 
    }


    public void setEmail(String email)
       { 
        this.email = email; 
    }


     
    public boolean checkPassword(String attempt) 
      { // checking password
        return password.equals(attempt);                     
    }


    protected void setPassword(String newPassword)
     {
        this.password = newPassword;
    }
   
}


// testing commit
