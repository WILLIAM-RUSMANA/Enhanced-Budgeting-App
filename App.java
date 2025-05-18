import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class App {
    private final Scanner scanner = new Scanner(System.in);
    private static final LocalDate today = LocalDate.now();
    private final int[] currentYearMonth = getYearMonth();
    private final ArrayList<Budget> budgets = new ArrayList<>();
    private final ArrayList<Expense> expenses = new ArrayList<>();
    private boolean run = true;
    private String username;

    App(String username) {
        this.username = username;
    }

    public void start() {
        initializeBudgetData();
        initializeExpenseData();
        mainLoop();
    }

    public void initializeBudgetData(){
        Data.addBudgetData(budgets);
    }
    public void initializeExpenseData() { Data.addExpenseData(expenses); }

    private void mainLoop() {
        Budget currentBudget = getCurrentBudget(currentYearMonth[0], currentYearMonth[1]);
        Expense currentExpense = getCurrentExpense(currentYearMonth[0], currentYearMonth[1]);

        printBudget(currentBudget);
        printExpense(currentExpense);

        while (run) {
            System.out.println("Enter a command (addExpense, addBudget, show, exit):");
            String command = scanner.nextLine();

            switch (command) {
                case "add expense":
                    addExpenseCommand();
                    break;
                case "add budget":
                    addBudgetCommand();
                    break;
                case "show":
                    showBudgetsAndExpenses();
                    break;
                case "exit":
                    run = false;
                    System.out.println("Exiting app...");
                    break;
                default:
                    System.out.println("Unknown command!");
            }
        }
    }
    public static int[] getYearMonth() {
        return new int[] {today.getYear(), today.getMonthValue()};
    }

    public void initializeCurrentBudget(double budget) {
        this.budgets.add(new Budget(budget, currentYearMonth[0], currentYearMonth[1]));
    }
    public void initializeCurrentExpense(double expense) {
        this.expenses.add(new Expense(expense, currentYearMonth[0], currentYearMonth[1]));
    }

    public Budget getCurrentBudget(int year, int month){
        for (Budget budget: budgets) {
            if (budget.getYearMonth().equals(year + " " + month)) {
                return budget;
            }
        }
        return null;
    }

    public Expense getCurrentExpense(int year, int month){
        for (Expense expense: expenses) {
            if (expense.getYearMonth().equals(year + " " + month)) {
                return expense;
            }
        }
        return null;
    }

    public void addExpenseCommand() {
    }

    public void addBudgetCommand() {
    }

    public void showBudgetsAndExpenses() {
    }

    private void printBudget(Budget budget) {
        System.out.println("Current Budget: " + budget.getAmount());
    }

    private void printExpense(Expense expense) {
        System.out.println("Current Expense: " + expense.getAmount());
    }
 
}
