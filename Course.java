package main;

import java.util.ArrayList;

public class Course {

    private String ID;
    private String name;
    private final String code;
    private String instructor;
    ArrayList<Exam> addedExams;

    public Course(String ID, String name, String code, String instructor) {
        this.ID = ID;
        this.name = name;
        this.code = code;
        this.instructor = instructor;
        addedExams = new ArrayList<Exam>();
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getInstructor() {
        return instructor;
    }

    @Override
    public String toString() {
        return this.code;
    }

}
