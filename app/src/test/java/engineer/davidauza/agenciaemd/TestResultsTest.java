package engineer.davidauza.agenciaemd;

import org.junit.Test;
import engineer.davidauza.agenciaemd.TestResults;

import static org.junit.Assert.*;

public class TestResultsTest {
    @Test
    public void score_is_correct() {
        TestResults tr = new TestResults();
        assertEquals(3,  tr.getScore((byte) 0, false, true, true, false));
        assertEquals(3,  tr.getScore((byte) 0, true));
    }
}
