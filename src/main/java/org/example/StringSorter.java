package org.example;
import java.util.*;
public class StringSorter {
    // Method to validate the input format of the strings
    private static boolean isValidString(String str) {
        return str.matches("[a-zA-Z][0-9]{1,2}");} // String should start with a letter followed by 1 or 2 digits

    // Method to sort the list into L1 based on the first character
    public static List<String> sortL1(List<String> inputList) throws InvalidInputException {
        for (String str : inputList) {
            if (!isValidString(str)) {throw new InvalidInputException("Invalid input format: " + str);}}

        // Sort based on the first character while maintaining original order for same letters
        inputList.sort(Comparator.comparing(s -> s.charAt(0)));
        return inputList;}

    // Method to sort within L1 to generate L2 based on the number part
    public static List<String> sortL2(List<String> inputList) {
        List<String> sortedList = new ArrayList<>();

        // Group the strings by their first character
        Map<Character, List<String>> groupedByLetter = new LinkedHashMap<>();
        for (String str : inputList) {char firstChar = str.charAt(0);
            groupedByLetter.computeIfAbsent(firstChar, k -> new ArrayList<>()).add(str);}

        // Sort each group by the number part in descending order
        for (Map.Entry<Character, List<String>> entry : groupedByLetter.entrySet()) {List<String> group = entry.getValue();
            group.sort((a, b) -> {int numA = Integer.parseInt(a.substring(1));
                int numB = Integer.parseInt(b.substring(1));
                return Integer.compare(numB, numA);  });// Descending order based on the number
            sortedList.addAll(group);}
        return sortedList;}

    // Main method to get user input and process the lists
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the strings: ");
            String input = scanner.nextLine();
            List<String> inputList = new ArrayList<>(Arrays.asList(input.split(",")));
            // Validate and sort to get L1
            List<String> L1 = sortL1(inputList);
            System.out.println("L1 : " + L1);
            // Sort L1 to get L2
            List<String> L2 = sortL2(L1);
            System.out.println("L2 : " + L2);}
        catch (InvalidInputException e) {System.out.println(e.getMessage());}
        finally {scanner.close();}}
}
