
/**
 * Write a description of class Casino here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CasinoGame
{
    
    
    
    
    
    
    public int whichtwelve(int stake, int whichtwelve)
    {
        int min = 0;
        int max = 37;
        int random = (int)(Math.random()*max) + min; 
        
        int winnings = (stake * 3) + stake;
        
        int oneOfThree = random / 12;
        
        if (oneOfThree == 0 ) {
            System.out.println("You have lost £" + stake + ". The winning number was 0");
        } else if (oneOfThree <= 1 && whichtwelve == 1) {
            System.out.println("You have won £" + winnings + " The winning number was in the 1st range");
        } else if (oneOfThree <= 2 && oneOfThree >= 1 && whichtwelve == 2) {
            System.out.println("You have won £" + winnings + "  The winning number was in the 2nd range");
        } else if (oneOfThree <=3 && oneOfThree >= 2 && whichtwelve == 3) {
            System.out.println("You have won £" + winnings + " The winning number was in the 3rd range");
        } else 
            System.out.println("Oh! You lost £" + stake + ". The winning number was in the " + oneOfThree + " range.");
       
       if( winnings< stake) {
           
       return winnings;
    }
    else return stake;

    }
    
    

    /**
     * Constructor for objects of class zerothirtysix
     */
    public int zerothirtysix(int stake, int number)
    {
        int min = 0;
        int max = 37;
        int random = min + (int)(Math.random() * ((max - min) + 1));
        
        int winnings = stake * 36;
        
        if (number == random) {
            System.out.println("You have won £" + winnings);
        } else {
            System.out.println("Oh! You lost £" + stake + ". The winning number was " + random);
        }
        return stake;
    }
    
    public int OddOrEven(int stake, String value)
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
        return stake;
    }
    
    public int RedOrBlack(int stake, String colour)
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
        
        return stake;
    }
    
    public int  WhichColumn(int stake, int whichcolumn)
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
        return stake;
        }
}
