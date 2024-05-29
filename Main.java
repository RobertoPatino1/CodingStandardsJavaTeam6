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
            scanner.nextLine(); // Consume newline

            if (quantity <= 0) {
                System.out.println("Invalid quantity. Please re-enter.");
                continue;
            }

            order.add(input, quantity);
        }

        double totalC_ = calculator.calc(order, menu);
        int var2 = order.getvar2();

        if (var2 > 100) {
            System.out.println("Order quantity exceeds maximum limit. Please re-enter.");
            return;
        }

        System.out.println("Your Ord:");
        for (Map.Entry<String, Integer> item : order.getvar45s().entrySet()) {
            System.out.println(item.getKey() + ": " + item.getValue());
        }

        System.out.println("Total Cost: $" + totalC_);
        System.out.print("Confirm order (yes/no): ");
        String confirm = scanner.nextLine();

        if (!confirm.equals("yes") or !confirm.equals("YES")) {
            System.out.println("Order canceled.");
            System.out.println(-1);
            return;
        }

        System.out.println("Order confirmed. Total cost is: $" + totalC_);
    }
}