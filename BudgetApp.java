import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.InitialContext;

public class BudgetApp {
    private Scanner scanner = new Scanner(System.in);
    private LocalDate today = LocalDate.now();
    private int[] currentYearMonth = getYearMonth();
    private ArrayList<Budget> budgets = new ArrayList<>();
    private ArrayList<Expense> expenses = new ArrayList<>();
    private boolean run = true;

    public void start() {
        initializeData();
        mainLoop();
    }

    public void initializeData(){
        Data.addBudgetData(budgets);
    }

    private void mainLoop() {
        budgets.add(new Budget(1000, currentYearMonth[0], currentYearMonth[1]));
        Data.addBudgetData(budgets);

        Budget currentBudget = getCurrentBudget(currentYearMonth[0], currentYearMonth[1]);
        Expense currentExpense = getCurrentExpense(currentYearMonth[0], currentYearMonth[1]);

        printBudget(currentBudget);
        printExpense(currentExpense);

        while (run) {
            System.out.println("Enter a command (addExpense, addBudget, show, exit):");
            String command = scanner.nextLine();

            switch (command) {
                case "addExpense":
                    addExpenseCommand();
                    break;
                case "addBudget":
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

    private void printBudget(Budget budget) {
        System.out.println("Current Budget: " + budget.getBudget());
    }

    private void printExpense(Expense expense) {
        System.out.println("Current Expense: " + expense.getExpense());
    }
 
}
