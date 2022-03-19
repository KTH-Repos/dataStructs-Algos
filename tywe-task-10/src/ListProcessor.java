import java.util.*;

/**
 * Below is a class for ListProcessor. It contains
 * different methods that create a collection of elements
 * inorder to manipulate them by performing shuffles and basic
 * addition by iteration and recursion.
 *
 * @author (Tomas)
 * @version (2020-11-19)
 */

public class ListProcessor
{

    public ListProcessor(){

    }
    /**
     * Create an array
     * @param  from lower bound
     * @param to upper bound
     * @return array with appropriate lower and upper bound
     */
    public int[] arraySequence(int from, int to)
    {
        if (from==to){
            int[] array = new int[0];
            return array;
        }
        else if(to < from){
            throw new IllegalArgumentException("to must be greater than from.");
        }
        else{
            int range = to - from;
            int[] array = new int[range];
            for(int i = 0; i < array.length; i++, from++){
                array[i] = from;
            }
            return array;

        }
    }
    /**
     * Create an ArrayList
     * @param  from lower bound
     * @param to upper bound
     * @return ArrayList with appropriate lower and upper bound
     */
    public List<Integer> listSequence(int from, int to)
    {
        if (from==to){
           List<Integer> list = new ArrayList<>(0);
           return list;
        }
        else if(to < from){
            throw new IllegalArgumentException("to must be greater than from.");
        }
        else{
            int n = to - from;
            List<Integer> list = new ArrayList<>(n);
            for(int i = from; i < to; i++){
                list.add(i);

            }
            return list;
        }
    }
    /**
     * Shuffle the elements of an array
     * @param  numbers
     * @return numbers with shuffled elements
     */
    public int[] shuffled(int[] numbers)
    {
        int [] numbers1 = numbers.clone();
        Random random = new Random();
        for (int i = 0; i < numbers1.length; i++){
            int randomArrayIndex = random.nextInt(numbers1.length);
            int tempIndex = numbers1[randomArrayIndex];
            numbers1[randomArrayIndex] = numbers1[i];
            numbers1[i] = tempIndex;
        }
        return numbers1;
    }
    /**
     * Shuffle the elements of an ArrayList
     * @param  numbers
     * @return numbers with shuffled elements
     */
    public List<Integer> shuffled(List<Integer> numbers)
    {
        List<Integer> numbers1 = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++){
            numbers1.add(numbers.get(i));
        }
        Random random = new Random();
        int n = numbers1.size();
        for (int i = 0; i < n - 1; i++){
            int randomIndex = i + random.nextInt(n - i);
            int elementNumber = numbers1.get(i);
            numbers1.set(i, numbers1.get(randomIndex));
            numbers1.set(randomIndex, elementNumber);
        }
        return numbers1;
    }
    /**
     * Add the elements of an array with iteration
     * @param  numbers
     * @return sum of numbers
     */
    public int sumIterative(int[] numbers)
    {
        int sum = 0;
        if (numbers.length != 0) {
            for (int i : numbers) {
                sum += i;
            }
        }
        return sum;
    }
    /**
     * Add the elements of an arrayList with iteration
     * @param  numbers
     * @return sum of numbers
     */
    public int sumIterative(List<Integer> numbers)
    {
        int sum = 0;
        if (numbers.size() != 0) {
            for (int i : numbers) {
                sum += i;
            }
        }
        return sum;
    }
    /**
     * Add the elements of an array with recursion
     * @param  numbers
     * @return sum of numbers
     */
    public int sumRecursive(int[] numbers)
    {
        if (numbers.length == 0){
            int sum = 0;
            return sum;
        }
        int[] tempNumbers = Arrays.copyOfRange(numbers, 1, numbers.length);
        return numbers[0] + sumRecursive(tempNumbers);
    }
    /**
     * Add the elements of an arrayList with recursion
     * @param  numbers
     * @return sum of numbers
     */
    public int sumRecursive(List<Integer> numbers)
    {
        if (numbers.size() == 0){
            int sum = 0;
            return sum;
        }
        int sum = numbers.get(0) + sumRecursive(numbers.subList(1, numbers.size()));
        return sum;
    }

    public static void main(String[] args)
    {
        ListProcessor listProcessor = new ListProcessor();
       // List<Integer> tom = new ArrayList<>();
        //for (int i = 0; i < 15; i++){
        //    tom.add(i);
        //}
        //System.out.println(tom);
        listProcessor.arraySequence(-9,-3);
       // System.out.println(tom);
    }

}