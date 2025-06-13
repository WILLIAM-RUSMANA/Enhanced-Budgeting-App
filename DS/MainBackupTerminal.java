package DS;

import java.util.*;

import DS.AVLTree.AVLTree;
import DS.ArrayList.ArrayListMethod;
import DS.HashMap.HashMapMethod;
import DS.LinkedList.LinkedListMethod;

public class MainBackupTerminal {
    static Scanner scanner = new Scanner(System.in); 

    public static void main(String[] args) {

        //warming up jvm
        System.out.println("Initializing system...");
        ArrayListMethod warmupAL = new ArrayListMethod();
        LinkedListMethod warmupLL = new LinkedListMethod();
        HashMapMethod warmupHM = new HashMapMethod();
        AVLTree warmupAVL = new AVLTree();
        
        // Do a small warmup operation
        warmupAL.generateExpense(50, false);
        warmupLL.generateExpense(50, false);
        warmupHM.generateExpense(50, false);
        warmupAVL.generateExpense(50, false);

        warmupAL.removeExpense(50, false);
        warmupLL.removeExpense(50, false);
        warmupHM.removeExpense(50, false);
        warmupAVL.removeExpense(50, false);
        

        ArrayListMethod methodsAL = new ArrayListMethod();
        LinkedListMethod methodsLL = new LinkedListMethod();
        HashMapMethod methodsHM = new HashMapMethod();
        AVLTree avlTree = new AVLTree();
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
            System.out.println("6. Print expense");
            System.out.println("7. Search Expenses");
            System.out.println("8. Exit");
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

                            System.out.println("Time and Memory Usage for Generating Expenses in Different Data Structures:");
                            methodsAL.generateExpense(numExpenses, true);
                            methodsLL.generateExpense(numExpenses, true);
                            methodsHM.generateExpense(numExpenses, true);
                            avlTree.generateExpense(numExpenses, true);
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
                            System.out.println("1. arrayList, linkedList, hashMap (Addition by index)");
                            System.out.println("2. AVL Tree (Addition by Value)");
                            System.out.println("3. Back to main menu");

                            int structureChoice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline

                            if (structureChoice == 1) {
                                System.out.print("Enter the index to add the expense: ");
                                int indexToAdd = scanner.nextInt();
                                methodsAL.addExpense(indexToAdd, true);
                                methodsLL.addExpense(indexToAdd, true);
                                methodsHM.addExpense(indexToAdd, true);
                                condition2 = false;
                            } else if (structureChoice == 2) {
                                System.out.print("Enter the amount to add to the AVL Tree: ");
                                int amountToAdd = scanner.nextInt();
                                avlTree.addExpense(amountToAdd, true);
                                condition2 = false;
                            } else if (structureChoice == 3) {
                                condition2 = false;
                            } else {
                                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
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
                            System.out.println("1. arrayList, linkedList, hashMap (deletion by index)");
                            System.out.println("2. AVL Tree (deletion by Value)");
                            System.out.println("3. Back to main menu");

                            int structureChoice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline

                            if (structureChoice == 1) {
                                System.out.print("Enter the index to delete in the data structures: ");
                                int indexToRemove = scanner.nextInt();
                                methodsAL.removeExpense(indexToRemove, true);
                                methodsLL.removeExpense(indexToRemove, true);
                                methodsHM.removeExpense(indexToRemove, true);
                                condition3 = false;
                            } else if (structureChoice == 2) {
                                System.out.print("Enter the amount to delete in AVl tree: ");
                                int amountToDelete = scanner.nextInt();
                                avlTree.removeExpense(amountToDelete, true);
                                condition3 = false;
                            } else if (structureChoice == 3) {
                                condition3 = false;
                            } else {
                                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
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
                            System.out.println("1. arrayList, linkedList, hashMap (update based on index)");
                            System.out.println("2. AVL Tree (update based on Value)");
                            System.out.println("3. Back to main menu");

                            int structureChoice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline

                            if (structureChoice == 1) {
                                System.out.print("Enter the index to update the expense: ");
                                int indexToUpdate = scanner.nextInt();
                                methodsAL.updateExpense(indexToUpdate, true);
                                methodsLL.updateExpense(indexToUpdate, true);
                                methodsHM.updateExpense(indexToUpdate, true);
                                condition4 = false;
                            } else if (structureChoice == 2) {
                                System.out.println("(e.g. if yoou want to update a node with amount 30, you input 30 here)");
                                System.out.print("Enter the amount to update");
                                int amountToUpdate = scanner.nextInt();
                                avlTree.addExpense(amountToUpdate, true);
                                condition4 = false;
                            } else if (structureChoice == 3) {
                                condition4 = false;
                            } else {
                                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
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
                            methodsAL.sortExpenses( true);
                            methodsHM.sortExpenses( true);
                            methodsLL.sortExpenses( true);
                            avlTree.sortExpenses( true);
                            condition5 = false;
                        } 
                         catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            scanner.nextLine(); // Clear any remaining input
                        }
                    }
                break;
                case 6:
                    boolean condition6 = true;
                    while (condition6) {
                        try {
                            System.out.println("Choose a data Struture that is to be printed: ");
                            System.out.println("(Max amount printed is 50)");
                            System.out.println("1. ArrayList");
                            System.out.println("2. LinkedList");
                            System.out.println("3. Hashmap");
                            System.out.println("4. AVL tree");
                            System.out.println("5. Return to Main Menu");

                            int structureChoice = scanner.nextInt();
                            scanner.nextLine();

                            if(structureChoice==1){
                                methodsAL.viewExpenses(true);
                                condition6 = false;
                            } 
                            else if (structureChoice==2){
                                methodsLL.viewExpenses(true);
                                condition6 = false;
                            }
                            else if (structureChoice==3){
                                methodsLL.viewExpenses(true);
                                condition6 = false;
                            }
                            else if (structureChoice==4){
                                methodsLL.viewExpenses(true);
                                condition6 = false;
                            }
                            else if (structureChoice==5){
                                System.out.println("Returning into the main method...");
                                condition6 = false;
                            }
                            
                        } 
                         catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            scanner.nextLine(); // Clear any remaining input
                        }
                    }
                break;
                case 7 :
                
                    
                
                case 8:
                    System.out.println("Exiting the program. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                
            }

        }
    }
}

