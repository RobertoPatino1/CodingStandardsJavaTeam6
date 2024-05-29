package model;
import java.util.Map;


public class Calculator {
    double baseCost = 5;
    public double calculateTotalPaymentWithDiscount(Order order, Menu menu) {
        double totalPayment = baseCost;
        int totalQuantity = order.getTotalItems();
        double discount = 0;
        for (Map.Entry<String, Integer> item : order.getOrderedItems().entrySet()) {
            totalPayment += menu.getPrice(item.getKey()) * item.getValue();
        }

        if (totalQuantity > 5) {
            discount = 0.1;
        } else if (totalQuantity > 10) {
            discount = 0.2;
        }
        totalPayment = totalPayment - (totalPayment * discount);

        return totalPayment;
    }
}
