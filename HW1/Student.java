package org.university.people;
import java.util.*;
import org.university.software.Course;
import org.university.hardware.Department;

public class Student {
	/*1. Each Student have a name and a schedule.  
	 * They also belong to a department*/
	private String name; 
	private Department department; 
	private ArrayList<Course> course;
	
	/* units completed,and total units needed for degree completion*/
	private Integer unitsCompleted; 
	private Integer unitsNeeded;
	
	public Student() {
		name= "";
		department=new Department();
		course= new ArrayList<Course>();
		unitsCompleted = 0;
		unitsNeeded = 0;
		
	}
	

	/*Getter and setter*/
	
  // name
	public String getName() {
		return name;	
	}
	
	public void setName(String aName ) {
		name = aName;
	}
	
	//department
	public Department getDepartment(){
	        return department;
	    }
		
	public void setDepartment(Department department){
	        this.department = department;
	        if(!this.department.getStudentList().contains(this)){
	            this.department.addStudent(this);
	        }
	    }
	
	// course
    public ArrayList<Course> getCourses(){
        return course;
    }
	
    //Units
	 public void setCompletedUnits(int units){
	        unitsCompleted = units;
	    }

	  public int getUnitsCompleted(){
	        return unitsCompleted;
	    }

	  //
	  public int requiredToGraduate(){
	        return unitsNeeded- unitsCompleted;
	    }

	  public void setRequiredCredits(int units){
	       unitsNeeded= units;
	    }

	  public int getTotalUnits(){
	        return unitsNeeded;
	    }
	
	/*		*/  
	  public boolean detectConflict(Course aCourse){
	        for(Course course : course){
	            if(course.compareSchedules(aCourse)){
	                ArrayList<String> conflicts = course.getConflictSlots(aCourse);
	                for(String conflict : conflicts){
	                    System.out.println(aCourse.getDepartment().getDepartmentName()
	                            + aCourse.getCourseNumber() + " course cannot be added to "
	                            + name + "'s Schedule. " + aCourse.getDepartment().getDepartmentName()
	                            + aCourse.getCourseNumber() + " conflicts with "
	                            + course.getDepartment().getDepartmentName()
	                            + course.getCourseNumber() + ". Conflicting time slot is "
	                            + conflict + ".");
	                }
	                return true;
	            }
	        }
	        return false;
	    }
	  
	  
	  private int[] getTimeSlots(){
	        int[] toReturn = new int[30];
	        int index = 0;
	        for(int i = 100; i <= 500; i += 100){
	            for(int j = 1; j <= 6; j++){
	                toReturn[index] = i + j;
	                index++;
	            }
	        }
	        return toReturn;
	    }
	  
	   public void addCourse(Course crs){
	        if(!detectConflict(crs)){
	            getCourses().add(crs);
	            if(!crs.getStudentRoster().contains(this))
	                crs.addStudent(this);
	        }
	    }
	   
	  public void dropCourse(Course crs){
	        if(getCourses().contains(crs)){
	            getCourses().remove(crs);
	            if(crs.getStudentRoster().contains(this))
	                crs.removeStudent(this);
	        }
	        else{
	            System.out.println("The course " + crs.getDepartment().getDepartmentName()
	                    + crs.getCourseNumber() + " could not be "
	                    + "dropped because " + crs.getName() + " is not enrolled in "
	                    + crs.getDepartment().getDepartmentName()
	                    + crs.getCourseNumber() + ".");
	        }
	    }

	



	    public void printSchedule(){
	        for(int time : getTimeSlots())
	            for(Course crs : course)
	                if(crs.getMeetingTime(time) != "")
	                    System.out.println(crs.getMeetingTime(time)
	                            + " " + crs.getDepartment().getDepartmentName()
	                            + crs.getCourseNumber() + " " + crs.getName());
	    }

	    
	}
	  
	  
