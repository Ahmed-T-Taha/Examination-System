package main;

import java.awt.event.*;
import javax.swing.*;

public class LaunchScreen implements ActionListener {

    JFrame frame = new JFrame();
    JButton adminButton = new JButton("Admin");
    JButton instructorButton = new JButton("Instructor");
    JButton studentButton = new JButton("Student");

    LaunchScreen() {

        adminButton.setBounds(100, 50, 200, 40);
        adminButton.setFocusable(false);
        adminButton.addActionListener(this);

        frame.add(adminButton);

        instructorButton.setBounds(100, 160, 200, 40);
        instructorButton.setFocusable(false);
        instructorButton.addActionListener(this);

        frame.add(instructorButton);

        studentButton.setBounds(100, 270, 200, 40);
        studentButton.setFocusable(false);
        studentButton.addActionListener(this);

        frame.add(studentButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == adminButton) {
            frame.dispose();
            new AdminLoginScreen();
        }
        if (e.getSource() == instructorButton) {
            frame.dispose();
            new InstructorLoginScreen();

        }
        if (e.getSource() == studentButton) {
            frame.dispose();
            new StudentLoginScreen();
        }
    }
}
