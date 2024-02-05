package main;

import java.util.ArrayList;
import java.util.Date;

public class Instructor extends AdvancedUser {

    private int age;
    ArrayList<Course> listOfCourses;

    public Instructor(String Username, String Password, String Name, String MobileNumber, String EmailAddress, int Age) {
        super(Username, Password, Name, MobileNumber, EmailAddress);
        this.age = Age;
        listOfCourses = new ArrayList<>();
    }

    public int getAge() {
        return age;
    }

}
