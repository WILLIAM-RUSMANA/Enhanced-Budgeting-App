package OOP;

import java.time.YearMonth;

public class test3 {
    public static void main(String[] args) {
        YearMonth ym = YearMonth.now();
        YearMonth ym2 = YearMonth.of(2025, 05);
        System.out.println(ym == (ym2));
    }
}

