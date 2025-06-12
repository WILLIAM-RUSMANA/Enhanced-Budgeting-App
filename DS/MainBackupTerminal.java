package DS;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import DS.AVLTree.AVLTree;
import DS.ArrayList.ArrayListMethod;
import DS.HashMap.HashMapMethod;
import DS.LinkedList.LinkedListMethod;

import java.time.LocalDate;

import OOP.Budget;
import OOP.Data;
import OOP.Expense;
import OOP.FinancialItem;

public class MainBackupTerminal {
    static Scanner scanner = new Scanner(System.in);
    static LocalDate today = LocalDate.now();    



    public static void main(String[] args) {

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

                            System.out.println("Time and Memory Usage for Generating Expenses in Different Data Structures:\n");
                            methodsAL.generateExpense(numExpenses);
                            methodsLL.generateExpense(numExpenses);
                            methodsHM.generateExpense(numExpenses);
                            avlTree.generateExpense(numExpenses);
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
                                methodsAL.addExpense(indexToAdd);
                                methodsLL.addExpense(indexToAdd);
                                methodsHM.addExpense(indexToAdd);
                                methodsHM.addExpenseChaining(indexToAdd);
                                condition2 = false;
                            } else if (structureChoice == 2) {
                                System.out.print("Enter the amount to add to the AVL Tree: ");
                                int amountToAdd = scanner.nextInt();
                                avlTree.addExpense(amountToAdd);
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
                                methodsAL.removeExpense(indexToRemove);
                                methodsLL.removeExpense(indexToRemove);
                                methodsHM.removeExpense(indexToRemove);
                                condition3 = false;
                            } else if (structureChoice == 2) {
                                System.out.print("Enter the amount to delete in AVl tree: ");
                                int amountToDelete = scanner.nextInt();
                                avlTree.removeExpense(amountToDelete);
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
                                methodsAL.updateExpense(indexToUpdate);
                                methodsLL.updateExpense(indexToUpdate);
                                methodsHM.updateExpense(indexToUpdate);
                                condition4 = false;
                            } else if (structureChoice == 2) {
                                System.out.println("(e.g. if yoou want to update a node with amount 30, you input 30 here)");
                                System.out.print("Enter the amount to update");
                                int amountToUpdate = scanner.nextInt();
                                avlTree.addExpense(amountToUpdate);
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
                            methodsAL.sortExpenses();
                            methodsHM.sortExpenses();
                            methodsLL.sortExpenses();
                            avlTree.sortExpenses();
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

                            switch(structureChoice) {
                                case 1:
                                    methodsAL.viewExpenses();
                                    condition6 = false;
                                    break;
                                case 2:
                                    methodsLL.viewExpenses();
                                    condition6 = false;
                                    break;
                                case 3:
                                    methodsHM.viewExpenses();  // Fixed: was using methodsLL instead of methodsHM
                                    condition6 = false;
                                    break;
                                case 4:
                                    avlTree.viewExpenses();    // Fixed: was using methodsLL instead of avlTree
                                    condition6 = false;
                                    break;
                                case 5:
                                    System.out.println("Returning to main menu...");
                                    condition6 = false;
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please enter 1-5.");
                            }
                        } 
                        catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            scanner.nextLine(); // Clear any remaining input
                        }
                    }
                    break;  // Add break to prevent fall-through to case 8
                    
                case 7:
                    boolean condition7 = true;
                    while (condition7) {
                        try {
                            System.out.println("Choose a data structure to search an expense:");
                            System.out.println("1. arrayList, linkedList, hashMap (searching by index by index)");
                            System.out.println("2. AVL Tree (searching by Value)");
                            System.out.println("3. Back to main menu");

                            int structureChoice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline

                            if (structureChoice == 1) {
                                System.out.print("Enter the index to search the expense: ");
                                int indexToSearch = scanner.nextInt();
                                methodsAL.addExpense(indexToSearch);
                                methodsLL.addExpense(indexToSearch);
                                methodsHM.addExpense(indexToSearch);
                                condition7 = false;
                            } else if (structureChoice == 2) {
                                System.out.print("Enter the amount to search to the AVL Tree: ");
                                int amountToSearch = scanner.nextInt();
                                avlTree.addExpense(amountToSearch);
                                condition7 = false;
                            } else if (structureChoice == 3) {
                                condition7 = false;
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
                case 8:
                    System.out.println("Exiting the program. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                
            }

        }
    }
}

