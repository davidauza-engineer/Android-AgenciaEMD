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

        // Assertions on Question #3
        assertEquals(10,  tr.getScore((byte) 2, true));
        assertEquals(0,  tr.getScore((byte) 2, false));


        // Assertions on Question #4
        assertEquals(3, tr.getScore((byte) 3, true));
        assertEquals(4, tr.getScore((byte) 3, false, true, false, true));
        assertEquals(6, tr.getScore((byte) 3, true, true, false, false));

        // Assertions on Question #5
        assertEquals(3, tr.getScore((byte) 4, true));
        assertEquals(2, tr.getScore((byte) 4, false, false, false, true));
        assertEquals(3, tr.getScore((byte) 4, false, true, false, false));

        // Assertions on Question #6
        assertEquals(10,  tr.getScore((byte) 5, true));
        assertEquals(0,  tr.getScore((byte) 5, false));

        // Assertions on Question #7
        assertEquals(10,  tr.getScore((byte) 6, true));
        assertEquals(0,  tr.getScore((byte) 6, false));

        // Assertions on Question #9
        assertEquals(3, tr.getScore((byte) 8, true));
        assertEquals(5, tr.getScore((byte) 8, false, true, false, true));
        assertEquals(5, tr.getScore((byte) 8, false, true, false, true));

        // Assertions on Question #10
        assertEquals(10,  tr.getScore((byte) 9, true));
        assertEquals(0,  tr.getScore((byte) 9, false));
    }
}
