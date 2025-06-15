package DS;

import DS.AVLTree.AVLTree;
import DS.ArrayList.ArrayListMethod;
import DS.HashMap.HashMapMethod;
import DS.LinkedList.LinkedListMethod;
import DS.Stack.StackMethod;
import java.util.*;


public class MainBackupTerminal {
    static Scanner scanner = new Scanner(System.in); 


    public static void main(String[] args) {


    //warming up jvm

        ArrayListMethod methodsAL = new ArrayListMethod();
        LinkedListMethod methodsLL = new LinkedListMethod();
        HashMapMethod methodsHM = new HashMapMethod();
        AVLTree avlTree = new AVLTree();
        StackMethod methodStack = new StackMethod();
        WarmUpJVM warmUpJVM = new WarmUpJVM();
        boolean condition = true;

        System.out.println("Welcome to the Budget Management System!");
        while (condition) {
            System.out.println("----------------------------------------");
            System.out.println("Menu:");
            System.out.println("1. Generate Expenses");
            System.out.println("2. Add Expense");
            System.out.println("3. Delete Expense");
            System.out.println("4. Update Expense");
            System.out.println("5. Sort expenses");
            System.out.println("6. Search Expenses");
            System.out.println("7. Print Expenses");
            System.out.println("8. Clear Data Structures");
            System.out.println("9. Exit");
            System.out.println("----------------------------------------");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    boolean condition1 = true;
                    while(condition1) {
                        try{
                            System.out.print("Enter the number of expenses to generate: ");
                            int numExpenses = scanner.nextInt();
                            warmUpJVM.warmUpGeneration(numExpenses);

                            System.out.println("Time and Memory Usage for Generating Expenses in Different Data Structures:");
                            methodsAL.generateExpense(numExpenses, true);
                            methodsLL.generateExpense(numExpenses, true);
                            methodsHM.generateExpense(numExpenses, true);
                            avlTree.generateExpense(numExpenses, true);
                            methodStack.generateExpense(numExpenses, true);
                            
                            System.out.println(numExpenses + " Expenses generated successfully!");
                            condition1 = false;

                        } catch(Exception e){
                            System.out.println("error: " + e.getMessage());
                            scanner.nextLine();
                        }
                    }
                    break;
                case 2:
                    boolean condition2 = true;
                    while (condition2) {
                        try {
                            System.out.println("Choose a data structure to add an expense:");
                            System.out.println("1. arrayList, linkedList, hashMap, Stack (Addition by index)");
                            System.out.println("2. AVL Tree (Addition by Value)");
                            System.out.println("3. Back to main menu");

                            int structureChoice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            switch (structureChoice) {
                                case 1 -> {
                                    System.out.print("Enter the index to add the expense: ");
                                    int indexToAdd = scanner.nextInt();
                                    warmUpJVM.warmUpAddition(indexToAdd);
                                    methodsAL.addExpense(indexToAdd, true);
                                    methodsLL.addExpense(indexToAdd, true);
                                    methodsHM.addExpense(indexToAdd, true);
                                    methodStack.addExpense(indexToAdd, true);
                                    condition2 = false;
                                }
                                case 2 -> {
                                    System.out.print("Enter the amount to add to the AVL Tree: ");
                                    int amountToAdd = scanner.nextInt();
                                    warmUpJVM.avlTree1.addExpense(amountToAdd, false);
                                    avlTree.addExpense(amountToAdd, true);
                                    condition2 = false;
                                }
                                case 3 -> condition2 = false;
                                default -> System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                            }
                        } 
                         catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            scanner.nextLine(); // Clear any remaining input
                        }
                    }
                break;
                case 3:
                    boolean condition3 = true;
                    while (condition3) {
                        try {
                            System.out.println("Choose a data structure to delete an expense from:");
                            System.out.println("1. arrayList, linkedList, hashMap, Stack (deletion by index)");
                            System.out.println("2. AVL Tree (deletion by Value)");
                            System.out.println("3. Back to main menu");

                            int structureChoice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            switch (structureChoice) {
                                case 1 -> {
                                    System.out.print("Enter the index to delete in the data structures: ");
                                    int indexToRemove = scanner.nextInt();
                                    warmUpJVM.warmUpRemoval(indexToRemove);
                                    methodsAL.removeExpense(indexToRemove, true);
                                    methodsLL.removeExpense(indexToRemove, true);
                                    methodsHM.removeExpense(indexToRemove, true);
                                    methodStack.removeExpense(indexToRemove, true);
                                    condition3 = false;
                                }
                                case 2 -> {
                                    System.out.print("Enter the amount to delete in AVl tree: ");
                                    int amountToDelete = scanner.nextInt();
                                    warmUpJVM.avlTree1.removeExpense(amountToDelete, false);
                                    avlTree.removeExpense(amountToDelete, true);
                                    condition3 = false;
                                }
                                case 3 -> condition3 = false;
                                default -> System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                            }
                        } 
                         catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            scanner.nextLine(); // Clear any remaining input
                        }
                    }
                break;
                case 4:
                    boolean condition4 = true;
                    while (condition4) {
                        try {
                            System.out.println("Choose a data structure to update an expense from:");
                            System.out.println("1. arrayList, linkedList, hashMap, stack (update based on index)");
                            System.out.println("2. AVL Tree (update based on Value)");
                            System.out.println("3. Back to main menu");

                            int structureChoice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            switch (structureChoice) {
                                case 1 -> {
                                    System.out.print("Enter the index to update the expense: ");
                                    int indexToUpdate = scanner.nextInt();
                                    warmUpJVM.warmUpUpdate(indexToUpdate);
                                    methodsAL.updateExpense(indexToUpdate, true);
                                    methodsLL.updateExpense(indexToUpdate, true);
                                    methodsHM.updateExpense(indexToUpdate, true);
                                    methodStack.updateExpense(indexToUpdate, true);
                                    condition4 = false;
                                }
                                case 2 -> {
                                    System.out.println("(e.g. if yoou want to update a node with amount 30, you input 30 here)");
                                    System.out.print("Enter the amount to update: ");
                                    int amountToUpdate = scanner.nextInt();
                                    warmUpJVM.avlTree1.updateExpense(amountToUpdate, false);
                                    avlTree.updateExpense(amountToUpdate, true);
                                    condition4 = false;
                                }
                                case 3 -> condition4 = false;
                                default -> System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                            }
                        } 
                         catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            scanner.nextLine(); // Clear any remaining input
                        }
                    }
                break;
                case 5:
                    boolean condition5 = true;
                    while (condition5) {
                        try {
                            System.out.println("Sorting expenses based on amount in multiple data sturctures");
                            warmUpJVM.warmUpSorting();;
                            
                            methodsAL.sortExpenses( true);
                            methodsHM.sortExpenses( true);
                            methodsLL.sortExpenses( true);
                            avlTree.sortExpenses( true);
                            methodStack.sortExpenses(true);
                            condition5 = false;
                        } 
                         catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            scanner.nextLine(); // Clear any remaining input
                        }
                    }
                break;
                case 6 :
                    boolean condition7 = true;
                    while (condition7) {
                        try {
                            System.out.println("Choose a data structure to search an expense from:");
                            System.out.println("1. arrayList, linkedList, hashMap, stack (search based on index)");
                            System.out.println("2. AVL Tree (search based on Value)");
                            System.out.println("3. Back to main menu");

                            int structureChoice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            switch (structureChoice) {
                                case 1 -> {
                                    System.out.print("Enter the index to search the expense: ");
                                    int indexToUpdate = scanner.nextInt();
                                    warmUpJVM.warmUpSearching(indexToUpdate);
                                    methodsAL.searchExpense(indexToUpdate, condition);
                                    methodsLL.searchExpense(indexToUpdate, condition);
                                    methodsHM.searchExpense(indexToUpdate, condition);
                                    methodStack.searchExpense(indexToUpdate, condition);
                                    condition7 = false;
                                }
                                case 2 -> {
                                    System.out.print("Enter the amount to search: ");
                                    int amountToUpdate = scanner.nextInt();
                                    warmUpJVM.warmUpSearching(amountToUpdate);
                                    avlTree.searchExpense(amountToUpdate, condition);
                                    condition7 = false;
                                }
                                case 3 -> condition7 = false;
                                default -> System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                            }
                        } 
                         catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            scanner.nextLine(); // Clear any remaining input
                        }
                    }
                break;
                case 7:
                    boolean condition6 = true;
                    while (condition6) {
                        try {
                            System.out.println("Choose a data Struture that is to be printed: ");
                            System.out.println("(Max amount printed is 50)");
                            System.out.println("1. ArrayList");
                            System.out.println("2. LinkedList");
                            System.out.println("3. Hashmap");
                            System.out.println("4. AVL tree");
                            System.out.println("5. Stack");
                            System.out.println("6. Return to Main Menu");

                            int structureChoice = scanner.nextInt();
                            scanner.nextLine();

                            switch (structureChoice) {
                                case 1 -> {
                                    methodsAL.viewExpenses(true);
                                    condition6 = false;
                                }
                                case 2 -> {
                                    methodsLL.viewExpenses(true);
                                    condition6 = false;
                                }
                                case 3 -> {
                                    methodsHM.viewExpenses(true);
                                    condition6 = false;
                                }
                                case 4 -> {
                                    avlTree.viewExpenses(true);
                                    condition6 = false;
                                }
                                case 5 -> {
                                    methodStack.viewExpenses(condition);
                                    condition6 = false;
                                }
                                case 6 -> {
                                    System.out.println("Returning to main menu..");
                                    condition6=false;
                                }
                                default -> {
                                }
                            }
                        } 
                         catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            scanner.nextLine(); // Clear any remaining input
                        }
                    }
                break;
                case 8:
                System.out.println("clearing the Data Structures");
                methodsAL.clear();
                methodsHM.clear();
                methodStack.clear();
               methodsLL.clear();
                avlTree.clear();
                break;
                case 9:
                    System.out.println("Exiting the program. Goodbye!");
                    condition = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                
            }

        }
    }

}

