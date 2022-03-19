
public class QuicksortFixedPivotInsertion extends QuicksortFixedPivot implements IntSorter{

    private InsertionSort mySorter;

    public QuicksortFixedPivotInsertion(){
        super();
        mySorter = new InsertionSort();
    }

    /**
     * Sorts the array in-place into ascending numerical order.
     *
     * @param v An array of ints.
     */

    @Override
    public void sort(int[] v) {
        quickSort(v,0, v.length-1);
    }

    public void quickSort(int[] v, int low, int high){
        if(low < high){
            int p = partition(v, low, high);
            int sizeOfLeftSubArray = (p - 1) - low + 1;
            int sizeOfRightSubArray = high - (p - 1) + 1;
            if(sizeOfLeftSubArray < 11){
                mySorter.insertionSort(v,low,p-1);
            }
            if(sizeOfRightSubArray < 11){
                mySorter.insertionSort(v,p+1, high);
            }
                quickSort(v, low, p - 1);
                quickSort(v, p + 1, high);
        }
    }

}

