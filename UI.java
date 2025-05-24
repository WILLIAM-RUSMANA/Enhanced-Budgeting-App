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
    private JLabel budgetLabel, remainingBudgetLabel, monthLabel, totalExpenseLabel, projectedExpenseLabel;
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
        setLocationRelativeTo(null);  // Place the window in the center of the screen

        setLayout(new BorderLayout());  // Applies Border layout to the container (NORTH, SOUTH, EAST, WEST, CENTER)

        // Top Panel with Month Navigation assignment
        JPanel topPanel = new JPanel(new BorderLayout());

        JPanel monthNavPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        JButton prevMonthButton = new JButton("<<");
        JButton nextMonthButton = new JButton(">>");

        monthLabel = new JLabel();
        monthLabel.setPreferredSize(new Dimension(120, 30));
        monthLabel.setHorizontalAlignment(SwingConstants.CENTER);         // Set the horizontal alignment of monthLabel to center
        updateMonth();  // updates month and year label in UI

        // adds month navigation buttons and monthLabel to monthNavPanel
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

        JPanel projectionPanel = new JPanel();
        projectionPanel.setLayout(new BoxLayout(projectionPanel, BoxLayout.X_AXIS));

        projectedExpenseLabel = new JLabel();
        projectedExpenseLabel.setFont(new Font("Arial", Font.BOLD, 16));
        remainingBudgetLabel.setPreferredSize(new Dimension(250, 30));
        projectedExpenseLabel.setText("Projected Expense: ");

        projectionPanel.add(projectedExpenseLabel);

        topContentPanel.add(monthNavPanel);
        topContentPanel.add(Box.createHorizontalStrut(20));
        topContentPanel.add(budgetPanel);

        topPanel.setLayout(new BorderLayout());
        topPanel.add(topContentPanel, BorderLayout.WEST);
        topPanel.add(projectionPanel, BorderLayout.EAST);

        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        add(topPanel, BorderLayout.NORTH);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 2, 0, 2));


        JTabbedPane tabbedPane = new JTabbedPane(); // Tabbed Pane (Budgeting and expenses) tabs

        // Budgeting tab
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

        // Expenses tab
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
        setupExpenseFieldNavigation();
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
            Expense expense = getExpense();
            expenses.add(expense);
            refreshUI();

            descriptionField.setText("");
            amountField.setText("");
            dateField.setText("");
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid expense.");
        } catch(IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid date.");
        }
    }

    private Expense getExpense() {
        String desc = descriptionField.getText().trim();
        double amount = Double.parseDouble(amountField.getText().trim().replace("\n", "").replace("\r", ""));
        int date = Integer.parseInt(dateField.getText().trim().replace("\n", "").replace("\r", ""));
        int numericYear = currentMonth.getYear();
        int numericMonth = currentMonth.getMonthValue();

        if (date > 31 || date < 1) {  // Change according to accurate amount of dates in the specific month
            throw new IllegalArgumentException();  // Triggers the invalid date popup
        }

        return new Expense(amount, numericYear, numericMonth, date, desc, "", "");
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

    private void setupExpenseFieldNavigation() {
        // When Enter is pressed in the date field, move focus to description field
        dateField.addActionListener(e -> {
            descriptionField.requestFocusInWindow();
        });

        // When Enter is pressed in the description field, move focus to amount field
        descriptionField.addActionListener(e -> {
            amountField.requestFocusInWindow();
        });

        // When Enter is pressed in the amount field (last field), submit the expense
        amountField.addActionListener(e -> addExpense());
    }
}
