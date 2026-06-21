package org.soldevelo.task;

import java.util.List;

public class Main {

    private static final int LIMIT = 105;
    private static final int LOW_DIVISOR = 3;
    private static final int ADVISORY_DIVISOR = 5;
    private static final int WARN_DIVISOR = 7;

    public static void main(String[] args) {
        List<AlertRule> rules = List.of(
                new DivisibleByRule(LOW_DIVISOR, "LOW"),
                new DivisibleByRule(ADVISORY_DIVISOR, "ADVISORY"),
                new DivisibleByRule(WARN_DIVISOR, "WARN")
        );

        for (int i = 1; i <= LIMIT; i++) {
            System.out.println(combine(i, rules));
        }
    }

    public static String combine(int number, List<AlertRule> rules) {
        StringBuilder result = new StringBuilder();
        for (AlertRule alertRule : rules){
            if (alertRule.matches(number)){
                result.append(alertRule.label());
            }
        }
        return result.isEmpty() ? String.valueOf(number) : result.toString();
    }
}