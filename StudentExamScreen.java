package main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class StudentExamScreen implements ActionListener {

    private Exam exam;
    private Question question;
    private char answer;
    private int qNumber, mark;
    JFrame frame = new JFrame();
    JLabel questionLabel = new JLabel();
    JRadioButton answerA = new JRadioButton();
    JRadioButton answerB = new JRadioButton();
    JRadioButton answerC = new JRadioButton();
    JRadioButton answerD = new JRadioButton();
    ButtonGroup answers = new ButtonGroup();
    JButton Button = new JButton("Submit Answer");

    StudentExamScreen(Exam exam, int qNumber, int mark) {

        this.exam = exam;
        this.qNumber = qNumber;
        this.mark = mark;
        question = exam.ListOfQuestions.get(qNumber);
        question.incrementNumberOfAttempts();

        questionLabel.setBounds(10, 0, 400, 50);
        questionLabel.setFont(new Font(null, Font.PLAIN, 15));
        questionLabel.setText("Question " + (qNumber + 1) + ": " + question.getQ());

        answerA.setBounds(10, 50, 400, 50);
        answerA.setText(question.getA());

        answerB.setBounds(10, 100, 400, 50);
        answerB.setText(question.getB());

        answerC.setBounds(10, 150, 400, 50);
        answerC.setText(question.getC());

        answerD.setBounds(10, 200, 400, 50);
        answerD.setText(question.getD());

        answers.add(answerA);
        answers.add(answerB);
        answers.add(answerC);
        answers.add(answerD);

        Button.setBounds(50, 250, 200, 30);
        Button.setFocusable(false);
        Button.addActionListener(this);

        frame.add(questionLabel);
        frame.add(answerA);
        frame.add(answerB);
        frame.add(answerC);
        frame.add(answerD);
        frame.add(Button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Button) {
            if (answerA.isSelected()) {
                answer = 'a';
            } else if (answerB.isSelected()) {
                answer = 'b';
            } else if (answerC.isSelected()) {
                answer = 'c';
            } else if (answerD.isSelected()) {
                answer = 'd';
            }

            if (answer == question.getCorrectAnswer()) {
                mark += question.getGrade();
                question.incrementNumberOfCorrectAnswers();
            }

            qNumber++;
            Date currentDate = new Date();
            if (currentDate.before(exam.endTime)
                    && qNumber < exam.ListOfQuestions.size()) {
                new StudentExamScreen(exam, qNumber, mark);
            } else {
                JOptionPane.showMessageDialog(null, "Your final grade is " + mark + "/" + exam.getMark());
                exam.report.graph.ListOfGrades.add(mark);
            }

            frame.dispose();
        }
    }
}
