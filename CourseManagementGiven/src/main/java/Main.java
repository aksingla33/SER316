package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class Main {
    static HashMap<String, Student> students = new HashMap<>();
    static HashMap<String, CourseGrades0> courses = new HashMap<>();

    public static void main(String[] args)throws Exception {

        students.put("anna", new Student("anna", Major.valueOf("SER")));
        students.put("karl", new Student("karl", Major.valueOf("CS")));
        students.put("franz", new Student("franz", Major.valueOf("CS")));
        students.put("harry", new Student("harry", Major.valueOf("SER")));
        students.put("aneesh", new Student("aneesh", Major.valueOf("SER")));
        students.put("rebecca", new Student("rebecca", Major.valueOf("SER")));
        students.put("alex", new Student("alex", Major.valueOf("SER")));
        students.put("rose", new Student("rose", Major.valueOf("SER")));
        
        
        
        courses.put("SER316", new CourseGrades0("SER316"));
        courses.put("SER315", new CourseGrades0("SER315"));
        courses.put("SC232", new CourseGrades0("CS232"));

        Integer marksRose ;
        System.out.println("Anna has scored " + new Integer(40).toString() + " marks which makes her the topper.");
        courses.get("SER315").set_points("anna", 40);
        courses.get("SER315").set_points("harry", 20);
        courses.get("SER315").set_points("aneesh", 30);
        courses.get("SER315").set_points("rebecca", 10);
        courses.get("SER315").set_points("alex", 30);
        courses.get("SER315").set_points("rose", 23);
        
        
        courses.get("SER315").printCourseStats();

     
    }
}
