package main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AdminAddCourseScreen implements ActionListener {

    JFrame frame = new JFrame();

    JButton mainMenu = new JButton("<- MainMenu");
    JButton addCourse = new JButton("Add Course");

    JLabel label = new JLabel("Course name:");
    JLabel label2 = new JLabel("Course code:");
    JLabel label3 = new JLabel("Course ID:");
    JLabel label4 = new JLabel("Instructor:");

    JTextField courseNameText = new JTextField();
    JTextField courseCodeText = new JTextField();
    JTextField courseIdText = new JTextField();

    JComboBox instructorCombo = new JComboBox();

    AdminAddCourseScreen() {

        label.setBounds(10, 0, 100, 50);
        label.setFont(new Font(null, Font.PLAIN, 15));

        label2.setBounds(10, 50, 100, 50);
        label2.setFont(new Font(null, Font.PLAIN, 15));

        label3.setBounds(10, 100, 100, 50);
        label3.setFont(new Font(null, Font.PLAIN, 15));

        label4.setBounds(10, 150, 100, 50);
        label4.setFont(new Font(null, Font.PLAIN, 15));

        courseNameText.setBounds(120, 10, 100, 30);
        courseNameText.setSize(150, 30);

        courseCodeText.setBounds(120, 60, 100, 30);
        courseCodeText.setSize(150, 30);

        courseIdText.setBounds(120, 110, 100, 30);
        courseIdText.setSize(150, 30);

        instructorCombo.setBounds(120, 160, 150, 30);
        for (int i = 0; i < Main.instructors.size(); i++) {
            instructorCombo.addItem(Main.instructors.get(i).getName());
        }

        mainMenu.setBounds(10, 210, 120, 30);
        mainMenu.setFocusable(false);
        mainMenu.addActionListener(this);

        addCourse.setBounds(150, 210, 120, 30);
        addCourse.setFocusable(false);
        addCourse.addActionListener(this);

        frame.add(label);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);

        frame.add(courseNameText);
        frame.add(courseCodeText);
        frame.add(courseIdText);
        frame.add(instructorCombo);

        frame.add(mainMenu);
        frame.add(addCourse);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addCourse) {

            String courseID = courseIdText.getText();
            String courseName = courseNameText.getText();
            String courseCode = courseCodeText.getText();
            String instructor = instructorCombo.getSelectedItem().toString();

            boolean creationSuccess = Main.admin.createCourse(courseID, courseName, courseCode, instructor);
            if (creationSuccess == true) {
                frame.dispose();
                JOptionPane.showMessageDialog(null, "Course added successfully");
            }

        } else if (e.getSource() == mainMenu) {
            frame.dispose();
        }
    }

}
