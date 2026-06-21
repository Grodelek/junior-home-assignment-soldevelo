package org.soldevelo.task;

public class DivisibleByRule implements AlertRule{
    private final int divisor;
    private final String label;

    public DivisibleByRule(int divisor, String label) {
        this.divisor = divisor;
        this.label = label;
    }

    @Override
    public boolean matches(int value) {
        return value % divisor == 0;
    }

    @Override
    public String label() {
        return label;
    }
}
