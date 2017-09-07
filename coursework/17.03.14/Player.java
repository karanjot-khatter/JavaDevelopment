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
    private String name;
    private int balance;
    public int maxItemWeight;
    public ArrayList<Item> pockets;
    
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
            winOrLose();
         }
        
        }
    
    /**
    * Pay -paying for things using the wallet 
    */
    public void pay(int n)
    {
        if ( balance < 5) {  
        System.out.println("you are out of money");
            winOrLose();
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
    
     public void winOrLose()
    {
    System.out.println("End of game");
    balance = getBalance();
    System.out.println("you have £" + balance);   
      if (balance < 0) {
        System.out.println("you had a terrible night out");
        System.exit(0); 
      }
    }
    
   }

