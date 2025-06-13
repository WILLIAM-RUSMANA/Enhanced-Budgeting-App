package OOP;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.YearMonth;
import java.util.*;
import java.util.List;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class UI extends JFrame {
    // Text fields:
    private final JTextField budgetField, amountField, categoryField, dateField, descriptionField;
    private final JComboBox<String> frequencyOptions;
    // Labels:
    private final JLabel budgetLabel, remainingBudgetLabel, monthLabel, totalExpenseLabel;
    // Expense table
    private final DefaultTableModel expenseTableModel;
    // Lists of budgets and expenses
    private ArrayList<Budget> budgets;
    private ArrayList<Expense> expenses;

    // tabbedPane and projectionPanel
    private final JTabbedPane tabbedPane;
    private final JPanel projectionPanel;

    // Initialize display and current month
    private YearMonth displayedMonth = YearMonth.now();  // Starts with the value of the current year and month (2025-5)
    private final YearMonth currentMonth = YearMonth.now();

    // variables used for projection
    private final YearMonth lowerBound = currentMonth.plusMonths(1);
    private final YearMonth upperBound = currentMonth.plusMonths(3);

    // Variable for rounding up to 2 decimal places and separates 0s with ','
    DecimalFormat df = new DecimalFormat("#,##0.00");

    // Array of options for frequency drop down
    private final String[] options = { "One-time", "Daily", "Weekly", "Monthly",
                                       "Quarterly", "Semi-Annual", "Annual"};

    // Sound effects
    File walkmanSound = new File("OOP/sounds/walkman sound.wav");
    File errorSound = new File("OOP/sounds/error.wav");

    /**
     * UI Constructor: Sets up the main window for the Enhanced Budgeting App.
     * Initializes all UI components, layouts, navigation, event listeners, and tabs.
     * Handles budget and expense input, month navigation, projection tab, and sound effects.
     * Connects the UI to the provided budgets and expenses lists.
     */
    public UI(ArrayList<Budget> budgets, ArrayList<Expense> expenses) {
        // Use the correct path for the sound file depending on its location

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

        // Top content components
        JPanel topContentPanel = new JPanel();
        topContentPanel.setLayout(new BoxLayout(topContentPanel, BoxLayout.X_AXIS));

        // Top budget and expense panel; month's budget, expense and remaining display
        JPanel budgetExpenseDisplayPanel = new JPanel();
        budgetExpenseDisplayPanel.setLayout(new BoxLayout(budgetExpenseDisplayPanel, BoxLayout.Y_AXIS));
        budgetExpenseDisplayPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        budgetExpenseDisplayPanel.add(budgetLabel);
        budgetExpenseDisplayPanel.add(totalExpenseLabel);
        budgetExpenseDisplayPanel.add(remainingBudgetLabel);
        monthNavPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        budgetExpenseDisplayPanel.setAlignmentY(Component.TOP_ALIGNMENT);

        topContentPanel.add(monthNavPanel);
        topContentPanel.add(Box.createHorizontalStrut(20));
        topContentPanel.add(budgetExpenseDisplayPanel);

        topPanel.setLayout(new BorderLayout());
        topPanel.add(topContentPanel, BorderLayout.WEST);

        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        add(topPanel, BorderLayout.NORTH);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 2, 0, 2));

        // Initialize tabbed pane
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

        setBudgetButton.addActionListener(e -> {
            setBudget();
            playSound(walkmanSound);
        });
        budgetField.addActionListener(e -> {
            setBudget();
            playSound(walkmanSound);
        });

        // Expenses tab
        JPanel expensesPanel = new JPanel(new BorderLayout());

        String[] columnNames = {"Date", "Amount (Rp)", "Category", "Description", "Freq"};
        expenseTableModel = new DefaultTableModel(columnNames, 0);
        JTable expenseTable = new JTable(expenseTableModel);
        JScrollPane scrollPane = new JScrollPane(expenseTable);

        JPanel addExpensePanel = new JPanel();
        amountField = new JTextField(10);
        dateField = new JTextField(2);
        categoryField = new JTextField(10);
        descriptionField = new JTextField(15);
        frequencyOptions = new JComboBox<>(options);

        JButton addExpenseButton = new JButton("Add Expense");

        // Adds labels, fields, ComboBox and a button to the addExpensePanel
        addExpensePanel.add(new JLabel("Date:"));
        addExpensePanel.add(dateField);
        addExpensePanel.add(new JLabel("Amount (Rp):"));
        addExpensePanel.add(amountField);
        addExpensePanel.add(new JLabel("Category:"));
        addExpensePanel.add(categoryField);
        addExpensePanel.add(new JLabel("Description"));
        addExpensePanel.add(descriptionField);
        addExpensePanel.add(new JLabel("Freq."));
        addExpensePanel.add(frequencyOptions);
        addExpensePanel.add(addExpenseButton);

        // Event listeners for Adding Expenses
        // action listener for add expense button
        addExpenseButton.addActionListener(e -> {
            addExpense();
            playSound(walkmanSound);
        });  

        setupExpenseFieldNavigation();  // run ENTER navigation action listener

        // Place addExpense panel on the top and scrollPane under it filling up the rest of the space
        expensesPanel.add(addExpensePanel, BorderLayout.NORTH);
        expensesPanel.add(scrollPane, BorderLayout.CENTER);

        // Navigation Button Listeners
        prevMonthButton.addActionListener(e -> {
            displayedMonth = displayedMonth.minusMonths(1);
            refreshUI();
            playSound(walkmanSound);
        });

        nextMonthButton.addActionListener(e -> {
            displayedMonth = displayedMonth.plusMonths(1);
            refreshUI();
            playSound(walkmanSound);
        });

        // Projection tab - create once and reuse
        projectionPanel = new JPanel(new BorderLayout());
        if (!displayedMonth.isBefore(lowerBound) && !displayedMonth.isAfter(upperBound)) {
            double[] projection = Projection.project(expenses, displayedMonth.getYear(), displayedMonth.getMonthValue());

            JLabel projectionLabel = new JLabel(df.format(projection[0]) + " ~ " + df.format(projection[1]));
            projectionLabel.setFont(new Font("Calibre", Font.BOLD, 26));
            JPanel centerPanel = new JPanel(new GridBagLayout());
            centerPanel.add(projectionLabel);
            projectionPanel.add(centerPanel, BorderLayout.CENTER);
        }

        // Label for Projection heading
        projectionPanel.add(new JLabel("Projection estimate for " + displayedMonth.getMonth() + ", " + displayedMonth.getYear()), BorderLayout.PAGE_START);

        // Create tabs and put panels into them
        tabbedPane.addTab("Budgeting", budgetingPanel);
        tabbedPane.addTab("Expenses", expensesPanel);


        // Add the tabbedPane (all tabs) to the main window
        add(tabbedPane, BorderLayout.CENTER);
        // Refresh the UI the current states
        refreshUI();
        // Make the window visible to the user
        setVisible(true);

        // Enable SHIFT + Tab for tabbed navigation
        tabbedNavigation();
    }

    // adds budget to budgets Array List and handles exception by displaying a pane detailing the cause
    private void setBudget() {
        try {
            double amount = Double.parseDouble(budgetField.getText());
            budgets.add(new Budget(amount, displayedMonth.getYear(), displayedMonth.getMonthValue()));
            refreshUI();
            amountField.setText("");
        } catch (NumberFormatException ex) {
            playSound(errorSound);
            JOptionPane.showMessageDialog(this, "Please enter a valid amount.");
        }
    }

    // adds Expense to expenses Array List and handles exception handling by displaying a pane detailing the cause
    private void addExpense() {
        try {
            Expense expense = getExpense();
            expenses.add(expense);
            refreshUI();

            dateField.setText("");
            amountField.setText("");
            categoryField.setText("");
            descriptionField.setText("");
        } catch (IllegalArgumentException e) {
            String message = e.getMessage();
            if (message.contains("inv date")) {
                playSound(errorSound);
                JOptionPane.showMessageDialog(this, "Please enter a valid date between 1 - " + displayedMonth.lengthOfMonth());
            } else if (message.contains("inv amount")) {
                playSound(errorSound);
                JOptionPane.showMessageDialog(this, "Please enter a valid amount.");
            }
        }
    }

    // Getter that returns a expense object with params derived from the text fields and drop down box of the expense tab
    private Expense getExpense() {
        int date = getIntDate();

        double amount = getDoubleAmount(); // Get valid

        String category = categoryField.getText().trim();
        int numericYear = displayedMonth.getYear();
        int numericMonth = displayedMonth.getMonthValue();
        String description = descriptionField.getText().trim();
        String freq = frequencyOptions.getSelectedItem() + "";




        return new Expense(amount, numericYear, numericMonth, date, category, description, freq);
    }

    // Method to determine if amount is valid and throws an exception
    private double getDoubleAmount() {
        String amountText = amountField.getText().trim().replace("\n", "").replace("\r", "");
        double amount = 0;
        if (!amountText.isEmpty()) {
            try {
                amount = Double.parseDouble(amountText);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("inv amount");
            }
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("inv amount"); // Triggers the invalid amount popup
        }
        return amount;
    }

    // Method to determine if date is valid if not throw an exception
    private int getIntDate() {
        int date = 0;
        String dateText = dateField.getText().trim().replace("\n", "").replace("\r", "");
        if (!dateText.isEmpty()) {
            try {
                date = Integer.parseInt(dateText);
            } catch (NumberFormatException e) {
                throw new NumberFormatException("inv date");
            }
        }
        if (date > displayedMonth.lengthOfMonth() || date < 1) {  // Change according to accurate amount of dates in the specific month
            throw new IllegalArgumentException("inv date");  // Triggers the invalid date popup
        }

        return date;
    }
    
    // Updates all UI components to reflect the current state of budgets, expenses,
    // displayed month, projection of specified month and table model generation.
    private void refreshUI() {
        // Update the month label at the top of the UI
        updateMonthLabel();
        // Add or remove the projection tab as needed
        updateProjectionTab(); // method call to add projection Tab accordingly
        // Sorts expenses and budgets items from earliest to latest
        ExpenseSort.sort(expenses);
        BudgetSort.sort(budgets);
        // Update expense table using expenses
        expenseTableModel.setRowCount(0);
        List<Expense> monthlyExpenses = new ArrayList<>();
        double totalExpenses = 0;
        for (Expense expense : expenses) {
            if (expense.getYear() == displayedMonth.getYear() && expense.getMonth() == displayedMonth.getMonthValue()) {
                monthlyExpenses.add(expense);
            }
        }

        for (Expense exp : monthlyExpenses) {  // display all expenses
            expenseTableModel.addRow(new Object[]{exp.getDate(), df.format(exp.getAmount()), exp.getCategory(), exp.getDescription(), exp.getFrequency()});
            totalExpenses += exp.getAmount();
        }

        double monthlyBudget = 0;
        for (Budget budget : budgets) {  // Updates budget to according budget of the appropriate month
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

    // Updates month label text with updated YearMonth object
    private void updateMonthLabel() {
        monthLabel.setText(displayedMonth.getMonth() + " " + displayedMonth.getYear());
    }

    // ENTER shortcut enabler function
    private void setupExpenseFieldNavigation() {
        // When Enter is pressed in the date field, move focus to description field
        dateField.addActionListener(e -> {
            amountField.requestFocusInWindow();
            playSound(walkmanSound);
        });

        // When Enter is pressed in the amount field, move to freq field
        amountField.addActionListener(e -> {
            categoryField.requestFocusInWindow();
            playSound(walkmanSound);
        });

        categoryField.addActionListener(e -> {
            descriptionField.requestFocusInWindow();
            playSound(walkmanSound);
        });

        descriptionField.addActionListener(e -> {
            frequencyOptions.requestFocusInWindow();
            playSound(walkmanSound);
        });

        // Set the keystore to ENTER
        frequencyOptions.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
                .put(KeyStroke.getKeyStroke("ENTER"), "enterPressed");

        // When enter is clicked, run addExpense()
        frequencyOptions.getActionMap().put("enterPressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addExpense();
                playSound(walkmanSound);
                dateField.requestFocusInWindow();
            }
        });
    }

    // Allows SHIFT + TAB to navigate accross the two tabs
    public void tabbedNavigation() {
        // Remove Shift+Tab from focus traversal keys so we can use it solely for tab switching
        Set<AWTKeyStroke> backwardKeys = new HashSet<>(tabbedPane.getFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS));
        backwardKeys.remove(KeyStroke.getKeyStroke("shift TAB"));
        tabbedPane.setFocusTraversalKeys(KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, backwardKeys);

        // Enable Shift+Tab navigation between Budgeting and Expenses tabs only
        InputMap inputMap = tabbedPane.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionMap actionMap = tabbedPane.getActionMap();
        inputMap.put(KeyStroke.getKeyStroke("shift TAB"), "switchTab");
        actionMap.put("switchTab", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int current = tabbedPane.getSelectedIndex();
                int next = 0;
                if (tabbedPane.getTabCount() == 3) {
                    next = (current >= 2) ? 0 : next + 1;
                } else {
                    next = (current == 0) ? 1 : 0; // Only switch between first two tabs
                }
                tabbedPane.setSelectedIndex(next);
            }
        });
    }

    // Function that plays .wav sound files
    private void playSound(File soundFile) {
        try {
            // Initialize audioStream with File object soundFile
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);

            // sound clip resource to play the audio clip
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("Error in playSound playing " + soundFile);
            System.err.println(e.getMessage());
        }
    }

}