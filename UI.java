import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.YearMonth;
import java.util.*;
import java.util.List;

public class UI extends JFrame {
    private JTextField budgetField, descriptionField, amountField, dateField;
    private JLabel remainingBudgetLabel, monthLabel;
    private DefaultTableModel expenseTableModel;

    private Map<YearMonth, Double> monthlyBudgets = new HashMap<>();
    private Map<YearMonth, List<Expense>> monthlyExpenses = new HashMap<>();

    private YearMonth currentMonth = YearMonth.now();

    public UI() {
        setTitle("Budgeting App");
        setSize(1080, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // Top Panel with Month Navigation and Remaining Budget
        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel monthNavPanel = new JPanel();

        JButton prevMonthButton = new JButton("<<");
        JButton nextMonthButton = new JButton(">>");
        monthLabel = new JLabel();
        updateMonthLabel();

        monthNavPanel.add(prevMonthButton);
        monthNavPanel.add(monthLabel);
        monthNavPanel.add(nextMonthButton);

        remainingBudgetLabel = new JLabel();
        remainingBudgetLabel.setFont(new Font("Arial", Font.BOLD, 16));
        remainingBudgetLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        topPanel.add(monthNavPanel, BorderLayout.WEST);
        topPanel.add(remainingBudgetLabel, BorderLayout.EAST);
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
            double budget = Double.parseDouble(budgetField.getText());
            monthlyBudgets.put(currentMonth, budget);
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

            Expense expense = new Expense(desc, amount, date);
            monthlyExpenses.computeIfAbsent(currentMonth, k -> new ArrayList<>()).add(expense);

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
        List<Expense> expenses = monthlyExpenses.getOrDefault(currentMonth, new ArrayList<>());
        double totalExpenses = 0;
        for (Expense exp : expenses) {
            expenseTableModel.addRow(new Object[]{exp.date, exp.description, exp.amount});
            totalExpenses += exp.amount;
        }

        double budget = monthlyBudgets.getOrDefault(currentMonth, 0.0);
        double remaining = budget - totalExpenses;
        remainingBudgetLabel.setText("Remaining: Rp " + String.format("%,.0f", remaining));
    }

    private void updateMonthLabel() {
        monthLabel.setText(currentMonth.getMonth() + " " + currentMonth.getYear());
    }

    static class Expense {
        String description;
        double amount;
        int date;

        Expense(String description, double amount, int date) {
            this.description = description;
            this.amount = amount;
            this.date = date;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(UI::new);
    }
}
