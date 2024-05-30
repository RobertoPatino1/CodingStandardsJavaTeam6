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


        orderProcess(scanner, menu, order, calculator);


        scanner.close();
    }


    private static void orderProcess(Scanner scanner, Menu menu, Order order, Calculator calculator) {
        while (true) {
            menu.showMenu();
            String input = Order.getOrderInput(scanner);
            if (input.equals("done")) break;


            if (!Order.isValidOrder(menu, input)) {
                System.out.println("Meal not available. Please re-select.");
                continue;
            }


            int quantity = Order.getOrderQuantity(scanner);
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


        Order.displayOrderSummary(order, totalCost);
        Order.confirmOrder(scanner, totalCost);
    }



}