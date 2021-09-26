
package org.university.software;
import java.util.ArrayList;
import org.university.people.*;
import org.university.hardware.*;

public class Course {
    private String[] Week = {"Mon", "Tue", "Wed", "Thu", "Fri"};
    private String[] Slot = {"8:00am to 9:15am",
            "9:30am to 10:45am",
            "11:00am to 12:15pm",
            "12:30pm to 1:45pm",
            "2:00pm to 3:15pm",
            "3:30pm to 4:45pm"};
    private String name;
    private int number;
    private ArrayList<Integer> schedule;
    private ArrayList<Student> roster;
    private Department dept;
    private Classroom room;
    private Professor prof;

    public Course(){
        name = "";
        number = -1;
        prof = null;
        schedule = new ArrayList<Integer>();
        roster = new ArrayList<Student>();
        dept = new Department();
    }

    public String getMeetingTime(int timeSlot){
        if(schedule.contains(timeSlot))
            return Week[timeSlot / 100 - 1] + " " + Slot[timeSlot % 10 - 1];
        return "";
    }

    public void printSchedule(){
        for(int timeSlot : schedule){
            System.out.println(getMeetingTime(timeSlot) + " " + room.getRoomNumber());
        }
    }

    public void printRoster(){
        for(Student snt : roster){
            System.out.println(snt.getName());
        }
    }

    public void setRoomAssigned(Classroom newRoom){
        newRoom.addCourse(this);
        room = newRoom;
    }

    public Classroom getRoomAssigned(){
        return room;
    }

    public boolean compareSchedules(Course other){
        for(Integer timeSlot : other.schedule){
            if(schedule.contains(timeSlot))
                return true;
        }
        return false;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setProfessor(Professor prof){
        this.prof = prof;
    }

    public Professor getProfessor(){
        return prof;
    }

    public void setCourseNumber(int num){
        number = num;
    }

    public int getCourseNumber(){
        return number;
    }

    public void setSchedule(int addNum){
        schedule.add(addNum);
    }

    public ArrayList<Integer> getSchedule(){
        return schedule;
    }

    public void setDepartment(Department dept){
        this.dept = dept;
        if(!this.dept.getCourseList().contains(this))
            this.dept.addCourse(this);
    }

    public Department getDepartment(){
        return dept;
    }

    public void addStudent(Student student){
        roster.add(student);
        if(!student.getCourses().contains(this)){
            student.addCourse(this);
        }
    }

    public void removeStudent(Student student){
        roster.remove(student);
        if(student.getCourses().contains(this)){
            student.dropCourse(this);
        }
    }

   

    public ArrayList<Student> getStudentRoster(){
        return roster;
    }

    public ArrayList<String> getConflictSlots(Course aCourse){
        ArrayList<String> toReturn = new ArrayList<String>();
        for(Integer timeSlot : aCourse.schedule){
            if(schedule.contains(timeSlot))
                toReturn.add(getMeetingTime(timeSlot));
        }
        return toReturn;
    }
}