package main;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatisticalGraph extends JPanel {

    private String ExamCode;
    ArrayList<Integer> ListOfGrades;
    ArrayList<Integer> NumberOfStudentsScoringEachGrade;

    public StatisticalGraph(String ExamCode) {
        this.ExamCode = ExamCode;
        ListOfGrades = new ArrayList<>();
        NumberOfStudentsScoringEachGrade = new ArrayList<>();
    }

    public String getExamCode() {
        return ExamCode;
    }

    public void findNumberofStudentsScoringEachGrade(int maxGrade) {

        for (int i = 0; i <= maxGrade; i++) {

            int numberOfGrade = 0;
            for (int j = 0; j < ListOfGrades.size(); j++) {
                if (ListOfGrades.get(j) == i) {
                    numberOfGrade++;
                }
            }
            NumberOfStudentsScoringEachGrade.add(numberOfGrade);
        }
    }

    public void printGraph(int maxGrade, JFrame frame) {

        findNumberofStudentsScoringEachGrade(maxGrade);
        for (int i = 0; i <= maxGrade; i++) {
            int number = NumberOfStudentsScoringEachGrade.get(i);
            String graph;
            JLabel label = new JLabel();

            if (number >= 1) {
                graph = "*";
                for (int j = 1; j < number; j++) {
                    graph = graph.concat("*");
                }
            } else {
                graph = " ";

            }
            label.setText(i + ": " + graph);
            label.setBounds(430, 30 * i, 400, 30);
            label.setFont(new Font(null, Font.PLAIN, 15));
            frame.add(label);
        }
    }
}
