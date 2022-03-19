import java.util.LinkedList;
import java.util.List;

public class MyHashSet<T> implements Set<T> {

    private List<T>[] table;
    private int size;

    public MyHashSet(int capacity){
        if (capacity <= 0) {
            throw new IllegalArgumentException(
                    "capacity must be a positive, non-zero value! Provided: " + capacity);
        }
        else{
            @SuppressWarnings("unchecked") // for this declaration only
            List<T>[] t = new LinkedList[capacity];

            table = t;
        }
    }

    @Override
    public boolean add(T elem) {
        if (!contains(elem)) {
            int hashVal = hash(elem);
            LinkedList current = new LinkedList();
            table[hashVal] = current;
            current.addLast(elem);
            size++;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(T elem) {
        if(!contains(elem)){
            int hashVal = hash(elem);
            List<T> current = table[hashVal];
            current.remove(elem);
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(T elem) {
        int hashVal = hash(elem);
        List<T> current = table[hashVal];
        if(current.contains(elem)){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int size() {
        return size;
    }

    public int hash(T elem){
        int hashVal = elem.hashCode() % table.length;
        if (hashVal < 0){
            return hashVal + table.length;      //hashVal must be in the range between 0 - tableSize
        }
        return hashVal;
    }
}
