package DataStructure;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDate;

import OOP.Budget;
import OOP.Data;
import OOP.Expense;
import OOP.FinancialItem;

public class MainBackupTerminal {
    static Scanner scanner = new Scanner(System.in);
    static LocalDate today = LocalDate.now();    

    public static void main(String[] args) {
        System.out.println("Welcome to the Budget Management System!");
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Generate Expenses");
            System.out.println("2. Add Expense");
            System.out.println("3. Update Expense");
            System.out.println("4. View Expenses");
            System.out.println("5. sort Expenses");
            System.out.println("6. Search Expenses");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    DS_Methods methods = new DS_Methods();
                    System.out.print("Enter the number of expenses to generate: ");
                    int numExpenses = scanner.nextInt();
                    methods.generateValues(numExpenses);
                    break;

 
                case 2:
                    System.out.println("Select Position to add expense:");
                    System.out.println("1. Beginning of the Data Structures");
                    System.out.println("2. Middle of the Data Structures");
                    System.out.println("3. End of the Data Structures");
                    System.out.print("Enter your choice (1-3): ");
                    int positionChoice = scanner.nextInt();
                    

                    break;

                /*
                case 3:
                    updateExpense();
                    break;
                case 4:
                    viewExpenses();
                    break;
                case 5:
                    sortExpenses();
                    break;
                case 6:
                    searchExpenses();
                    break;
                case 7:
                    System.out.println("Exiting the program. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                */
            }

        }
    }
}

