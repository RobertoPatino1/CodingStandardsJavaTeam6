import java.util.Scanner;

import model.CostCalculator;
import model.Menu;
import model.Order;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Order order = new Order();
        CostCalculator costCalculator = new CostCalculator();
        Scanner scanner = new Scanner(System.in);

        Order.processOrder(menu, order, scanner);

        if (order.getTotalItems() > 100) {
            System.out.println("Order quantity exceeds maximum limit. Please re-enter.");
            scanner.close();
            return;
        }

        order.printOrder();
        double totalCost = costCalculator.calculateTotalPaymentWithDiscount(order, menu);

        if (!Order.confirmOrder(scanner, totalCost)) {
            System.out.println("Order canceled.");
            System.out.println(-1);
            scanner.close();
            return;
        }

        System.out.println("Order confirmed. Total cost is: $" + totalCost);
        scanner.close();
    }




}
