import java.awt.*;
import java.time.YearMonth;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UI extends JFrame {
    // Text fields:
    private JTextField budgetField, descriptionField, amountField, dateField;
    // Labels:
    private JLabel budgetLabel, remainingBudgetLabel, monthLabel, totalExpenseLabel;
    // Expense table
    private DefaultTableModel expenseTableModel;
    // Lists of budgets and expenses
    private ArrayList<Budget> budgets;
    private ArrayList<Expense> expenses;

    private YearMonth currentMonth = YearMonth.now();  // Starts with the value of the current year and month (2025-5)

    public UI(ArrayList<Budget> budgets, ArrayList<Expense> expenses) {
        this.budgets = budgets;   // Gives access to the budgets arraylist to the UI class
        this.expenses = expenses;
        setTitle("Enhanced Budgeting App");
        setSize(1080, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // Top Panel with Month Navigation
        JPanel monthNavPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0)    );
        JPanel topPanel = new JPanel(new BorderLayout());

        JButton prevMonthButton = new JButton("<<");
        JButton nextMonthButton = new JButton(">>");
        monthLabel = new JLabel();
        monthLabel.setPreferredSize(new Dimension(120, 30));
        monthLabel.setHorizontalAlignment(SwingConstants.CENTER);
        updateMonth();

        monthNavPanel.add(prevMonthButton);
        monthNavPanel.add(monthLabel);
        monthNavPanel.add(nextMonthButton);

        budgetLabel = new JLabel();
        budgetLabel.setFont(new Font("Arial", Font.BOLD, 16));
        budgetLabel.setPreferredSize(new Dimension(250, 30));
        budgetLabel.setHorizontalAlignment(SwingConstants.LEFT);

        totalExpenseLabel = new JLabel();
        totalExpenseLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalExpenseLabel.setPreferredSize(new Dimension(250, 30));
        totalExpenseLabel.setHorizontalAlignment(SwingConstants.LEFT);

        remainingBudgetLabel = new JLabel();
        remainingBudgetLabel.setFont(new Font("Arial", Font.BOLD, 16));
        remainingBudgetLabel.setPreferredSize(new Dimension(250, 30));
        remainingBudgetLabel.setHorizontalAlignment(SwingConstants.LEFT);

        JPanel topContentPanel = new JPanel();
        topContentPanel.setLayout(new BoxLayout(topContentPanel, BoxLayout.X_AXIS));

        JPanel budgetPanel = new JPanel();
        budgetPanel.setLayout(new BoxLayout(budgetPanel, BoxLayout.Y_AXIS));
        budgetPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        budgetPanel.add(budgetLabel);
        budgetPanel.add(totalExpenseLabel);
        budgetPanel.add(remainingBudgetLabel);

        monthNavPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        budgetPanel.setAlignmentY(Component.TOP_ALIGNMENT);

        topContentPanel.add(monthNavPanel);
        topContentPanel.add(Box.createHorizontalStrut(20));
        topContentPanel.add(budgetPanel);

        topPanel.setLayout(new BorderLayout());
        topPanel.add(topContentPanel, BorderLayout.CENTER);

        // Reduce the bottom margin from 10 to 5 (or any desired value)
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        add(topPanel, BorderLayout.NORTH);
        // Remove almost all margins from the top panel
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 2, 0, 2));
        // Tabbed Pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Budgeting Tab
        JPanel budgetingPanel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel();

        budgetField = new JTextField(10);
        JButton setBudgetButton = new JButton("Set Budget");

        inputPanel.add(new JLabel("Monthly Budget (Rp):"));
        inputPanel.add(budgetField);
        inputPanel.add(setBudgetButton);

        budgetingPanel.add(inputPanel, BorderLayout.NORTH);

        setBudgetButton.addActionListener(e -> setBudget());
        budgetField.addActionListener(e -> setBudget());

        // Expenses Tab
        JPanel expensesPanel = new JPanel(new BorderLayout());

        String[] columnNames = {"Date", "Description", "Amount (Rp)"};
        expenseTableModel = new DefaultTableModel(columnNames, 0);
        JTable expenseTable = new JTable(expenseTableModel);
        JScrollPane scrollPane = new JScrollPane(expenseTable);

        JPanel addExpensePanel = new JPanel();
        descriptionField = new JTextField(15);
        amountField = new JTextField(10);
        dateField = new JTextField(5);
        JButton addExpenseButton = new JButton("Add Expense");

        addExpensePanel.add(new JLabel("Date:"));
        addExpensePanel.add(dateField);
        addExpensePanel.add(new JLabel("Description:"));
        addExpensePanel.add(descriptionField);
        addExpensePanel.add(new JLabel("Amount (Rp):"));
        addExpensePanel.add(amountField);
        addExpensePanel.add(addExpenseButton);

        addExpenseButton.addActionListener(e -> addExpense());
        amountField.addActionListener(e -> addExpense());

        expensesPanel.add(addExpensePanel, BorderLayout.NORTH);
        expensesPanel.add(scrollPane, BorderLayout.CENTER);

        tabbedPane.addTab("Budgeting", budgetingPanel);
        tabbedPane.addTab("Expenses", expensesPanel);
        add(tabbedPane, BorderLayout.CENTER);

        // Navigation Button Listeners
        prevMonthButton.addActionListener(e -> {
            currentMonth = currentMonth.minusMonths(1);
            refreshUI();
        });

        nextMonthButton.addActionListener(e -> {
            currentMonth = currentMonth.plusMonths(1);
            refreshUI();
        });

        refreshUI();
        setVisible(true);
    }

    private void setBudget() {
        try {
            double amount = Double.parseDouble(budgetField.getText());
            budgets.add(new Budget(amount, currentMonth.getYear(), currentMonth.getMonthValue()));
            refreshUI();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
        }
    }

    private void addExpense() {
        try {
            String desc = descriptionField.getText();
            double amount = Double.parseDouble(amountField.getText());
            int date = Integer.parseInt(dateField.getText());
            int numericYear = currentMonth.getYear();
            int numericMonth = currentMonth.getMonthValue();

            Expense expense = new Expense(amount, numericYear, numericMonth, date, desc);
//            expense.computeIfAbsent(currentMonth, k -> new ArrayList<>()).add(expense);
            expenses.add(expense);
            refreshUI();

            descriptionField.setText("");
            amountField.setText("");
            dateField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid expense.");
        }
    }

    private void refreshUI() {
        updateMonthLabel();

        // Update expense table
        expenseTableModel.setRowCount(0);
        List<Expense> monthlyExpenses = new ArrayList<>();
        double totalExpenses = 0;
        for (Expense expense : expenses) {
            if (expense.getYear() == currentMonth.getYear() && expense.getMonth() == currentMonth.getMonthValue()) {
                monthlyExpenses.add(expense);
            }
        }

        for (Expense exp : monthlyExpenses) {
            expenseTableModel.addRow(new Object[]{exp.getDate(), exp.getDescription(), exp.getAmount()});
            totalExpenses += exp.getAmount();
        }

        double monthlyBudget = 0;
        for (Budget budget: budgets) {
            if (budget.getYear() == currentMonth.getYear() && budget.getMonth() == currentMonth.getMonthValue()) {
                monthlyBudget = budget.getAmount();
            }
        }
        budgetLabel.setText("Budget         : Rp " + String.format("%,.0f", monthlyBudget));
        totalExpenseLabel.setText("Expense      : Rp " + String.format("%,.0f", totalExpenses));
        double remaining = monthlyBudget - totalExpenses;
        remainingBudgetLabel.setText("Remaining  : Rp " + String.format("%,.0f", remaining));
    }

    private void updateMonth() {
        updateMonthLabel();
    }

    private void updateMonthLabel() {
        monthLabel.setText(currentMonth.getMonth() + " " + currentMonth.getYear());
    }
}
