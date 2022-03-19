import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

 /**
  * Abstract test class for  implementations.
  *
  * Implementing test classes must override the getIntSorter method.
  *
  * @author Simon Larsén
  * @version 2018-01-16
  */
 public abstract class IntSorterTest {

     private IntSorter mySorter;
     private final int EVEN_LIST_LENGTH = 100;
     private final int ODD_LIST_LENGTH = 99;
     private final int LARGE_LIST_LENGTH = 10000000;
     private Data evenArrayData;
     private Data ascendingElementsArrayData;
     private Data descendingElementsArrayData;
     private Data oddArrayData;
     private Data largeElementsArrayData;
     private Data equalElementsArrayData;


     /**
      * Returns an implementation of the IntSorter interface. Extending classes
      * must override this method.
      *
      * @return An implementation of IntSorter.
      */
     protected abstract IntSorter getIntSorter();

     @Before
     public void setUp() {
         //Arrange
         mySorter = getIntSorter();
         evenArrayData = new Data(200, EVEN_LIST_LENGTH, Data.Order.RANDOM);
         oddArrayData = new Data(199, ODD_LIST_LENGTH, Data.Order.RANDOM);
         ascendingElementsArrayData = new Data(30,40, Data.Order.ASCENDING);
         descendingElementsArrayData = new Data(30,40, Data.Order.DESCENDING);
         equalElementsArrayData = new Data(20,1, Data.Order.RANDOM);
         largeElementsArrayData = new Data(1000000, LARGE_LIST_LENGTH, Data.Order.RANDOM);
     }

     @Test
     public void sortHasNoEffectWhenArrayIsEmpty(){
         //Arrange
         int[] emptyArray = new int[0];
         //Act
         mySorter.sort(emptyArray);
         //Assert
         assertThat(emptyArray.length,equalTo(0));
     }

     @Test
     public void sortHasNoEffectWhenArrayHasOneElement(){
         //Arrange
         int[] oneElementArray = new int[]{4};
         //Act
         mySorter.sort(oneElementArray);
         //Assert
         assertThat(oneElementArray.length, equalTo(1));
     }

     @Test
     public void sortOddElementArrayGivesCorrectOrdering(){
         //Arrange
         int[] oddArray = oddArrayData.createData(oddArrayData.max);
         int[] expected = oddArray.clone();
         //Act
         Arrays.sort(expected);
         mySorter.sort(oddArray);
         //Assert
         assertThat(oddArray, equalTo(expected));
     }

     @Test
     public void sortEvenElementsArrayGivesCorrectOrdering(){
         //Arrange
         int[] evenArray = evenArrayData.createData(evenArrayData.max);
         int[] expected = evenArray.clone();
         //Act
         Arrays.sort(expected);
         mySorter.sort(evenArray);
         //Assert
         assertThat(evenArray, equalTo(expected));
     }

     @Test
     public void sortAscendingElementsArrayGivesNoEffect(){
         //Arrange
         int[] ascendingElementsArray = ascendingElementsArrayData.createData(ascendingElementsArrayData.max);
         int[] expected = ascendingElementsArray.clone();
         //Act
         mySorter.sort(ascendingElementsArray);
         //Assert
         assertThat(ascendingElementsArray, equalTo(expected));
     }

     @Test
     public void sortDescendingElementsArrayGivesCorrectOrdering(){
         //Arrange
         int[] descendingElementsArray = descendingElementsArrayData.createData(descendingElementsArrayData.max);
         List<Integer> expected = Arrays.stream(descendingElementsArray).boxed().collect(Collectors.toList());
         //Act
         mySorter.sort(descendingElementsArray);
         Collections.reverse(expected);
         //Assert
         assertThat(descendingElementsArray, equalTo(expected.toArray()));
     }

     @Test
     public void sortEqualElementsArrayHasNoEffect(){
         //Arrange
         int[] equalElementsArray = equalElementsArrayData.createData(evenArrayData.max);
         int size = equalElementsArray.length;
         //Act
         mySorter.sort(equalElementsArray);
         //Assert
         assertThat(equalElementsArray.length, equalTo(size));
     }

     @Test
     public void sortLargeElementsArrayGivesCorrectOrdering(){
         //Arrange
         int[] largeElementsArray = largeElementsArrayData.createData(largeElementsArrayData.max);
         int[] expected = largeElementsArray.clone();
         //Act
         mySorter.sort(largeElementsArray);
         Arrays.sort(expected);
         //Assert
         assertThat(largeElementsArray,equalTo(expected));
     }

 }
