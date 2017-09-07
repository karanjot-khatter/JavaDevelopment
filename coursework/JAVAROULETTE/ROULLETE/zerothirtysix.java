
/**
 * Write a description of class zerothirtysix here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class zerothirtysix
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class zerothirtysix
     */
    public zerothirtysix(int stake, int number)
    {
        int min = 0;
        int max = 37;
        int random = min + (int)(Math.random() * ((max - min) + 1));
        
        int winnings = random * 36;
        
        if (number == random) {
            System.out.println("You have won £" + winnings);
        } else {
            System.out.println("Oh! You lost £" + stake + ". The winning number was " + random);
        }
    }
}
