package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import javax.swing.JOptionPane;

public class Exam {

    private int ID;
    private String courseCode;
    private String examCode;
    private String InstructorName;
    private int duration;

    Date startTime;
    Date endTime;

    EvaluationExamReport report;
    ArrayList<Question> ListOfQuestions;
    ArrayList<Question> QuestionsRanked;
    private int Mark = 0;

    public Exam(int ID, String courseCode, String InstructorName, int duration) {
        this.ID = ID;
        this.courseCode = courseCode;
        this.examCode = courseCode + "_" + ID;
        this.InstructorName = InstructorName;
        this.duration = duration;
        this.report = new EvaluationExamReport(courseCode);
        ListOfQuestions = new ArrayList<>();
    }

    public int getID() {
        return ID;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getExamCode() {
        return examCode;
    }

    public String getInstructorName() {
        return InstructorName;
    }

    public int getDuration() {
        return duration;
    }

    public int getMark() {
        return Mark;
    }

    public void setMark(int Mark) {
        this.Mark = Mark;
    }

    public String getValidationStatus() {
        Date CurrentDate = new Date();

        if (CurrentDate.before(startTime)) {
            return "Not started";
        } else if (CurrentDate.after(startTime) && CurrentDate.before(endTime)) {
            return "In progress";
        } else {
            return "Ended";
        }
    }

    public boolean rankQuestions() {
        if (this.getValidationStatus().equals("Ended") == false) {
            JOptionPane.showMessageDialog(null, "Selected exam has not yet ended");
            return false;
        }

        if (QuestionsRanked != null) {
            return true;
        }

        QuestionsRanked = new ArrayList(ListOfQuestions);
        Collections.sort(QuestionsRanked, Collections.reverseOrder());
        return true;
    }

    public void prepareReport() {

        boolean success = this.rankQuestions();
        if (success == false) {
            return;
        }
        this.report.graph.findNumberofStudentsScoringEachGrade(this.getMark());
        int size = Integer.min(5, this.QuestionsRanked.size());
        this.report.ToughQuestions = new String[size];
        for (int i = 0; i < size; i++) {
            this.report.ToughQuestions[i] = this.QuestionsRanked.get(i).getQ();
        }
    }

    @Override
    public String toString() {
        return examCode;
    }

}
