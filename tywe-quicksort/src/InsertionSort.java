/*
 * This class is an insertion sort implementation of the
 * IntSorter interface. It sorts an array of integers.
 *
 * @author Tomas
 * @version 2021-03-01
 */

public class InsertionSort implements IntSorter {

    public InsertionSort(){
        //constructor for insertion sort
    }

    /**
     * Sorts the array in-place into ascending numerical order.
     *
     * @param v An array of ints.
     */
    @Override
    public void sort(int[] v) {
        System.out.println(insertionSort(v,0, v.length));
//        for(int i =0; i < v.length; i++){
//            System.out.println(v[i]);
//        }
    }
    public boolean insertionSort(int[] v, int low, int high) {
        for (int i = low+1; i < high; i++) {
            int j = i;
            while ( j > 0 && v[j - 1] > v[j]){
                int temp = v[j];
                v[j] = v[j - 1];
                v[j - 1] = temp;
                j = j - 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] myArray = new int[]{1,78,3,23,6,7,4,90,100};
        IntSorter mySorterer = new InsertionSort();
        mySorterer.sort(myArray);
    }


}
