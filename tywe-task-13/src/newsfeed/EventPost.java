import java.time.*;
/**
 * This class allows you to create events in
 * the newsfeed app.
 *
 * @author (Tomas)
 * @version (2021-01-18)
 */
public class EventPost extends Post
{

    private String title;
    private String location;
    private LocalDate date;

    /**
     * Constructor for objects of class EventPost
     */
    public EventPost(String author)
    {
        super(author);
    }

    /**
     * This sets the location of the event to the
     * specified parameter.
     * @param location the location of the event
     */
    public void setLocation(String location)
    {
        this.location = location;
    }

    /**
     * This sets the title of the event to the
     * specified parameter.
     * @param title the title of the event
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * This sets the date of the event to the
     * specified parameter in the format YYYY-MM-DD
     * @param year the year of the event
     * @param month the month of the event
     * @param day the date of the event
     */
    public void setDate(int year, int month, int day)
    {
        date = LocalDate.of(year, month, day);
        System.out.println(date.toString());
    }
    /**
     * This displays the total information of the event. 
     *
     */
    public void display()
    {
        System.out.println(title + " will take place at " + location + " on " + date);
        super.display();
        
    }

    public static void main(String[] args) {
        EventPost eventPost = new EventPost("Tomisha");
        eventPost.display();
    }
}
