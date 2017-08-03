/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classerp;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
public class Table {
    JPanel mainPanel, centerPanel, southPanel;
    JButton delete, deleteAll;
    JTable dataTable;
    JScrollPane scrollPane;
    
    JPanel prepareGUI(String subject) throws SQLException{
        mainPanel = new JPanel(new BorderLayout());
        
        centerPanel = new JPanel();
        
        Database object = new Database();
        dataTable = object.makeTable(subject);
        centerPanel.add(new JScrollPane(dataTable));
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        
        southPanel = new JPanel(new GridBagLayout());
        
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
        
        delete = new JButton("Delete");
        southPanel.add(delete, constraint);
        
        constraint.gridx++;
        
        deleteAll = new JButton("Delete All");
        southPanel.add(deleteAll, constraint);
        
        delete.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent deleteRow){
               Database object = new Database();
               try {
                    object.deleteRow(subject, (String)dataTable.getValueAt(dataTable.getSelectedRow(), dataTable.getSelectedColumn()));
               } catch (SQLException ex) {
                   Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
               }
               
           }
        });
        
        deleteAll.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent deleteRow){
               Database object = new Database();
               try {
                    object.deleteTable(subject);
               } catch (SQLException ex) {
                   Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
               }
               
           }
        });
        
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        
        return mainPanel;
    }
}