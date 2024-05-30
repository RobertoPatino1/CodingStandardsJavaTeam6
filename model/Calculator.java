package model;
import java.util.Map;


public class Calculator {
    private static final  double BASE_COST = 5;

    public double calculateTotalPaymentWithDiscount(Order order, Menu menu) {
        double totalPayment = BASE_COST;
        int totalQuantity = order.getTotalItems();
        for (Map.Entry<String, Integer> item : order.getOrderedItems().entrySet()) {
            totalPayment += menu.getPrice(item.getKey()) * item.getValue();
        }

        double discount = assignDiscount(totalQuantity);
        totalPayment = totalPayment - (totalPayment * discount);
        return totalPayment;
    }

    private double assignDiscount(int totalQuantity){
        double discount = 0;
        if (totalQuantity > 5) {
            discount = 0.1;
        } else if (totalQuantity > 10) {
            discount = 0.2;
        }
        return discount;
    }
}
