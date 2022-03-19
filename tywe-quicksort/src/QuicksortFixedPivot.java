public class QuicksortFixedPivot implements IntSorter {

    public QuicksortFixedPivot(){

    }

    /**
     * Sorts the array in-place into ascending numerical order.
     *
     * @param v An array of ints.
     */
    @Override
    public void sort(int[] v) {
        quickSort(v,0, v.length - 1);
    }
    /*
     * This is a recursive helper method that essentially
     * runs the quicksort algorithm.
     * @param v An array of ints
     * @param low
     *
     */
    public void quickSort(int[] v, int low, int high){
        if(low < high){
            int p = partition(v, low, high);
            quickSort(v,low,p-1);
            quickSort(v,p+1,high);
        }
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
        int pivot = v[high];
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(v[j] < pivot){
                i++;
                int temp = v[i];
                v[i] = v[j];
                v[j] = temp;
            }
        }
        int temp = v[i+1];
        v[i+1] = v[high];
        v[high] = temp;
        return i + 1;
    }
}
