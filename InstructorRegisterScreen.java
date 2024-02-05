package main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import javax.swing.*;

public class InstructorRegisterScreen implements ActionListener {

    JFrame frame = new JFrame();

    JLabel label1 = new JLabel("Username: ");
    JLabel label2 = new JLabel("Password: ");
    JLabel label3 = new JLabel("Name: ");
    JLabel label4 = new JLabel("Mobile Number: ");
    JLabel label5 = new JLabel("Email Address: ");
    JLabel label6 = new JLabel("Age: ");

    JTextField usernameText = new JTextField();
    JTextField passwordText = new JTextField();
    JTextField nameText = new JTextField();
    JTextField mobileText = new JTextField();
    JTextField emailText = new JTextField();
    JTextField idText = new JTextField();

    JButton Register = new JButton("Register");
    JButton cancelButton = new JButton("Cancel");

    InstructorRegisterScreen() {
        label1.setBounds(10, 0, 150, 50);
        label1.setFont(new Font(null, Font.PLAIN, 15));

        label2.setBounds(10, 50, 150, 50);
        label2.setFont(new Font(null, Font.PLAIN, 15));

        label3.setBounds(10, 100, 150, 50);
        label3.setFont(new Font(null, Font.PLAIN, 15));

        label4.setBounds(10, 150, 150, 50);
        label4.setFont(new Font(null, Font.PLAIN, 15));

        label5.setBounds(10, 200, 150, 50);
        label5.setFont(new Font(null, Font.PLAIN, 15));

        label6.setBounds(10, 250, 150, 50);
        label6.setFont(new Font(null, Font.PLAIN, 15));

        usernameText.setBounds(150, 10, 100, 30);
        usernameText.setSize(150, 30);

        passwordText.setBounds(150, 60, 100, 30);
        passwordText.setSize(150, 30);

        nameText.setBounds(150, 110, 100, 30);
        nameText.setSize(150, 30);

        mobileText.setBounds(150, 160, 100, 30);
        mobileText.setSize(150, 30);

        emailText.setBounds(150, 210, 100, 30);
        emailText.setSize(150, 30);

        idText.setBounds(150, 260, 100, 30);
        idText.setSize(150, 30);

        cancelButton.setBounds(10, 310, 100, 30);
        cancelButton.setFocusable(false);
        cancelButton.addActionListener(this);

        Register.setBounds(200, 310, 100, 30);
        Register.setFocusable(false);
        Register.addActionListener(this);

        frame.add(Register);
        frame.add(cancelButton);

        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(label5);
        frame.add(label6);

        frame.add(usernameText);
        frame.add(passwordText);
        frame.add(nameText);
        frame.add(mobileText);
        frame.add(emailText);
        frame.add(idText);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Register) {
            try {

                if (usernameText.getText() == null || passwordText.getText() == null || nameText.getText() == null || mobileText.getText() == null || emailText.getText() == null || idText.getText() == null) {
                    throw new NullException("Fields cannot be empty");
                }

                String Username = usernameText.getText();
                String Password = passwordText.getText();
                String Name = nameText.getText();
                String MobileNumber = mobileText.getText();
                String EmailAddress = emailText.getText();
                int Age = Integer.valueOf(idText.getText());

                boolean registerSuccess = Main.register(Username, Password, Name, MobileNumber, EmailAddress, Age);
                if (registerSuccess == true) {
                    frame.dispose();
                }
            } catch (NullException n) {
                JOptionPane.showMessageDialog(null, n.getMessage());

            } catch (InputMismatchException m) {
                JOptionPane.showMessageDialog(null, m.getMessage());
            }

        } else if (e.getSource() == cancelButton) {
            frame.dispose();
        }
    }

}
