package engineer.davidauza.agenciaemd;

import org.junit.Test;
import engineer.davidauza.agenciaemd.TestResults;

import static org.junit.Assert.*;

public class TestResultsTest {
    @Test
    public void score_is_correct() {
        TestResults tr = new TestResults();

        // Assertions on Question #1
        assertEquals(3,  tr.getScore((byte) 0, true));
        assertEquals(3,  tr.getScore((byte) 0, true, false, false, false));
        assertEquals(6,  tr.getScore((byte) 0, true, true, false, false));
        assertEquals(8,  tr.getScore((byte) 0, true, true, true, false));
        assertEquals(5,  tr.getScore((byte) 0, true, false, true, false));
        assertEquals(7,  tr.getScore((byte) 0, true, false, true, true));

        // Assertions on Question #2
        assertEquals(10,  tr.getScore((byte) 1, true));
        assertEquals(0,  tr.getScore((byte) 1, false));
    }
}
