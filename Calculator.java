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

            //Asking User For Input

            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();

            //If the Operation  is "/"

            if (operation.equals("/")) {
                while (num2 == 0) {
                    System.out.println();
                    System.out.println("Error: Division by zero is not allowed.");
                    System.out.print("Please enter a non-zero second number: ");
                    num2 = scanner.nextInt();
                }
            }

            //Using Switch and cases for all the operations
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

            //Displaying Output

            System.out.println("The result is: " + result);

            //Giving the User a choice to complete a different operation.

            System.out.print("Would you like to perform another operation (yes/no)? ");
            String choice = scanner.next();

            //If condition to validate the input. 

            if (!choice.equalsIgnoreCase("yes")) {
                keepRunning = false;
                System.out.println("Thank you for using the Java Calculator! Goodbye!");
            }
        }

        scanner.close();
    }
}
