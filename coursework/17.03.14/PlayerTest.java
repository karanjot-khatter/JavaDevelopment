import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PlayerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PlayerTest
{ 
     // The amount of money entered by a customer so far.
    private int balance;
    private String name;
   
    /**
     * 
     */
    public void pay(int n)
    {
        balance = 3;
        if ( balance < 5) {  
        System.out.println("you are out of money");
            
            //System.exit(); //exit command
    }
    else {
        
            balance = balance - n;
    }
    }
    
    /**
     * Gets the name of the player
     */
    public String getName()
    {    
     name = "sean";
        if (name.matches("[a-zA-Z]+$")) {
    // str consists entirely of letters
    }
        return name;
    }
    
    
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        balance = 50;
    }
    
    public int recieveMoney(int earn)
    {
        earn = 20;
        balance = balance + earn;
        return balance;
    }
    
    public void winOrLose()
    {
    System.out.println("End of game");
    System.out.println("you have £" + balance);   
    if (balance> 0) {
        System.out.println("you have Won");
    }
    else
    System.out.println("you had a terrible night out");
   }
    
   
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void balance()
    {
    }

    @Test
    public void getname()
    {
    }
}



