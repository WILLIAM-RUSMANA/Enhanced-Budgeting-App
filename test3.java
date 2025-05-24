public class test3 {
    public static void main(String[] args) {
        for (Expense expense : (new randomData().generateRandomData(2000))) {
            System.out.println(expense.getAmount() + "   " + expense.getCategory() + "   " + expense.getDate() + " " + expense.getMonth() + " " + expense.getYear());
        }
    }

}
