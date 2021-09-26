package university;

import java.util.ArrayList;

public class Student {
	private String name;
	private Department department;
	private ArrayList<Course> course;
	//private ArrayList<Integer> schedule;
	//constructors
	public Student(){
		name = "unknown";
		department = new Department();
		course = new ArrayList<Course>();
		//schedule = new ArrayList<>();
	}
	//setters and getters
	public String getName(){ 
		return name;
	}
	public void setName(String aName){
		name = aName;
	}
	public Department getDepartment(){
		return department;
	}
	public void setDepartment(Department d){
		department = d;
	}
	public void addCourse(Course c){
		c.addStudent(this);
		course.add(c);
	}

}
