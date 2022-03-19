import java.util.Objects;
/**
 * The Box class models a three-dimensional box
 */
public class Box implements Comparable<Box>{
    private final int height;
    private final int width;
    private final int depth;

    /**
     * Create a new Box with the specified dimensions (height, width, depth).
     *
     * @param height the height of the box
     * @param width the width of the box
     * @param depth the depth of the box
     */
    public Box(int height, int width, int depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    /**
     * Create a copy of box.
     *
     * @param box A Box to copy.
     */
    public Box(Box box) {
        this.height = box.height;
        this.width = box.width;
        this.depth = box.depth;
    }

    /**
     * Get this box's volume
     *
     * @return the box's volume
     */
    public int volume() {
        return height * width * depth;
    }

    /**
     * @return The box's height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return The box's width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return The box's depth
     */
    public int getDepth() {
        return depth;
    }

    /**
     * Defines if two Boxes should be considered equal according to their volume.
     *
     * @param o an object
     * @return true if the given object has equal volume to this Box
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Box)) {
            return false;
        }
        Box other = (Box) o;
        return this.volume() == other.volume();
    }

    /**
     * Defines the hash code of this Box.
     *
     * This is required by the contract of hashCode, which states that if for
     * two objects x and y, x.equals(y) is true,
     * then x.hashCode() == y.hashCode() must also be true. Note that the
     * converse is not necessary, equal hash codes does not imply equality.
     *
     * So, as we override the Object.equals(Object o), we must also override
     * Object.hashCode(). If we do not abide by the contract, data structures
     * that rely on hashes (such as HashMap) will simply not work correctly.
     *
     * Ideally, a small change in an object's state should result in a large
     * change in the hash. Therefore, instead of just returning the volume
     * (which would trivially fulfill the contract), we run the volume through
     * an existing hash function. Of course, just returning the volume directly
     * would also work, just not as well.
     *
     * For a good explanation, see Effective Java Recipe Item 9
     * @return the hash code of this Box
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(volume());
    }

    /**
     * @return a String representation of this Box.
     */
    @Override
    public String toString() {
        return "Box(" + height + ", " + width + ", " + depth + ")";
    }

    @Override
    public int compareTo(Box o) {
       if(this.volume()>o.volume()){
           return 1;
       }
       else if(this.volume()<o.volume()){
           return -1;
       }
       else{
           return 0;
       }
    }

    //My own testing
    public static void main(String[] args)
    {
        Box box1 = new Box(5,5,5);
        Box box2 = new Box(6,6,6);
        System.out.println(box1.volume());
        System.out.println(box2.volume());
        Box box3 = new Box(box1);
        System.out.println(box3.getDepth());
        System.out.println(box3.getHeight());
        System.out.println(box3.getWidth());
        int result = box3.compareTo(box2);
        System.out.println(result);
        System.out.println(box2.equals(box1));
    }
}
