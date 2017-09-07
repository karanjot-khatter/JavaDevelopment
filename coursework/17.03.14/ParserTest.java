

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ParserTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ParserTest
{
    private CommandWords commands;  // holds all valid command words
     private static final String[] validCommands = {
        "go", "quit", "help", "balance", "north", "south","east","west", "back", "whichtwelve", "zerothirtysix","whichcolumn", "casino"
    };
    /**
     * Default constructor for test class ParserTest
     */
    public ParserTest()
    {
        commands.showAll();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
      
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
    public void showcommands()
    {
    }
}

