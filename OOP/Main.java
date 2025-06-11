package OOP;
import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Budget> budgets = new ArrayList<>();
        ArrayList<Expense> expenses = new ArrayList<>();
        ExpenseBuilder builder = new ExpenseBuilder();
//        Data.addBudgetData(budgets);
//        Data.addExpenseData(expenses);
        builder.build(expenses);


        SwingUtilities.invokeLater(() -> new UI(budgets, expenses));
    }
}
