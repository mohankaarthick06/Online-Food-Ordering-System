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



        
       