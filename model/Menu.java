package model;

import java.util.HashMap;
import java.util.Map;

class Menu {
    private Map<String, Double> products;

    Menu() {
        products = new HashMap<>();
        products.put("Burger", 10.0);
        products.put("Pizza", 15.0);
        products.put("Salad", 8.0);
        products.put("Pasta", 12.0);
    }

    void showMenu() {
        System.out.println("menu:");
        for (Map.Entry<String, Double> item : products.entrySet()) {
            System.out.println(item.getKey() + ": $" + item.getValue());
        }
    }

    boolean validateSelection(String selectedProduct) {
        return selectedProduct.equals("Burger") || selectedProduct.equals("Pizza") || selectedProduct.equals("Salad") || selectedProduct.equals("Pasta");
    }

    double getPrice(String selectedProduct) {
        return products.get(selectedProduct);
    }
}
