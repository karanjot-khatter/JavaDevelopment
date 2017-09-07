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
    private Player player;
    private Character girlfriend;
    private Room currentRoom;
    private Room girlfriendsRoom;
    private Room previousRoom;
    private Room previousRoom2;
    private Scanner reader; 
    private ArrayList<Room> previousRooms;
    private String name;
    private int balance;
    private Room street, union, cambridgeStreet, registry, guildhallWalk, astoria, lyberry, club8, fuzzyDuck, popWorld, stanhopeRoad, liquid, envy, tigerTiger, casino, house;
    // source of command input
    MusicOrganizer musicOrganizer = new MusicOrganizer();
    private CasinoGame casinoGame;
    private int game1;
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        reader = new Scanner(System.in);
        previousRooms = new ArrayList<Room>();
        girlfriend = new Character();
        girlfriendsRoom = house;
        casinoGame = new CasinoGame();
    }
    
    
    /**
     * Create all the rooms and link their exits together.
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
       guildhallWalk.setExit("south", astoria);
       guildhallWalk.setExit("north", registry);
       astoria.setExit("south", lyberry);
       astoria.setExit("north", guildhallWalk);
       lyberry.setExit("south", club8);
       lyberry.setExit("north", astoria);
       club8.setExit("east", fuzzyDuck);
       club8.setExit("north", lyberry);
       fuzzyDuck.setExit("east", popWorld);
       fuzzyDuck.setExit("west", club8);
       popWorld.setExit("south", stanhopeRoad);
       popWorld.setExit("north", fuzzyDuck);
       stanhopeRoad.setExit("south", liquid);
       stanhopeRoad.setExit("north", popWorld);
       liquid.setExit("north", envy);
       liquid.setExit("south", stanhopeRoad);
       envy.setExit("north", tigerTiger);
       envy.setExit("south", liquid);
       tigerTiger.setExit("west", casino);
       tigerTiger.setExit("east", envy);
       casino.setExit("north", house);
       casino.setExit("south", tigerTiger);
       house.setExit("north", union);
       house.setExit("north", casino);
       currentRoom = union;  // start game outside
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
        System.out.print('\f'); 
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
        String stake ;
        String range;

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
        else if (commandWord.equals("casino")) {
             currentRoom = casino;
             System.out.println(currentRoom.getLongDescription(name));
        }
        
        else if (commandWord.equals("whichtwelve")) {
            if (currentRoom == casino) {
              System.out.println("what is your stake?");
             stake = reader.nextLine();
             int stakes = Integer.parseInt(stake);
             System.out.println("what is your range, 1,2 or 3");
             range = reader.nextLine();
             int ranges = Integer.parseInt(range);
             game1 = casinoGame.whichtwelve(stakes , ranges);
             player.recieveMoney(game1);
            
            
             
             
             
          
        }
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
            currentRoom = nextRoom;
            entryToClub(5);
            sameRoom();
            previousRoom2 = currentRoom;
            previousRooms.add(previousRoom);
            System.out.println(currentRoom.getLongDescription(name));
            playSongs();
        }
    }

    private void playSongs()
      {
        if (currentRoom != stanhopeRoad && currentRoom != guildhallWalk && currentRoom != stanhopeRoad && currentRoom !=cambridgeStreet && currentRoom != house && currentRoom != casino)        {
                musicOrganizer.playFirst(); 
               }
            else {
             musicOrganizer.stopPlaying();
             }
    }
    
    private void entryToClub(int price)
    {
      if ( currentRoom != guildhallWalk && currentRoom != stanhopeRoad && currentRoom != cambridgeStreet && currentRoom != house) {
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
     * 
     */
    //private void endGame();
    //{
    //    if(currentRoom = house && balance >= 50)){
    //    
    //         System.out.printlm("Congratulations you won the game");
    //    }
    //    else {
    //          System.out.printlm("You didn't win this time please try again");


   //     }         

    //}
    
    






}