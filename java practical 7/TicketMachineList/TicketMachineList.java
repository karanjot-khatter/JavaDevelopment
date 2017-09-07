import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class TicketMachineList
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<TicketMachine> files; //field
        
    /**
     * Create a MusicOrganizer
     */
    public TicketMachineList() //constructor
    {
        files = new ArrayList<TicketMachine>();
        
        TicketMachine TM1 = new TicketMachine(50); //assigning
        TicketMachine TM2 = new TicketMachine(100);
        TicketMachine TM3 = new TicketMachine(150);
                
        files.add(TM1);
        files.add(TM2);
        files.add(TM3);
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(TicketMachine filename)
    {
        files.add(filename);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            TicketMachine filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }
}
