/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classerp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Aditya Sharma
 */
public class Attendance {
    JPanel mainPanel;
    JTable attendanceTable;
    JButton present, absent;
    
    JPanel prepareGUI(String subject) throws SQLException{
        mainPanel = new JPanel();
        
        Database object = new Database();
        attendanceTable = object.getAttendance(subject);
        mainPanel.add(new JScrollPane(attendanceTable));
        
        present = new JButton("Present");
        absent = new JButton("Absent");
        
        mainPanel.add(present);
        mainPanel.add(absent);
        
        present.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent studentPrsent){
               Database object = new Database();
               try {
                   try {
                       object.attendanceManager(subject, (String)attendanceTable.getValueAt(attendanceTable.getSelectedRow(), attendanceTable.getSelectedColumn()), 1);
                   } catch (ClassNotFoundException ex) {
                       Logger.getLogger(Attendance.class.getName()).log(Level.SEVERE, null, ex);
                   }
               } catch (SQLException ex) {
                   Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
               }
               
           }
        });
        
        absent.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent studentAbsent){
               Database object = new Database();
               try {
                   try {
                       object.attendanceManager(subject, (String)attendanceTable.getValueAt(attendanceTable.getSelectedRow(), attendanceTable.getSelectedColumn()), 0);
                   } catch (ClassNotFoundException ex) {
                       Logger.getLogger(Attendance.class.getName()).log(Level.SEVERE, null, ex);
                   }
               } catch (SQLException ex) {
                   Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
               }
               
           }
        });
        
        return mainPanel;
    }
}