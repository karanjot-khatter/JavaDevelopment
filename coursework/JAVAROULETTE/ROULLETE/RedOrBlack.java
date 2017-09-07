
/**
 * Write a description of class redorblack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedOrBlack
{
    public RedOrBlack(int stake, String colour)
    {
        int min = 0;
        int max = 3;
        int random = min + (int)(Math.random() * ((max - min) + 1));

        int winnings = stake  + stake;
       
        if (colour == "red" && random == 1) {
            System.out.println("You have won £" + winnings + "The winning colour was red");
        } else if (colour == "black") {
            System.out.println("Oh! You lost £" + stake + ". The winning colour was black ");
        }
        
        if (colour == "black" && random == 2) {
            System.out.println("You have won £" + winnings + "The wining colour was blakck");
        } else if (colour == "red") {
            System.out.println("Oh! You lost £" + stake + ". The winning number was red");
        }
    }
}

