
/**
 * Write a description of class whichcoloum here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WhichColumn
{
    public WhichColumn(int stake, int whichcolumn)
    {
        int min = 0;
        int max = 4;
        int random = (int)(Math.random()*max) + min; 
        
        int winnings = (stake * 3) + stake;
        
        if (random == 1 && whichcolumn == 1) {
            System.out.println("You have won £" + winnings + " The number was in the first column");
        } else if (random == 2 && whichcolumn == 2) {
            System.out.println("You have won £" + winnings + " The number was in the second column " );
        } else if (random == 3 && whichcolumn == 3) {
            System.out.println("You have won £" + winnings + "  The number was in the third column");
        } else if (random == 0) {
            System.out.println("Oh! You lost £" + stake + ". The number was 0 ");
        } else {
        System.out.println("Oh! You lost £" + stake + ". The winning number was in the " + random + " range.");
        }
        }
    }

