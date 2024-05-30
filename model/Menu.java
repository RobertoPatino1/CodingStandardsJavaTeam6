package model;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private Map<String, Double> products;

    public Menu() {
        products = new HashMap<>();
        products.put("Burger", 10.0);
        products.put("Pizza", 15.0);
        products.put("Salad", 8.0);
        products.put("Pasta", 12.0);
    }

    public void showMenu() {
        System.out.println("menu:");
        for (Map.Entry<String, Double> item : products.entrySet()) {
            System.out.println(item.getKey() + ": $" + item.getValue());
        }
    }

    public boolean validateSelection(String selectedProduct) {
        return selectedProduct.equalsIgnoreCase("Burger") || selectedProduct.equalsIgnoreCase("Pizza") || selectedProduct.equalsIgnoreCase("Salad") || selectedProduct.equalsIgnoreCase("Pasta");
    }

    public double getPrice(String selectedProduct) {
        return products.get(selectedProduct);
    }
}
