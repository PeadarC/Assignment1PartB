package partB;

import java.util.ArrayList;

import org.joda.time.DateTime;

import studentReg.CourseProgramme;
import studentReg.Module;
import studentReg.Student;


public class Driver
{
    private static CourseProgramme ComputerScience, Business, Science;
    private static Student Peadar, Seamus, Shannon;
    private static Module Maths, Accounting, Programming;

    public Driver() {

        Maths = new Module("Maths", "MTS34");
        Seamus = new Student("Seamus", 21, new DateTime("1999-12-25"), 17803141);
        ComputerScience = new CourseProgramme("ComputerScience", new DateTime("2020-09-28"), new DateTime("2021-05-20"));
        Accounting = new Module("Accounting", "DB84");
        Peadar = new Student("Peadar", 21, new DateTime("1999-01-11"), 17461562);
        Business = new CourseProgramme("Business", new DateTime("2020-09-28"), new DateTime("2021-05-20"));
        Programming = new Module("Programming", "BS28");
        Shannon = new Student("Shannon", 21, new DateTime("1999-07-12"), 17236124);
        Science = new CourseProgramme("Science", new DateTime("2020-09-28"), new DateTime("2021-05-20"));

        Seamus.addModule(Maths);
        Seamus.addModule(Accounting);
        Seamus.addModule(Programming);
        Seamus.addCourse(ComputerScience);
        
        Peadar.addModule(Maths);
        Peadar.addModule(Accounting);
        Peadar.addCourse(Business);

        Shannon.addModule(Maths);
        Shannon.addModule(Accounting);
        Shannon.addCourse(Science);

        Maths.addStudent(Peadar);
        Maths.addStudent(Seamus);
        Maths.addStudent(Shannon);

        Accounting.addStudent(Peadar);
        Accounting.addStudent(Seamus);
        Accounting.addStudent(Shannon);

        Programming.addStudent(Seamus);

        Maths.addCourse(Business);
        Maths.addCourse(Science);
        Maths.addCourse(ComputerScience);

        Programming.addCourse(ComputerScience);

        Accounting.addCourse(Business);
        Accounting.addCourse(Science);
        Accounting.addCourse(ComputerScience);

        Programming.addCourse(ComputerScience);

        ComputerScience.addModule(Programming);
        ComputerScience.addModule(Maths);
        ComputerScience.addModule(Accounting);
        Business.addModule(Accounting);
        Business.addModule(Maths);
        Science.addModule(Maths);
        Science.addModule(Accounting);

        ComputerScience.addStudent(Seamus);
        Business.addStudent(Peadar);
        Science.addStudent(Shannon);
    }

    public void printToConsole(){
        studentPrint(Peadar);
        studentPrint(Seamus);
        studentPrint(Shannon);
        modulePrint(Maths);
        modulePrint(Accounting);
        modulePrint(Programming);
        coursesPrint(ComputerScience);
        coursesPrint(Business);
        coursesPrint(Science);
    }

    public void studentPrint(Student student){

        System.out.println(student.getName());
        ArrayList<CourseProgramme> courses = student.getRegisteredCourses();

        System.out.print("Student username:");
        System.out.println(student.getUsername());

        System.out.println("They study the course(s):");
        for (CourseProgramme course : courses) {
            System.out.println(course.getCourseName());
        }

        System.out.println("They take the following module(s):");
        ArrayList<Module> modules = student.getRegisteredModules();
        for (Module module : modules) {
            System.out.println(module.getModuleName());
        }
        System.out.println();
    }

    public void modulePrint(Module module){

        System.out.print(module.getModuleName());
        ArrayList<CourseProgramme> courses = module.getModuleCourses();
        System.out.println(" is a module in the following course(s):");
        for (CourseProgramme course : courses) {
            System.out.println(course.getCourseName());
        }

        ArrayList<Student> students = module.getModuleStudents();
        System.out.println("The following student(s) take this module:");
        for (Student student : students) {
            System.out.println(student.getName());
        }
        System.out.println();
    }

    public void coursesPrint(CourseProgramme course){

        System.out.print(course.getCourseName());
        ArrayList<Module> modules = course.getCourseModules();
        System.out.println(" has the following module(s):");
        for (Module module : modules) {
            System.out.println(module.getModuleName());
        }

        System.out.println("The following student(s) are registered for this course:");
        ArrayList<Student> students = course.getCourseStudents();
        for (Student student : students) {
            System.out.println(student.getName());
        }
        System.out.println();
    }

}
