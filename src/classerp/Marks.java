/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classerp;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Aditya Sharma
 */
public class Marks {
    JPanel mainPanel;
    JTextField rollNumberField, sessionalField, quizField, attendanceMarksField, semesterField, attendanceField, totalLecturesField;
    JLabel rollNumber, sessional, quiz, attendanceMarks, semester, attendance, totalLectures;
    JButton update, insert;
    GridBagLayout layout;
    
    
    JPanel prepareGUI(String subject){
        mainPanel = new JPanel();
        
        layout = new GridBagLayout();
        mainPanel.setLayout(layout);
        
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
    
        rollNumber = new JLabel("Roll Number");
        rollNumberField = new JTextField();
        rollNumberField.setColumns(15);

        mainPanel.add(rollNumber, constraint);
        constraint.gridx++;
        mainPanel.add(rollNumberField, constraint);
        
        constraint.gridy++;
        constraint.gridx = 0;
        
        sessional = new JLabel("Sessional");
        sessionalField = new JTextField();
        sessionalField.setColumns(15);
        
        mainPanel.add(sessional, constraint);
        constraint.gridx++;
        mainPanel.add(sessionalField, constraint);
        
        constraint.gridy++;
        constraint.gridx = 0;
        
        quiz = new JLabel("Quiz");
        quizField = new JTextField();
        quizField.setColumns(15);
        
        mainPanel.add(quiz, constraint);
        constraint.gridx++;
        mainPanel.add(quizField, constraint);
        
        
        attendanceMarks = new JLabel("Attendance Marks");
        attendanceMarksField = new JTextField();
        attendanceMarksField.setColumns(15);
        
        constraint.gridx = 0;
        constraint.gridy++;
        
        mainPanel.add(attendanceMarks, constraint);
        constraint.gridx++;
        mainPanel.add(attendanceMarksField, constraint);
        
        constraint.gridx = 0;
        constraint.gridy++;
        
        semester = new JLabel("Semester");
        semesterField = new JTextField();
        semesterField.setColumns(15);
        
        mainPanel.add(semester, constraint);
        constraint.gridx++;
        mainPanel.add(semesterField, constraint);
        
        constraint.gridx = 0;
        constraint.gridy++;
        
        attendance = new JLabel("Attendance");
        attendanceField = new JTextField();
        attendanceField.setColumns(15);
        
        mainPanel.add(attendance, constraint);
        constraint.gridx++;
        mainPanel.add(attendanceField, constraint);
        
        constraint.gridx = 0;
        constraint.gridy++;
        
        totalLectures = new JLabel("Total Lectures");
        totalLecturesField = new JTextField();
        totalLecturesField.setColumns(15);
        
        mainPanel.add(totalLectures, constraint);
        constraint.gridx++;
        mainPanel.add(totalLecturesField, constraint);    
                
        constraint.gridx = 0;
        constraint.gridy++;
        
        update = new JButton("Update");
        mainPanel.add(update, constraint);
        
        constraint.gridx++;
        insert = new JButton("Insert");
        mainPanel.add(insert, constraint);
        
        return mainPanel;
    }
}