/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classerp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Aditya Sharma
 */
public class Login {
    JFrame mainFrame;
    BorderLayout frameLayout;
    JPanel northPanel;
    JLabel heading;	
    JPanel mainPanel;
    GridBagLayout mainPanelLayout;	
    JLabel usernameLabel;
    JTextField usernameField;
    JLabel passwordLabel;
    JPasswordField passwordField;	
    JButton submit;	
    JPanel southPanel;
    GridBagLayout southPanelLayout;	
    JLabel developer;
    JLabel southLabel;
    
    void prepareGUI(){
            mainFrame = new JFrame("Login Page");
            frameLayout = new BorderLayout();
            mainFrame.setVisible(true);
            mainFrame.setResizable(false);
            mainFrame.setLayout(frameLayout);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setSize(500, 300);
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension size = toolkit.getScreenSize();
            mainFrame.setLocation(size.width/2-mainFrame.getWidth()/2,size.height/2-mainFrame.getHeight()/2);
            
            northPanel = new JPanel();	
            northPanel.setBackground(Color.white);

            heading = new JLabel("Class ERP");
            northPanel.add(heading);

            mainFrame.add(northPanel, BorderLayout.NORTH);

    /**main body in main panel*/
            mainPanel = new JPanel();
            mainPanelLayout = new GridBagLayout();
            mainPanel.setLayout(mainPanelLayout);

            GridBagConstraints constraint = new GridBagConstraints();
            constraint.gridheight = 1;
            constraint.gridwidth = 1;
            constraint.gridx = 0;
            constraint.gridy = 0;
            constraint.insets.top = 5;
            constraint.insets.bottom = 5;
            constraint.insets.left = 5;
            constraint.insets.right = 8;
            constraint.anchor = GridBagConstraints.CENTER;

            usernameLabel = new JLabel("Username");
            mainPanel.add(usernameLabel, constraint);
            constraint.gridx++;
            usernameField = new JTextField();
            usernameField.setColumns(10);
            mainPanel.add(usernameField, constraint);

            constraint.gridx = 0;
            constraint.gridy++;
            passwordLabel = new JLabel("Password");
            mainPanel.add(passwordLabel, constraint);
            constraint.gridx++;
            passwordField = new JPasswordField();
            passwordField.setColumns(10);
            mainPanel.add(passwordField, constraint);

            constraint.gridx = 0;
            constraint.gridy++;
            constraint.gridx++;
            submit = new JButton("Submit");
            mainPanel.add(submit, constraint);

            mainFrame.add(mainPanel, BorderLayout.CENTER);

    /**residual stuff in south panel*/
            southPanel = new JPanel();
            southPanelLayout = new GridBagLayout();
            southPanel.setLayout(southPanelLayout);
            southPanel.setBackground(Color.white);

            GridBagConstraints southConstraint = new GridBagConstraints();
            southConstraint.gridheight = 1;
            southConstraint.gridwidth = 1;
            southConstraint.gridx = 0;
            southConstraint.gridy = 0;
            southConstraint.insets.top = 5;
            southConstraint.insets.bottom = 5;
            southConstraint.insets.left = 5;
            southConstraint.insets.right = 8;
            southConstraint.anchor = GridBagConstraints.CENTER;

            developer = new JLabel("Developed by Aditya Sharma Roll Number: CO15303");
            southPanel.add(developer, southConstraint);

            southConstraint.gridy++;
            mainFrame.add(southPanel, BorderLayout.SOUTH);
            
            
            submit.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent startSoftware){
                    Database databaseObject = new Database();
                    try {
                        int x = databaseObject.verifyUser(usernameField.getText(), passwordField.getText());
                        switch (x) {
                            case 1:
                                String subject = usernameField.getText();
                                ClassERP classERPObject = new ClassERP();
                                mainFrame.dispose();
                                classERPObject.prepareGUI(subject);
                                break;
                            case 0:
                                JOptionPane.showMessageDialog(mainFrame, "Password Incorrect");
                                break;
                            default:
                                JOptionPane.showMessageDialog(mainFrame, "Username Incorrect");
                                break;
                        }
                   } catch (ClassNotFoundException | SQLException ex) {
                       Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
            });
       }
}