package OOP;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;


public class ExpenseBuilder {
    HashMap<String, String[]> categoriesMap = new HashMap<>() {{
        // a
        put("Accommodation", new String[]{"500", "Daily"});
        put("Advertising", new String[]{"2000", "Monthly"});
        put("Airfare", new String[]{"1200", "Monthly"});
        // b
        put("Business Travel", new String[]{"2500", "Monthly"});
        put("Bank Fees", new String[]{"1000", "Monthly"});
        put("Books & Subscriptions", new String[]{"1000", "Monthly"});
        // c
        put("Client Entertainment", new String[]{"4000", "Monthly"});
        put("Consulting Fees", new String[]{"1500", "Monthly"});
        put("Courier Services", new String[]{"800", "One-time"});
        // d
        put("Depreciation", new String[]{"300000", "Annual"});
        put("Donations", new String[]{"50000", "Semi-Annual"});
        put("Dues & Memberships", new String[]{"20000", "Quarterly"});
        // e
        put("Equipment", new String[]{"1000000", "One-time"});
        put("Employee Benefits", new String[]{"600000", "Monthly"});
        put("Education & Training", new String[]{"80000", "Annual"});
        // f
        put("Fuel", new String[]{"90000", "Monthly"});
        put("Freight & Shipping", new String[]{"70000", "Monthly"});
        put("Food & Beverages", new String[]{"120000", "Monthly"});
        // g
        put("Gifts", new String[]{"30000", "Annual"});
        put("General Office Expenses", new String[]{"40000", "Monthly"});
        put("Government Fees", new String[]{"25000", "Annual"});
        // h
        put("Healthcare", new String[]{"500000", "Monthly"});
        put("Hardware", new String[]{"200000", "One-time"});
        put("Hosting Services", new String[]{"35000", "Monthly"});
        // i
        put("Insurance", new String[]{"400000", "Annual"});
        put("Internet", new String[]{"15000", "Monthly"});
        put("IT Support", new String[]{"30000", "Monthly"});
        // j
        put("Janitorial Services", new String[]{"25000", "Monthly"});
        put("Job Advertising", new String[]{"10000", "One-time"});
        // k
        put("Kitchen Supplies", new String[]{"12000", "Monthly"});
        put("Keycard Access", new String[]{"5000", "One-time"});
        // l
        put("Legal Fees", new String[]{"100000", "One-time"});
        put("Licenses", new String[]{"20000", "Annual"});
        // m
        put("Marketing", new String[]{"30000", "Monthly"});
        put("Maintenance", new String[]{"8000", "Monthly"});
        put("Meals", new String[]{"60000", "Monthly"});
        // n
        put("Networking", new String[]{"25000", "Monthly"});
        put("Non-Employee Compensation", new String[]{"150000", "Monthly"});
        // o
        put("Office Supplies", new String[]{"4000", "Monthly"});
        put("Outsourcing", new String[]{"200000", "Monthly"});
        // p
        put("Postage", new String[]{"5000", "Monthly"});
        put("Parking", new String[]{"8000", "Monthly"});
        put("Printing", new String[]{"10000", "Monthly"});
        // q
        put("Quality Assurance", new String[]{"35000", "Quarterly"});
        put("Quarterly Taxes", new String[]{"500000", "Quarterly"});
        // r
        put("Rent", new String[]{"2000000", "Every 5 years"});
        put("Repairs", new String[]{"120000", "One-time"});
        put("Recruitment", new String[]{"90000", "Annual"});
        // s
        put("Software", new String[]{"250000", "Annual"});
        put("Salaries", new String[]{"50000000", "Monthly"});
        put("Stationery", new String[]{"7000", "Monthly"});
        put("Storage", new String[]{"20000", "Monthly"});
        // t
        put("Taxes", new String[]{"3000000", "Annual"});
        put("Telecommunications", new String[]{"40000", "Monthly"});
        put("Training", new String[]{"60000", "Annual"});
        // u
        put("Utilities", new String[]{"90000", "Monthly"});
        put("Uniforms", new String[]{"15000", "Annual"});
        // v
        put("Vehicle Expenses", new String[]{"80000", "Monthly"});
        put("Vendor Payments", new String[]{"350000", "Monthly"});
        // w
        put("Wages", new String[]{"4000000", "Monthly"});
        put("Website Hosting", new String[]{"12000", "Monthly"});
        put("Workshops", new String[]{"25000", "Annual"});
        // x
        put("Xerox/Printing", new String[]{"6000", "Monthly"});
        // y
        put("Year-End Bonuses", new String[]{"1000000", "Annual"});
        put("Yield Loss", new String[]{"50000", "One-time"});
        // z
        put("Zoning Fees", new String[]{"20000", "One-time"});
    }};


//    HashMap<String, Integer> frequencies = new HashMap<>() {{  // TODO: REM LATER
//        put("One-time", 0);
//        put("Daily", 0); // Not a monthly frequency, set to 0 or handle specially
//        put("Weekly", 0); // Not a monthly frequency, set to 0 or handle specially
//        put("Monthly", 1);
//        put("Quarterly", 3);
//        put("Semi-Annual", 6);
//        put("Annual", 12);
//        put("Every 2 years", 24);
//        put("Every 3 years", 36);
//        put("Every 4 years", 48);
//        put("Every 5 years", 60);
//        put("Every decade", 120);
//    }};

    // Array Lists used to store categories of type string
    ArrayList<String> oneTime = new ArrayList<>();
    ArrayList<String> daily = new ArrayList<>();
    ArrayList<String> weekly = new ArrayList<>();
    ArrayList<String> monthly = new ArrayList<>();
    ArrayList<String> quarterly = new ArrayList<>();
    ArrayList<String> semiAnnual = new ArrayList<>();
    ArrayList<String> annual = new ArrayList<>();
    ArrayList<String> every5Years = new ArrayList<>();

    public void build(ArrayList <Expense> expenses) {
        for (String category : categoriesMap.keySet()) {
            String frequency = categoriesMap.get(category)[1];
            try {
                switch (frequency) {
                    case "One-time" ->       oneTime.add(category);
                    case "Daily" ->          daily.add(category);
                    case "Weekly" ->         weekly.add(category);
                    case "Monthly" ->        monthly.add(category);
                    case "Quarterly" ->      quarterly.add(category);
                    case "Semi-Annual" ->    semiAnnual.add(category);
                    case "Annual" ->         annual.add(category);
                    case "Every 5 years" ->  every5Years.add(category);
                }
            } catch (Exception e) {
                System.err.println("Error in build function ExpenseBuilder.java");
            }
        }

        // 1 year back ...   1-6-2024
        // ! When Adding MUST DO IT LINEARLLY for each category EARLIEST TO LATEST!!!!

        // Daily
        dailyExpensesAdder(expenses, 2024, 12);
        dailyExpensesAdder(expenses, 2025, 5);

        // Weekly
        weeklyExpenseAdder(expenses, 2024, 12);
        weeklyExpenseAdder(expenses, 2025, 5);

        // Monthly
        monthlyExpenseAdder(expenses, 2024, 12);
        monthlyExpenseAdder(expenses, 2025, 5);

        // Quarterly
        quarterlyExpenseAdder(expenses, 2024, 4);
        quarterlyExpenseAdder(expenses, 2025, 1);

        // Semi-Annual
        semiAnnualExpenseAdder(expenses, 2024, 2);
        semiAnnualExpenseAdder(expenses, 2025, 1);

        // Annual
        annualExpenseAdder(expenses, 2024);
        annualExpenseAdder(expenses, 2025);
    }

    public void dailyExpensesAdder(ArrayList<Expense> expenses, int year, int months) {
        for (int month=1; month < months + 1; month++) {
            int numberOfDays = YearMonth.of(year, month).lengthOfMonth();  // static factory method 'of'
            for (int date=1; date < numberOfDays+1; date++) {
                for (String dailyCategory : daily) {
                    double amount = Double.parseDouble(categoriesMap.get(dailyCategory)[0]);
                    expenses.add(new Expense(amount, year, month, date, dailyCategory, "",  "Daily"));
                }
            }
            increaseAmount(daily, "Daily", 0.005);
            }
    }

    public void weeklyExpenseAdder(ArrayList <Expense> expenses, int year, int months) {
        for (int month=1; month < months + 1; month++) {  // Loop through months
            for (int date = 7; date < 29; date += 7) {    // Loop starting from 7 to 28
                for (String weeklyCategory : weekly) {    // Loop throuhg the categories in weekly list
                    double amount = Double.parseDouble(categoriesMap.get(weeklyCategory)[0]);
                    expenses.add(new Expense(amount, year, month, date, weeklyCategory, "", "Weekly"));
                }
            }
            increaseAmount(weekly, "Weekly", 0.005);
        }
    }

    public void monthlyExpenseAdder(ArrayList <Expense> expenses, int year, int months) {
        HashMap<String, Integer> monthlyCategoryPaymentDate = makeDateMap(monthly);
        
        // add expenses per category for every months
        for (int month = 1; month < months + 1; month++) {
            for (String monthlyCategory : monthly) {
                double amount = getCategoryAmount(monthlyCategory);
                int date = monthlyCategoryPaymentDate.get(monthlyCategory);
                expenses.add(new Expense(amount, year, month, date, monthlyCategory, "", "Monthly"));
            }
            increaseAmount(monthly, "Monthly", 0.005);
        }
    }

    // @param quarters should be an integer between 1 - 4 inclusive
    public void quarterlyExpenseAdder(ArrayList <Expense> expenses, int year, int quarters) {
        if (5 > quarters && quarters > 0) {
            HashMap<String, Integer> quarterlyCategoryPaymentDate = makeDateMap(quarterly);
            for (String quarterCategory : quarterly) {
                int startMonth = randomInt(3);
                for (int month = startMonth; month < quarters * 3 + 1; month+=3) {
                    double amount = getCategoryAmount(quarterCategory);
                    int date = quarterlyCategoryPaymentDate.get(quarterCategory);
                     expenses.add(new Expense(amount, year, month, date, quarterCategory, "", "Quarterly"));
                }
            }
        }
    }

    // @param halfYears should be an integer between 1 - 2 inclusive
    public void semiAnnualExpenseAdder(ArrayList<Expense> expenses, int year, int halfYears) {
        if (halfYears < 3 && halfYears > 0) {
            HashMap<String, Integer> semiAnnualCategoryPaymentDate = makeDateMap(semiAnnual);
            switch (halfYears) {
                case 1 -> {
                    for (String semiAnnualCategory : semiAnnual) {
                        double amount = getCategoryAmount(semiAnnualCategory);
                        int date = semiAnnualCategoryPaymentDate.get(semiAnnualCategory);
                        expenses.add(new Expense(amount, year, randomInt(6), date, semiAnnualCategory, "", "Semi-Annual"));
                    }
                    increaseAmount(semiAnnual, "Semi-Annual", 0.035);
                }
                case 2 -> {
                    for (String semiAnnualCategory : semiAnnual) {
                        double amount = getCategoryAmount(semiAnnualCategory);
                        int date = semiAnnualCategoryPaymentDate.get(semiAnnualCategory);
                        int startMonth = randomInt(6);
                        expenses.add(new Expense(amount, year, startMonth, date, semiAnnualCategory, "", "Semi-Annual"));
                        expenses.add(new Expense(amount, year, startMonth + 6, date, semiAnnualCategory, "", "Semi-Annual"));
                    }
                    increaseAmount(semiAnnual, "Semi-Annual", 0.07);
                }
            }
        }
    }

    // Annual expense consistently generate january 1st
    public void annualExpenseAdder(ArrayList <Expense> expenses, int year) {
        for (String annualCategory : annual) {
            double amount = getCategoryAmount(annualCategory);
            expenses.add(new Expense(amount, year, 1, 1, annualCategory, "", "Annual"));
        }
        increaseAmount(annual, "Annual", 0.08);
    }

    private int randomInt(int end) {  // Generates a random number from the range of 1-end inclusive
        return (int) (Math.random() * (end- 1) + 1 + 1);
    }

    private double getCategoryAmount(String category) {
        // returns amount value from array inside of categories map
        return Double.parseDouble(categoriesMap.get(category)[0]);
    }

    //
    private void increaseAmount(ArrayList<String> categories, String frequency, double decimalIncrease) {
        for (String category: categories) {
            double amount = Double.parseDouble(categoriesMap.get(category)[0]);
            amount += amount * decimalIncrease;
            categoriesMap.put(category, new String[] {String.valueOf(amount), frequency});
        }
    }

    // Builds a hash map to store dates for recurring expenses
    private HashMap<String, Integer> makeDateMap(ArrayList<String> categories) {
        HashMap<String, Integer> categoryPaymentDate = new HashMap<>();
        // puts each category in monthly into the hash map key and uses a randInt to assign a date as value
        for (String category : categories) {
            categoryPaymentDate.put(category, randomInt(28));
        }

        return categoryPaymentDate;
    }

    public ExpenseBuilder() {
        // Divide all "Monthly" amounts above 10000 by 10
        for (String category : categoriesMap.keySet()) {
            String[] arr = categoriesMap.get(category);
            if (arr[1].equals("Monthly")) {
                double amount = Double.parseDouble(arr[0]);
                if (amount > 10000) {
                    amount = amount / 10.0;
                    arr[0] = String.valueOf(amount);
                    categoriesMap.put(category, arr);
                }
            }
        }
    }
}
