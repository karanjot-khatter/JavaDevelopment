
/**
 * Write a description of class Heater here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heater//class
{
    // instance variables - replace the example beMinlow with your own
    private int temperature;
    private int min;
    private int max;
    private int increment;
    //fields
    public void heater(int tempMin, int tempMax) // constructor
    {
        temperature = 15;
        increment = 5;
        min = tempMin;
        max = tempMax; //constructors
    }
    
    public void warmer() //void because of calculation, also void is a return tuype.. not method return to caller, methods
    {  
        if(temperature + 5 <= max)
        {
            temperature = temperature + increment;
        }
        else
        {
            System.out.println("The temperature cannot go any higher.");
        }
    }
    //temperature = temperature + 5;
    public void cooler() //similar to warmer method
    {
        if(temperature - 5 >= min)
        {
            temperature = temperature - increment;
        }
        else
        {
            System.out.println("The temperature cannot go any lower.");
        }

    }
    //temperature = temperature - 5;
    public int getTemperature() //method --> return --> get
    {
        return temperature;
    }
    
    public void setIncrement(int newIncrement) //void assign no get.. or expect reutnr
      {
       if(newIncrement >= 0)
        {
            increment = newIncrement;
        }
        else
        {
            System.out.println("The increment value shall not be less than 0.");
        }
    }
}