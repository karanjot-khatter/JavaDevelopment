

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CommandTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CommandTest
{   
    private String commandWord;
    private String secondWord;
    /**
     * Default constructor for test class CommandTest
     */
    public CommandTest()
    {
        commandWord = commandWord;
        this.secondWord = secondWord;
    }
    
    /**
     * Return the command word (the first word) of this command. If the
     * command was not understood, the result is null.
     * @return The command word.
     */
    public String getCommandWord()
    {
        return commandWord;
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
      commandWord = "go";
       secondWord =  "north";
    }

    @Test
    public void getcommand()
    {
    }
}

