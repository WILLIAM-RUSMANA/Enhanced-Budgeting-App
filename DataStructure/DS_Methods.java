package DataStructure;

import java.util.*;
import OOP.Expense;


public class DS_Methods {

    public Map<Integer, Expense> expensemap = new HashMap<>();
    public List<Expense> expenseArrayList = new ArrayList<>();
    public List<Expense> expenseLinkedList = new LinkedList<>();
    Scanner sc = new Scanner(System.in);

    // Sample Expense object to be used for generating random expenses
    Expense expense = new Expense(
            50.0 + (Math.random() * 200),  // random amount between 50 and 250
            2024,                         
            (int)(Math.random() * 12) + 1, // random month 1-12
            (int)(Math.random() * 28) + 1, // random day 1-28
            "Some Expense",                     
            "Sample expense " ,     
            "Daily"                      
            );


    /*  Method to generate a map of expenses with random values
        and store them in an ArrayList, LinkedList anf Hashmap.
        The method takes an Integer numValues as input, which specifies the number of Expense objects to generate.
        The method runtime and memory usage for each data structure (HashMap, ArrayList, LinkedList) is measured and printed.
    */

    public void generateValues(Integer numValues) {
        System.out.println("Generated " + numValues + " expense objects in arraylist, linkedlist and hashmap."); 
        
        // Start timing and memory usage for HashMap
        System.gc();
        Runtime runtimeHS = Runtime.getRuntime();
        long memoryBeforeHS = runtimeHS.totalMemory() - runtimeHS.freeMemory();
        long startTimeHS = System.nanoTime();

        for (int i = 0; i < numValues; i++) {expensemap.put(i+1, expense);} //generate random expenses in HashMap

        //end timing and memory usage for HashMap
        long endTimeHS = System.nanoTime();
        long memoryAfterHS = runtimeHS.totalMemory() - runtimeHS.freeMemory();
        long totalMemoryHS = memoryAfterHS - memoryBeforeHS;
        long totalTimeHS = endTimeHS - startTimeHS;

        // Start timing and memory usage for ArrayList
        System.gc();
        Runtime runtimeAL = Runtime.getRuntime();
        long memoryBeforeAL = runtimeAL.totalMemory() - runtimeAL.freeMemory();
        long startTimeAL = System.nanoTime();

        for (int i = 0; i < numValues; i++) {expensemap.put(i+1, expense);} //generate random expenses in ArrayList

        //end timing and memory usage for ArrayList
        long endTimeAL = System.nanoTime();
        long memoryAfterAL = runtimeAL.totalMemory() - runtimeAL.freeMemory();
        long totalMemoryAL = memoryAfterAL - memoryBeforeAL;
        long totalTimeAL = endTimeAL - startTimeAL;

        // Start timing and memory usage for LinkedList
        System.gc();
        Runtime runtimeLL = Runtime.getRuntime();
        long memoryBeforeLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
        long startTimeLL = System.nanoTime();

        for (int i = 0; i < numValues; i++) {expenseLinkedList.add(expense);} //generate random expenses in LinkedList

        //end timing and memory usage for LinkedList
        long endTimeLL = System.nanoTime();
        long memoryAfterLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
        long totalMemoryLL = memoryAfterLL - memoryBeforeLL;
        long totalTimeLL = (endTimeLL - startTimeLL);

        // Print memory and time usage for HashMap
        System.out.println("HashMap Memory Usage: " + totalMemoryHS + " bytes, Time Taken: " + totalTimeHS + " ns");
        System.out.println("ArrayList Memory Usage: " + totalMemoryAL + " bytes, Time Taken: " + totalTimeAL + " ns");
        System.out.println("LinkedList Memory Usage: " + totalMemoryLL + " bytes, Time Taken: " + totalTimeLL + " ns");
    }
    


    // method to add an expense to the map at a specific index
    public void addExpense(Expense exp, Integer index) {

        Integer attempt = 0;
        Integer maxAttempts = expensemap.size()*2; // maximum attempts to find an available index

        try {
            // Index cant be zero or negative
            if (index < 1) {
                throw new Exception("Index must be greater than 0.");
            }

            while(expensemap.containsKey(index)) {
                attempt++;
                if (attempt > maxAttempts) {
                    System.out.println("No available index found after " + maxAttempts + " attempts.");
                }
                index = index + (attempt *attempt); // reselve collison by quadratic probing
            }
            // Add to HashMap
            expensemap.put(index, exp);
            System.out.println("Expense added at index " + index + ": " + exp);

            // Add to ArrayList and LinkedList
            expenseArrayList.add(index, exp);
            expenseLinkedList.add(index, exp);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}

    
