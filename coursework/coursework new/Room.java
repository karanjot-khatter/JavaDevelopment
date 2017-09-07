import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.08.08
 */

public class Room 
{
    private String description;
    private boolean pickable;
    private int weight;
    private int entryPrice;
    private HashMap<String, Room> exits; // stores exits of this room.
    private ArrayList <Item> items;
     

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        ArrayList<Item> items = new ArrayList<Item>();
        pickable = false;
        weight = 0;
        
        
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
    
       public boolean isPickable()
   {
       return pickable;
    }
    
      public void setPickable(boolean b)
    {
        pickable = b;
    }
    
    public int getItemWeight()
    {
        return weight;
    }
    
    public void setWeight(int w)
    {
        weight = w;
    }
    
    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription(String name)
    {
        System.out.println("The item(s) in this room are: " + getItemString());
        return name + " you are " + description + ".\n" + getExitString();
    }
    
      /**
     * Add item when room is created
     */
    
    public void addItem(String description, int weight)
    {
        items.add(new Item( description, weight));
    }
    
    public void addItem(Item item)
    {
        items.add(item);
    }
    
       /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
     /**
     * 
     */
    public int getItemString()
    {
        //String returnString = "";
        //{
           // returnString += " " +
           //return Item.list;
           return 1;
        }
        //return returnString;
    }




