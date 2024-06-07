package model;

import java.util.HashMap;
import java.util.Map;
public class Menu {
    Map<String, Double> products;

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
            String productName = item.getKey();
            double productPrice = item.getValue();
            printMenuLines(productName,productPrice);
        }
    }

    public boolean validateSelection(String selectedProduct) {
        boolean burgerValidation = selectedProduct.equals("Burger");
        boolean pizzaValidation =  selectedProduct.equals("Pizza");
        boolean saladValidation = selectedProduct.equals("Salad");
        boolean pastaValidation = selectedProduct.equals("Pasta");
        return burgerValidation || pizzaValidation || saladValidation || pastaValidation;
    }

    public double getPrice(String selectedProduct) {
        return products.get(selectedProduct);
    }

    private void printMenuLines(String productName, double productPrice){
        System.out.println(productName+": $"+productPrice);
    }
}