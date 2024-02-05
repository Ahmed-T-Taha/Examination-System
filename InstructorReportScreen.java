package main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InstructorReportScreen implements ActionListener {

    Instructor instructor;
    JFrame frame = new JFrame();
    JLabel label = new JLabel("Exam code : ");
    JLabel label2 = new JLabel("The toughest questions are:");

    JComboBox examCodeCombo = new JComboBox();

    JLabel labels[];

    JButton Done = new JButton("Done");

    InstructorReportScreen() {

        instructor = (Instructor) Main.ActiveUser;
        label.setBounds(10, 0, 100, 50);
        label.setFont(new Font(null, Font.PLAIN, 15));

        label2.setBounds(10, 50, 700, 50);
        label.setFont(new Font(null, Font.PLAIN, 15));

        examCodeCombo.setBounds(120, 10, 150, 30);
        for (int i = 0; i < instructor.listOfCourses.size(); i++) {
            Course course = instructor.listOfCourses.get(i);
            for (int j = 0; j < course.addedExams.size(); j++) {
                examCodeCombo.addItem(course.addedExams.get(j));
            }
        }
        examCodeCombo.addActionListener(this);

        Done.setBounds(370, 350, 100, 30);
        Done.setFocusable(false);
        Done.addActionListener(this);

        updateData((Exam) examCodeCombo.getSelectedItem());

        frame.add(examCodeCombo);
        frame.add(label);
        frame.add(label2);
        frame.add(Done);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(840, 420);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    private void updateData(Exam exam) {
        exam.prepareReport();
        int size = exam.report.ToughQuestions.length;

        labels = new JLabel[size];
        for (int i = 0; i < size; i++) {
            labels[i] = new JLabel((i + 1) + ") " + exam.report.ToughQuestions[i]);
            labels[i].setBounds(10, 100 + 50 * i, 800, 50);
            labels[i].setFont(new Font(null, Font.PLAIN, 15));
            frame.add(labels[i]);
        }
        exam.report.graph.printGraph(exam.getMark(), frame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == examCodeCombo) {
            Exam exam = (Exam) examCodeCombo.getSelectedItem();
            updateData(exam);
        } else if (e.getSource() == Done) {
            frame.dispose();
        }
    }

}
