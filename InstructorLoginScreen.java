package main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class InstructorLoginScreen implements ActionListener {

    JFrame frame = new JFrame();
    JLabel label = new JLabel("Username: ");
    JLabel label2 = new JLabel("Password: ");
    JButton registerButton = new JButton("Register");
    JButton loginButton = new JButton("Login");
    JButton mainMenu = new JButton("<-MainMenu");
    JTextField usernameText = new JTextField();
    JTextField passwordText = new JTextField();

    InstructorLoginScreen() {

        label.setBounds(10, 0, 100, 50);
        label.setFont(new Font(null, Font.PLAIN, 15));

        label2.setBounds(10, 50, 100, 50);
        label2.setFont(new Font(null, Font.PLAIN, 15));

        usernameText.setBounds(90, 10, 100, 30);
        usernameText.setSize(150, 30);

        passwordText.setBounds(90, 60, 100, 30);
        passwordText.setSize(150, 30);

        loginButton.setBounds(160, 110, 80, 30);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        registerButton.setBounds(10, 110, 100, 30);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);

        mainMenu.setBounds(80, 160, 120, 30);
        mainMenu.setFocusable(false);
        mainMenu.addActionListener(this);

        frame.add(loginButton);
        frame.add(mainMenu);
        frame.add(registerButton);
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

                boolean loginSuccess = Main.login("instructor", usernameText.getText(), passwordText.getText());

                if (loginSuccess == true) {
                    frame.dispose();
                    new InstructorMainScreen();
                    JOptionPane.showMessageDialog(null, "Logged in successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                }

            } catch (NullException n) {
                JOptionPane.showMessageDialog(null, n.getMessage());

            }
        } else if (e.getSource() == registerButton) {
            new InstructorRegisterScreen();

        } else if (e.getSource() == mainMenu) {
            frame.dispose();
            new LaunchScreen();
        }
    }

}
