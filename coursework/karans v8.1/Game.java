import java.util.Scanner;
import java.util.ArrayList;
/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.08.08
 */

public class Game 
{
    private Parser parser;
    private Item item;
    private ArrayList<Item> inventory;
    //private final int MAXWEIGHT = 20;  
    private Player player;
    private Room currentRoom;
    private Room previousRoom;
    private Room previousRoom2;
    private Scanner reader; 
    //private ArrayList<Player> player;
    private ArrayList<Room> previousRooms;
    private ArrayList<Item> unionItems;
    private String name;
    private int balance;
    private Room street, union, cambridgeStreet, registry, guildhallWalk, astoria, lyberry, club8, fuzzyDuck, popWorld, stanhopeRoad, liquid, envy, tigerTiger, casino, house;
    // source of command input
    MusicOrganizer musicOrganizer = new MusicOrganizer();
   
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        reader = new Scanner(System.in);
        //player = new ArrayList<Player>();
        previousRooms = new ArrayList<Room>();
        unionItems = new ArrayList<Item>();
        inventory = new ArrayList<Item>();
        //item1 = new Item("drink");
    }
    
    /**
     * Create all the rooms and link their exits together. Also creates items into specific rooms.
     */
    private void createRooms()
    {
        // create the rooms
        union = new Room("in the Union");
        cambridgeStreet = new Room("on Cambridge Street");
        registry = new Room("In Registry");
        guildhallWalk = new Room("on Guildhall Walk");
        astoria = new Room("in Astoria");
        lyberry= new Room("in Lyberry");
        club8 = new Room("in Club 8");
        fuzzyDuck = new Room("in Fuzzy Duck");
        popWorld = new Room("in PopWorld");
        stanhopeRoad = new Room("on Stanhope Road");
        liquid = new Room("in Liquid");
        envy = new Room("in Envy");
        tigerTiger = new Room("in TigerTiger");
        casino = new Room("in the Casino");
        house = new Room("in your House");
     
         //initialise room exits
       union.setExit("west", cambridgeStreet);
       cambridgeStreet.setExit("south", registry);
       cambridgeStreet.setExit("north", union);
       cambridgeStreet.setExit("south2", guildhallWalk);
       registry.setExit("south", guildhallWalk);
       registry.setExit("north", cambridgeStreet);
       registry.addItem( new Item("drink",3));
       registry.addItem( new Item("food",5));
       registry.addItem( new Item("microphone",70));
       registry.addItem( new Item("pole",70));
       guildhallWalk.setExit("south", astoria);
       guildhallWalk.setExit("north", registry);
       astoria.setExit("south", lyberry);
       astoria.setExit("north", guildhallWalk);
       astoria.addItem ( new Item("drink",3));
       astoria.addItem( new Item("microphone",70));
       astoria.addItem (new Item("pole",70));
       lyberry.setExit("south", club8);
       lyberry.setExit("north", astoria);
       lyberry.addItem ( new Item ("drink",3));
       lyberry.addItem( new Item("microphone",70));
       lyberry.addItem( new Item("pole",70));
       club8.setExit("east", fuzzyDuck);
       club8.setExit("north", lyberry);
       club8.addItem( new Item("drink",3));
       club8.addItem( new Item("microphone",70));
       club8.addItem( new Item("pole",70));
       fuzzyDuck.setExit("east", popWorld);
       fuzzyDuck.setExit("west", club8);
       fuzzyDuck.addItem( new Item("drink",3));
       fuzzyDuck.addItem( new Item("microphone",70));
       fuzzyDuck.addItem( new Item("pole",70));
       popWorld.setExit("south", stanhopeRoad);
       popWorld.setExit("north", fuzzyDuck);
       popWorld.addItem( new Item("drink",3));
       popWorld.addItem( new Item("microphone",70));
       popWorld.addItem( new Item ("pole",70));
       stanhopeRoad.setExit("south", liquid);
       stanhopeRoad.setExit("north", popWorld);
       liquid.setExit("north", envy);
       liquid.setExit("south", stanhopeRoad);
       liquid.addItem( new Item("drink",3));
       liquid.addItem( new Item("microphone",70));
       liquid.addItem( new Item("pole",70));
       envy.setExit("north", tigerTiger);
       envy.setExit("south", liquid);
       envy.addItem( new Item("drink",3));
       envy.addItem( new Item("microphone",70));
       envy.addItem( new Item("pole",70));
       tigerTiger.setExit("west", casino);
       tigerTiger.setExit("east", envy);
       tigerTiger.addItem( new Item("drink",3));
       tigerTiger.addItem( new Item("microphone",70));
       tigerTiger.addItem( new Item("pole",70));
       casino.setExit("north", house);
       casino.setExit("south", tigerTiger);
       casino.addItem( new Item("drink",3));
       casino.addItem( new Item("Casino Card",1));
       casino.addItem( new Item("Roulette wheel",70));
       house.setExit("north", union);
       house.setExit("north", casino);
       house.addItem( new Item("hairdryer",10));
       house.addItem( new Item("water",1));
       house.addItem( new Item("clothes",10));
       house.addItem( new Item("hoover",30));
       house.addItem( new Item("television",70));
       currentRoom = union;  // start game outside
       
       //inventory.add(new Item("wallet",2));
       //inventory.add(new Item("phone", 3));
       
       
       //Item item2 = new Item("food",5);
       //Item item3 = new Item("microphone",70);
       //Item item4 = new Item("pole",70);
       //Item item5 = new Item("Casino Card",1);
       //Item item6 = new Item("Roulemtte wheel",70);
       //Item item7 = new Item("hairdryer",10);
       //Item item8 = new Item("water",1);
       //Item item9 = new Item("clothes",10);
       //Item item10= new Item("hoover",30);
       //Item item11 = new Item("television",70);
   
    }         
      
    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("You giving up already!.  Good bye.");
    }
   
        
    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        
        System.out.println("Hello what is your name?");
        name = reader.nextLine().trim().toLowerCase();
        System.out.println("Welcome, " + name + " to the night out!");
        
     
        player = new Player(name);
        System.out.println("this is a new, incredibly CRAZY adventure game!");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription(name));
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        else if (commandWord.equals("balance")) {
             balance = player.getBalance();
            System.out.println("you have £" + balance  + " in your wallet");
        }
        else if( commandWord.equals("inventory")) {
            printInventory();
        }
           else if (commandWord.equals("take")) {
            doTake(command);
        }
        else if (commandWord.equals("drop")) {
            doDrop(command);
        }
      
        
        if (commandWord.equals("back")) {
             if (previousRoom != null)  {
             
             currentRoom = previousRooms.get(previousRooms.size()-1);
             previousRooms.add(previousRoom2);
             System.out.println(currentRoom.getLongDescription(name));
             }
             else
             System.out.println("you can not go back");
           
        }
  
        return wantToQuit;       
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around Portsmouth.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

     /** 
     * Try to in to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
               if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();
        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);
      
       if (nextRoom == null) {
            System.out.println("There is no building!");
        }
        else {
            previousRoom = currentRoom;
            entryToClub(5);
            currentRoom = nextRoom;
            previousRoom2 = currentRoom;
            previousRooms.add(previousRoom);
            System.out.println(currentRoom.getLongDescription(name));
            if (currentRoom != stanhopeRoad && currentRoom != guildhallWalk && currentRoom != stanhopeRoad && currentRoom !=cambridgeStreet && currentRoom != house && currentRoom != casino) {
                musicOrganizer.playFirst();
               }
            else {
             musicOrganizer.stopPlaying();
             }
        
        }
    }

    private void entryToClub(int price)
    {
      if ( currentRoom ==  guildhallWalk || currentRoom == stanhopeRoad || currentRoom == cambridgeStreet ||  currentRoom == house) {
               player.pay(price);                       
      }
          
    }
    
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
        
     /**
     * Do take checks if user takes an item, checks if the item adds in the inventory.
     */
    public void doTake(Command c) {
        if (! c.hasSecondWord()) {
            System.out.println("Take what?");
            return;
        }
        String s = c.getSecondWord();
        Item item = findByName(s,inventory);
        if (item ==null) {
           System.out.println("You took a " + s);
            return;
        }
        inventory.add(item);       
        currentRoom.addItem(item);
        System.out.println("You have took the" + s);
    }  
    
    /**
     * Do drop checks if user drops an item, checks if its in the inventory and then deletes the item from the inventory.
     */
      public void doDrop(Command c) {
        if (! c.hasSecondWord()) {  // "DROP",but no object named
            System.out.println("Drop what?");
            return;
        }
        String s = c.getSecondWord();
        Item item = findByName(s,inventory);
        if(item !=null) {
            System.out.println("You don't have a " + s);
            return;
           
        }
        // inventory.remove(item);                  
        currentRoom.addItem(item);
        System.out.println("You have dropped the " + s);
    }
    
        private void printInventory() {
        if (inventory.size() == 0) {
            System.out.println("you are not carrying anything");
        } else {
            System.out.print("You have the following:");
            //for (int n = 0; n < inventory.size(); n++) {
             //   Item item = inventory.get(n);
                System.out.println(inventory);
                //System.out.println(inventory);
                                //+ item.getShortDescription());
            }
            System.out.println();
            //System.out.println("Total weight: " + totalWeight(inventory));
        }
    
    
      //private int totalWeight(ArrayList<Item> L) {
       // int n=0;
       // int sum = 0;
      //  while (n < L.size()) {
      //      Item item = L.get(n);
       //     sum += item.weight();
       //     n++;
      //  }
       // return sum;    // not found above
    //}
    
        private Item findByName(String s, ArrayList<Item> L) {
        int n=0;
        while (n < L.size()) {
            Item item = L.get(n);
            if (s.equals(item.getShortDescription())) 
                return item;
            n++;
        }
        return null;    // not found above
    }
    }
    
     
   
