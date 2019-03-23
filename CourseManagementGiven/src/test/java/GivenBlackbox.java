package test.java;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import main.java.Course;
import main.java.CourseGrades1;
import main.java.CourseGrades2;
import main.java.CourseGrades5;
import main.java.CourseGrades4;
import main.java.CourseGrades0;
import main.java.CourseGrades3;

import java.lang.reflect.Constructor;

@RunWith(Parameterized.class)
public class GivenBlackbox {
    private Class<Course> classUnderTest;
    
    
    @SuppressWarnings("unchecked")
    public GivenBlackbox(Object classUnderTest) {
        this.classUnderTest = (Class<Course>) classUnderTest;
    }
    
    // Defining all the classes that need to be tested
    @Parameters
    public static Collection<Object[]> courseGradesUnderTest() {
        Object[][] classes = { 
                {CourseGrades0.class},
                {CourseGrades1.class},
                {CourseGrades2.class},
                {CourseGrades3.class},
                {CourseGrades4.class},
                {CourseGrades5.class}
        };
        return Arrays.asList(classes);
    }
    
    // method to call the correct constructor
    private Course createCourse(String name) throws Exception {
        Constructor<Course> constructor = classUnderTest.getConstructor(String.class);
        return constructor.newInstance(name);
    }
    

    // A sample course
    Course twoStudent;
    HashMap<String, Integer> twoStudentExpected = new HashMap<String, Integer>(); 
    
    
    @Before
    public void setUp() throws Exception {
        
        // all courses should be created like this
        
        
        // Course created with two Students having
        twoStudent = createCourse("SER316");
        twoStudent.set_points("Hanna",100);
        twoStudent.set_points("Karla",100);
        // this would be the expected result after the method countOccurencesLetterGrades is called
        twoStudentExpected.put("A", 2);
        twoStudentExpected.put("B", 0);
        twoStudentExpected.put("C", 0);
        twoStudentExpected.put("D", 0);
        twoStudentExpected.put("F", 0);
    }


    // Sample test
    @Test
    public void twoStudent() {
        HashMap<String, Integer> ans = twoStudent.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(twoStudentExpected));
    }


}
