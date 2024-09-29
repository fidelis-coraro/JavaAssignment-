package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StockInvestmentStreaks { // Method to find the longest winning streak
    public static List<Integer> longestWinningStreak(int[] returns) {
        List<Integer> longestStreak = new ArrayList<>();List<Integer> currentStreak = new ArrayList<>();

        for (int i = 0; i < returns.length; i++) {if (returns[i] > 0) {currentStreak.add(returns[i]);}
        else {if (currentStreak.size() > longestStreak.size()) {longestStreak = new ArrayList<>(currentStreak);}currentStreak.clear();}  }// Reset current streak
        // Check for the last streak if it ends on a positive value
        if (currentStreak.size() > longestStreak.size()) {longestStreak = currentStreak;}return longestStreak;}

    // Method to find the shortest losing streak
    public static List<Integer> shortestLosingStreak(int[] returns) {
        List<Integer> shortestStreak = null;List<Integer> currentStreak = new ArrayList<>();

        for (int i = 0; i < returns.length; i++) {if (returns[i] < 0) {currentStreak.add(returns[i]);}
        else {if (currentStreak.size() > 0 && (shortestStreak == null || currentStreak.size() < shortestStreak.size())) {shortestStreak = new ArrayList<>(currentStreak);}currentStreak.clear();}} // Reset current streak
        // Check for the last streak if it ends on a negative value
        if (currentStreak.size() > 0 && (shortestStreak == null || currentStreak.size() < shortestStreak.size())) {shortestStreak = currentStreak;}return shortestStreak;}

    // Method to handle input from the user
    public static int[] getInputArray(Scanner scanner) throws InvalidInputException {
        System.out.println("Enter the number of years (length of return array): ");
        int n;try {n = Integer.parseInt(scanner.nextLine());}
         catch (NumberFormatException e) {throw new InvalidInputException("Invalid : Number of years must be an integer.");}

        if (n <= 0) {throw new InvalidInputException("Invalid : The array length must be greater than zero.");}

        int[] returns = new int[n];System.out.println("Enter the returns for " + n + " years:");
        for (int i = 0; i < n; i++) {try {returns[i] = Integer.parseInt(scanner.nextLine());}
        catch (NumberFormatException e) {throw new InvalidInputException("Invalid : Return values must be integers.");}}return returns;}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {// Get the returns array from the user
            int[] returns = getInputArray(scanner);
            // Find the longest winning streak
            List<Integer> winningStreak = longestWinningStreak(returns);
            if (winningStreak.isEmpty()) {System.out.println("No winning streak found.");}
            else {System.out.println("Longest Winning Streak: " + winningStreak);}
            // Find the shortest losing streak
            List<Integer> losingStreak = shortestLosingStreak(returns);
            if (losingStreak == null) {System.out.println("No losing streak found.");}
            else {System.out.println("Shortest Losing Streak: " + losingStreak);}}
        catch (InvalidInputException e) {System.out.println(e.getMessage());}
        finally {scanner.close();}}
}

