import java.util.ArrayList;

/**
 * A class to maintain an arbitrarily long list of student objects.
 * 
 * @author Robert Topp
 * @version 2013.02.05
 */
public class Register
{
    // Storage for an arbitrary number of students.
    private ArrayList<Student> students;

    /**
     * Perform any initialization that is required for the
     * student list
     */
    public Register()
    {
        students = new ArrayList<Student>();
        storeStudent(new Student("Abigail", "100001",180));
        storeStudent(new Student("Brenda", "200001",120));
        storeStudent(new Student("Catherine", "300001",120));
        storeStudent(new Student("Doris", "400001",120));
        storeStudent(new Student("Erica", "500001",0));
        storeStudent(new Student("Fiona", "600001",120));
        storeStudent(new Student("Geraldine", "700001",120));
        storeStudent(new Student("Harriet", "800001",60));
    }

    /**
     * Store a new student into the student list.
     * @param student The student to be stored.
     */
    public void storeStudent(Student stud)
    {
        students.add(stud);       
    }

    /**
     * @return The number of students currently in the list.
     */
    public int numberOfStudents()
    {
        return students.size();
    }

    /**
     * 
     * Remove from the list the student at index position "ind"
     * 
     */
    public void absent(int ind)
    {

    if(ind >= 0 && ind< students.size()) {
          students.remove(ind);  
            }
    }    
    
    /**
     * List the names of all students in the list.
     */
    public void listStudentNames(int ind)
    {
         if(ind >= 0 && ind < students.size()) {
            Student stud = students.get(ind);
            System.out.println(stud);
        }
    }

    /**
     * Report whether all students have a credit count of at least 100
     * return true if all students have a credit count of at least 100
     * otherwise return false
     */
    public boolean allatleast100(int ind)
    {
        boolean valid;
        
        if(ind >=100) {
            System.out.println("Credit count is atleast 100: " + ind);
            valid = true;
        }
        else if(ind <= students.size()) {
            System.out.println("Credic count is too small: " + ind);
            valid = false;
        }
        else {
            valid = true;
        }
        return valid;
    }
        
}
