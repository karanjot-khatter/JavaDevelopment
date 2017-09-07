import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

// comment omitted

public class Crab extends Animal
{
    private GreenfootImage image1;
    private GreenfootImage image2; 
    private int wormsEaten;
    public Crab()
    {
        image1 = new GreenfootImage("crab.png");
        image2 = new GreenfootImage("crab2.png");
        setImage(image1);
        wormsEaten = 0;
    }
    public void act() 
    {
        if(getImage() == image1)
        {     
            setImage(image2);
        }
        else 
        {
            setImage(image1);
        }
        moveAndTurn();
        eat();
    }
    public void lookForWorm()
    {
        int WormsEaten = 0;
        if ( canSee(Worm.class) )
        {
            eat(Worm.class);
            Greenfoot.playSound("slurp.wav");
            
            wormsEaten = wormsEaten + 1;
            if(wormsEaten == 8)
            {
                Greenfoot.playSound("FANFARE.wav");
                Greenfoot.stop();
            }
        }
    }
    public void moveAndTurn()
    {
        move(4);

        if (Greenfoot.isKeyDown("left"))
        {
            turn(-3);

        }
        if (Greenfoot.isKeyDown("right"))
        {
            turn(3);
        }
    }

    public void eat()
    {
        Actor worm;
        worm = getOneObjectAtOffset(0,0,Worm.class);

        if (worm != null)
        {
            World world;
            world = getWorld();
            world.removeObject(worm);
            Greenfoot.playSound("eating.wav");
        }
    }
}