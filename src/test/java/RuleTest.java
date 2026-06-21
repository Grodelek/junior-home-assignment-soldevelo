import org.junit.jupiter.api.Test;
import org.soldevelo.task.AlertRule;
import org.soldevelo.task.DivisibleByRule;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.soldevelo.task.Main.combine;

public class RuleTest {
    private static final int LOW_DIVISOR = 3;
    private static final int ADVISORY_DIVISOR = 5;
    private static final int WARN_DIVISOR = 7;
    List<AlertRule> rules = List.of(
            new DivisibleByRule(LOW_DIVISOR, "LOW"),
            new DivisibleByRule(ADVISORY_DIVISOR, "ADVISORY"),
            new DivisibleByRule(WARN_DIVISOR, "WARN")
    );

    @Test
    void noRuleMatchesReturnsNumber() {
        assertEquals("1", combine(1, rules));
        assertEquals("2", combine(2, rules));
    }

    @Test
    void lowDivisorTest(){
       assertEquals("LOW", combine(LOW_DIVISOR, rules));
    }

    @Test
    void advisoryDivisorTest(){
        assertEquals("ADVISORY", combine(ADVISORY_DIVISOR, rules));
    }

    @Test
    void lowAdvisoryDivisorTest(){
        assertEquals("LOWADVISORY", combine(15, rules));
    }

    @Test
    void warnDivisorTest(){
        assertEquals("WARN", combine(WARN_DIVISOR, rules));
        assertEquals("WARN", combine(14, rules));
    }

    @Test
    void lowWarnDivisorTest(){
        assertEquals("LOWWARN", combine(21, rules));
    }

    @Test
    void advisoryWarnDivisorTest(){
        assertEquals("ADVISORYWARN", combine(35, rules));
    }

    @Test
    void lowAdvisoryWarnTest(){
        assertEquals("LOWADVISORYWARN", combine(105, rules));
    }
}


