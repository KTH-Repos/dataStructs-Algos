import org.junit.Before;

import static org.junit.Assert.*;

public class QuicksortRandomPivotInsertionTest extends IntSorterTest {

    @Override
    protected IntSorter getIntSorter() {
        return new QuicksortRandomPivotInsertion();
    }

    @Before
    public void setUp() {
        super.setUp();
    }
}