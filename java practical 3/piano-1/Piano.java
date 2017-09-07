import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

public class Piano extends World
{
    private String[] whiteKeys =
        { "a", "s", "d", "f", "g", "h", "j", "k", "l", ";", "'", "\\" };
    private String[] whiteNotes =
        { "3c", "3d", "3e", "3f", "3g", "3a", "3b", "4c", "4d", "4e", "4f", "4g" };    
    private String[] blackKeys =
        { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "="}; 
    private String[] blackNotes =
        { "3g#", "3a#", "4c#", "3f#", "3g#", "3a#", "3a#", "4c#", "4d#", "4d#", "4f#", "4f#" }; 

    public Piano() 
    {
        super(800, 340, 1);
        makeKeys();
    }

   private void makeKeys() 
     {
        // make the white keys
        for(int i = 0; i < whiteKeys.length; i++) {
            Key key = new Key(whiteKeys[i], whiteNotes[i]+".wav", "white-key.png", "white-key-down.png"); 
            addObject(key, 54 + (i*63), 140);
        }

        // make the black keys
        for(int i = 0; i < whiteKeys.length-1; i++) {
            if( ! blackKeys[i].equals("") ) {
                Key key = new Key(blackKeys[i], blackNotes[i]+".wav", "black-key.png", "black-key-down.png");
                addObject(key, 85 + (i*63), 86);
            }
        }
    }
}


