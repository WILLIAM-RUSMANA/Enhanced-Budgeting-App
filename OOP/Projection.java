package OOP;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.NoSuchElementException;


public class Projection {
    // Returns an array of doubles where 
    // index [0] contains lower projection val 
    // index [2] contains higher projection val
    public static double[] project(ArrayList<Expense> expenses, int yearOfProjection, int monthOfProjection) {
        YearMonth projectionDate = YearMonth.of(yearOfProjection, monthOfProjection);
        int projectionNumberOfDays = projectionDate.lengthOfMonth();

        double lowerProjectedExpense = 0;
        double higherProjectedExpense = 0;
        double dailyProjectedExpense = 0;
        try {
            // relevantExpenses: Expenses a year back
            ArrayList<Expense> relevantExpenses = Projection.filterRelevantExpense(expenses, yearOfProjection, monthOfProjection);

            // Use the first element as the earliest (since we now iterate from 0 to size-1)
            if (relevantExpenses.isEmpty()) {
                throw new NoSuchElementException("Relevant Expenses is empty");
            }
            Expense earliestAvailableExpense = relevantExpenses.getLast();
            int[] earliestAvailableExpenseDate = {earliestAvailableExpense.getYear(), earliestAvailableExpense.getMonth(), earliestAvailableExpense.getDate()};

            // A month back from the earliest available expense date
            // Used to check for the daily and monthly projection
            int[] previousMonthToCheck = previousMonthDayFinder(earliestAvailableExpenseDate);

            // 3 month's ago for quarterly projection
            int[] quarterlyExpenseToCheck = getQuarterlyExpenseToCheck(yearOfProjection, monthOfProjection);
            // 6 month's ago for semi-annual projection
            int[] semiAnnualExpenseToCheck = getSemiAnnualExpenseToCheck(yearOfProjection, monthOfProjection);
            // get last year's annual projection
            int[] annualExpenseToCheck = getAnnualExpenseToCheck(yearOfProjection, monthOfProjection);

            for (Expense expense : relevantExpenses) {  // Use enhanced for-each loop
                switch (expense.getFrequency()) {
                    case "Daily" -> {
                        if (expense.getMonth() == previousMonthToCheck[1]) {
                            dailyProjectedExpense += expense.getAmount();
                        }
                    }
                    case "Monthly" -> {
                        if (expense.getMonth() == previousMonthToCheck[1]) { lowerProjectedExpense += expense.getAmount(); }
                    }
                    case "Quarterly" -> {
                        if (expense.getMonth() == quarterlyExpenseToCheck[1] && expense.getYear() == quarterlyExpenseToCheck[0]) {
                            lowerProjectedExpense += expense.getAmount();
                        }
                    }
                     case "Semi-Annual" -> {
                        if (expense.getMonth() == semiAnnualExpenseToCheck[1] && expense.getYear() == semiAnnualExpenseToCheck[0]) {
                            lowerProjectedExpense += expense.getAmount();
                        }
                     }
                    case "Annual" -> {
                        if (expense.getMonth() == annualExpenseToCheck[1] && expense.getYear() == annualExpenseToCheck[0]) {
                            lowerProjectedExpense += expense.getAmount();
                        }
                    }
                    case "One-time" -> {
                        if (expense.getMonth() >= quarterlyExpenseToCheck[1] && expense.getYear() >= quarterlyExpenseToCheck[0]) {
                            higherProjectedExpense += expense.getAmount();
                        }
                    }
                }
            }

            // Adjust dailyProjectedExpense to an according value based on the number of days in the respective month
            dailyProjectedExpense = dailyProjectedExpense / previousMonthToCheck[2] * projectionNumberOfDays;

        } catch (NoSuchElementException e) {
            System.err.println("Relevant Expenses is most likely empty");
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("ERROR in Projecting");
            System.err.println(e.getMessage());
        }

        // Take daily expense projection into account
        lowerProjectedExpense += dailyProjectedExpense;
        higherProjectedExpense += lowerProjectedExpense * 1.05;

        return new double[] {lowerProjectedExpense, higherProjectedExpense};
    }

    // Return relevant Expenses which are a year back from the projected 
    // @param expenses should be a sorted arrayList containing expenses ordered by latest to earliest.
    private static ArrayList<Expense> filterRelevantExpense(ArrayList<Expense> expenses, int year, int month) {
        ArrayList <Expense> relevantExpenses = new ArrayList<> ();
        // Use enhanced for-each loop
        for (Expense expense : expenses) {
            if (expense.getYear() == year && expense.getMonth() < month) {
                relevantExpenses.add(expense);
            }
            else if (expense.getYear() == (year - 1) && expense.getMonth() >= month) {
                relevantExpenses.add(expense);
            }
        }
        return relevantExpenses;
    }

   // function that returns previous month's year, month, day value
   private static int[] previousMonthDayFinder(int[] arr) {
        int year = (arr[1] == 1) ? arr[0] - 1 : arr[0];
        int month = (arr[1] > 1) ? arr[1] - 1 : 12;
        int day = YearMonth.of(year, month).lengthOfMonth();

        return new int[] {year, month, day};
   }

   private static int[] getQuarterlyExpenseToCheck(int year, int month) {
        int targetYear = (month < 4) ? (year -1) : year;
        int targetMonth = (month < 4) ? monthSubtractionSolver(month, 3) : month - 3;

        return new int[] {targetYear, targetMonth};
   }

   private static int monthSubtractionSolver(int month, int minusValue) {
        return 12 + month - minusValue;
    }
    private static int[] getSemiAnnualExpenseToCheck(int year, int month) {
        int targetYear = (month < 7) ? (year -1) : year;
        int targetMonth = (month < 7) ? monthSubtractionSolver(month, 7) : month-6;

        return new int[] {targetYear, targetMonth};
    }

    private static int[] getAnnualExpenseToCheck(int year, int month) {
        return new int[] {year-1, month};
    }
}
