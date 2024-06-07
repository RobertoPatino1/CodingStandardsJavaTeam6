package model;
import java.util.Map;

public class CostCalculator {
    private static final double BASE_COST = 5;

    public double calculateTotalPayment(Order order, Menu menu) {
        double totalPayment = BASE_COST;
        int totalQuantity = order.getTotalItems();
        for (Map.Entry<String, Integer> item : order.getOrderedItems().entrySet()) {
            totalPayment += menu.getPrice(item.getKey()) * item.getValue();
        }
        double discount = assignDiscount(totalQuantity);
        totalPayment = totalPayment - (totalPayment * discount);

        totalPayment = specialOfferDiscount(totalPayment);

        return totalPayment;
    }

    private double assignDiscount(int totalQuantity) {
        double discount = 0;
        if (totalQuantity > 10) {
            discount = 0.2;
        } else if (totalQuantity > 5) {
            discount = 0.1;
        }
        return discount;
    }

    private double specialOfferDiscount(double totalPayment){
        if (totalPayment > 100) {
            totalPayment -= 25;
        } else if (totalPayment > 50) {
            totalPayment -= 10;
        }
        return totalPayment;
    }
}
