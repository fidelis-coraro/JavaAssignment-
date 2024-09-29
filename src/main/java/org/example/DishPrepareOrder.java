package org.example;
import java.util.*;

// Custom Exception for invalid order inputs
class InvalidOrderException extends Exception { public InvalidOrderException(String message) {super(message);} }

public class DishPrepareOrder {
    // Method to find the dish preparation order
    public List<Integer> dishPrepareOrder(List<Integer> orderList) throws InvalidOrderException {
        if (orderList == null || orderList.isEmpty()) {throw new InvalidOrderException("Order list cannot be null or empty.");}

        // Valid dish IDs in the restaurant's menu
        Set<Integer> validDishes = new HashSet<>(Arrays.asList(1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009));

        // Map to store the frequency of each dish ordered
        Map<Integer, Integer> dishCountMap = new HashMap<>();

        // Count the number of orders for each dish
        for (int dishId : orderList) {
            if (!validDishes.contains(dishId)) {throw new InvalidOrderException("Invalid dish ID found: " + dishId);}
            dishCountMap.put(dishId, dishCountMap.getOrDefault(dishId, 0) + 1);
        }
        // Create a list from the entry set of the map for sorting
        List<Map.Entry<Integer, Integer>> sortedDishes = new ArrayList<>(dishCountMap.entrySet());

        // Sort the dishes primarily by the number of orders, and by dish ID for dishes with the same number of orders
        sortedDishes.sort((entry1, entry2) -> {int compareOrders = entry2.getValue().compareTo(entry1.getValue()); // Descending order of orders
            if (compareOrders == 0) {return entry1.getKey().compareTo(entry2.getKey());} // Ascending order of dish ID
            return compareOrders;});

        // Prepare the final list of dish IDs in the preparation order
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : sortedDishes) { result.add(entry.getKey());}return result;}

    // Main method to test the dishPrepareOrder method
    public static void main(String[] args) {
        DishPrepareOrder restaurant = new DishPrepareOrder();
        List<Integer> orderList = Arrays.asList(1001, 1002, 1003, 1002, 1001, 1004, 1004, 1005, 1001, 1002);

        try {
            // Fetching the preparation order
            List<Integer> preparationOrder = restaurant.dishPrepareOrder(orderList);

            // Printing the preparation order
            System.out.println("The dishes will be prepared in the following order:");
            for (int dishId : preparationOrder) { System.out.println("Dish ID: " + dishId);}

        } catch (InvalidOrderException e) { System.out.println("Error: " + e.getMessage()); }
    }
}