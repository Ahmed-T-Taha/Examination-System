package main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class InstructorAddQuestionScreen implements ActionListener {

    JFrame frame = new JFrame();
    JLabel label = new JLabel("Question : ");
    JLabel label2 = new JLabel("Answer A: ");
    JLabel label3 = new JLabel("Answer B: ");
    JLabel label4 = new JLabel("Answer C: ");
    JLabel label5 = new JLabel("Answer D: ");
    JLabel label6 = new JLabel("Correct answer: ");
    JLabel label7 = new JLabel("Question grade: ");

    JTextField questionText = new JTextField();
    JTextField aText = new JTextField();
    JTextField bText = new JTextField();
    JTextField cText = new JTextField();
    JTextField dText = new JTextField();
    JComboBox box = new JComboBox();
    JTextField gradeText = new JTextField();

    JButton cancelButton = new JButton("Cancel");
    JButton doneButton = new JButton("Done");

    ArrayList<Question> questions;

    InstructorAddQuestionScreen(ArrayList<Question> questions) {

        this.questions = questions;
        box.addItem('a');
        box.addItem('b');
        box.addItem('c');
        box.addItem('d');

        label.setBounds(10, 0, 100, 50);
        label.setFont(new Font(null, Font.PLAIN, 15));

        label2.setBounds(10, 50, 100, 50);
        label2.setFont(new Font(null, Font.PLAIN, 15));

        label3.setBounds(10, 100, 100, 50);
        label3.setFont(new Font(null, Font.PLAIN, 15));

        label4.setBounds(10, 150, 100, 50);
        label4.setFont(new Font(null, Font.PLAIN, 15));

        label5.setBounds(10, 200, 100, 50);
        label5.setFont(new Font(null, Font.PLAIN, 15));

        label6.setBounds(10, 250, 150, 50);
        label6.setFont(new Font(null, Font.PLAIN, 15));

        label7.setBounds(10, 300, 150, 50);
        label7.setFont(new Font(null, Font.PLAIN, 15));

        questionText.setBounds(120, 10, 250, 30);

        aText.setBounds(120, 60, 250, 30);

        bText.setBounds(120, 110, 250, 30);

        cText.setBounds(120, 160, 250, 30);

        dText.setBounds(120, 210, 250, 30);

        box.setBounds(120, 260, 250, 30);

        gradeText.setBounds(120, 310, 250, 30);

        cancelButton.setBounds(10, 350, 80, 30);
        cancelButton.setFocusable(false);
        cancelButton.addActionListener(this);

        doneButton.setBounds(290, 350, 80, 30);
        doneButton.setFocusable(false);
        doneButton.addActionListener(this);

        frame.add(cancelButton);
        frame.add(box);
        frame.add(doneButton);
        frame.add(label);
        frame.add(questionText);
        frame.add(label3);
        frame.add(aText);
        frame.add(label4);
        frame.add(bText);
        frame.add(label5);
        frame.add(cText);
        frame.add(label6);
        frame.add(label2);
        frame.add(dText);
        frame.add(label7);
        frame.add(gradeText);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancelButton) {
            frame.dispose();
        } else if (e.getSource() == doneButton) {
            String q = questionText.getText();
            String a = aText.getText();
            String b = bText.getText();
            String c = cText.getText();
            String d = dText.getText();
            char answer = box.getSelectedItem().toString().charAt(0);
            int grade = Integer.valueOf(gradeText.getText());
            questions.add(new Question(q, a, b, c, d, answer, grade));
            JOptionPane.showMessageDialog(null, "Question added successfully");
            frame.dispose();
        }
    }

}
