package OOP;

import java.util.ArrayList;
import java.util.Comparator;

public class BudgetSort {
    public static ArrayList<Budget> sort(ArrayList<Budget> budgets) {
        budgets.sort(Comparator
                .comparingInt(Budget::getYear)
                .thenComparingInt(Budget::getMonth));

        return budgets;
    }
}
