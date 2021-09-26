package university;

import java.util.ArrayList;

public class Course {
	private String name;
	private int number;
	private ArrayList<Integer> schedule;
	private ArrayList<Student> studentRoster;
	private Department department;
	//constructors
	public Course(){
		name = "unknown";
		number = 0;
		schedule = new ArrayList<>();
		studentRoster = new ArrayList<>();
	}
	//getters and setters
	public void setName(String aName){
		name = aName;
	}
	public String getName(){
		return name;
	}
	public void setCourseNumber(int aNumber){
		number = aNumber;
	}
	public int getCourseNumber(){
		return number;
	}
	public void addStudent(Student s){
		studentRoster.add(s);
	}
	public void setSchedule(int number){
		schedule.add(number);
	}
	public ArrayList<Integer> getSchedule(){
		return schedule;
	}
	public ArrayList<Student> getStudentRoster(){
		return studentRoster;
	}
	public void setDepartment(Department d){
		department = d;
	}
	public Department getDepartment(){
		return department;
	}
}
