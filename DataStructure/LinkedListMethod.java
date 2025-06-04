package DataStructure;

import OOP.Expense;
import java.util.*;

public class LinkedListMethod {

    public void generateExpense(int numValues) {
        UtilityMethod utility = new UtilityMethod();
        LinkedList<Expense> expenseLinkedList = new LinkedList<>();

        // Start timing and memory usage for LinkedList
        System.gc();
        Runtime runtimeLL = Runtime.getRuntime();

        long memoryBeforeLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
        long startTimeLL = System.nanoTime();

        for (int i = 0; i < numValues; i++) {
            expenseLinkedList.add(utility.initialiseExpense()); //generate random expenses in LinkedList
        }

        //end timing and memory usage for LinkedList
        long endTimeLL = System.nanoTime();
        long memoryAfterLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();

        utility.printMemoryUsage("LinkedList", memoryBeforeLL, memoryAfterLL, endTimeLL - startTimeLL);
        utility.printRuntime("LinkedList", startTimeLL, endTimeLL);
    }
    
}
