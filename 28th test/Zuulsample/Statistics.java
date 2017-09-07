import java.util.HashMap;
import java.util.Iterator;

/**
 * Write a description of class Statistics here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Statistics
{
    // instance variables - replace the example below with your own
    private int x;
    private HashMap<String, count> counts;
    
    

    /**
     * Constructor for objects of class Statistics
     */
    public Statistics()
    {
        // initialise instance variables
        x = 0;
        counts = new HashMap<String, count>();
    }
    
    public boolean addCount(Command command)
    {
    boolean counts = false;
    
    if( command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

    String commandWord = command.getCommandWord();
    if (commandWord.equals("help")) {
    //        return count.getValue;
        }
    return counts;
    
    }
    
    public void showAll()
    {
      //      System.out.println(count.inc);
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
