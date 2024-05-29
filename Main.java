public class Main {
    public static void main(String[] args) {
        menu menu = new menu();
        Ord order = new Ord();
        sumThe_Total calculator = new sumThe_Total();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            menu.show();

            System.out.print("Enter meal name to order or 'done' to finish: ");
            String var45 = scanner.nextLine();
            //System.out.println("here i am in main method");
            //this will allow the user to exit the loop
            if (var45.equals("done")) break;

            if (!menu.aval(var45)) {
                System.out.println("meal not available. Please re-select.");
                continue;
            }

            System.out.print("Enter quantity for " + var45 + ": ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (quantity <= 0) {
                System.out.println("Invalid quantity. Please re-enter.");
                continue;
            }

            order.add(var45, quantity);
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