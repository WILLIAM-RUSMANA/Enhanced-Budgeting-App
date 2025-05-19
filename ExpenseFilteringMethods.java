import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExpenseFilteringMethods {         
    //make constructor to take in the array of budgets and expenses
    /*public ExpenseFilteringMethods(ArrayList<Budget> budgets, ArrayList<Expense> expenses) {
        this.budgets = budgets;
        this.expenses = expenses;
    }*/ //lowkey, i don't think we need this constructor, but if we do, uncomment it
    
    // Filter methods

    //filter by category
   public ArrayList<Expense> filterByCategory(List<Expense> expenses, String category) {
        ArrayList<Expense> expenseCopy = new ArrayList<>(expenses); // Create a copy of the expenses list
        ArrayList<Expense> filteredExpenses = new ArrayList<>(); // Create a new list to store filtered expenses

        // Sort the expenses by description in ascending order
        Collections.sort(expenses, Comparator.comparing(Expense::getDescription));// Sort the expenses by description

        // Add expenses to the filtered list if they match the category
        for (Expense expense : expenseCopy) {
            if (expense.getDescription().equalsIgnoreCase(category)) {
                filteredExpenses.add(expense);// Add the expense to the filtered list if it matches the category
            }
        }
        return filteredExpenses;// Return the filtered list
    }

    //filter from newest to oldest
    public ArrayList<Expense> filterByDate(List<Expense> expenses, int year, int month, int date) {
        ArrayList<Expense> expensesCopy = new ArrayList<>(expenses); // Create a copy of the expenses list
        ArrayList<Expense> filteredExpenses = new ArrayList<>(); // Create a new list to store filtered expenses

        // Sort the expenses by year, month, and date in descending order
        Collections.sort(expenses, Comparator.comparing(Expense::getYear).reversed()
                    .thenComparing(Expense::getMonth).reversed()
                    .thenComparing(Expense::getDate).reversed());

        // Add expenses to the filtered list if they match the specified year, month, and date
        for (Expense expense : expensesCopy) {
            if (expense.getYear() == year && expense.getMonth() == month) {
                filteredExpenses.add(expense);
            }
        }
        return filteredExpenses;
    }
}
