package org.university.hardware;
import java.util.ArrayList;
import org.university.people.*;
import org.university.software.*;

public class Department {
    private String name;
    private ArrayList<Course> courses;
    private ArrayList<Student> students;
    private ArrayList<Professor>professors;
    
    public Department(){
        courses = new ArrayList<Course>();
        students = new ArrayList<Student>();
       professors = new ArrayList<Professor>();
       
    }

    public void setDepartmentName(String name){
        this.name = name;
    }

    public String getDepartmentName(){
        return name;
    }



    public void addProfessor(Professor prof){
       professors.add(prof);
        if(prof.getDepartment() == null || prof.getDepartment() != this){
            prof.setDepartment(this);
        }
    }

    public ArrayList<Professor> getProfessorList(){
        return professors;
    }

    public void addStudent(Student student){
        students.add(student);
        if(!student.getDepartment().equals(this))
            student.setDepartment(this);
    }

    public ArrayList<Student> getStudentList(){
        return students;
    }

    public void addCourse(Course course){
        courses.add(course);
        if(!course.getDepartment().equals(this))
            course.setDepartment(this);
    }

    public ArrayList<Course> getCourseList(){
        return courses;
    }

    public void printStudentList(){
        for(Student s : students){
            System.out.println(s.getName());
        }
    }

    public void printProfessorList(){
        for(Professor s :professors){
            System.out.println(s.getName());
        }
    }

 
    public void printCourseList(){
        for(Course crs : courses){
            System.out.println(name + crs.getCourseNumber());
        }
    }


}
