package org.soldevelo.task;

public class Main {

    private static final int LIMIT = 20;
    private static final int LOW_DIVISOR = 3;
    private static final int ADVISORY_DIVISOR = 5;

    public static void main(String[] args) {
        for (int i = 1; i <= LIMIT; i++) {
            System.out.println(combine(i));
        }
    }

    static String combine(int number) {
        StringBuilder result = new StringBuilder();
        if (number % LOW_DIVISOR == 0) {
            result.append("LOW");
        }
        if (number % ADVISORY_DIVISOR == 0){
            result.append("ADVISORY");
        }
        if (result.isEmpty()) {
            return String.valueOf(number);
        }
        return result.toString();
    }
}