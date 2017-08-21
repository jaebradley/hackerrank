package algorithms.implementations;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MissingNumbersIdentifierTest {

    @Test
    public void itShouldIdentifyMissingNumbers() {
        List<Integer> values1 = new ArrayList<>();
        values1.add(203);
        values1.add(203);
        values1.add(204);
        values1.add(204);
        values1.add(204);
        values1.add(205);
        values1.add(205);
        values1.add(205);
        values1.add(206);
        values1.add(206);
        values1.add(206);
        values1.add(207);
        values1.add(208);

        List<Integer> values2 = new ArrayList<>();
        values2.add(203);
        values2.add(204);
        values2.add(205);
        values2.add(206);
        values2.add(207);
        values2.add(208);
        values2.add(203);
        values2.add(204);
        values2.add(205);
        values2.add(206);

        List<Integer> expected = new ArrayList<>();
        expected.add(204);
        expected.add(205);
        expected.add(206);

        assertEquals(expected, MissingNumbersIdentifier.identifyMissingNumbers(values1, values2));
    }
}