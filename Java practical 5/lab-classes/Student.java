
/**
 * The Student class represents a student in a student administration system.
 * It holds the student details relevant in our context.
 * 
 * @author Michael Kölling and David Barnes
 * @version 2011.07.31
 */
public class Student
{
    // the student's full name
    private String name;
    // the student ID
    private String id;
    // the amount of credits for study taken so far
    private int credits;
    
    private String favourite; //attribute / field
    
    /**
     * Create a new student with a given name and ID number.
     */
    public Student(String fullName, String studentID, String favsubject)//constructor of student
    {
        name = fullName;
        id = studentID;
        credits = 0;
        favourite = favsubject;
    }

    /**
     * Return the full name of this student.
     */
    public String getName() //method get.. use return
    {
        return name;
    }

    /**
     * Set a new name for this student.
     */
    public void changeName(String replacementName) //assign, no return
    {
        name = replacementName;
    }

    /**
     * Return the student ID of this student.
     */
    public String getStudentID() // get --> return method
    {
        return id;
    }

    /**
     * Add some credit points to the student's accumulated credits.
     */
    public void addCredits(int additionalPoints) // cslculstion sssign --> void
    {
        credits += additionalPoints;
    }

    /**
     * Return the number of credit points this student has accumulated.
     */
    public int getCredits() // get --> return --> method
    {
        return credits;
    }

    /**
     * Return the login name of this student. The login name is a combination
     * of the first four characters of the student's name and the first three
     * characters of the student's ID number.
     */
    public String getLoginName()
    {
        return name.substring(0,4) + id.substring(0,3);
    }
    
    /**
     * Print the student's name and ID number to the output terminal.
     */
    public void print() //no return, assign
    {
        System.out.println(name + ", student ID: " + id + ", credits: " + credits);

    }
    
    public String getFavourite()
    {
        return favourite;
    }   
    
    public void changeFavourite(String replacementFavourite)
    {
        favourite = replacementFavourite;
    }
    
    public void printFavourite()
    {
        System.out.println(name + "'s favourite subject is: "+ favourite);     
    }
    
    public void printResult()
    {
        if (getCredits() >= 120) {
        System.out.println(name + "'s You have passed! "+ ",credits: " + credits); 
    }
    else {
        System.out.println(name + "'s You have failed! "+ ",credits: " + credits); 
    }
    }
}        
