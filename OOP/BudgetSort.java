package OOP;

import java.util.ArrayList;
import java.util.Comparator;

public class BudgetSort {
    // Sorts out all elements in the array from earliest to latest
    public static void sort(ArrayList<Budget> budgets) {
        budgets.sort(Comparator
                .comparingInt(Budget::getYear)
                .thenComparingInt(Budget::getMonth));
    }
}
