

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TrackTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TrackTest
{
    private String title;
    private String artist;
    
    /**
     * Default constructor for test class TrackTest
     */
    public TrackTest()
    {
        title = title;
        artist = artist;
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        title = "in da club";
        artist = "50 cent";
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
    
    /**
     * Test the get title method
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Tests the return artist method  
     */    
   public String getArtist()
    {
        return artist;
    }
    
    

    @Test
    public void testName()
    {
    }
}

