
/**
 * Write a description of class whichtwelve here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class whichtwelve
{
    public whichtwelve(int stake, int whichtwelve)
    {
        int min = 1;
        int max = 37;
        int random = (int)(Math.random()*max) + min; 
        
        int winnings = (stake * 3) + stake;
        
        int oneOfThree = random / 12;
        
        if (oneOfThree == 1 && whichtwelve == 1) {
            System.out.println("You have won £" + winnings + " The winning number was in the 1st range");
        } else if (oneOfThree == 2 && whichtwelve == 2) {
            System.out.println("You have won £" + winnings + " The winning number was in the 2nd range");
        } else if (oneOfThree == 3 && whichtwelve == 3) {
            System.out.println("You have won £" + winnings + "  The winning number was in the 3rdrange");
        } else if (oneOfThree == 0 ) {
            System.out.println("You have lost £" + stake + ". The winning number was 0");
        } else {
            System.out.println("Oh! You lost £" + stake + ". The winning number was in the " + oneOfThree + " range.");
        }
    }
}
