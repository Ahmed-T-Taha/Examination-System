package main;

import java.awt.event.*;
import javax.swing.*;

public class AdminMainScreen implements ActionListener {

    JFrame frame = new JFrame();
    JButton enrolButton = new JButton("Enrol Student");
    JButton courseButton = new JButton("Create New Course");
    JButton logoutButton = new JButton("Logout");

    AdminMainScreen() {

        enrolButton.setBounds(100, 50, 200, 40);
        enrolButton.setFocusable(false);
        enrolButton.addActionListener(this);

        frame.add(enrolButton);

        courseButton.setBounds(100, 160, 200, 40);
        courseButton.setFocusable(false);
        courseButton.addActionListener(this);

        frame.add(courseButton);

        logoutButton.setBounds(100, 270, 200, 40);
        logoutButton.setFocusable(false);
        logoutButton.addActionListener(this);

        frame.add(logoutButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == enrolButton) {
            new AdminEnrolStudentScreen();
        } else if (e.getSource() == courseButton) {
            new AdminAddCourseScreen();
        } else if (e.getSource() == logoutButton) {
            Main.ActiveUser = null;
            frame.dispose();
            new LaunchScreen();
            JOptionPane.showMessageDialog(null, "Logged out successfully");
        }
    }
}
