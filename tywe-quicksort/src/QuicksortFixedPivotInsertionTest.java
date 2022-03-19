import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class QuicksortFixedPivotInsertionTest extends IntSorterTest {

    private QuicksortFixedPivotInsertion mySorter;

    @Override
    protected IntSorter getIntSorter() {
        return new QuicksortFixedPivotInsertion();
    }

    @Before
    public void setUp() {
        super.setUp();

        mySorter = (QuicksortFixedPivotInsertion) getIntSorter();
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void partitionDoesntPickAPivotElementWhenArrayIsEmpty(){
        //Array
        int[] emptyArray = new int[0];
        mySorter.partition(emptyArray,0,0);
    }

    @Test
    public void partitionPicksAPivotElementWhenArrayHasSingleElement(){
        //Arrange
        int[] singleElementArray = new int[]{4};
        //Act
        int index = mySorter.partition(singleElementArray,0,0);
        //Assert
        assertThat(index, equalTo(0));
    }
}