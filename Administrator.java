package main;

import javax.swing.JOptionPane;

public class Administrator extends User {

    public Administrator() {
        super("adminUsername", "adminPassword");
    }

    public boolean createCourse(String courseID, String courseName, String courseCode, String instructor) {

        for (int i = 0; i < Main.courses.size(); i++) {
            if (Main.courses.get(i).getID().equals(courseID)) {
                JOptionPane.showMessageDialog(null, "Course ID already exists");
                return false;
            } else if (Main.courses.get(i).getName().equals(courseName)) {
                JOptionPane.showMessageDialog(null, "Course name already exists");
                return false;
            } else if (Main.courses.get(i).getCode().equals(courseCode)) {
                JOptionPane.showMessageDialog(null, "Course code already exists");
                return false;
            }
        }

        Course course = new Course(courseID, courseName, courseCode, instructor);
        Main.courses.add(course);

        for (int i = 0; i < Main.instructors.size(); i++) {
            if (instructor.equals(Main.instructors.get(i).getName())) {
                Main.instructors.get(i).listOfCourses.add(course);
                break;
            }
        }
        return true;
    }

    public boolean enrolStudent(String studentID, String courseID) {

        Course course = null;
        Student student = null;

        for (int i = 0; i < Main.students.size(); i++) {
            if (Main.students.get(i).getID().equals(studentID)) {
                student = Main.students.get(i);
                break;
            }
        }

        for (int i = 0; i < student.listOfTakenCourses.size(); i++) {
            if (student.listOfTakenCourses.get(i).getID().equals(courseID)) {
                JOptionPane.showMessageDialog(null, "Student already enrolled");
                return false;
            }
        }

        for (int i = 0; i < Main.courses.size(); i++) {
            if (Main.courses.get(i).getID().equals(courseID)) {
                course = Main.courses.get(i);
                break;
            }
        }

        student.listOfTakenCourses.add(course);
        return true;

    }

}
