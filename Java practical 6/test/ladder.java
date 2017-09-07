
/**
 * Write a description of class ladder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ladder
{
   private int height;
   private int width;
   private boolean safe;
   private String material;   
   
   public void ladder()
   {
       height = 15;
       width = 1;
       safe = false;
    }
    
   public void ladder(int height, int width, boolean safe, String material)
   {
       this.height = height;
       this.width = width;
       this.safe = safe;
       this.material = material;
    }
   
   public int getHeight()
   {
       return height;       
   }
   
   public int getWidth()
   {
       return width;
   }
   
   public boolean getSafe()
   {
       return safe;
    }
    
   public String getMaterial()
   {
       return material;
    }
    
   public int totalHeight()
   {
       return 8;
    }
}
