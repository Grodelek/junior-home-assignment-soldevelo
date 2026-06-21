package org.soldevelo.task;

public interface AlertRule {
    boolean matches(int value);
    String label();
}
