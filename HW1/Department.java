package university;

import java.util.ArrayList;

public class Department {
	private String name;
	private ArrayList<Course> course;
	private ArrayList<Student> student;
	//constructors
	public Department(){
		name = "unknown";
		course = new ArrayList<Course>();
		student = new ArrayList<Student>();
	}
	//setters and getters
	public void setDepartmentName(String aName){
		name = aName;
	}
	public String getDepartmentName(){
		return name;
	}
	public void addCourse(Course c){
		c.setDepartment(this);
		course.add(c);
	}
	public void addStudent(Student s){
		s.setDepartment(this);
		student.add(s);
	}
	public ArrayList<Student> getStudents(){
		return student;
	}
	
	public ArrayList<Course> getCourseList(){
		return course;
		}
	
}
