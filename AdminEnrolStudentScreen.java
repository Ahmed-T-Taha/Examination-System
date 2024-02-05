package main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AdminEnrolStudentScreen implements ActionListener {

    JFrame frame = new JFrame();

    JLabel label = new JLabel("Student ID: ");
    JLabel label2 = new JLabel("Course ID: ");

    JComboBox studentIdCombo = new JComboBox();
    JComboBox courseIdCombo = new JComboBox();

    JButton enrolStudent = new JButton("Enrol Student");
    JButton mainMenu = new JButton("<- MainMenu");

    AdminEnrolStudentScreen() {

        label.setBounds(10, 0, 100, 50);
        label.setFont(new Font(null, Font.PLAIN, 15));

        label2.setBounds(10, 50, 100, 50);
        label2.setFont(new Font(null, Font.PLAIN, 15));

        studentIdCombo.setBounds(110, 10, 150, 30);
        for (int i = 0; i < Main.students.size(); i++) {
            studentIdCombo.addItem(Main.students.get(i).getID());
        }

        courseIdCombo.setBounds(110, 60, 150, 30);
        for (int i = 0; i < Main.courses.size(); i++) {
            courseIdCombo.addItem(Main.courses.get(i).getID());
        }

        mainMenu.setBounds(10, 110, 120, 30);
        mainMenu.setFocusable(false);
        mainMenu.addActionListener(this);

        enrolStudent.setBounds(140, 110, 120, 30);
        enrolStudent.setFocusable(false);
        enrolStudent.addActionListener(this);

        frame.add(mainMenu);
        frame.add(enrolStudent);
        frame.add(label);
        frame.add(studentIdCombo);
        frame.add(label2);
        frame.add(courseIdCombo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enrolStudent) {
            String studentID = studentIdCombo.getSelectedItem().toString();
            String courseID = courseIdCombo.getSelectedItem().toString();
            boolean enrolmentSuccess = Main.admin.enrolStudent(studentID, courseID);
            if (enrolmentSuccess == true) {
                frame.dispose();
                JOptionPane.showMessageDialog(null, "Student enrolled successfully");
            }

        } else if (e.getSource() == mainMenu) {
            frame.dispose();
        }
    }

}
