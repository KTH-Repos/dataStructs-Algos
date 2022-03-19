import java.util.Random;

public class QuicksortRandomPivot extends QuicksortFixedPivot implements IntSorter {

    public QuicksortRandomPivot(){
        super();
    }

    /**
     * Sorts the array in-place into ascending numerical order.
     *
     * @param v An array of ints.
     */
    @Override
    public void sort(int[] v) {
        super.quickSort(v,0,v.length-1);
    }

    /*
     * It switches the elements into their proper place
     * in the array by taking the last element in the
     * array as a pivot. The pivot is chosen randomly and
     * placed at the end of the array first.
     *
     * @param v the array to be sorted
     * @param low the first element of the array from which to start iterating.
     * @param high the last element of the array. It is also the pivot.
     * @return the index of the element which divides the smaller numbers and the larger numbers in contrast with the pivot
     */
    public int partition(int[] v, int low, int high){
        randomPartition(v,low,high);
        return super.partition(v,low,high);
    }

    /*
     * It chooses a random element from the array to be used
     * as a pivot for quicksort. It then places the randomly
     * chosen element at the end of the list.
     *
     * @param v the array to be sorted
     * @param low the first element of the array
     * @param high the last element of the array.
     * @return the pivot
     */
    public int randomPartition(int[] v, int low, int high){
        Random random = new Random();
        int pivot = random.nextInt(high - low)+low;
        int temp = v[pivot];
        v[pivot] = v[high];
        v[high] = temp;
        return temp;
    }
}
