package model;

import java.util.HashMap;
import java.util.Map;

class Order {
    Map<String, Integer> orderedItems;

    Order() {
        //this will create a new order
        orderedItems = new HashMap<>();
    }

    void add(String meal, int quantity) {
        orderedItems.put(meal, quantity);
    }

    Map<String, Integer> getOrderedItems() {
        return orderedItems;
    }

    int getTotalItems() {
        int total = 0;
        for (int quantity : orderedItems.values()) {
            total += quantity;
        }
        return total;
    }
}