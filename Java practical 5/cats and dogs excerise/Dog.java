
public class Dog
{
    private String dogsName;
    private double weightsInKilos;
    private String preferedDogFood;
    
    public void dog(String name, String PreferedFood, double weightsInKilos)
    { 
    dogsName = name;
    weightsInKilos = 15;
    preferedDogFood = "Pedigree Chum" ;
    }
    
    public String getName()
    {
        return dogsName;
    }
    
       public double getWeight()
    {
        return 15; //weightsInkilos
    }
    
    public String getFood()
    {
        return preferedDogFood;
    }
    
    public void bark()
    {
        System.out.println("woof woof woof");
    }     
}
