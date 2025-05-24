import java.util.*;

public class Budget extends FinancialItem{
    public Budget(int year, int month) {
        super(year, month);
    }

    public Budget(double amount, int year, int month) {
        super(amount, year, month);
    }

    public Budget(double amount, int year, int month, String category) {
        super(amount, year, month, category);
    }
}