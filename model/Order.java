package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Order {
    private Map<String, Integer> orderedItems;

    public Order() {
        orderedItems = new HashMap<>();
    }

    public void addMeal(String meal, int quantity) {
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

    public static String getOrderInput(Scanner scanner) {
        System.out.print("Enter meal name to order or 'done' to finish: ");
        return scanner.nextLine();
    }



    public static int getOrderQuantity(Scanner scanner) {
        System.out.print("Enter quantity for the meal: ");
        return scanner.nextInt();
    }


    public static void displayOrderSummary(Order order, double totalCost) {
        System.out.println("Your Order:");
        for (Map.Entry<String, Integer> item : order.getOrderedItems().entrySet()) {
            System.out.println(item.getKey() + ": " + item.getValue());
        }
        System.out.println("Total Cost: $" + totalCost);
    }

    public static int confirmOrder(Scanner input, double totalCost) {
        System.out.print("Confirm order (yes/no): ");
        String confirmation = input.nextLine();


        if (!confirmation.equalsIgnoreCase("yes")) {
            System.out.println("Order canceled.");
            return -1;
        }


        System.out.println("Order confirmed. Total cost is: $" + totalCost);
        return 1;
    }
}