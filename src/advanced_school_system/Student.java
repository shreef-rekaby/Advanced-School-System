/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package advanced_school_system;

import java.util.ArrayList;

/**
 *
 * @author Bios
 */
public class Student extends Person {
    
    private String password;

    private ArrayList<Course>EnrolledCourses=new ArrayList<>();

    public Student(String password, ArrayList EnrolledCourses, String id, String name) {
        super(id, name);
        this.password = password;
        this.EnrolledCourses = EnrolledCourses;
    }

    public Student(String password, ArrayList EnrolledCourses) {
        this.password = password;
        this.EnrolledCourses = EnrolledCourses;
    }

    public Student() {
        this("no password",new ArrayList());
    }
    
    
    
    
    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }
    public void addCourse(Course course)
    {
        EnrolledCourses.add(course);
    }

    public ArrayList<Course> getEnrolledCourses()
    {
        return this.EnrolledCourses;
    }
    
  
    @Override
    public void displayInfo() {
        System.out.println("ID:"+this.getId());
        System.out.println("Name:"+this.getName());
        System.out.println("Enrolled Courses:");
        for(Course c :EnrolledCourses)
        {
            System.out.println(" - "+c);
        }
    }

}
