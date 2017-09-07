
public class Cat
{
    private String catsName;
    private int ageInYears;
    private String colourOfFur;
    private boolean happy; // cats may be happy or sad
    
    public void cat(String name, int ageInYears, String colour, boolean happy)
    {
    catsName = name;
    this.ageInYears = ageInYears;
    colourOfFur = "ginger";
    this.happy = happy;
    }
    
    public String getName()
    {
        return catsName;
    }
        
    public String getColour()
    {
        return colourOfFur; 
    }
    
    public boolean getHappy()
    {
        return happy;
    }
    
    public int getAge()
    {
        return ageInYears;
    }
     
    public void purr()
    {
        System.out.println("pur pur pur");
    }
    
    public void miawo()
    {
        System.out.println("miaow miaow miaow");
    }
    
    public void makeSound()
    {
        if(happy == true)
        {
            System.out.println("pur pur pur");
        }
        else
        {
            System.out.println("miaow miaow miaow");
        }
    }
}
    
