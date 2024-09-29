package org.example;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
// Custom exception for invalid input
class InvalidInputException extends Exception { public InvalidInputException(String message) {super(message);}}

public class TwoSumSolution { // Method to find and print all distinct pairs that sum up to the target
    public static void findPairs(int[] arr, int target) throws InvalidInputException {
        // Check for bad input (null or array of length less than 2)
        if (arr == null || arr.length < 2) {throw new InvalidInputException("Array must have at least two elements.");}
        // Using a set to store the seen numbers
        Set<Integer> seenNumbers = new HashSet<>();
        boolean found = false;
        // Loop through the array to find pairs
        for (int i = 0; i < arr.length; i++) {int complement = target - arr[i];
            // Check if the complement is already in the set
            if (seenNumbers.contains(complement)) {System.out.println("Pair found: (" + arr[i] + ", " + complement + ")");found = true;}seenNumbers.add(arr[i]);}// Add the current number to the set

        if (!found) {System.out.println("No pairs found that sum to the target.");}}

    // Method to validate the input array and target sum
    public static int[] getInputArray(Scanner scanner) throws InvalidInputException {
        System.out.println("Enter the number of elements in the array: ");
        int n;try {n = Integer.parseInt(scanner.nextLine());}  // Validate if n is an integer
        catch (NumberFormatException e) {throw new InvalidInputException("Invalid input: Number of elements should be an integer.");}

        if (n < 2) {throw new InvalidInputException("Array must have at least two elements.");}

        int[] arr = new int[n];
        System.out.println("Enter " + n + " integers for the array:");

        // Read array elements from the user
        for (int i = 0; i < n; i++) {try {arr[i] = Integer.parseInt(scanner.nextLine());}  // Validate each element as an integer
        catch (NumberFormatException e) {throw new InvalidInputException("Invalid input: Array elements should be integers.");}}
        return arr;}

    // Method to get the target sum from the user
    public static int getTargetSum(Scanner scanner) throws InvalidInputException {System.out.println("Enter the target sum: ");
        try {return Integer.parseInt(scanner.nextLine());}  // Validate if target is an integer
        catch (NumberFormatException e) {throw new InvalidInputException("Invalid input: Target sum should be an integer.");}}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {// Get valid input array and target sum from the user
            int[] arr = getInputArray(scanner);int target = getTargetSum(scanner);findPairs(arr, target);}// Find and display pairs that sum to the target

          catch (InvalidInputException e) {System.out.println(e.getMessage());}  // Print meaningful error message
          finally {scanner.close();}}
}

