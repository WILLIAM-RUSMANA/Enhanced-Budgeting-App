import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;



public class MainBackupTerminal {
    static Scanner scanner = new Scanner(System.in);
    static LocalDate today = LocalDate.now();
    static int[] currentYearMonth = getYearMonth();
    static ArrayList<Budget> budgets = new ArrayList<>();
    static ArrayList<Expense> expenses = new ArrayList<>();


    public static void main(String[] args) {
        budgets.add(new Budget(1000, currentYearMonth[0], currentYearMonth[1]));
        Data.addBudgetData(budgets);

        Budget currentBudget = getCurrentBudget(currentYearMonth[0], currentYearMonth[1]);
        Expense currentExpense = getCurrentExpense(currentYearMonth[0], currentYearMonth[1]);

        printBudget(currentBudget);
        printExpense(currentExpense);
        boolean run = true;
        while (run) {
            String command = scanner.nextLine();
        }
        for (Budget budget: budgets) {
            System.out.println(budget.getAmount() + " " + budget.getYearMonth());
        }
    }

    public static Budget newBudget(double budget) {
        return new Budget(budget, currentYearMonth[0], currentYearMonth[1]);
    }

    public static Expense newExpense(double expense) {
        return new Expense(expense, currentYearMonth[0], currentYearMonth[1]);
    }

    // Getters
    public static Budget getCurrentBudget(int year, int month) {
        for (Budget budget: budgets) {
            if (budget.getYearMonth().equals(year + " " + month)) {
                return budget;
            }
        }
        return new Budget(year, month);
    }

    public static Expense getCurrentExpense(int year, int month) {
        for (Expense expense: expenses) {
            if (expense.getYearMonth().equals(year + " " + month)) {
                return expense;
            }
        }
        return new Expense(year, month);
    }

    public static int[] getYearMonth() {
        return new int[] {today.getYear(), today.getMonthValue()};
    }

    // Prints
    public static void printBudget(Budget budget) {
        System.out.println("Current Budget: " + budget.getAmount());
    }

    public static void printExpense(Expense expense) {
        System.out.println("Current Budget: " + expense.getAmount());
    }


}
