package service;
import model.Order;
import java.util.*;

public class ReportService {
    /* Find top selling items */
    public Map<String,Integer> topSellingItems(Collection<Order> orders, int topN) {
        Map<String,Integer> counts = new HashMap<>();

        for (Order o : orders) {
            if (o.getStatus() == Order.OrderStatus.CANCELLED) continue;
            for (Order.OrderItem oi : o.getItems()) {
                String itemName = oi.getMenuItem().getName();
                counts.put(itemName, counts.getOrDefault(itemName, 0) + oi.getQuantity());
            }
        }

        // Sort by sold quantity (descending)
        List<Map.Entry<String,Integer>> list = new ArrayList<>(counts.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        Map<String,Integer> result = new LinkedHashMap<>();
        for (int i = 0; i < Math.min(topN, list.size()); i++) {
            result.put(list.get(i).getKey(), list.get(i).getValue());
        }

        return result;
    }
}
