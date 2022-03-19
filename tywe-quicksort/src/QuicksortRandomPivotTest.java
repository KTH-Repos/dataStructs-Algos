import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class QuicksortRandomPivotTest extends IntSorterTest {

    private QuicksortRandomPivot mySorter;
    private Data elements;


    @Override
    protected IntSorter getIntSorter() {
        return new QuicksortRandomPivot();
    }

    @Before
    public void setUp() {
        super.setUp();

        mySorter = (QuicksortRandomPivot) getIntSorter();
        elements = new Data(1,20, Data.Order.RANDOM);
    }

    @Test(expected = IllegalArgumentException.class)
    public void partitionDoesNotPickAPivotElementWhenArrayIsEmpty(){
        //Array
        int[] emptyArray = new int[0];
        mySorter.partition(emptyArray,0,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void randomPartitionDoesNotPickAPivotWhenArrayIsEmpty(){
        //Arrange
        int[] emptyArray = new int[0];
        mySorter.randomPartition(emptyArray,0,0);
    }

    @Test
    public void randomPartitionPlacesThePivotAtTheEndOfTheList(){
        //Arrange
        int[] elementsArray = elements.createData(elements.max);
        //Act
        int pivot = mySorter.randomPartition(elementsArray,0,19);
        //Assert
        assertThat(elementsArray[elementsArray.length-1], equalTo(pivot));
    }

}