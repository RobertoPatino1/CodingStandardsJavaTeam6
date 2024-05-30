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
        String userInput = "";
        while (!"done".equals(userInput)) {
            menu.showMenu();
            System.out.print("Enter meal name to order or 'done' to finish: ");
            userInput = scanner.nextLine();

            if (!menu.validateSelection(userInput)) {
                System.out.println("meal not available. Please re-select.");
                continue;
            }

            int quantity = Order.getValidQuantity(scanner, userInput);
            if(quantity==-1) continue;

            order.addMeal(userInput, quantity);
        }

        double totalCost = calculator.calculateTotalPaymentWithDiscount(order, menu);
        int totalOrderedItems = order.getTotalItems();
        if (totalOrderedItems > 100) {
            System.out.println("Order quantity exceeds maximum limit. Please re-enter.");
            scanner.close();
            return;
        }

        order.printOrder();

        System.out.println("Total Cost: $" + totalCost);
        System.out.print("Confirm order (yes/no): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("no")) {
            System.out.println("Order canceled.");
            System.out.println(-1);
            return;
        }

        System.out.println("Order confirmed. Total cost is: $" + totalCost);
        scanner.close();
    }
}