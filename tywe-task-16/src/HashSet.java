import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A hash table-based implementation of the Set interface.
 *
 * @author Tomas
 * @version 2021-02-10
 */
public class HashSet<T> implements Set<T> {
//    private List<T>[] table;
    private ArrayList<LinkedList<T>> table;
    private int size;                         //number of object, not buckets!!
    
    /**
     * Creates a hash table with the given capacity (amount of buckets).
     *
     * @throws IllegalArgumentException if capacity <= 0.
     */
    public HashSet(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(
                "capacity must be a positive, non-zero value! Provided: " + capacity);
        }
        else{
            table = new ArrayList<>();
            for(int i = 0; i < capacity; i++){
                LinkedList<T> bucket = new LinkedList<>();
                table.add(i, bucket);
            }
        }


        // We want to do the following:
        //
        //     table = new LinkedList<String>[capacity];
        //
        // However, that won't compile ("generic array creation")
        // since Java generics and arrays don't get along very well.
        // Instead we need to do the following:
        //
        //     table = new LinkedList[capacity];
        //
        // The above will compile, but with a warning. The proper
        // approach is to document why the warning can be safely
        // ignored and then suppress the warning. Thus:

        /* 
         * This array will contain only LinkedList<T>
         * instances, all created in the add method. This
         * is sufficient to ensure type safety.
         */
//        @SuppressWarnings("unchecked") // for this declaration only
//        List<T>[] t = new LinkedList[capacity];
//        for(int i = 0; i < capacity; i++){
//            t[i] = new LinkedList<>();
//        }
//
//        table = t;
    }

    /**
     * Adds the given element to the set.
     *
     * Complexity: O(1) expected time.
     *
     * @param elem An element to add to the set.
     * @return true if the set did not contain the element, otherwise false.
     */
    public boolean add(T elem) {
        int hashValue = hash(elem);
        LinkedList<T> current = table.get(hashValue);
        if(current.size() == 0){
            current.addFirst(elem);
            size++;
            return true;
        }
        else{
            if(!current.contains(elem)){
                current.addLast(elem);
                size++;
                return true;
            }
        }
        return false;
    }

    /**
     * Removes the given element from the dictionary, if it is present.
     *
     * Complexity: O(1) expected time.
     *
     * @param elem An element to remove from the set.
     * @return true if the set contained the element, false otherwise.
     */
    public boolean remove(T elem) {
        int hashValue = hash(elem);
        LinkedList<T> current = table.get(hashValue);
        if(current.isEmpty()){
            return false;
        }
        else {
            if (current.contains(elem)) {
                current.remove(elem);
                size--;
                return true;
            }
        }
        return false;
    }

    /**
     * Check if an element is in the Set.
     *
     * Complexity: O(1) expected time.
     *
     * @param elem An element to look for.
     * @return true if the element is in the set, false otherwise.
     */
    public boolean contains(T elem) {
        int hashValue = hash(elem);
        LinkedList<T> current = table.get(hashValue);
        if(current.contains(elem)){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Returns the number of elements in this set.
     *
     * Complexity: O(1) expected time.
     *
     * @return The amount of elements in this set.
     */
    public int size() {
        return size;
    }

    public int hash(T elem){
            int hashVal = elem.hashCode() % table.size();
            if (hashVal < 0){
                return hashVal + table.size();      //hashVal must be in the range between 0 - tableSize
            }
            return hashVal;
    }

//    public boolean equals(Object elem){
//        if (this == elem) {
//            return true;
//        }
//        return false;
//    }

    public static void main(String[] args) {
        HashSet<String> myHash = new HashSet<>(11);
        System.out.println(myHash.add("Tomas"));
        System.out.println(myHash.add("Tomas"));
        myHash.add("Window");
        myHash.add("Edit");
        myHash.add("56");
        System.out.println(myHash.add("56"));
        //System.out.println(myHash.contains("jonas"));
//        for (LinkedList<String> lists : myHash){
//            System.out.println(lists);
//        }

    }


}
