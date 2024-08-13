import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float result = 0; // Initialize result variable

        // Scanner object to capture user input
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the two numbers to operate on:");

        // Getting and validating the first user input
        System.out.println("Enter first number:");
        if (!sc.hasNextFloat()) {  // Ensure the input is a float
            System.out.println("Invalid float, please enter a valid number.");
            return;
        }
        float num1 = sc.nextFloat();

        // Getting and validating the second user input
        System.out.println("Enter second number:");
        if (!sc.hasNextFloat()) {  // Ensure the input is a float
            System.out.println("Invalid float, please enter a valid number.");
            return;
        }
        float num2 = sc.nextFloat();

        System.out.println("Enter the operator to perform calculation. " +
                "Note: only +, -, *, /, and % are allowed:");

        // Getting the operator to determine the calculation
        String operator = sc.next();

        // Perform the calculation based on the operator
        switch (operator) {
            case "+" -> result = num1 + num2;
            case "-" -> result = num1 - num2;
            case "*" -> result = num1 * num2;
            case "/" -> {
                if (num2 == 0) {  // Check for division by zero
                    System.out.println("Cannot divide by zero.");
                    return;
                }
                result = num1 / num2;
            }
            case "%" -> result = num1 % num2;
            default -> {
                // Handle invalid operator input
                System.out.println("You entered an invalid operator.");
                return;
            }
        }

        // Display the result of the calculation
        System.out.println("The result is " + result);
    }
}
