import model.*;
import service.FoodOrderingService;
import service.ReportService;



import java.util.*;



public class Main {
    public static void main(String[] args)
     {
        Scanner sc = new Scanner(System.in);

        FoodOrderingService service = new FoodOrderingService();
        
        ReportService reportService = new ReportService();
        
        Restaurant r1 = service.createRestaurant("Pizza Hut", "Chennai");

        service.addMenuItem(r1, "Margherita Pizza", "Classic cheese pizza", 299);

        service.addMenuItem(r1, "Veggie Burger", "Burger with fresh veggies", 149);

        service.addMenuItem(r1, "Coke", "Cold drink", 49);

        // Register customer
        Customer c1 = service.registerCustomer("Mohan", "1", "1234", "Coimbatore");

        Customer loggedIn = null;

        Order placedOrder = null;

          while (true) 
           {
            System.out.println("\n==== Online Food Ordering ====");

            System.out.println("1. Login as Customer");

            System.out.println("2. Order Items");

            System.out.println("3. Check Order Status");

            System.out.println("4. Show Reports (Top Selling Items)");

            System.out.println("5. Exit");

            System.out.print("Choose: ");

            int choice = sc.nextInt();

            sc.nextLine();

             switch (choice)
               {
                case 1: // login
                    System.out.print("Enter email: ");

                    String email = sc.nextLine();

                    System.out.print("Enter password: ");

                    String pass = sc.nextLine();

                    if (c1.getEmail().equals(email) && c1.checkPassword(pass)) 
                    {
                        loggedIn = c1;
                        System.out.println("Login successful. Welcome " + c1.getName() + "!");
                    } 
                    else
                     {
                        System.out.println("Invalid credentials.");
                    }
                    break;

                case 2: 
                    if(loggedIn == null) 
                    {
                        System.out.println("Please login first!");
                        break;
                    }
                    System.out.println("Menu:");
                    for(MenuItem mi:r1.getMenuItems()) 
                    {
                        System.out.println(mi.getId() + ". " + mi);
                    }
                    Map<Integer,Integer> orderMap = new HashMap<>();
                    while(true)
                    {
                        System.out.print("Enter menu id to add (0 to finish): ");
                        int mid=sc.nextInt();

                        if (mid==0) break;

                        System.out.print("Quantity: ");

                        int qty=sc.nextInt();

                        orderMap.put(mid, qty);
                    }
                    placedOrder=service.placeOrder(loggedIn, r1, orderMap);

                    System.out.println("Order placed: " + placedOrder);
                    break;

                case 3: 
                    if (placedOrder==null)
                     {
                        System.out.println("No order placed yet.");
                    }
                     else
                      {
                        System.out.println("Your order status: " + placedOrder.getStatus());
                        System.out.println("Full details: " + placedOrder);
                    }
                    break;

                case 4: 
                    Map<String,Integer> report = reportService.topSellingItems(service.listAllOrders(), 5);

                    System.out.println("Top Selling Items:");

                    for (Map.Entry<String,Integer> e:report.entrySet()) 
                       {
                        System.out.println(e.getKey() + " -> " + e.getValue() + " sold");
                    }
                    break;

                case 5: 
                        System.out.println("Exiting... Goodbye!");
                        sc.close();
                        return;

                default:
                         System.out.println("Invalid choice."); // default which gives invalid choice
            }
        }
    }
}



        
       