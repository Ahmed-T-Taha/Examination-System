package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StudentLoginScreen implements ActionListener {

    JFrame frame = new JFrame();
    JLabel label = new JLabel("Username: ");
    JLabel label2 = new JLabel("Password: ");
    JButton mainMenu = new JButton("<-MainMenu");
    JButton loginButton = new JButton("Login");
    JButton registerButton = new JButton("Register");
    JTextField usernameText = new JTextField();
    JTextField passwordText = new JTextField();

    StudentLoginScreen() {

        label.setBounds(10, 0, 100, 50);
        label.setFont(new Font(null, Font.PLAIN, 15));

        label2.setBounds(10, 50, 100, 50);
        label2.setFont(new Font(null, Font.PLAIN, 15));

        usernameText.setBounds(90, 10, 100, 30);
        usernameText.setSize(160, 30);

        passwordText.setBounds(90, 60, 100, 30);
        passwordText.setSize(160, 30);

        loginButton.setBounds(170, 110, 80, 30);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        registerButton.setBounds(10, 110, 100, 30);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);

        mainMenu.setBounds(65, 160, 120, 30);
        mainMenu.setFocusable(false);
        mainMenu.addActionListener(this);

        frame.add(loginButton);
        frame.add(registerButton);
        frame.add(mainMenu);
        frame.add(label);
        frame.add(usernameText);
        frame.add(label2);
        frame.add(passwordText);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginButton) {
            try {

                if (usernameText.getText() == null || passwordText.getText() == null) {
                    throw new NullException("Fields cannot be empty");
                }

                boolean loginSuccess = Main.login("student", usernameText.getText(), passwordText.getText());

                if (loginSuccess == true) {
                    frame.dispose();
                    new StudentMainScreen();
                    JOptionPane.showMessageDialog(null, "Logged in successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                }
            } catch (NullException n) {
                JOptionPane.showMessageDialog(null, n.getMessage());

            }

        } else if (e.getSource() == registerButton) {
            new StudentRegisterScreen();

        } else if (e.getSource() == mainMenu) {
            frame.dispose();
            new LaunchScreen();
        }
    }
}
