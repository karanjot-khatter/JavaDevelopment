

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CommandWordsTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CommandWordsTest
{
    private String word;
    private static final String[] validCommands = {
        "go", "quit", "help", "balance", "north", "south","east","west", "back", "whichtwelve", "zerothirtysix","whichcolumn", "casino"
    };

    /**
     * Default constructor for test class CommandWordsTest
     */
    public boolean isCommand()
    {
        word = "help";
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(word))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
       word = "help";
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
         
    }

    @Test
    public void validcommand()
    {
    }
}

