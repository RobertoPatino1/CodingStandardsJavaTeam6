package model;


import java.util.Map;

class Calculator {
    double baseCost = 5;

    double calc(Order order, Menu menu) {
        double totalCost = baseCost;
        int totalQuantity = order.getTotalItems();

        for (Map.Entry<String, Integer> item : order.getOrderedItems().entrySet()) {
            totalCost += menu.getPrice(item.getKey()) * item.getValue();
        }

        double discount = 0;
        if (totalQuantity > 5) {
            discount = 0.1;
        } else if (totalQuantity > 10) {
            discount = 0.2;
        }

        totalCost = totalCost - (totalCost * discount);

        return totalCost;
    }
}