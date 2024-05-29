package model;

import java.util.HashMap;
import java.util.Map;

public class Order {
    Map<String, Integer> orderedItems;

    public Order() {
        orderedItems = new HashMap<>();
    }

    public void add(String meal, int quantity) {
        orderedItems.put(meal, quantity);
    }

    public Map<String, Integer> getOrderedItems() {
        return orderedItems;
    }

    public int getTotalItems() {
        int total = 0;
        for (int quantity : orderedItems.values()) {
            total += quantity;
        }
        return total;
    }
}