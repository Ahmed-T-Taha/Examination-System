package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InstructorMainScreen implements ActionListener {

    JFrame frame = new JFrame();
    JButton prepareButton = new JButton("Prepare new exam");
    JButton reportButton = new JButton("View evaluation exam report");
    JButton rankButton = new JButton("View question ranking");
    JButton logoutButton = new JButton("Logout");

    InstructorMainScreen() {

        prepareButton.setBounds(100, 50, 200, 40);
        prepareButton.setFocusable(false);
        prepareButton.addActionListener(this);

        frame.add(prepareButton);

        reportButton.setBounds(100, 120, 200, 40);
        reportButton.setFocusable(false);
        reportButton.addActionListener(this);

        frame.add(reportButton);

        rankButton.setBounds(100, 190, 200, 40);
        rankButton.setFocusable(false);
        rankButton.addActionListener(this);

        frame.add(rankButton);

        logoutButton.setBounds(100, 260, 200, 40);
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
        if (e.getSource() == prepareButton) {
            new InstructorPrepareExamScreen();
        } else if (e.getSource() == reportButton) {
            new InstructorReportScreen();
        } else if (e.getSource() == rankButton) {
            new InstructorRankScreen();
        } else if (e.getSource() == logoutButton) {
            Main.ActiveUser = null;
            frame.dispose();
            new LaunchScreen();
            JOptionPane.showMessageDialog(null, "Logged out successfully");
        }
    }

}
