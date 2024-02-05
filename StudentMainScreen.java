package main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class StudentMainScreen implements ActionListener {

    JFrame frame = new JFrame();
    JLabel label1 = new JLabel("Exam Code: ");
    JLabel label2 = new JLabel("Start Time: ");
    JLabel label3 = new JLabel("End Time: ");

    JLabel startLabel = new JLabel("");
    JLabel endLabel = new JLabel("");

    JComboBox examCombo = new JComboBox();
    JButton examButton = new JButton("Take Exam");
    JButton logoutButton = new JButton("Logout");

    StudentMainScreen() {

        label1.setBounds(10, 0, 100, 50);
        label1.setFont(new Font(null, Font.PLAIN, 15));

        Student student = (Student) Main.ActiveUser;
        examCombo.setBounds(120, 10, 150, 30);
        for (int i = 0; i < student.listOfTakenCourses.size(); i++) {
            Course course = student.listOfTakenCourses.get(i);
            for (int j = 0; j < course.addedExams.size(); j++) {
                examCombo.addItem(course.addedExams.get(j));
            }
        }
        examCombo.addActionListener(this);

        label2.setBounds(10, 50, 100, 50);
        label2.setFont(new Font(null, Font.PLAIN, 15));

        startLabel.setBounds(120, 50, 250, 50);
        startLabel.setFont(new Font(null, Font.PLAIN, 15));

        label3.setBounds(10, 100, 100, 50);
        label3.setFont(new Font(null, Font.PLAIN, 15));

        endLabel.setBounds(120, 100, 250, 50);
        endLabel.setFont(new Font(null, Font.PLAIN, 15));

        examButton.setBounds(170, 150, 100, 50);
        examButton.setFocusable(false);
        examButton.addActionListener(this);
        examButton.setVisible(false);

        logoutButton.setBounds(10, 150, 100, 50);
        logoutButton.setFocusable(false);
        logoutButton.addActionListener(this);

        updateData((Exam) examCombo.getSelectedItem());

        frame.add(label1);
        frame.add(label2);
        frame.add(label3);

        frame.add(startLabel);
        frame.add(endLabel);

        frame.add(examCombo);
        frame.add(examButton);
        frame.add(logoutButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    public void updateData(Exam exam) {
        startLabel.setText(exam.startTime.toString());
        endLabel.setText(exam.endTime.toString());
        Date date = new Date();
        if (date.after(exam.startTime) && date.before(exam.endTime)) {
            examButton.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Exam exam = (Exam) examCombo.getSelectedItem();

        if (e.getSource() == examCombo) {
            updateData(exam);
        } else if (e.getSource() == examButton) {
            new StudentExamScreen(exam, 0, 0);
        } else if (e.getSource() == logoutButton) {
            Main.ActiveUser = null;
            frame.dispose();
            new LaunchScreen();
            JOptionPane.showMessageDialog(null, "Logged out successfully");
        }
    }

}
