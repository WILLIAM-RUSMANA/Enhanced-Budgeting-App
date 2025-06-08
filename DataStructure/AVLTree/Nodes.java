package DataStructure.AVLTree;

import OOP.Expense;

public class Nodes {
    private Nodes left;
    private Nodes right;
    private int height;
    private int count;
    private Expense expense;

    /*
     * Constructor to create a new node with an expense.
     * Initializes left and right children to null, height to 1, and count to 1.
     * @param expense The Expense object to be stored in this node.
     */
    public Nodes(Expense expense) {
        this.left = null; 
        this.right = null; 
        this.expense = expense;
        this.height = 1; 
        this.count = 1; 
    }

    // Getters and Setters for the node properties
    public Nodes getLeft() {return left;}
    public void setLeft(Nodes left) {this.left = left;}

    public Nodes getRight() {return right;}
    public void setRight(Nodes right) {this.right = right;}

    public int getHeight() {return height;}
    public void setHeight(int height) {this.height = height;}

    public int getCount() {return count;}
    public void setCount(int count) {this.count = count;}

    public Expense getExpense() {return expense;}
    public void setExpense(Expense expense) {this.expense = expense;}

    
}
