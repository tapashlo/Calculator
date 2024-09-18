import java.util.Scanner;

public class Calculator{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;
        double result = 0;

        while (keepRunning) {
            System.out.println();
            System.out.println("Welcome to the Java Calculator!");
            System.out.print("Enter an operation (+, -, *, /, or exit): ");
            String operation = scanner.next();

            if (operation.equals("exit")) {
                System.out.println("Thank you for using the Java Calculator! Goodbye!");
                keepRunning = false;
                continue; //breaks the iteration and goes back to the parent loop
            }

            // Asking User For Input
            double num1 = getValidNumber(scanner, "Enter the first number: ");
            double num2 = getValidNumber(scanner, "Enter the second number: ");

            // If the Operation is "/"
            if (operation.equals("/")) {
                while (num2 == 0) {
                    System.out.println();
                    System.out.println("Error: Division by zero is not allowed.");
                    num2 = getValidNumber(scanner, "Please enter a non-zero second number: ");
                }
            }

            // Using Switch and cases for all the operations
            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("Error: Invalid operation. Please enter a valid operation.");
                    continue;
            }

            // Displaying Output
            System.out.println("The result is: " + result);

            // Giving the User a choice to complete a different operation.
            System.out.print("Would you like to perform another operation (yes/no)? ");
            String choice = scanner.next();

            // If condition to validate the input. 
            if (!choice.equalsIgnoreCase("yes")) {
                keepRunning = false;
                System.out.println("Thank you for using the Java Calculator! Goodbye!");
            }
        }

        scanner.close();
    }

    // Method to get a valid number within the range of -1000 to 1000
    //Creating a method that gets the input from the user withing the limit of MIN and MAX
    
    public static double getValidNumber(Scanner scanner, String prompt) {
        double num;
        final int MIN_RANGE = -1000;
        final int MAX_RANGE = 1000;

        while (true) {
            System.out.print(prompt);
            num = scanner.nextDouble();
            if (num >= MIN_RANGE && num <= MAX_RANGE) {
                break;
            } else {
                System.out.println("Error: Number out of range. Please enter a number between " + MIN_RANGE + " and " + MAX_RANGE);
            }
        }
        return num;
    }
}
