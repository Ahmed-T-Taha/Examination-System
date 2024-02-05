package main;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class Main {

    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Instructor> instructors = new ArrayList<>();
    static ArrayList<Course> courses = new ArrayList<>();
    static Administrator admin = new Administrator();
    static User ActiveUser = null;

    public static void main(String[] args) {

        initialiseData();
        new LaunchScreen();
    }

    public static void initialiseData() {

        students.add(new Student("student0user", "student0pass", "student0name",
                "student0mobile", "student0email", "student0id"));

        students.add(new Student("student1user", "student1pass", "student1name",
                "student1mobile", "student1email", "student1id"));

        students.add(new Student("student2user", "student2pass", "student2name",
                "student2mobile", "student2email", "student2id"));

        instructors.add(new Instructor("instructor0user", "instructor0pass",
                "instructor 0", "instructor0mobile", "instructor0email", 40));

        instructors.add(new Instructor("instructor1user", "instructor1pass",
                "instructor 1", "instructor1mobile", "instructor1email", 50));

        instructors.add(new Instructor("instructor2user", "instructor2pass",
                "instructor 2", "instructor2mobile", "instructor2email", 60));

        courses.add(new Course("course0id", "course0name", "course0code", "instructor0"));
        courses.add(new Course("course1id", "course1name", "course1code", "instructor1"));
        courses.add(new Course("course2id", "course2name", "course2code", "instructor2"));

        Exam exam = new Exam(1, "course0code", "instructor0", 1);
        exam.startTime = new Date(122, 4, 25, 19, 0);
        exam.endTime = new Date(122, 4, 25, 20, 0);
        for (int i = 0; i < 3; i++) {
            exam.ListOfQuestions.add(new Question("Question " + i, "Answer a", "Answer b", "Answer c", "Answer d", 'a', 3));
            exam.setMark(exam.getMark() + 3);
        }

        for (int j = 0; j < 100; j++) {
            int mark = 0;
            for (int k = 0; k < 3; k++) {
                exam.ListOfQuestions.get(k).incrementNumberOfAttempts();
                if (Math.random() > 0.5) {
                    exam.ListOfQuestions.get(k).incrementNumberOfCorrectAnswers();
                    mark += exam.ListOfQuestions.get(k).getGrade();
                }
            }
            exam.report.graph.ListOfGrades.add(mark);
        }
        courses.get(0).addedExams.add(exam);

        exam = new Exam(1, "course1code", "instructor1", 1);
        exam.startTime = new Date(122, 4, 25, 19, 0);
        exam.endTime = new Date(122, 4, 25, 20, 0);
        for (int i = 0; i < 3; i++) {
            exam.ListOfQuestions.add(new Question("Question " + i, "Answer a", "Answer b", "Answer c", "Answer d", 'a', 3));
            exam.setMark(exam.getMark() + 3);
        }

        for (int j = 0; j < 100; j++) {
            int mark = 0;
            for (int k = 0; k < 3; k++) {
                exam.ListOfQuestions.get(k).incrementNumberOfAttempts();
                if (Math.random() > 0.5) {
                    exam.ListOfQuestions.get(k).incrementNumberOfCorrectAnswers();
                    mark += exam.ListOfQuestions.get(k).getGrade();
                }
            }
            exam.report.graph.ListOfGrades.add(mark);
        }
        courses.get(1).addedExams.add(exam);

        exam = new Exam(1, "course2code", "instructor2", 1);
        exam.startTime = new Date(122, 4, 25, 19, 0);
        exam.endTime = new Date(122, 4, 25, 20, 0);
        for (int i = 0; i < 3; i++) {
            exam.ListOfQuestions.add(new Question("Question " + i, "Answer a", "Answer b", "Answer c", "Answer d", 'a', 3));
            exam.setMark(exam.getMark() + 3);
        }
        for (int j = 0; j < 100; j++) {
            int mark = 0;
            for (int k = 0; k < 3; k++) {
                exam.ListOfQuestions.get(k).incrementNumberOfAttempts();
                if (Math.random() > 0.5) {
                    exam.ListOfQuestions.get(k).incrementNumberOfCorrectAnswers();
                    mark += exam.ListOfQuestions.get(k).getGrade();
                }
            }
            exam.report.graph.ListOfGrades.add(mark);
        }
        courses.get(2).addedExams.add(exam);

        for (int i = 0; i < 3; i++) {
            students.get(i).listOfTakenCourses.add(courses.get(i));
        }

        for (int i = 0; i < 3; i++) {
            instructors.get(i).listOfCourses.add(courses.get(i));
        }

    }

    public static boolean login(String userType, String username, String password) {

        switch (userType) {
            case "admin":
                if (username.equals(admin.getUsername())
                        && password.equals(admin.getPassword())) {
                    ActiveUser = admin;
                    return true;
                }
                return false;

            case "instructor":
                for (int i = 0; i < instructors.size(); i++) {
                    if (username.equals(instructors.get(i).getUsername())
                            && password.equals(instructors.get(i).getPassword())) {
                        ActiveUser = instructors.get(i);
                        return true;
                    }
                }
                return false;

            case "student":
                for (int i = 0; i < students.size(); i++) {
                    if (username.equals(students.get(i).getUsername())
                            && password.equals(students.get(i).getPassword())) {
                        ActiveUser = students.get(i);
                        return true;
                    }
                }
                return false;

            default:
                return false;
        }

    }

    public static boolean register(String Username, String Password, String Name,
            String MobileNumber, String EmailAddress, int Age) {

        for (int i = 0; i < instructors.size(); i++) {
            if (instructors.get(i).getUsername().equals(Username)) {
                JOptionPane.showMessageDialog(null, "Username already exists");
                return false;
            }
        }

        instructors.add(new Instructor(Username, Password, Name, MobileNumber, EmailAddress, Age));
        return true;
    }

    public static boolean register(String Username, String Password, String Name,
            String MobileNumber, String EmailAddress, String ID) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getUsername().equals(Username)) {
                JOptionPane.showMessageDialog(null, "Username already exists");
                return false;
            }
        }

        students.add(new Student(Username, Password, Name, MobileNumber, EmailAddress, ID));
        return true;
    }

}
