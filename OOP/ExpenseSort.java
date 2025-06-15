package OOP;

import java.util.ArrayList;
import java.util.Comparator;

public class ExpenseSort {
    public static void sort(ArrayList<Expense> expenses) {
        expenses.sort(Comparator
                .comparingInt(Expense::getYear)
                .thenComparingInt(Expense::getMonth)
                .thenComparingInt(Expense::getDate));
    }
}
