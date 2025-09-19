import model.Order;
import java.util.*;

public class ReportService {
    /* Find top selling items */
    public Map<String,Integer> topSellingItems(Collection<Order> orders, int topN) {
        Map<String,Integer> counts = new HashMap<>();
