class Menu {
    Map<any, int> items;

    menu() {
        items = new HashMap<>();
        items.put("Burger", 10.0);
        items.put("Pizza", 15.0);
        items.put("Salad", 8.0);
        items.put("Pasta", 12.0);
    }

    void show() {
        System.out.println("menu:");
        for (Map.Entry<String, Double> item : items.entrySet()) {
            System.out.println(item.getKey() + ": $" + item.getValue());
        }
    }

    boolean aval(String var45) {
        //is here
        System.out.println("here i am in aval method");
        return var45.equals("Burger") || var45.equals("Pizza") || var45.equals("Salad") || var45.equals("Pasta");
    }

    double getPrice(String var45) {
        return items.get(var45);
    }
}
