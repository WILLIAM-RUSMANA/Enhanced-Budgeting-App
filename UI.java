import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.Year;
import java.time.YearMonth;
import java.util.*;
import java.util.List;

public class UI extends JFrame {
    private JTextField budgetField, descriptionField, amountField, dateField;
    private JLabel budgetLabel, remainingBudgetLabel, monthLabel;
    private DefaultTableModel expenseTableModel;
    private ArrayList<Budget> budgets;
    private ArrayList<Expense> expenses;

    private YearMonth currentMonth = YearMonth.now();  // Starts with the value of the current year and month

    public UI(ArrayList<Budget> budgets, ArrayList<Expense> expenses) {
        this.budgets = budgets;
        this.expenses = expenses;
        setTitle("Enhanced Budgeting App");
        setSize(1080, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // Top Panel with Month Navigation and Remaining Budget
//        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel monthNavPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0)    );
//        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 10)); // hgap = 20px
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton prevMonthButton = new JButton("<<");
        JButton nextMonthButton = new JButton(">>");
        monthLabel = new JLabel();
        monthLabel.setPreferredSize(new Dimension(100, 30));
        monthLabel.setHorizontalAlignment(SwingConstants.CENTER);
        updateMonth();

        monthNavPanel.add(prevMonthButton);
        monthNavPanel.add(monthLabel);
        monthNavPanel.add(nextMonthButton);

        budgetLabel = new JLabel();
        budgetLabel.setFont(new Font("Arial", Font.BOLD, 16));
        budgetLabel.setPreferredSize(new Dimension(250, 30));
        budgetLabel.setHorizontalAlignment(SwingConstants.LEFT);

        remainingBudgetLabel = new JLabel();
        remainingBudgetLabel.setFont(new Font("Arial", Font.BOLD, 16));
        remainingBudgetLabel.setPreferredSize(new Dimension(250, 30));
        remainingBudgetLabel.setHorizontalAlignment(SwingConstants.LEFT);

        JPanel budgetPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 0)); // 20px horizontal gap
        budgetPanel.add(budgetLabel);
        budgetPanel.add(remainingBudgetLabel);

        topPanel.add(monthNavPanel, BorderLayout.WEST);
        topPanel.add(budgetPanel, BorderLayout.EAST);

        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(topPanel, BorderLayout.NORTH);

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
            JOptionPane.showMessageDialog(this, "Please enter a valid expense amount.");
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
        budgetLabel.setText("Budget: Rp " + monthlyBudget);
        double remaining = monthlyBudget - totalExpenses;
        remainingBudgetLabel.setText("Remaining: Rp " + String.format("%,.0f", remaining));
    }

    private void updateMonth() {

        updateMonthLabel();
    }

    private void updateMonthLabel() {
        monthLabel.setText(currentMonth.getMonth() + " " + currentMonth.getYear());
    }
}
