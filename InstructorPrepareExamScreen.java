package main;

import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import javax.swing.*;

public class InstructorPrepareExamScreen implements ActionListener {

    Instructor instructor;
    JFrame frame = new JFrame();

    String months[] = {"January", "February", "March",
        "April", "May", "June", "July", "August",
        "September", "October", "Novemeber", "December"};

    JButton addButton = new JButton("Add Question");
    JButton doneButton = new JButton("Done");

    ArrayList<Question> questions = new ArrayList<>();

    JLabel dateLabel = new JLabel("Date:");
    JLabel codeLabel = new JLabel("Course Code:");
    JLabel timeLabel = new JLabel("Start Time:");
    JLabel durationLabel = new JLabel("Duration:");
    JLabel label1 = new JLabel("/");
    JLabel label2 = new JLabel("/");
    JLabel label3 = new JLabel(":");

    JComboBox courseCodeCombo = new JComboBox();
    JTextField durationText = new JTextField();

    JSpinner daySpinner;
    JSpinner monthSpinner;
    JSpinner yearSpinner;
    JSpinner hourSpinner;
    JSpinner minuteSpinner;

    InstructorPrepareExamScreen() {

        instructor = (Instructor) Main.ActiveUser;

        daySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 31, 1));
        monthSpinner = new JSpinner(new SpinnerListModel(months));
        yearSpinner = new JSpinner(new SpinnerNumberModel(2022, 2022, 2030, 1));
        hourSpinner = new JSpinner(new SpinnerNumberModel(00, 00, 23, 1));
        minuteSpinner = new JSpinner(new SpinnerNumberModel(00, 00, 59, 1));

        for (int i = 0; i < instructor.listOfCourses.size(); i++) {
            courseCodeCombo.addItem(instructor.listOfCourses.get(i));
        }

        codeLabel.setBounds(10, 0, 100, 50);
        codeLabel.setFont(new Font(null, Font.PLAIN, 15));

        courseCodeCombo.setBounds(120, 10, 150, 30);

        dateLabel.setBounds(10, 50, 100, 50);
        dateLabel.setFont(new Font(null, Font.PLAIN, 15));

        daySpinner.setBounds(70, 60, 40, 30);

        label1.setBounds(207, 50, 150, 50);
        label1.setFont(new Font(null, Font.PLAIN, 20));

        monthSpinner.setBounds(130, 60, 70, 30);

        label2.setBounds(117, 50, 150, 50);
        label2.setFont(new Font(null, Font.PLAIN, 20));

        yearSpinner.setBounds(220, 60, 60, 30);

        timeLabel.setBounds(10, 100, 100, 50);
        timeLabel.setFont(new Font(null, Font.PLAIN, 15));

        hourSpinner.setBounds(150, 110, 40, 30);

        label3.setBounds(207, 100, 100, 50);
        label3.setFont(new Font(null, Font.PLAIN, 20));

        minuteSpinner.setBounds(230, 110, 40, 30);

        durationLabel.setBounds(10, 150, 100, 50);
        durationLabel.setFont(new Font(null, Font.PLAIN, 15));

        durationText.setBounds(120, 160, 150, 30);
        durationText.setSize(150, 30);

        addButton.setBounds(10, 200, 150, 30);
        addButton.setFocusable(false);
        addButton.addActionListener(this);

        doneButton.setBounds(170, 200, 100, 30);
        doneButton.setFocusable(false);
        doneButton.addActionListener(this);

        frame.add(daySpinner);
        frame.add(monthSpinner);
        frame.add(yearSpinner);
        frame.add(hourSpinner);
        frame.add(minuteSpinner);

        frame.add(dateLabel);
        frame.add(label3);
        frame.add(label2);
        frame.add(label1);
        frame.add(codeLabel);
        frame.add(timeLabel);
        frame.add(durationLabel);

        frame.add(courseCodeCombo);
        frame.add(durationText);

        frame.add(addButton);
        frame.add(doneButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addButton) {
            new InstructorAddQuestionScreen(questions);
        } else if (e.getSource() == doneButton) {

            try {
                if (minuteSpinner.getValue() == null || hourSpinner.getValue() == null || daySpinner.getValue() == null || monthSpinner.getValue() == null || yearSpinner.getValue() == null || courseCodeCombo.getSelectedItem() == null || durationText.getText() == null) {
                    throw new NullException("Fields cannot be empty");
                }

                int minute = Integer.valueOf(minuteSpinner.getValue().toString());
                int hour = Integer.valueOf(hourSpinner.getValue().toString());
                int day = Integer.valueOf(daySpinner.getValue().toString());
                int year = Integer.valueOf(yearSpinner.getValue().toString());
                int month;
                String monthSpinnerResult = monthSpinner.getValue().toString();
                for (month = 0; month < 12; month++) {
                    if (monthSpinnerResult.equals(months[month])) {
                        break;
                    }
                }

                int examID = 1;
                String courseCode = courseCodeCombo.getSelectedItem().toString();
                int duration = Integer.valueOf(durationText.getText());

                for (int j = 0; j < instructor.listOfCourses.size(); j++) {
                    if (instructor.listOfCourses.get(j).getCode().equals(courseCode)) {
                        examID = instructor.listOfCourses.get(j).addedExams.size() + 1;
                    }
                }

                Exam exam = new Exam(examID, courseCode, ((Instructor) Main.ActiveUser).getName(), duration);
                exam.startTime = new Date(year - 1900, month, day, hour, minute);
                exam.endTime = new Date(year - 1900, month, day, hour + exam.getDuration(), minute);

                exam.ListOfQuestions = questions;

                int mark = 0;
                for (int i = 0; i < exam.ListOfQuestions.size(); i++) {
                    mark += exam.ListOfQuestions.get(i).getGrade();
                }
                exam.setMark(mark);
            } catch (NullException n) {
                JOptionPane.showMessageDialog(null, n.getMessage());
                return;
            } catch (InputMismatchException m) {
                JOptionPane.showMessageDialog(null, m.getMessage());
                return;
            }
            JOptionPane.showMessageDialog(null, "Exam added successfully");
            frame.dispose();
        }
    }
}
