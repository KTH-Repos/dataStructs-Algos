If written answers are required, you can add them to this file. Just copy the relevant questions from the root of the repo, preferably in [Markdown](https://guides.github.com/features/mastering-markdown/) format :)

### Task 2 - Time Complexity

search - is O(n) because the whole tree has to be iterated over

insert - is O(n) because the tree is like a linkedlist and all elements
have to be iterated over to get to the last one.

size - is O(1) because the number of binary nodes is stored in the size field
of the class.

height - is O(n) because the tree is like a linkedlist and all elements have to be
counted.

leaves - is O(n) because the tree is like a linkedlist and all elemens have to be iterated
over inorder to reach the leaves of the tree.

toString - is O(n) because inOrder traversal reaches every element in the tree.