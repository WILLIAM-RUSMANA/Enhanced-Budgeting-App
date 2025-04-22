import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    static LocalDate today = LocalDate.now();
    static int[] currentYearMonth = getYearMonth();
    static ArrayList<Budget> budgets = new ArrayList<>();
    static ArrayList<Expense> expenses = new ArrayList<>();


    public static void main(String[] args) {
        Budget currentBudget = getCurrentBudget(currentYearMonth[0], currentYearMonth[1]);
        boolean run = true;
        double currentBudgetAmount = currentBudget.getBudget();
        System.out.println("Budget: " + currentBudget.getBudget());
        while (run) {
            String command = scanner.nextLine();
            System.out.println("-->" + command);
        }
    }

    public static Budget newBudget(double budget) {
        return new Budget(budget, currentYearMonth[0], currentYearMonth[1]);
    }

    public static Expense newExpense(double expense) {
        return new Expense(expense, currentYearMonth[0], currentYearMonth[1]);
    }

    public static Budget getCurrentBudget(int year, int month) {
        for (Budget budget: budgets) {
            if (budget.getYearMonth().equals(year + " " + month)) {
                return budget;
            }
        }
        return new Budget(year, month);
    }

    public static int[] getYearMonth() {
        return new int[] {today.getYear(), today.getMonthValue()};
    }
}
