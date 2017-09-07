/**
 * Read web server data and analyse
 * hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2011.07.31
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer(String fname)
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader(fname);
        
        
        }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        //System.out.println("Hr: Count");
        //for(int hour = 0; hour < hourCounts.length; hour++) {
        //    System.out.println(hour + ": " + hourCounts[hour]);
        System.out.println("Hr: Count");
        int hour = 0;
        while( hour < hourCounts.length) {
            System.out.println(hour + ": " + hourCounts[hour]);
            hour++;
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
    
    public int numberOfAccesses()
    {
    int total =0;
    for(int hour = 0; hour < hourCounts.length; hour++) {
       total = total +  hourCounts[hour];
    }
    return total;
    }
    
    public int busiestHour()
    {
    int busiestHour = 0;
    int numberOfAccesses = 0;
    for(int hour = 0; hour < hourCounts.length; hour++) {
          if( numberOfAccesses < hourCounts[hour]) {
              numberOfAccesses =  hourCounts[hour];
              busiestHour = hour;
    }    
    }
    return busiestHour;
   }
   
   public int twoBusiestHour()
    {
    int busiestHour = 0;
    int busiestHour2 = 0;
    int numberOfAccesses = 0;
    for(int hour = 0; hour <= hourCounts.length; hour++) {
          if( numberOfAccesses < hourCounts[hour]) {
              numberOfAccesses =  hourCounts[hour];
              busiestHour = hour;
    }    
    }
    
    for(int hour = 0; hour < hourCounts.length; hour++) {
          if( numberOfAccesses < hourCounts[hour]) {
              numberOfAccesses =  hourCounts[hour];
              busiestHour2 = hour;
    }    
    }
    return busiestHour;
   }
    
     public int quitestHour()
    {
    int quitestHour = 0;
        int numberOfAccesses = hourCounts[0];
    for(int hour = 1; hour < hourCounts.length; hour++) {
          if( numberOfAccesses > hourCounts[hour]) {
              numberOfAccesses =  hourCounts[hour];
              quitestHour = hour;
    }    
    }
    return quitestHour;
   }
   
   
}
