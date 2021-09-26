package org.university.people;
import java.util.ArrayList;

import org.university.hardware.Department;
import org.university.software.Course;

public class Professor {
	private String name; 
	private Department department; 
	private ArrayList<Course> course;
	  
	    public Professor(){
	    	name= "";
			department=new Department();
			course= new ArrayList<Course>();
	    }

	    public String getName() {
			return name;	
		}
		
		public void setName(String aName ) {
			name = aName;
		}
		
		//department
		   public void setDepartment(Department newDept){
		       department = newDept;
		    }

		    public Department getDepartment(){
		        return  department;
		    }
		
		// course
	    public ArrayList<Course> getcourse(){
	        return course;
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

	    public void printSchedule(){
	        for(int time : getTimeSlots())
	            for(Course crs : course)
	                if(crs.getMeetingTime(time) != "")
	                    System.out.println(crs.getMeetingTime(time)
	                            + " " + crs.getDepartment().getDepartmentName()
	                            + crs.getCourseNumber() + " " + crs.getName());
	    }
	    public void addCourse(Course aCourse) {
	        if(aCourse.getProfessor() != null){
	            System.out.println("The professor cannot be assigned to this course"
	                    + " because professor " + aCourse.getProfessor().getName()
	                    + " is already assigned to the course " + aCourse.getName() + ".");
	        }
	        else if(!detectConflict(aCourse)){
	            aCourse.setProfessor(this);
	            getcourse().add(aCourse);
	        }
	    }

	}


