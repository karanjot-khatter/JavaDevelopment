import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
/**
 * Used to create and store items
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String description;
    public int weight;
    public ArrayList<Item> list;
    /**
     * Constructor for objects of class Item 
     * The amount of weight the player can carry at one time 
     */ 
    public Item(String description, int weight)
    {
        this.description = description;
        weight = weight;
        Item item1 = new Item ("drink", 5);
        Item item2 = new Item ("money", 1);
        Item item3 = new Item ("CasinoChp", 1);
        Item item4 = new Item ("food", 5);
        Item item5 = new Item ("microphone", 70);
        add(item1);
        add(item2);
        add(item3);
        add(item4);
        add(item5);
    }
    
    /**
     * Gets a description for the item in question
     */
    public String getShortDescription()
    {
        return description;
    }
    
    /**
     * Returns the weight of the current item
     */
    public int weight()
    {
        return weight;
    }
    
    /**
     * Shows the weight and description of the current item
     */
    public String toString()
    {
        return "Item" + description + "Weight" + weight;
    }
    
    /**
     * Creates a new item, with a description and weight  
     */
    public void addItem(String Description,int weight)
    {
        list.add(new Item (description, weight));
    }
    
    /**
     * Adds an item to the list 
     */
    
    public void add(Item item)
    {
        list.add(item);
    }
    
    /**
     * Returns a list of all the items
     */
    public ArrayList<Item> getItems()
    {
        return list;
    }
    
    /**
     * Items in the list of items 
     */
    public void addItem()
    {
        
    }
}
    