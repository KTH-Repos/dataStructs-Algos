import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * A singly linked list.
 * 
 * @author (Tomas)
 * @version (2021-01-25)
 */
public class LinkedList<T> {
    private ListElement<T> first;   // First element in list.
    private ListElement<T> last;    // Last element in list.
    private int size;               // Number of elements in list.

    /**
     * A list element.
     */
    private static class ListElement<T> {
        public T data;
        public ListElement<T> next;

        public ListElement(T data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Creates an empty list.
     */
    public LinkedList() {
        // TODO
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Inserts the given element at the beginning of this list.
     *
     * @param element An element to insert into the list.
     */
    public void addFirst(T element) {
        // TODO
        ListElement<T> firstElement = new ListElement<>(element);
        if (this.first == null) {
            this.first = firstElement;
            this.last = firstElement;
            size++;
        }
        else if(this.first == this.last){
            ListElement<T> head = this.first;
            firstElement.next = head;
            this.first = firstElement;
            size++;
        }
        else {
            ListElement<T> head = this.first;
            firstElement.next = head;
            this.first = firstElement;
            size++;
        }
    }

    /**
     * Inserts the given element at the end of this list.
     *
     * @param element An element to insert into the list.
     */
    public void addLast(T element) {
        // TODO
        ListElement<T> lastElement = new ListElement<>(element);
        if (this.first == null) {
            this.first = lastElement;
            this.last = lastElement;
            size++;
        }
        else if (this.first == this.last) {
            ListElement<T> head = this.first;
            head.next = lastElement;
            this.last = lastElement;
            size++;
        } else {
            ListElement<T> tail = this.last;
            tail.next = lastElement;
            this.last = lastElement;
            size++;
        }
    }

    /**
     * @return The head of the list.
     * @throws NoSuchElementException if the list is empty.
     */
    public T getFirst() {
        // TODO
        if (isEmpty()) {
            throw new NoSuchElementException("No such element in the list");
        }
        else if(this.first == this.last){
            ListElement<T> head = this.first;
            return head.data;
        }
        else {
            ListElement<T> head = this.first;
            return head.data;
        }
    }

    /**
     * @return The tail of the list.
     * @throws NoSuchElementException if the list is empty.
     */
    public T getLast() {
        // TODO
        if (isEmpty()) {
            throw new NoSuchElementException("No such element in the list");
        } else if (this.first == this.last) {
            ListElement<T> tail = this.last;
            return tail.data;
        } else {
            ListElement<T> tail = this.last;
            return tail.data;
        }

    }

    /**
     * Returns an element from a specified index.
     *
     * @param index A list index.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public T get(int index) {
        // TODO
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException("The provided index is out of bounds");
        } else {
            int count = 0;
            for (ListElement<T> current = this.first; current != null; current = current.next) {
                if (count == index) {
                    return current.data;
                }
                count++;
            }
        }
        return null;
    }

    /**
     * Removes the first element from the list.
     *
     * @return The removed element.
     * @throws NoSuchElementException if the list is empty.
     */
    public T removeFirst() {
        // TODO
        if (this.first == null) {
            throw new NoSuchElementException("This element doesn't exist");
        }
        else if (this.first == this.last) {
            ListElement<T> head = this.first;
            this.first = null;
            this.last = null;
            size = 0;
            return head.data;
        }
        else {
            ListElement<T> oldFirst = this.first;
            this.first = oldFirst.next;
            oldFirst.next = null;
            size--;
            return oldFirst.data;
        }
    }



    /**
     * Removes all of the elements from the list.
     */
    public void clear() {
        // TODO
        this.first = null;
        this.last = null;
        size = 0;
    }

    /**
     * @return The number of elements in the list.
     */
    public int size() {
        // TODO
        return size;
//        int count = 0;
//        ListElement<T> current = this.first;
//        while(current != null){
//            current = current.next;
//            count++;
//        }
//        return count;
    }

    /**
     * Note that by definition, the list is empty if both first and last
     * are null, regardless of what value the size field holds (it should
     * be 0, otherwise something is wrong).
     *
     * @return <code>true</code> if this list contains no elements.
     */
    public boolean isEmpty() {
        return first == null && last == null;
    }

    /**
     * Creates a string representation of this list. The string
     * representation consists of a list of the elements enclosed in
     * square brackets ("[]"). Adjacent elements are separated by the
     * characters ", " (comma and space). Elements are converted to
     * strings by the method toString() inherited from Object.
     *
     * Examples:
     *  "[1, 4, 2, 3, 44]"
     *  "[]"
     *
     * @return A string representing the list.
     */
    public String toString() {
        // TODO
        ArrayList<T> elements = new ArrayList<>(this.size);
        for (ListElement<T> current = this.first; current != null; current = current.next) {
            elements.add(current.data);
        }
        Object[] arrayOfElements = elements.toArray();
        return Arrays.toString(arrayOfElements);
    }
}

//    public static void main(String[] args) {
//        LinkedList<Integer> numbers = new LinkedList<>();
//    //    ListElement<Integer> first = new ListElement<>(3);
//        numbers.addFirst(5);
//        numbers.addFirst(4);


