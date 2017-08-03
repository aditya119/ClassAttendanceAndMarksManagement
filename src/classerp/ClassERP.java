/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classerp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Aditya Sharma
 */
public class ClassERP {

    /**
     * @param args the command line arguments
     */
    JFrame mainFrame;
    JPanel mainPanel;
    JTabbedPane tabbedPane;
    JButton logout, refresh;
    Table table;
    Marks marks;
    Attendance attendance;
    
    public static void main(String[] args){
            Login object = new Login();
            object.prepareGUI();
    }
    
    void prepareGUI(String subject) throws SQLException{
        System.out.println("Subject: " + subject);
        
        mainFrame = new JFrame("Class ERP");
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setSize(800, 600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension size = toolkit.getScreenSize();
        mainFrame.setLocation(size.width/2-mainFrame.getWidth()/2,size.height/2-mainFrame.getHeight()/2);
        
        /**main panel begins*/
        mainPanel = new JPanel(new BorderLayout());
        mainFrame.add(mainPanel);
        
        logout = new JButton("Logout");
        mainPanel.add(logout, BorderLayout.NORTH);
        
        
        tabbedPane = new JTabbedPane();
        
        attendance = new Attendance();
        marks = new Marks();
        table = new Table();
        
        tabbedPane.addTab("Marks", marks.prepareGUI(subject));
        
        tabbedPane.addTab("Attendance", attendance.prepareGUI(subject));
        
        marks.update.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent updateDatabase){
                Database object = new Database();
                try {
                    object.updateData(subject, marks);
                } catch (SQLException ex) {
                    Logger.getLogger(ClassERP.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        marks.insert.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent insertInDatabase){
                try {
                    Database object = new Database();
                    object.insertData(subject, marks);
                } catch (SQLException ex) {
                    Logger.getLogger(ClassERP.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        tabbedPane.addTab("Table", table.prepareGUI(subject));
        
        refresh = new JButton("Refresh");
        mainPanel.add(refresh, BorderLayout.SOUTH);
        refresh.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent insertInDatabase){
                try {
                    tabbedPane.removeTabAt(2);
                    tabbedPane.removeTabAt(1);
                    
                    tabbedPane.addTab("Attendance", attendance.prepareGUI(subject));
                    tabbedPane.addTab("Table", table.prepareGUI(subject));
                } catch (SQLException ex) {
                    Logger.getLogger(ClassERP.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
        mainPanel.add(tabbedPane);
        
        
        logout.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent logout){
                mainFrame.dispose();
                Login obj = new Login();
                obj.prepareGUI();
            }
        });
    }
}