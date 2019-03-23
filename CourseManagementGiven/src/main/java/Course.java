package main.java;

/**
 * class for managing course statistics
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;



public class Course {
    
    public HashMap<String, Integer> points = new HashMap<>(); // maps student names (asurite) to their points
    private String Name; // course name


    public Course(String name){
        this.SetName(name);
    }

    public String GetName() {
        return Name;
    }

    public void SetName(String name) {
        this.Name = name;
    }
    

    public void printCourseStats() {
       ArrayList<Integer> values = new ArrayList<Integer>(points.values());

        System.out.print("Average Grades without max and without min: ");
        System.out.println(this.calculateAverageWithoutMinWithoutMax());
    }
    
    
    // REACH at least 95% Code coverage (assign 3)
    // method to draw node graph for
    // should throw null pointer for empty points member
    // negative points should be ignored
    // max value and min value should be removed - (if doubles then only the first occurrence)
    // if just one or two values no values will be omitted
    public double calculateAverageWithoutMinWithoutMax() throws NullPointerException {
        ArrayList<Integer> collection = new ArrayList<Integer>(points.values());
        
         int counter = 0;
         int min = Integer.MAX_VALUE;
         int max = Integer.MIN_VALUE;
         if(collection.size() == 1)
            return collection.get(0);
        
        else if(collection.size() == 2 ){
            return (double)(collection.get(0) + collection.get(1))/2;
        }
        else {
            int allPoints = 0;
            for(int point: collection){
                if (point >= 0) {
                    
                    counter = counter++;
                    if (point < min){
                        min = point;
                    }
                    if (point > max){
                        max = point;
                    }
                    allPoints = allPoints + point;
                }
            }
            
            int totalPoints = allPoints-max-min;
                return totalPoints/(double)(counter-1); 

        }
    }
    
    // REACH at least 95% Code coverage  (assign 3)
    // if student with the name (asurite member) is not yet included student needs to be added to student list 
    // sets points for a student 
    public void set_points(String name, int points) {
    	System.out.println(points);
        this.points.put(name, points);
    }
    
    
    // REACH at least 95% Code coverage  (assign 3)
    // Students should only be added when they are not yet in the course (names (asurite member) needs to be unique)
    ArrayList<Student> students  = new ArrayList<Student>();
    public boolean addStudent(Student s) {
        students.add(s);
        points.put(s.getAsurite(), -1);
        return true;
    }


    public HashMap<String, Integer> GetPoints(){
        return points;
    }
    

    public int getStudent_Points(String student) {
        return points.get(student);
    }
    
    public int getStudent_Points(Student student) {
        return points.get(student.getAsurite());
    }

    
    public ArrayList<Student> getStudents(){
        return students;
    }
    
    public HashMap<String, Integer> countOccurencesLetterGrades() throws NullPointerException{
     	return null;
   
    }
  
 
  
 }