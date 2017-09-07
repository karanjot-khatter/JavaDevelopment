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
    private static int maxItemWeight = 20;
    private int playerWeight;
    // The total amount of money collected by this machine.
    /**
     * Create a machine that issues tickets of the given price.
     */
    public Player(String name)
    {
        balance = 50;
        this.name = name;
        maxItemWeight = 20;
        playerWeight = 0;
        if (balance <=0) {
            System.out.println("you are out of money");
            //System.out.println("Total money spent:$%.2f");
            System.exit(0); //exit command
         }
        
        }
   
        public void pay(int n)
    {
        balance = balance - n;
    }
    
    /**
     * @return The member's name.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }
   
    public int getPlayerWeight()
    {
        return playerWeight;
    }
    
    public static int getMaxItemWeight()
    {
        return maxItemWeight;
    }
    
    public int getMaximumItemWeight()
    {
        return maxItemWeight;
    }
}
