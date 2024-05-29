import java.util.Map;
import java.util.Scanner;

import model.Calculator;
import model.Menu;
import model.Order;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Order order = new Order();
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            menu.showMenu();
            System.out.print("Enter meal name to order or 'done' to finish: ");
            String input = scanner.nextLine();
            if (input.equals("done")) break;

            if (!menu.validateSelection(input)) {
                System.out.println("meal not available. Please re-select.");
                continue;
            }

            System.out.print("Enter quantity for " + input + ": ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            if (quantity <= 0) {
                System.out.println("Invalid quantity. Please re-enter.");
                continue;
            }

            order.add(input, quantity);
        }

        double totalCost = calculator.calculateTotalPaymentWithDiscount(order, menu);
        int totalAmountOfItems = order.getTotalItems();

        if (totalAmountOfItems > 100) {
            System.out.println("Order quantity exceeds maximum limit. Please re-enter.");
            return;
        }

        System.out.println("Your Order:");
        for (Map.Entry<String, Integer> item : order.getOrderedItems().entrySet()) {
            System.out.println(item.getKey() + ": " + item.getValue());
        }

        System.out.println("Total Cost: $" + totalCost);
        System.out.print("Confirm order (yes/no): ");
        String confirmation = scanner.nextLine();

        if (!confirmation.equalsIgnoreCase("yes")) {
            System.out.println("Order canceled.");
            return;
        }

        System.out.println("Order confirmed. Total cost is: $" + totalCost);
        scanner.close();
    }
}