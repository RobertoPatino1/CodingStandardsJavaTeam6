package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Order {
    Map<String, Integer> orderedItems;

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

    public void printOrder(){
        System.out.println("Your Order:");
        for (Map.Entry<String, Integer> item : this.getOrderedItems().entrySet()) {
            System.out.println(item.getKey() + ": " + item.getValue());
        }
    }

    public static int getValidQuantity(Scanner scanner, String mealName) {
        System.out.print("Enter quantity for " + mealName + ": ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
    
        if (quantity <= 0 || quantity > 100) {
            System.out.println("Invalid quantity. Please re-enter.");
            return -1;
        }
    
        return quantity;
    }
}