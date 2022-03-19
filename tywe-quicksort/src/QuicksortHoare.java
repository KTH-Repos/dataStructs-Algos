public class QuicksortHoare implements IntSorter {

    /**
     * Sorts the array in-place into ascending numerical order.
     *
     * @param v An array of ints.
     */
    @Override
    public void sort(int[] v) {
        quickSort(v,0,v.length-1);
    }

    public void quickSort(int[] v, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(v,low,high);
            quickSort(v, low, partitionIndex);
            quickSort(v, partitionIndex + 1, high);
        }
    }

    public int partition(int[] v, int low, int high){
        int pivot = v[(low+high)/2];
        int highIndex = high + 1;
        int lowIndex = low - 1;

        while(true){
            do{
                lowIndex++;
            }while (v[lowIndex] < pivot);

            do{
                highIndex--;
            }while(v[highIndex] > pivot);

            if(lowIndex < highIndex){
                exchange(v,lowIndex,highIndex);
            }
            else{
                return highIndex;
            }
        }
    }

    public void exchange(int[] v, int i, int j) {
        int temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }
}
