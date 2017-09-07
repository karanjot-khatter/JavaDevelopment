
/**
 * This section is used for when the player enters the casino and can gamble.
 * This is a unique Room and can be entered anytime throughout the game by typing casino in the teminal.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CasinoGame
{    
    
    /**
     * A type of game that is played within the casino
     * Choose between 3 values
     */
    public int whichTwelve(int stake, int whichtwelve)
    {
        int min = 0;
        int max = 37;
        int random = (int)(Math.random()*max) + min; 
        int winnings = 0;
        winnings = (stake * 3) + stake;
        
        int oneOfThree = random / 12;
        
        if (oneOfThree == 0 ) {
            System.out.println("You have lost £" + stake + ". The winning number was 0");
        } else if (oneOfThree <= 1 && whichtwelve == 1) {
            System.out.println("You have won £" + winnings + " The winning number was in the 1st range");
            return winnings +stake;
        } else if (oneOfThree <= 2 && oneOfThree >= 1 && whichtwelve == 2) {
            System.out.println("You have won £" + winnings + "  The winning number was in the 2nd range");
            return winnings+ stake;
        } else if (oneOfThree <=3 && oneOfThree >= 2 && whichtwelve == 3) {
            System.out.println("You have won £" + winnings + " The winning number was in the 3rd range");
            return winnings+stake;
        }
        else  System.out.println("Oh! You lost £" + stake + ". The winning number was in the " + oneOfThree + " range.");
              return 0;       
    }

   /**
     * A type of game that is played within the casino
     * Choose between o-36
     */
    public int zeroThirtySix(int stake, int number)
    {
        int min = 0;
        int max = 37;
        int random = min + (int)(Math.random() * ((max - min) + 1));
        int winnings = 0;
        winnings = stake * 36;
        
        if (number == random) {
            System.out.println("You have won £" + winnings);
            return winnings +stake;
        } else {
            System.out.println("Oh! You lost £" + stake + ". The winning number was " + random);
           
        }
         return 0;
    }

   /**
     * A type of game that is played within the casino
     * Choose between 4 columns
     */ 
   public int  WhichColumn(int stake, int whichcolumn)
    {
        int min = 0;
        int max = 4;
        int random = (int)(Math.random()*max) + min; 
         int winnings = 0;
        winnings = (stake * 3) + stake;
        
        if (random == 1 && whichcolumn == 1) {
            System.out.println("You have won £" + winnings + " The number was in the first column");
            return winnings +stake;
        } else if (random == 2 && whichcolumn == 2) {
            System.out.println("You have won £" + winnings + " The number was in the second column " );
            return winnings +stake;
        } else if (random == 3 && whichcolumn == 3) {
            System.out.println("You have won £" + winnings + "  The number was in the third column");
            return winnings +stake;
        } else if (random == 0) {
            System.out.println("Oh! You lost £" + stake + ". The number was 0 ");
           
        } else {
        System.out.println("Oh! You lost £" + stake + ". The winning number was in the " + random + " range.");
        
        }
        return 0;
        }
        
       
    //public int OddOrEven(int stake, String value)
    //{
      //  int min = 0;
        //int max = 37;
        //int random = min + (int)(Math.random() * ((max - min) + 1));
        //int winnings = 0;
        //winnings = stake  + stake;
       
        //if (value == "even" && random % 2 == 0) {
          //  System.out.println("You have won £" + winnings + " The winning number was " + random);
          //  return winnings +stake;
        //} else if (value == "even") {
          //  System.out.println("Oh! You lost £" + stake + ". The winning number was " + random);
            
        //}
        
        //if (value == "odd" && random % 2 != 0) {
          //  System.out.println("You have won £" + winnings + " The winning number was " + random);
            //return winnings +stake;
       // } else if (value == "odd") {
         //   System.out.println("Oh! You lost £" + stake + ". The winning number was " + random);
            
        //}
       // return 0;
    //}
    
   // public int RedOrBlack(int stake, String colour)
    //{
      //  int min = 0;
        //int max = 3;
        //int random = min + (int)(Math.random() * ((max - min) + 1));
        //int winnings = 0;
       // winnings = stake  + stake;
       
      //  if (colour == "red" && random == 1) {
        //    System.out.println("You have won £" + winnings + "The winning colour was red");
           //  return winnings +stake;
        //} else if (colour == "black") {
         //   System.out.println("Oh! You lost £" + stake + ". The winning colour was black ");
            
        //}
        
        //if (colour == "black" && random == 2) {
          //  System.out.println("You have won £" + winnings + "The wining colour was black");
            // return winnings +stake;
        //} else if (colour == "red") {
          //  System.out.println("Oh! You lost £" + stake + ". The winning number was red");
            
        //}
        //return 0;
        
   // }
         
}
