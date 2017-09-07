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
    public Room girlfriendsRoom;
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
    private ArrayList<String> casinoGameTypes;
    boolean finished = false;
    
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        reader = new Scanner(System.in);
        previousRooms = new ArrayList<Room>();
        girlfriend = new Character("python");
        girlfriendsRoom = house;
        casinoGame = new CasinoGame();
    }
    
    private void sameRoom()
    {
        if (girlfriendsRoom == currentRoom) {
            System.out.println("Your girlfreind has found you, you lose and must go home");
            player.winOrLose();
            finished = true;
        }
    }
    
    private void gotHome()
    {
        if (currentRoom == house && girlfriendsRoom !=currentRoom) {
            player.winOrLose();
            finished = true;
        }
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
        int stake;
        int range;
        String srange;
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
             System.out.println("What game would you like to play ?");
             System.out.println("whichtwelve, zerothirtysix,  or whichcolumn");
             System.out.println("Type the Game you wish to play");
        }
        
        else if (commandWord.equals("whichtwelve")) {
            if (currentRoom == casino) {
             stake = stakeAmount();
             System.out.println("what is your range, 1, 2 or 3");
             srange = reader.nextLine();
             range = Integer.parseInt(srange);
             int returns = casinoGame.whichTwelve(stake , range);
             player.recieveMoney(returns);
            }
        }
        else if (commandWord.equals("zerothirtysix")) {
            if (currentRoom == casino) {
             stake = stakeAmount();
             System.out.println("Choose a number between 0-36");
             srange = reader.nextLine();
             int number = Integer.parseInt(srange);
             int returns = casinoGame.zeroThirtySix(stake , number);
             player.recieveMoney(returns);
             }
        }
        else if (commandWord.equals("whichcolumn")) {
            if (currentRoom == casino) {
             stake = stakeAmount();
             System.out.println("which column. 1-4");
             srange = reader.nextLine();
             int number = Integer.parseInt(srange);
             int returns = casinoGame.WhichColumn(stake , number);
             player.recieveMoney(returns);
            }
       
        else if (commandWord.equals("back")) {
             if (previousRoom != null)  {
                 currentRoom = previousRooms.get(previousRooms.size()-1);
                 previousRooms.add(previousRoom2);
                 System.out.println(currentRoom.getLongDescription(name));
             }
             else
                System.out.println("you can not go back");
           
        }
      }
      return wantToQuit;
     }
    
    private void movingToNewRoom()
      {
     
      int min = 0;
      int max = 15;
      int random = min + (int)(Math.random() * ((max - min) + 1));
       
       if (random == 0) {
           girlfriendsRoom = union;
      }
      else  if (random == 1) {
        girlfriendsRoom = cambridgeStreet;
      }
      else if (random == 2) {
        girlfriendsRoom = registry;
      }
      else  if (random == 3) {
        girlfriendsRoom = guildhallWalk;
      }
      else if (random == 4) {
        girlfriendsRoom = astoria;
      }
      else if  (random == 5) {
      girlfriendsRoom = lyberry; 
      }
      else  if (random == 6) {
        girlfriendsRoom = club8;
      }
      else if (random == 7) {
        girlfriendsRoom = fuzzyDuck;
      }
      else  if (random == 8) {
        girlfriendsRoom = popWorld;
      }
      else if (random == 9) {
        girlfriendsRoom = stanhopeRoad;
      }
      else  if (random == 10) {
        girlfriendsRoom = liquid;
      }
      else if (random == 11) {
        girlfriendsRoom = envy;
      }
      else if (random == 12){
      girlfriendsRoom = tigerTiger;
      }
      
   }
   
   private int stakeAmount()
    {
        balance = player.getBalance();
        int stake = balance + 1;
        while (stake > balance) {
        System.out.println("what is your stake?");
        String stakes = reader.nextLine();
        stake = Integer.parseInt(stakes);
        
         if (stake > balance) {
           System.out.println("you do not have sufficient funds");
         }
         else
         player.pay(stake);
         }
        return stake;
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
            movingToNewRoom();
            sameRoom();
            gotHome();
            previousRoom2 = currentRoom;
            previousRooms.add(previousRoom);
            System.out.println(currentRoom.getLongDescription(name));
            playSongs();
        }
    }

    private void playSongs()
      {
        if (currentRoom != stanhopeRoad && currentRoom != guildhallWalk && currentRoom != stanhopeRoad && currentRoom !=cambridgeStreet && currentRoom != house && currentRoom != casino)        {
                musicOrganizer.playRandomSongs(); 
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
    
   
}
