package OOP;
import java.awt.*;
import java.text.DecimalFormat;
import java.time.YearMonth;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class UI extends JFrame {
    // Text fields:
    private JTextField budgetField, amountField, categoryField, dateField, descriptionField, frequencyField;
    // Labels:
    private JLabel budgetLabel, remainingBudgetLabel, monthLabel, totalExpenseLabel;
    // Expense table
    private DefaultTableModel expenseTableModel;
    // Lists of budgets and expenses
    private ArrayList<Budget> budgets;
    private ArrayList<Expense> expenses;

    // tabbedPane and projectionPanel
    private JTabbedPane tabbedPane;
    private JPanel projectionPanel;

    // Initialize display and current month
    private YearMonth displayedMonth = YearMonth.now();  // Starts with the value of the current year and month (2025-5)
    private YearMonth currentMonth = YearMonth.now();

    // variables used for projection
    private YearMonth lowerBound = currentMonth.plusMonths(1);
    private YearMonth upperBound = currentMonth.plusMonths(3);

    DecimalFormat df = new DecimalFormat("#,##0.00");

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
        updateMonthLabel();  // updates month and year label in UI

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

        topContentPanel.add(monthNavPanel);
        topContentPanel.add(Box.createHorizontalStrut(20));
        topContentPanel.add(budgetPanel);

        topPanel.setLayout(new BorderLayout());
        topPanel.add(topContentPanel, BorderLayout.WEST);

        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        add(topPanel, BorderLayout.NORTH);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 2, 0, 2));

        tabbedPane = new JTabbedPane(); // Tabbed Pane (Budgeting and expenses) tabs

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

        String[] columnNames = {"Date", "Amount (Rp)", "Category", "Description", "Freq"};
        expenseTableModel = new DefaultTableModel(columnNames, 0);
        JTable expenseTable = new JTable(expenseTableModel);
        JScrollPane scrollPane = new JScrollPane(expenseTable);

        JPanel addExpensePanel = new JPanel();
        amountField = new JTextField(10);
        dateField = new JTextField(5);
        categoryField = new JTextField(5);
        descriptionField = new JTextField(15);
        frequencyField = new JTextField(5);

        JButton addExpenseButton = new JButton("Add Expense");

        addExpensePanel.add(new JLabel("Date:"));
        addExpensePanel.add(dateField);
        addExpensePanel.add(new JLabel("Amount (Rp):"));
        addExpensePanel.add(amountField);
        addExpensePanel.add(new JLabel("Category:"));
        addExpensePanel.add(categoryField);
        addExpensePanel.add(new JLabel("Description"));
        addExpensePanel.add(descriptionField);
        addExpensePanel.add(new JLabel("Freq."));
        addExpensePanel.add(frequencyField);

        addExpensePanel.add(addExpenseButton);

        // Event listeners for Adding Expenses
        addExpenseButton.addActionListener(e -> addExpense());  // using button click
        setupExpenseFieldNavigation();  // using ENTER navigation

        expensesPanel.add(addExpensePanel, BorderLayout.NORTH);
        expensesPanel.add(scrollPane, BorderLayout.CENTER);

        // Navigation Button Listeners
        prevMonthButton.addActionListener(e -> {
            displayedMonth = displayedMonth.minusMonths(1);
            refreshUI();
        });

        nextMonthButton.addActionListener(e -> {
            displayedMonth = displayedMonth.plusMonths(1);
            refreshUI();
        });

        // Projection tab - create once and reuse
        projectionPanel = new JPanel(new BorderLayout());
//        if (!displayedMonth.isBefore(lowerBound) && !displayedMonth.isAfter(upperBound)) {
            double[] projection = Projection.project(expenses, displayedMonth.getYear(), displayedMonth.getMonthValue());

            JLabel projectionLabel = new JLabel(df.format(projection[0]) + " ~ " + df.format(projection[1]));
            projectionLabel.setFont(new Font("Calibre", Font.BOLD, 26));
            JPanel centerPanel = new JPanel(new GridBagLayout());
            centerPanel.add(projectionLabel);
            projectionPanel.add(centerPanel, BorderLayout.CENTER);
//        }

        // TODO: BUG displayed month stays in june for some reason
        projectionPanel.add(new JLabel("Projection estimate for " + displayedMonth.getMonth() + ", " + displayedMonth.getYear()), BorderLayout.PAGE_START);

        // Create tabs and put panels into them
        tabbedPane.addTab("Budgeting", budgetingPanel);
        tabbedPane.addTab("Expenses", expensesPanel);

        add(tabbedPane, BorderLayout.CENTER);

        refreshUI();
        setVisible(true);
    }

    private void setBudget() {
        try {
            double amount = Double.parseDouble(budgetField.getText());
            budgets.add(new Budget(amount, displayedMonth.getYear(), displayedMonth.getMonthValue()));
            refreshUI();
            amountField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
        }
    }

    private void addExpense() {
        try {
            Expense expense = getExpense();
            expenses.add(expense);
            refreshUI();

            dateField.setText("");
            amountField.setText("");
            categoryField.setText("");
            descriptionField.setText("");
            frequencyField.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid expense.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid date.");
        }
    }

    private Expense getExpense() {
        double amount = Double.parseDouble(amountField.getText().trim().replace("\n", "").replace("\r", ""));
        int date = Integer.parseInt(dateField.getText().trim().replace("\n", "").replace("\r", ""));
        String category = categoryField.getText().trim();
        int numericYear = displayedMonth.getYear();
        int numericMonth = displayedMonth.getMonthValue();
        String description = descriptionField.getText().trim();
        String freq = frequencyField.getText().trim();


        if (date > 31 || date < 1) {  // Change according to accurate amount of dates in the specific month
            throw new IllegalArgumentException();  // Triggers the invalid date popup
        }

        return new Expense(amount, numericYear, numericMonth, date, category, description, freq);
    }

    private void refreshUI() {
        updateMonthLabel();
        updateProjectionTab(); // method call to add projection Tab accordingly

        // Update expense table using expenses
        expenseTableModel.setRowCount(0);
        List<Expense> monthlyExpenses = new ArrayList<>();
        double totalExpenses = 0;
        for (Expense expense : expenses) {
            if (expense.getYear() == displayedMonth.getYear() && expense.getMonth() == displayedMonth.getMonthValue()) {
                monthlyExpenses.add(expense);
            }
        }

        for (Expense exp : monthlyExpenses) {
            expenseTableModel.addRow(new Object[]{exp.getDate(), df.format(exp.getAmount()), exp.getCategory(), exp.getDescription(), exp.getFrequency()});
            totalExpenses += exp.getAmount();
        }

        double monthlyBudget = 0;
        for (Budget budget : budgets) {
            if (budget.getYear() == displayedMonth.getYear() && budget.getMonth() == displayedMonth.getMonthValue()) {
                monthlyBudget = budget.getAmount();
            }
        }
        budgetLabel.setText("Budget          : Rp " + String.format("%,.0f", monthlyBudget));
        totalExpenseLabel.setText("Expense        : Rp " + String.format("%,.0f", totalExpenses));
        double remaining = monthlyBudget - totalExpenses;
        remainingBudgetLabel.setText("Remaining    : Rp " + String.format("%,.0f", remaining));
    }

    // New method to handle projection tab visibility
    private void updateProjectionTab() {
        // Check if displayedMonth is within the projection range (next 1-3 months)
        boolean shouldShowProjection = !displayedMonth.isBefore(lowerBound) && !displayedMonth.isAfter(upperBound);

        // Check if projection tab already exists
        int projectionTabIndex = -1;
        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            if ("Projection".equals(tabbedPane.getTitleAt(i))) {
                projectionTabIndex = i;
                break;
            }
        }

        if (shouldShowProjection) {
            // Always update the projectionPanel content for the current displayedMonth
            projectionPanel.removeAll();
            double[] projection = Projection.project(expenses, displayedMonth.getYear(), displayedMonth.getMonthValue());
            JLabel projectionLabel = new JLabel(df.format(projection[0]) + " ~ " + df.format(projection[1]));
            projectionLabel.setFont(new Font("Calibre", Font.BOLD, 26));
            JPanel centerPanel = new JPanel(new GridBagLayout());
            centerPanel.add(projectionLabel);
            projectionPanel.add(centerPanel, BorderLayout.CENTER);
            projectionPanel.add(new JLabel("Projection estimate for " + displayedMonth.getMonth() + ", " + displayedMonth.getYear()), BorderLayout.PAGE_START);
            projectionPanel.revalidate();
            projectionPanel.repaint();
            if (projectionTabIndex == -1) {
                tabbedPane.addTab("Projection", projectionPanel);
            }
        } else if (projectionTabIndex != -1) {
            // Remove the projection tab if it exists but shouldn't be shown
            tabbedPane.removeTabAt(projectionTabIndex);
        }
    }

    private void updateMonthLabel() {
        monthLabel.setText(displayedMonth.getMonth() + " " + displayedMonth.getYear());
    }

    // Enter shortcut enabler function
    private void setupExpenseFieldNavigation() {
        // When Enter is pressed in the date field, move focus to description field
        dateField.addActionListener(e -> {
            amountField.requestFocusInWindow();
        });

        // When Enter is pressed in the amount field, move to freq field
        amountField.addActionListener(e -> {
            categoryField.requestFocusInWindow();
        });

        categoryField.addActionListener(e -> {
            descriptionField.requestFocusInWindow();
        });

        descriptionField.addActionListener(e -> {
            frequencyField.requestFocusInWindow();
        });

        frequencyField.addActionListener(e -> addExpense());

    }
}