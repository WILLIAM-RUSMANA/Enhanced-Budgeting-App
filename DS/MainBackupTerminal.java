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
            System.out.println("5. sort expenses");
            System.out.println("6. view expense");
            System.out.println("7. Search Expenses");
            System.out.println("8. Exit");
            System.out.println("----------------------------------------");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                while(condition) {
                    try{
                        System.out.print("Enter the number of expenses to generate: ");
                        int numExpenses = scanner.nextInt();

                        System.out.println("Time and Memory Usage for Generating Expenses in Different Data Structures:");
                        methodsAL.generateExpense(numExpenses);
                        methodsLL.generateExpense(numExpenses);
                        methodsHM.generateExpense(numExpenses);
                        avlTree.generateExpense(numExpenses);
                        System.out.println(numExpenses + " Expenses generated successfully!");
                        condition = false;

                    } catch(Exception e){
                        System.out.println("error: " + e.getMessage());
                        scanner.nextLine();
                    }
                }

 
                case 2:
                    while (condition) {
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
                                condition = false;
                            } else if (structureChoice == 2) {
                                System.out.print("Enter the amount to add to the AVL Tree: ");
                                int amountToAdd = scanner.nextInt();
                                avlTree.addExpense(amountToAdd);
                                condition = false;
                            } else if (structureChoice == 3) {
                                condition = false;
                            } else {
                                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                            }
                        } 
                         catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            scanner.nextLine(); // Clear any remaining input
                        }
                    }
                
                case 3:
                    while (condition) {
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
                                condition = false;
                            } else if (structureChoice == 2) {
                                System.out.print("Enter the amount to delete in AVl tree: ");
                                int amountToDelete = scanner.nextInt();
                                avlTree.removeExpense(amountToDelete);
                                condition = false;
                            } else if (structureChoice == 3) {
                                condition = false;
                            } else {
                                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                            }
                        } 
                         catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            scanner.nextLine(); // Clear any remaining input
                        }
                    }
               case 4:
                    while (condition) {
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
                                condition = false;
                            } else if (structureChoice == 2) {
                                System.out.println("(e.g. if yoou want to update a node with amount 30, you input 30 here)");
                                System.out.print("Enter the amount to update");
                                int amountToUpdate = scanner.nextInt();
                                avlTree.addExpense(amountToUpdate);
                                condition = false;
                            } else if (structureChoice == 3) {
                                condition = false;
                            } else {
                                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                            }
                        } 
                         catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            scanner.nextLine(); // Clear any remaining input
                        }
                    }
                    case 5:
                    while (condition) {
                        try {
                            System.out.println("Sorting expenses based on amount in multiple data sturctures");
                            methodsAL.sortExpenses();
                            methodsHM.sortExpenses();
                            methodsLL.sortExpenses();
                            avlTree.sortExpenses();
                            condition = false;
                        } 
                         catch (Exception e) {
                            System.out.println("Error: " + e.getMessage());
                            scanner.nextLine(); // Clear any remaining input
                        }
                    }
             /*      case 6:
                    searchExpenses();
                    break;*/
                case 8:
                    System.out.println("Exiting the program. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                
            }

        }
    }
}

