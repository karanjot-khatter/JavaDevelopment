
/**
 * Write a description of class modelCar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class modelCar
{
    private String makeOfCar;
    private String model;
    private int engineSize;
    private String regNum;
    private boolean fourWheels;
    /**
     * Constructor for objects of class modelCar
     */
    public modelCar(String makeOfCar, String model, int engineSize)
    {
        this.makeOfCar = makeOfCar;
        this.model = model;
        this.engineSize = engineSize;
             
    }

    public String getmakeOfCar()
    {
        return makeOfCar;
    }
        
    public String getModel()
       {
        return model;
    }
    
    public int getengineSize()
       {
        return engineSize;
    }
    
    public String setregNum()
    {
        if (String.length ==7){
            return regNum;
        }
        else {
            return !regNum;            
    }
    }
    
    public boolean getfourWheels()
    {
        return fourWheels;
    }
}
