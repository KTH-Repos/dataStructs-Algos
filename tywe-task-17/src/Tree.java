/*
 *A Binary Search Tree
 *
 * @author (Tomas)
 * @version (2021-02-19)
 */
public class Tree<T extends Comparable<T>> {

    public binaryNode<T> root;    //the first element of the tree
    public int size;

    /*
     * A binary Node element
     */
    private static class binaryNode<T> {
        public T data;
        public binaryNode<T> left;
        public binaryNode<T> right;

        public binaryNode(T data){  //constructor for binaryNode
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    /*
     * Constructor for Binary Search Tree
     */
    public Tree(){
        this.size = 0;
    }

    /*
     * Search if an element is present in the tree
     * @param the element to be searched for
     * @return true if found, otherwise false
     */
    public boolean search(T elem){
        if(root == null){
            return false;
        }
        binaryNode<T> current = root;
        while(current != null){
            if(elem.compareTo(current.data) < 0){
                current = current.left;
            }
            else if(elem.compareTo(current.data) > 0){
                current = current.right;
            }
            else {
                return true;
            }
        }
        return false;
    }
    /*
     * Insert an element into the tree if it
     * doesn't already exist
     * @param the element to be inserted.
     * @return true if inserted, false otherwise
     */
    public boolean insert(T elem){
        if(root == null){
            root = new binaryNode<>(elem);
            size++;
            return true;
        }
        else if(root != null) {
            boolean KeyIsPresent = search(elem);
            if(!(KeyIsPresent)){
                binaryNode<T> current = root;
                binaryNode<T> parent = null;
                while (current != null) {
                    parent = current;
                    if (elem.compareTo(current.data) < 0) {
                        current = current.left;
                    }
                    else{
                        current = current.right;
                    }
                }
                if(elem.compareTo(parent.data) < 0){
                    parent.left = new binaryNode<>(elem);
                }
                else{
                    parent.right = new binaryNode<>(elem);
                }
                size++;
                return true;
                }
            }
        return false;
    }

    /*
     * Size of the tree
     * @return the number of binary nodes
     */
    public int size(){
        return size;
    }

    /*
     * The height of the tree. Applies a helper method.
     * @return the number of binary nodes
     * in the longest branch of the tree
     */
    public int height(){

        return maximumDepth(root);

    }

    /*
     * Helper method for height.
     * @param node from which to start counting
     * @return the number of binary nodes in the
     * longest branch of the tree
     */
    private int maximumDepth(binaryNode<T> node){
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null){
            return 0;
        }

        int leftSubTreeDepth = maximumDepth(node.left);
        int rightSubTreeDepth = maximumDepth(node.right);

        return Math.max(leftSubTreeDepth, rightSubTreeDepth) + 1;
    }

    /*
     * The leaves of the tree. Applies a helper method
     * @return the number of leaves
     */
    public int leaves(){

        return countLeaves(root);

    }

    /*
     * Helper method for leaves.
     * @param the node from which to start counting
     * @return the number of leaves
     */
    private int countLeaves(binaryNode<T> node){
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null){
            return 1;
        }
        else{
            return countLeaves(node.left) + countLeaves(node.right);
        }
    }

    /*
     * A string describing the tree. It represents the tree
     * in ascending order, like a sorted list. Takes help of a
     * method that traverses the tree with inOrder Traversal.
     * @return the string representation of the tree with "[]"
     */
    public String toString(){
        String myTree = "[" + inOrder(root) + "]";
        return myTree;
    }

    /*
     * A method for inOrder traversal
     * @param the node from which to start traversing.
     */
    private String inOrder(binaryNode root){
        if(root == null){
            return "";
        }
        String leftTree = inOrder(root.left);
        if(!leftTree.isEmpty()){
            leftTree = leftTree + ", ";
        }
        String rightTree = inOrder(root.right);
        if(!rightTree.isEmpty()){
            rightTree = ", " + rightTree;
        }
        return leftTree + root.data + rightTree;
    }


}
