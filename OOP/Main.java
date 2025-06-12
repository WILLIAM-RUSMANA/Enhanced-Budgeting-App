package OOP;
import java.util.ArrayList;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Budget> budgets = new ArrayList<>();
        ArrayList<Expense> expenses = new ArrayList<>();
        ExpenseBuilder builder = new ExpenseBuilder();
        BudgetBuilder.addBudgetData(budgets);
        builder.build(expenses);


        SwingUtilities.invokeLater(() -> new UI(budgets, expenses));
    }
}
