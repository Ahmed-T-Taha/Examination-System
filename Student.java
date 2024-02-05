package main;

import java.util.ArrayList;

public class Student extends AdvancedUser {

    private String ID;
    ArrayList<Course> listOfTakenCourses;

    public Student(String Username, String Password, String Name, String MobileNumber, String EmailAddress, String ID) {
        super(Username, Password, Name, MobileNumber, EmailAddress);
        this.ID = ID;
        listOfTakenCourses = new ArrayList<>();
    }

    public String getID() {
        return ID;
    }

}
