package DS;
/*package DataStructure;

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
    
    


}
*/
    
