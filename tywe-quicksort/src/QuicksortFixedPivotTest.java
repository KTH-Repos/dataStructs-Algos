import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class QuicksortFixedPivotTest extends IntSorterTest {

    private Data evenArrayData;
    private Data oddArrayData;
    private Data ascendingElementsArrayData;
    private QuicksortFixedPivot mySorter;

    @Override
    protected IntSorter getIntSorter() {
        return new QuicksortFixedPivot();
    }

    @Before
    public void setUp() {
        super.setUp();

        mySorter = (QuicksortFixedPivot) getIntSorter();
//        evenArrayData = new Data(1,50, Data.Order.RANDOM);
//        ascendingElementsArrayData = new Data(10,10, Data.Order.ASCENDING);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void partitionDoesNotPickAPivotElementWhenArrayIsEmpty(){
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