
/**
 * Write a description of class OddOrEven here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OddOrEven
{
    public OddOrEven(int stake, String value)
    {
        int min = 0;
        int max = 37;
        int random = min + (int)(Math.random() * ((max - min) + 1));

        int winnings = stake  + stake;
       
        if (value == "even" && random % 2 == 0) {
            System.out.println("You have won £" + winnings + " The winning number was " + random);
        } else if (value == "even") {
            System.out.println("Oh! You lost £" + stake + ". The winning number was " + random);
        }
        
        if (value == "odd" && random % 2 != 0) {
            System.out.println("You have won £" + winnings + " The winning number was " + random);
        } else if (value == "odd") {
            System.out.println("Oh! You lost £" + stake + ". The winning number was " + random);
        }
    }
}
