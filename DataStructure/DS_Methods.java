package DataStructure;

import java.util.*;
import OOP.Expense;


public class DS_Methods {

    public Map<Integer, Expense> expenseHashMap = new HashMap<>();
    public List<Expense> expenseArrayList = new ArrayList<>();
    public List<Expense> expenseLinkedList = new LinkedList<>();
    //ToDo: BST implementation by will
    // 

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
    


    // method to add an expense to the map at a specific index
    public void addExpense(int positionChoice) {

        try {
            switch (positionChoice) {
                // Add expense at the beginning of the data structures
                case 1:
                    System.out.println("Adding expense at the beginning of the data structures.");

                    // calculate the memory and time taken for HashMap
                    System.gc();
                    Runtime runtimeHS = Runtime.getRuntime();
                    long memoryBeforeHS = runtimeHS.totalMemory() - runtimeHS.freeMemory();
                    long startTimeHS = System.nanoTime();

                    //increment keys in the HashMap by 1 to make space for the new expense
                    for (Map.Entry<Integer, Expense> entry : expenseHashMapCopy.entrySet()) {
                        expenseHashMap.put(entry.getKey() + 1, entry.getValue());
                    }
                    expenseHashMapCopy.put(1, addedExpense); 

                    long endTimeHS = System.nanoTime();
                    long memoryAfterHS = runtimeHS.totalMemory() - runtimeHS.freeMemory();
                    long totalMemoryHS = memoryAfterHS - memoryBeforeHS;
                    long totalTimeHS = endTimeHS - startTimeHS;

                    // calculate the memory and time taken for Arryalist
                    System.gc();
                    Runtime runtimeAL = Runtime.getRuntime();
                    long memoryBeforeAL = runtimeAL.totalMemory() - runtimeAL.freeMemory();
                    long startTimeAL = System.nanoTime();

                    expenseArrayList.add(0, addedExpense); // add expense at the beginning of the ArrayList
            
                    long endTimeAL = System.nanoTime();
                    long memoryAfterAL = runtimeAL.totalMemory() - runtimeAL.freeMemory();
                    long totalMemoryAL = memoryAfterAL - memoryBeforeAL;
                    long totalTimeAL = endTimeAL - startTimeAL;

                    // calculate the memory and time taken for LinkedList
                    System.gc();
                    Runtime runtimeLL = Runtime.getRuntime();
                    long memoryBeforeLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
                    long startTimeLL = System.nanoTime();

                    expenseLinkedList.add(0, addedExpense);

                    long endTimeLL = System.nanoTime();
                    long memoryAfterLL = runtimeLL.totalMemory() - runtimeLL.freeMemory();
                    long totalMemoryLL = memoryAfterLL - memoryBeforeLL;
                    long totalTimeLL = endTimeLL - startTimeLL;

                    // Print the results
                    System.out.println("Expense added at the beginning of the data structures.");
                    System.out.println("HashMap Memory Usage: " + totalMemoryHS + " bytes, Time Taken: " + totalTimeHS + " ns");
                    System.out.println("ArrayList Memory Usage: " + totalMemoryAL + " bytes, Time Taken: " + totalTimeAL + " ns");
                    System.out.println("LinkedList Memory Usage: " + totalMemoryLL + " bytes, Time Taken: " + totalTimeLL + " ns");
                    break;

                case 2:
                    System.out.println("Adding expense at the middle of the data structures.");

                    int middleiNdexAL = expenseArrayList.size() / 2;
                    int middleIndexLL = expenseLinkedList.size() / 2;
                    int middleIndexHS = expenseHashMap.size() / 2;

                    // calculate the memory and time taken for HashMap
                    System.gc();
                    Runtime runtimeHSMid = Runtime.getRuntime();
                    long memoryBeforeHSMid = runtimeHSMid.totalMemory() - runtimeHSMid.freeMemory();
                    long startTimeHSMid = System.nanoTime();

                    //increment keys in the HashMap by 1 to make space for the new expense
                    for (int i = expenseHashMap.size()-1 ; i >= expenseHashMap.size()/2; i--) {
                        expenseHashMap.put(entry.getKey() + 1, entry.getValue());
                    }
                    expenseHashMapCopy.put(1, addedExpense); 

                    long endTimeHSMid = System.nanoTime();
                    long memoryAfterHSMid = runtimeHSMid.totalMemory() - runtimeHSMid.freeMemory();
                    long totalMemoryHSMid = memoryAfterHSMid - memoryBeforeHSMid;
                    long totalTimeHSMid = endTimeHSMid - startTimeHSMid;

                    // calculate the memory and time taken for Arryalist
                    System.gc();
                    Runtime runtimeALMid = Runtime.getRuntime();
                    long memoryBeforeALMid = runtimeALMid.totalMemory() - runtimeALMid.freeMemory();
                    long startTimeALMid = System.nanoTime();

                    expenseArrayList.add(0, addedExpense); // add expense at the beginning of the ArrayList
            
                    long endTimeALMid = System.nanoTime();
                    long memoryAfterALMid = runtimeALMid.totalMemory() - runtimeALMid.freeMemory();
                    long totalMemoryALMid = memoryAfterALMid - memoryBeforeALMid;
                    long totalTimeALMid = endTimeALMid - startTimeALMid;

                    // calculate the memory and time taken for LinkedList
                    System.gc();
                    Runtime runtimeLLMid = Runtime.getRuntime();
                    long memoryBeforeLLMid = runtimeLLMid.totalMemory() - runtimeLLMid.freeMemory();
                    long startTimeLLMid = System.nanoTime();

                    expenseLinkedList.add(0, addedExpense);

                    long endTimeLLMid = System.nanoTime();
                    long memoryAfterLLMid = runtimeLLMid.totalMemory() - runtimeLLMid.freeMemory();
                    long totalMemoryLLMid = memoryAfterLLMid - memoryBeforeLLMid;
                    long totalTimeLLMid = endTimeLLMid - startTimeLLMid;

                    // Print the results
                    System.out.println("Expense added at the beginning of the data structures.");
                    System.out.println("HashMap Memory Usage: " + totalMemoryHSMid + " bytes, Time Taken: " + totalTimeHSMid + " ns");
                    System.out.println("ArrayList Memory Usage: " + totalMemoryALMid + " bytes, Time Taken: " + totalTimeALMid + " ns");
                    System.out.println("LinkedList Memory Usage: " + totalMemoryLLMid + " bytes, Time Taken: " + totalTimeLLMid + " ns");
                default:
                    break;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}

    
