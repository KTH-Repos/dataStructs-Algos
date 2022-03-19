import java.util.List;

/**
 * The BoxProcessor class sorts and searches
 * cllections of Box objects.
 * @author Tomas
 * @version 2020-11-26
 */
public class BoxProcessor {

    /**
     * Create a BoxProcessor
     */
    public BoxProcessor() {
        //constructor for BoxProcessor
    }

    /**
     * Sort an array of Box objects using insertion sort
     * @param array to be sorted
     * @return
     */
    public void sort(Box[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int j = i;
            while ( j > 0 && array[j - 1].compareTo(array[j]) == 1) {
                    Box temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    j = j - 1;
            }
        }

    }

    /**
     * sort a list of Box objects using insertion sort
     * @param list to be sorted
     * @return
     */
    public void sort(List<Box> list)
    {
        int n = list.size();
        for (int i = 1; i < n; i++){
            Box temp = list.get(i);
            int j = i;
            while( j > 0 && list.get(j - 1).compareTo(list.get(j)) == 1){
                list.set(j, list.get(j - 1));
                list.set(j - 1, temp);
                j = j - 1;
            }

        }

    }
    /**
     * search through Box objects in array using brute force
     * @param array to be searched
     * @param box to be matched with elements in array
     */
    public int sequentialSearch(Box[] array, Box box)
    {
        for (int i = 0; i < array.length; i++){
            if (array[i].compareTo(box) == 0){
                return i;
            }
        }
        return -1;
    }
    /**
     * search through Box objects in list using brute force
     * @param list to be searched
     * @param box to be matched with elements in list
     */
    public int sequentialSearch(List<Box> list, Box box)
    {
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).compareTo(box) == 0){
                return i;
            }
        }
        return -1;
    }
    /**
     * seatch through Box objects in array using binary search
     * @param array to be searched
     * @param box to be matched with elements in list
     */
    public int binarySearch(Box[] array, Box box)
    {
        int lowerBound = 0;
        int upperBound = array.length - 1;
        while (lowerBound <= upperBound){
            int index = (int) (Math.floor (lowerBound + upperBound) / 2);      //approximation
            if (array[index].compareTo(box) == 0){
                return index;
            }
            else if (array[index].compareTo(box) == 1){
                upperBound = index - 1;
            }
            else if (array[index].compareTo(box) == -1){
                lowerBound = index + 1;
            }
        }
        return -1;
    }
    /**
     * search through Box objects in list using binary search
     * @param list to be searched
     * @param box to be matched with elements in list
     */
    public int binarySearch(List<Box> list, Box box){
        int lowerBound = 0;
        int upperBound = list.size() - 1;
        while (lowerBound <= upperBound){
            int index = (int) (Math.floor (lowerBound + upperBound) / 2);   //approximation
            if (list.get(index).compareTo(box) == 0){
                return index;
            }
            else if (list.get(index).compareTo(box) == 1){
                upperBound = index - 1;
            }
            else if (list.get(index).compareTo(box) == -1){
                lowerBound = index + 1;
            }
        }
        return -1;
    }

    /*
    //My own testing
    public void displayArray(Box[] array)
    {
        for(int i = 0; i < array.length - 1; i++ ){
            System.out.print(array[i] + "");
        }
        System.out.println();
    }
    public void displayArray(List<Box> list)
    {
        for(int i = 0; i < list.size() - 1; i++ ){
            System.out.print(list.get(i) + "");
        }
        System.out.println();
    }

    public static void main(String[] args){
        List<Box> box = new ArrayList<>();
        Box box1 = new Box(2,2,2);
        Box box2 = new Box(3,3,3);
        Box box3 = new Box(4,4,4);
        Box box4 = new Box(5,5,5);
        Box box5 = new Box(7,7,7);
        /*box.add(box1);
        box.add(box2);
        box.add(box3);
        box.add(box4);
        box.add(box5);*/
       // for(int i = 0; i < box.size() - 1; i++ ){
           // System.out.print(box.get(i) + "");
        //}
      //  Box[] array = {box5,box3,box2,box4,box1};
      //  BoxProcessor boxProcessor = new BoxProcessor();
      //  boxProcessor.sort(array);
      //  boxProcessor.displayArray(array);
        //Box searchedBox = new Box(6,6,6);
        //boxProcessor.sequentialSearch(array, searchedBox);
    }
