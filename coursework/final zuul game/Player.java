import java.util.ArrayList;
/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class Player
{
    // The price of a ticket from this machine.
    private String name;
    // The amount of money entered by a customer so far.
    private int balance;
    public int maxItemWeight;
    public ArrayList<Item> pockets;
    // The total amount of money collected by this machine.
    /**
     * Create a wallet which stores and deposits money in the game 
     */
    public Player(String name)
    {
        balance = 50;
        this.name = name;
        maxItemWeight = 60;
        if (balance <=0) {
            System.out.println("you are out of money");
            //System.out.println("Total money spent:$%.2f");
            System.exit(0); //exit command
         }
        
        }
    
    /**
    * Pay -paying for things using the wallet 
    */
    public void pay(int n)
    {
        if ( balance < 5) {  
        System.out.println("you are out of money");
            //System.out.println("Total money spent:$%.2f");
            System.exit(0); //exit command
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
        return name;
    }
    
    /**
     * Returns the amount of money availablbe in the wallet
     * 
     */
    public int getBalance()
    {
        return balance;
    }
   
    public void recieveMoney(int earn)
    {
        balance = balance + earn;
    }
        
    
    
    
    
}
