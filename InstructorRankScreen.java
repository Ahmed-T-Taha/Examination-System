package main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InstructorRankScreen implements ActionListener {

    Instructor instructor;
    JFrame frame = new JFrame();
    JLabel label = new JLabel("Exam Code:");
    JLabel label1 = new JLabel("Questions ranking from easiest to hardest:");

    JLabel labels[];

    JComboBox examCombo = new JComboBox();
    JButton Done = new JButton("Done");

    InstructorRankScreen() {

        instructor = (Instructor) Main.ActiveUser;

        label.setBounds(10, 0, 100, 50);
        label.setFont(new Font(null, Font.PLAIN, 15));

        label1.setBounds(10, 50, 800, 50);
        label1.setFont(new Font(null, Font.PLAIN, 15));

        Done.setBounds(100, 350, 150, 30);
        Done.setFocusable(false);
        Done.addActionListener(this);

        examCombo.setBounds(120, 10, 150, 30);
        for (int i = 0; i < instructor.listOfCourses.size(); i++) {
            Course course = instructor.listOfCourses.get(i);
            for (int j = 0; j < course.addedExams.size(); j++) {
                examCombo.addItem(course.addedExams.get(j));
            }
        }
        examCombo.addActionListener(this);
        updateData((Exam) (examCombo.getSelectedItem()));

        frame.add(examCombo);
        frame.add(label);
        frame.add(label1);
        frame.add(Done);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void updateData(Exam exam) {
        if (exam.rankQuestions() == false) {
            return;
        }

        int size = exam.QuestionsRanked.size();

        labels = new JLabel[size];
        for (int i = 0; i < size; i++) {
            labels[i] = new JLabel((i + 1) + ") " + exam.QuestionsRanked.get(size - i - 1).getQ());
            labels[i].setBounds(10, 100 + 50 * i, 800, 50);
            labels[i].setFont(new Font(null, Font.PLAIN, 15));
            frame.add(labels[i]);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == examCombo) {
            updateData((Exam) examCombo.getSelectedItem());
        } else if (e.getSource() == Done) {
            frame.dispose();
        }
    }

}
