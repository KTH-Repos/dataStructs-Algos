import java.util.EmptyStackException;

/**
 * This is an interface for Stack(ADT). It has five abstract methods for
 * adding/removing elements, returning the top element, an accessor of
 * the size of the stack and a method for checking if the stack is empty.
 *
 * @author (Tomas)
 * @version (2021-02-02)
 */

public interface Stack<T> {

    /**
     * Adds element to the top of the stack
     * @param elem The element to be added to the top of the stack.
     */
    void push(T elem);

    /**
     * Removes and returns the top element in the
     * stack, that is the element that was last added
     * to the stack.
     * @return The top element
     * @throws java.util.EmptyStackException if the stack is empty
     */
    T pop()throws EmptyStackException;

    /**
     * Returns the top element in the stack without removing it.
     * @return The top element
     * @throws java.util.EmptyStackException if the stack is empty
     */
    T top()throws EmptyStackException;

    /**
     * Returns the number of element in the stack.
     * @return the total number of elements in the stack
     */
    int size();

    /**
     * Returns true if the stack is empty
     * @return true if the stack is emtpy, false
     * if the stack is not empty.
     */
    boolean isEmpty();
}
