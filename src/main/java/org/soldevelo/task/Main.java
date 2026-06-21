package org.soldevelo.task;

public class Main {

    private static final int LIMIT = 20;
    private static final int LOW_DIVISOR = 3;
    private static final int ADVISORY_DIVISOR = 5;

    public static void main(String[] args) {
        for (int i = 1; i <= LIMIT; i++) {
            if (i % LOW_DIVISOR == 0 && i % ADVISORY_DIVISOR == 0) {
                System.out.println("LOWADVISORY");
            } else if (i % LOW_DIVISOR == 0) {
                System.out.println("LOW");
            } else if (i % ADVISORY_DIVISOR == 0) {
                System.out.println("ADVISORY");
            } else {
                System.out.println(i);
            }
        }
    }
}