import model.*;
import service.FoodOrderingService;
import util.ReportService;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FoodOrderingService service = new FoodOrderingService();
        ReportService reportService = new ReportService();

        // Register customers
        Customer alice = service.registerCustomer("Alice", "alice@mail.com", "pwd", "Bangalore");
        Customer bob = service.registerCustomer("Bob", "bob@mail.com", "pwd", "Chennai");