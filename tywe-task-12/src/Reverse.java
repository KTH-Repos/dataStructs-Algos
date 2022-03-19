import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * A class for reversing List and array types.
 *
 * @author Tomas
 * @version 2020-12-01
 */
public class Reverse {

    /**
     * Return a reversed copy of the argument array.
     * The passed array is NOT mutated.
     *
     * @param array An array.
     * @return A reversed copy of array.
     */
    public int[] reversed(int[] array) {
        if (array.length > 1) {
            int[] arrayCopy = array.clone();
            for (int i = 0; i < arrayCopy.length / 2; i++) {
                int temp = arrayCopy[i];
                arrayCopy[i] = arrayCopy[arrayCopy.length - 1 - i];
                arrayCopy[arrayCopy.length - 1 - i] = temp;
            }
            return arrayCopy;
        }
        return array;

    }

    /**
     * Return a reversed copy of the argument List.
     * The passed List is NOT mutated.
     *
     * @param list A List.
     * @return A reversed copy of list.
     */
    public List<Integer> reversed(List<Integer> list) {
        if (list.size() > 1){
            List<Integer> listCopy = new ArrayList<>();
            for (int i = 0; i < list.size(); i++){
                listCopy.add(list.get(i));
            }
            for(int i = 0; i < listCopy.size()/2; i++){
                Collections.swap(listCopy, i,listCopy.size() - 1 - i);
            }
            return listCopy;
        }
        return list;
    }

    public static void main (String[] args)
    {
        int[] num = new int[]{1,2,3,4,5,6};
        Reverse reverse = new Reverse();
        int[] reversedNum = reverse.reversed(num);
        for(int i = 0; i < reversedNum.length; i++ ){
            System.out.println(reversedNum[i]);
        }

    }
}
