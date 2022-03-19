If written answers are required, you can add them to this file. Just copy the relevant questions from the root of the repo, preferably in [Markdown](https://guides.github.com/features/mastering-markdown/) format :)

### Written Answer for Task 16

#### Task 2 - Time Complexities for Data Structures

Operation | Sorted Array | Unosrted Singly Linked List | Hashtable(average) | Hashtable(worst)
--- | --- | --- | --- | --- 
Search for key X | O(log n) | O(n) | O(1) | O(n)
Insert X at start | O(n) | O(1) | O(1) | O(n)
Remove X from end | O(1) | O(n) | O(1) | O(n)

##### Sorted Array
 - Search for key X takes log n with binary search which is appropriate to use with 
  sorted arrays. In best cases it takes O(1) if the index matches the value to be searched for.
 - Insert X at start takes linear time because before insertion all elements in
    array must move one step to the right to make room for X. 
 - Remove X from end takes constant time because only one operation is needed to complete
    the task and moving elemnts is not necessary after deletion of X. 
    
##### Unosrted Singly Linked List
- Search for key X takes linear time as X might be the last element and we have
    to traverse all elements to find it. 
- Insert X at start takes constant time as the head pointer allows only one operation.
- Remove X from end takes linear time as the tail pointer needs to be updated and its
neigbhour set to null because it is the last element. For this to happpen there needs to happen
a traversal. 

##### Hashtable (Average)
- Search for Key X takes constant time as X can be accessed directly by its hashcode.
- Insert X at start takes constant time as X has a unique hashcode which enables it to
    be placed in the first index without traversing the buckets in the list.
- Remove X from end takes constant time as X can be accessed and removed directly by 
    its hashcode.
    
##### Hashtable (Worst)
- Search for key X takes linear time as the hashtable may only have one bucket and in order
    to find X the element must be traversed(if the hashtable is chained) until the end of 
    the bucket if X is in the last spot. 
- Insert X at start Remove X from end take linear time due to some possible collision.


#### Task 3 - Dynamic Tables

1, What is the initial capacity of an ArrayList's internal array?

Answer: The inital capacity is 10. 

2, Starting with the add(E e) method (ln:442), find the line number for the conditional statement used 
to determine that the internal array needs to grow.

Answer: ln:219

3, Looking at the grow(int minCapacity) method (ln:237), which operator is used to decide the new size 
of the internal array?

Answer: The operator >> is used to decide the new size of the internal array. 

4, What is the scaling factor for growth of the internal array?

Answer: The >> operator scales down an integer by half. So the scaling factor is
newCapacity/oldCapacity = (oldCapacity + (oldCapacity / 2))/oldCapacity.

5, If 20 elements had been added to an empty ArrayList, what would the size of the internal array be?

Answer: The empty Arraylist has an array of size 10. The first 10 elements are inserted without difficulty.
Before the 11th element is inserted the internal array is increased to have a size of 15. The next five elements
are inserted without difficulty. Before the 16th element is inserted the internal array is increased to have a size 
of 22. And the last five elements are inserted. 

6, What is the worst, average, and best-case time complexity of the add(E e) method of Arraylist?

Answer:  Best-Case is O(1). The arrayList doesnt need to resize.
Average-Case and Worst-case is Θ(n) because we need to move elements from the old array
to the new array which takes linear time. 