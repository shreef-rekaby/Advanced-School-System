/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package advanced_school_system;

import java.util.ArrayList;
import java.util.Scanner;


public class Advanced_School_System {

    private static ArrayList<Student>students=new ArrayList();
    private static ArrayList<Course> schoolCourses = new ArrayList<>();
    private static Scanner in=new Scanner(System.in);
    public static void main(String[] args) {
        
        schoolCourses.add(new Course("CS101", "Introduction to OOP", 3));
        schoolCourses.add(new Course("CS102", "Data Structures", 4));
        schoolCourses.add(new Course("MAT201", "Calculus I", 3));
        schoolCourses.add(new Course("ENG101", "English Comp", 3));
        schoolCourses.add(new Course("PHY101", "General Physics", 4));
       
        while(true)
        {
            System.out.println("\n--- School Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Enroll in Course");
            System.out.println("3. Remove Course");
            System.out.println("4. Show Student Info");
            System.out.println("5. Delete Student");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            String choice=in.next();
            switch(choice)
            {
                case "1":
                    addStudent();
                    break;
                case "2":
                    enrollInCourse();
                    break;
                case "3":
                    deleteCourse();
                    break;
                case "4":
                    displayStudent();
                    break;
                case "5":
                    deleteStudent();
                    break;
                case "0":
                    System.out.println("Terminating...");
                    System.exit(0);
                    break;
                default: System.out.println("Invalid Choice.");

            }
    
        }
    }
    
   private static Student logIn() {
        System.out.print("Enter Student ID: ");
        String id = in.next();
        System.out.print("Enter Password: ");
        String password = in.next();

        for (Student s : students) {
            
            if (s.getId().equals(id) && s.getPassword().equals(password)) {
                return s;
            }
        }
    return null;
   }
    
    private static void addStudent()
    {
        System.out.print("Enter Student ID:"); 
        String id=in.next();
        
         for (Student s : students) {
            if (s.getId().equals(id)) {
                System.out.println("[Error] Student ID already exists!");
                return;
            }
        }
         
        in.nextLine();
        System.out.print("Enter Full Name:");
        String name=in.nextLine();

        System.out.print("Enter Password:");
        String password=in.next();
        
        Student student=new Student();
        student.setId(id);
        student.setName(name);
        student.setPassword(password);
        
        students.add(student);
        System.out.println("[Success] Student added.");
  
    }
    private static void enrollInCourse()
    {

        Student currentStudent =logIn();
        if (currentStudent == null) {
            System.out.println("LogIn Failed.");
            return;
        }
        
        System.out.println("\nAvailable Courses:");
        for(int i=0;i<schoolCourses.size();i++)
        {
            System.out.println((i+1)+".  "+schoolCourses.get(i));
        }
        
        
        System.out.print("Select course number: ");
        int choice = in.nextInt();

        if (choice < 1 || choice > 5) {
            System.out.println("Invalid choice.");
            return;
        }

        Course selected = schoolCourses.get(choice - 1);

       
        for (Course c : currentStudent.getEnrolledCourses()) {
            if (c.getCourseId().equals(selected.getCourseId())) {
                System.out.println("[Error] Already enrolled in this course.");
                return;
            }
        }
        
       currentStudent.addCourse(selected);
       System.out.println("[Success] Enrolled in " + selected.getCourseName());

        

    }
    
    private static void deleteCourse()
    {
    
       Student currentStudent=logIn();
      if (currentStudent == null) {
            System.out.println("LogIn Failed.");
            return;
        }
          System.out.println("You are currently enrolled in:");
            
          for(Course c :currentStudent.getEnrolledCourses())
          {
                System.out.println(" - "+c);
          }
            
            System.out.println("\nEnter the Course ID you wish to remove:\n");
            String courseId=in.next();
            Course courseToRemove=null;
            
            for(Course c :currentStudent.getEnrolledCourses() )
            {
                if (c.getCourseId().equals(courseId)) {
                courseToRemove = c;
                break;
            }
                
            }
            if(courseToRemove!=null)
            {
             currentStudent.getEnrolledCourses().remove(courseToRemove);
             System.out.println("[Success] Course removed.");
            }
            else
            {
             System.out.println("[Error] Course not found in your profile.");
            }
            
      
    }
    private static void displayStudent()
    {
       Student currentStudent=logIn();
       if (currentStudent == null) {
            System.out.println("LogIn Failed.");
            return;
       }
           
       currentStudent.displayInfo();

      
    }
    private static void deleteStudent()
    {
      Student currentStudent=logIn();
       if (currentStudent == null) {
            System.out.println("LogIn Failed.");
            return;
       }
       
          
      System.out.print("Are you sure you want to delete " 
               + currentStudent.getName() + " and all enrollment data? (Y/N): ");
               String Y_N=in.next();
              
      if(Y_N.equalsIgnoreCase("Y"))
      {
          students.remove(currentStudent);
      }
      else if(Y_N.equalsIgnoreCase("N"))
      {
          System.out.println("Student is won't be removed");
      }
      else
      {
          System.out.println("you enter invalid data");
          return;
      }
         
    }
    

   
}
