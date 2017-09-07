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
    private int weight;
    private ArrayList<Item> list = null; 
    private ArrayList<Item> inventory = null;
   
    public Item(String description)
    {
        this.description = description;
        this.weight = 0;
    }
    
     /**
     * Constructor for objects of class Item
     */
    public Item(String description, int weight)
    {
        this.description = description;
        this.weight = weight;
        list = new ArrayList<Item>();
        inventory = new ArrayList <Item> ();
          //addItem();

    }
    
    /**
     * Get description of item
     */
    public String getShortDescription()
    {
        return description;
    }
    
    /**
     * Get weight of item
     */
    public int weight()
    {
        return weight;
    }
    
    /**
     * Show description and weight of item
     */
    public String toString()
    {
        return "Item" + description + "Weight" + weight;
    }
    
    /**
     * add item to the list
     */
    public void addItem(String description,int weight)
    {
        list.add(new Item (description, weight));
   }
   
   /**
     * add items to the inventory
     */
   public void add(String description, int weight)
   {
       inventory.add(new Item(description, weight));
   }
        
    /**
    * create a variety of items
    */
  public void addItem(Item Item)
    {
      list.add(Item);
    }
  
    /**
     * create a items to the inventory
     */
   public void add(Item Item)
   {
      inventory.add(Item);
    }
    
    /**
     * get the item
     */
    public ArrayList<Item> getItems()
    {
        return list;
   }
   
   /**
     * get the inventory
     */
   public ArrayList<Item> getInventory()
   {
       return inventory;
    }
    
   /**
     * displays the items in the list
    */
    public String getItemString()
    {
        
        String returnString = "Item:";
    
        {
            returnString += " " + list;
        }
        return returnString;
      
   }
   
   /**
     * Adding the different types of items in the list
     */
   public void addItem()
    {
     ArrayList<Item> list = new ArrayList<Item> ();
         
    //Item item1 = new Item("drink",3);
    Item item2 = new Item("food",5);
    Item item3 = new Item("microphone",70);
    Item item4 = new Item("pole",70);
    Item item5 = new Item("Casino Card",1);
    Item item6 = new Item("Roulette wheel",70);
    Item item7 = new Item("hairdryer",10);
    Item item8 = new Item("water",1);
    Item item9 = new Item("clothes",10);
    Item item10= new Item("hoover",30);
    Item item11 = new Item("television",70);
   
  
    //list.add(item1);
    list.add(item2);
    list.add(item3);
    list.add(item4);
    list.add(item5);
    list.add(item6);
    list.add(item7);
    list.add(item8);
    list.add(item9);
    list.add(item10);
    list.add(item11);
    
     ArrayList<Item> inventory = new ArrayList<Item> ();   
    Item item12= new Item("wallet",2);
    Item item13 = new Item("phone", 3);
     
    list.add(item12);
    list.add(item13);
     // this.list.add(new Item ("money", 3)); 
     // this.list.add(new Item ("drink", 4));
     // this.list.add(new Item ("after Shave", 5));

    }
    }
    