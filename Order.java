class Order {
    Map<String, Integer> var45s;

    Order() {
        //this will create a new order
        var45s = new HashMap<>();
    }

    void add(String var45, int quantity) {
        //this will add the meal and quantity to the order
        var45s.put(var45, quantity);
    }

    HashMap<String, Integer> getvar45s() {
        return var45s;
    }

    int getvar2() {
        int total = 0;
        for (int quantity : var45s.values()) {
            total += quantity;
        }
        return total;
    }
}