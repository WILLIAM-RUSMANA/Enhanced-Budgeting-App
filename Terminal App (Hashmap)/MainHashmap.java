import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainHashmap {
    // initializing different maps to store expenses and budgets
    public static Map<Integer, Value> expenseMap = new HashMap<>();
    public static Map<Integer, Value> budgetMap = new HashMap<>();

    public static void main(String[] args) {
        Methods.addDummyData("expense", 100,expenseMap); // Adding dummy data for expenses
        Methods.addDummyData("budget", 100,budgetMap); // Adding dummy data for budgets

        Scanner scanner = new Scanner(System.in); // Scanner object for user input
        while (true) {
            System.out.println("Welcome to the financial tracker!");
            System.out.println("Choose an option:");
            System.out.println("1. Expense");
            System.out.println("2. Budget");
            System.out.println("3. Exit");

            String mainChoice = scanner.nextLine().trim(); // Read user input for main menu
            // Main menu for choosing between expense and budget
            switch (mainChoice) {
                case "1":
                    expenseMenu(scanner);
                    break;
                case "2":
                    budgetMenu(scanner);
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    public static void expenseMenu(Scanner scanner) {
        // Submenu for expense-related operations

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Expense");
            System.out.println("2. Update Expense");
            System.out.println("3. Delete Expense");
            System.out.println("4. List All Expenses");
            System.out.println("5. Show Total Summary");
            System.out.println("6. Show Monthly Summary");
            System.out.println("7. Sort by Descending Order");
            System.out.println("8. Exit");

            // Handle user input for expense operations
            String choice = scanner.nextLine().trim();

            // Switch case to handle different operations based on user input
            switch (choice) {
                case "1":
                    Methods.handleAddValue("Expense", expenseMap, scanner);
                    break;
                case "2":
                    Methods.handleUpdateValue("Expense", expenseMap, scanner);
                    break;
                case "3":
                    Methods.handleDeleteValue("Expense", expenseMap, scanner);
                    break;
                case "4":
                    Methods.listValues("Expense", expenseMap);
                    break;
                case "5":
                    Methods.showTotalSummary("Expense", expenseMap);
                    break;
                case "6":
                    Methods.showMonthlySummary("Expense", expenseMap);
                    break;
                case "7":
                    Methods.sortByDescendingOrder("Expense", expenseMap);
                    return;
                case "8":
                    System.out.println("Returning to main menu.");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    public static void budgetMenu(Scanner scanner) {
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Budget");
            System.out.println("2. Update Budget");
            System.out.println("3. Delete Budget");
            System.out.println("4. List All Budgets");
            System.out.println("5. Show Total Summary");
            System.out.println("6. Show Monthly Summary");
            System.out.println("7. Sort by Descending Order");
            System.out.println("8. Exit");

            //handle user input for budget operations
            String choice = scanner.nextLine().trim();

            // Switch case to handle different operations based on user input
            switch (choice) {
                case "1":
                    Methods.handleAddValue("Budget", budgetMap, scanner);
                    break;
                case "2":
                    Methods.handleUpdateValue("Budget", budgetMap, scanner);
                    break;
                case "3":
                    Methods.handleDeleteValue("Budget", budgetMap, scanner);
                    break;
                case "4":
                    Methods.listValues("Budget", budgetMap);
                    break;
                case "5":
                    Methods.showTotalSummary("Budget", budgetMap);
                    break;
                case "6":
                    Methods.showMonthlySummary("Budget", budgetMap);
                    break;
                case "7":
                    Methods.sortByDescendingOrder("Budget", budgetMap);
                    return;
                case "8":
                    System.out.println("Returning to main menu.");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
