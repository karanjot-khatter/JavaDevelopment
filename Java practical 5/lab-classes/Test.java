
/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */



public class Test

{
    public void useStudent()
    {
        Student student_1;
        Student student_2;
        Student student_3;
        student_1 = new Student("Karanjot Khatter", "685632");
        student_1.print();
        student_2 = new Student("Dimitar F", "634632");
        student_2.print();
        student_3 = new Student("Daniel B", "692342");
        student_3.print();
        LabClass LabClass_1;
        LabClass_1 = new LabClass(3);
        LabClass_1.enrollStudent(student_1);
        LabClass_1.enrollStudent(student_2);
        LabClass_1.enrollStudent(student_3);
        LabClass_1.printList();
        System.out.println("press return to finish");
        System.out.println("Program Finished");
    }
}

 
