/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classerp;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Aditya Sharma
 */
public class Database{

    Connection connect;
    ResultSet rs;
    Statement stateObj;
    
    private void createDatabaseConnection() throws ClassNotFoundException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");  
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/class_erp","root","");
            stateObj = connect.createStatement();
            System.out.println("Database Connected!");
        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }
    }
    
    public void attendanceManager(String subject, String rollNumber, int result) throws SQLException, ClassNotFoundException{
        createDatabaseConnection();
        if(result == 1){
            System.out.println("Present");
            switch(subject){
                case "se":
                {
                    String query = "UPDATE SE_DATABASE_ATTENDANCE SET ATTENDANCE=ATTENDANCE+1, TOTAL=TOTAL+1 WHERE ROLL_NUMBER=?";
                    PreparedStatement preparedStatement = connect.prepareStatement(query);
                    preparedStatement.setString(1, rollNumber);
                    preparedStatement.execute();
                }
                case "os":
                {
                    String query = "UPDATE OS_DATABASE_ATTENDANCE SET ATTENDANCE=ATTENDANCE+1, TOTAL=TOTAL+1 WHERE ROLL_NUMBER=?";
                    PreparedStatement preparedStatement = connect.prepareStatement(query);
                    preparedStatement.setString(1, rollNumber);
                    preparedStatement.execute();
                }
                case "ada":
                {
                    String query = "UPDATE ADA_DATABASE_ATTENDANCE SET ATTENDANCE=ATTENDANCE+1, TOTAL=TOTAL+1 WHERE ROLL_NUMBER=?";
                    PreparedStatement preparedStatement = connect.prepareStatement(query);
                    preparedStatement.setString(1, rollNumber);
                    preparedStatement.execute();
                }
                case "cao":
                {
                    String query = "UPDATE CAO_DATABASE_ATTENDANCE SET ATTENDANCE=ATTENDANCE+1, TOTAL=TOTAL+1 WHERE ROLL_NUMBER=?";
                    PreparedStatement preparedStatement = connect.prepareStatement(query);
                    preparedStatement.setString(1, rollNumber);
                    preparedStatement.execute();
                }
                case "wt":
                {
                    String query = "UPDATE WT_DATABASE_ATTENDANCE SET ATTENDANCE=ATTENDANCE+1, TOTAL=TOTAL+1 WHERE ROLL_NUMBER=?";
                    PreparedStatement preparedStatement = connect.prepareStatement(query);
                    preparedStatement.setString(1, rollNumber);
                    preparedStatement.execute();
                }
            }
        }
        else if(result == 0){
            System.out.println("Absent");
            switch(subject){
                case "se":
                {
                    String query = "UPDATE SE_DATABASE_ATTENDANCE SET TOTAL=TOTAL+1 WHERE ROLL_NUMBER=?";
                    PreparedStatement preparedStatement = connect.prepareStatement(query);
                    preparedStatement.setString(1, rollNumber);
                    preparedStatement.execute();
                }
                case "os":
                {
                    String query = "UPDATE OS_DATABASE_ATTENDANCE SET TOTAL=TOTAL+1 WHERE ROLL_NUMBER=?";
                    PreparedStatement preparedStatement = connect.prepareStatement(query);
                    preparedStatement.setString(1, rollNumber);
                    preparedStatement.execute();
                }
                case "ada":
                {
                    String query = "UPDATE ADA_DATABASE_ATTENDANCE SET TOTAL=TOTAL+1 WHERE ROLL_NUMBER=?";
                    PreparedStatement preparedStatement = connect.prepareStatement(query);
                    preparedStatement.setString(1, rollNumber);
                    preparedStatement.execute();
                }
                case "wt":
                {
                    String query = "UPDATE WT_DATABASE_ATTENDANCE SET TOTAL=TOTAL+1 WHERE ROLL_NUMBER=?";
                    PreparedStatement preparedStatement = connect.prepareStatement(query);
                    preparedStatement.setString(1, rollNumber);
                    preparedStatement.execute();
                }
                case "cao":
                {
                    String query = "UPDATE CAO_DATABASE_ATTENDANCE SET TOTAL=TOTAL+1 WHERE ROLL_NUMBER=?";
                    PreparedStatement preparedStatement = connect.prepareStatement(query);
                    preparedStatement.setString(1, rollNumber);
                    preparedStatement.execute();
                }
            }
        }
    }
    
    public void deleteTable(String subject) throws SQLException{
        try {
            createDatabaseConnection();
            switch(subject){
                case "se":
                {
                    String query1 = "DELETE FROM SE_DATABASE_MARKS WHERE 1";
                    PreparedStatement preparedsmt1 = connect.prepareStatement(query1);

                    String query2 = "DELETE FROM SE_DATABASE_ATTENDANCE WHERE 1";
                    PreparedStatement preparedsmt2 = connect.prepareStatement(query2);

                    preparedsmt1.execute();
                    preparedsmt2.execute();
                    JOptionPane.showMessageDialog(new JFrame(), "All data deleted!");
                    break;
                }
                case "ada":
                {
                    String query1 = "DELETE FROM ADA_DATABASE_MARKS WHERE 1";
                    PreparedStatement preparedsmt1 = connect.prepareStatement(query1);

                    String query2 = "DELETE FROM ADA_DATABASE_ATTENDANCE WHERE 1";
                    PreparedStatement preparedsmt2 = connect.prepareStatement(query2);

                    preparedsmt1.execute();
                    preparedsmt2.execute();
                    JOptionPane.showMessageDialog(new JFrame(), "All data deleted!");
                    break;
                }
                case "os":
                {
                    String query1 = "DELETE FROM OS_DATABASE_MARKS WHERE 1";
                    PreparedStatement preparedsmt1 = connect.prepareStatement(query1);

                    String query2 = "DELETE FROM OS_DATABASE_ATTENDANCE WHERE 1";
                    PreparedStatement preparedsmt2 = connect.prepareStatement(query2);

                    preparedsmt1.execute();
                    preparedsmt2.execute();
                    JOptionPane.showMessageDialog(new JFrame(), "All data deleted!");
                    break;
                }
                case "wt":
                {
                    String query1 = "DELETE FROM WT_DATABASE_MARKS WHERE 1";
                    PreparedStatement preparedsmt1 = connect.prepareStatement(query1);

                    String query2 = "DELETE FROM WT_DATABASE_ATTENDANCE WHERE 1";
                    PreparedStatement preparedsmt2 = connect.prepareStatement(query2);

                    preparedsmt1.execute();
                    preparedsmt2.execute();
                    JOptionPane.showMessageDialog(new JFrame(), "All data deleted!");
                    break;
                }
                case "cao":
                {
                    String query1 = "DELETE FROM CAO_DATABASE_MARKS WHERE 1";
                    PreparedStatement preparedsmt1 = connect.prepareStatement(query1);

                    String query2 = "DELETE FROM CAO_DATABASE_ATTENDANCE WHERE 1";
                    PreparedStatement preparedsmt2 = connect.prepareStatement(query2);

                    preparedsmt1.execute();
                    preparedsmt2.execute();
                    JOptionPane.showMessageDialog(new JFrame(), "All data deleted!");
                    break;
                }    
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteRow(String subject, String rollNumber) throws SQLException{
        try {
            createDatabaseConnection();
            System.out.println("Roll Number: "+rollNumber);
            switch(subject){
                case "se":
                {
                    if(!findRollNumber(rollNumber, subject)){
                        JOptionPane.showMessageDialog(new JFrame(), "Record for Roll Number "+rollNumber+" doesn't exist! Press REFRESH button!");
                    }
                    else{
                        String query1 = "DELETE FROM SE_DATABASE_MARKS WHERE ROLL_NUMBER=?";
                        PreparedStatement preparedsmt1 = connect.prepareStatement(query1);
                        preparedsmt1.setString(1, rollNumber);

                        String query2 = "DELETE FROM SE_DATABASE_ATTENDANCE WHERE ROLL_NUMBER=?";
                        PreparedStatement preparedsmt2 = connect.prepareStatement(query2);
                        preparedsmt2.setString(1, rollNumber);

                        preparedsmt1.execute();
                        preparedsmt2.execute();
                        JOptionPane.showMessageDialog(new JFrame(), "Roll Number "+rollNumber+" deleted!");
                    }
                    break;
                }
                case "ada":
                {
                    if(!findRollNumber(rollNumber, subject)){
                        JOptionPane.showMessageDialog(new JFrame(), "Record for Roll Number "+rollNumber+" doesn't exist! Press REFRESH button!");
                    }
                    else{
                        String query1 = "DELETE FROM ADA_DATABASE_MARKS WHERE ROLL_NUMBER=?";
                        PreparedStatement preparedsmt1 = connect.prepareStatement(query1);
                        preparedsmt1.setString(1, rollNumber);

                        String query2 = "DELETE FROM ADA_DATABASE_ATTENDANCE WHERE ROLL_NUMBER=?";
                        PreparedStatement preparedsmt2 = connect.prepareStatement(query2);
                        preparedsmt2.setString(1, rollNumber);

                        preparedsmt1.execute();
                        preparedsmt2.execute();
                        JOptionPane.showMessageDialog(new JFrame(), "Roll Number "+rollNumber+" deleted!");
                    }
                    break;
                }
                case "os":
                {
                    if(!findRollNumber(rollNumber, subject)){
                        JOptionPane.showMessageDialog(new JFrame(), "Record for Roll Number "+rollNumber+" doesn't exist! Press REFRESH button!");
                    }
                    else{
                        String query1 = "DELETE FROM OS_DATABASE_MARKS WHERE ROLL_NUMBER=?";
                        PreparedStatement preparedsmt1 = connect.prepareStatement(query1);
                        preparedsmt1.setString(1, rollNumber);

                        String query2 = "DELETE FROM OS_DATABASE_ATTENDANCE WHERE ROLL_NUMBER=?";
                        PreparedStatement preparedsmt2 = connect.prepareStatement(query2);
                        preparedsmt2.setString(1, rollNumber);

                        preparedsmt1.execute();
                        preparedsmt2.execute();
                        JOptionPane.showMessageDialog(new JFrame(), "Roll Number "+rollNumber+" deleted!");
                    }
                    break;
                }
                case "wt":
                {
                    if(!findRollNumber(rollNumber, subject)){
                        JOptionPane.showMessageDialog(new JFrame(), "Record for Roll Number "+rollNumber+" doesn't exist! Press REFRESH button!");
                    }
                    else{
                        String query1 = "DELETE FROM WT_DATABASE_MARKS WHERE ROLL_NUMBER=?";
                        PreparedStatement preparedsmt1 = connect.prepareStatement(query1);
                        preparedsmt1.setString(1, rollNumber);

                        String query2 = "DELETE FROM WT_DATABASE_ATTENDANCE WHERE ROLL_NUMBER=?";
                        PreparedStatement preparedsmt2 = connect.prepareStatement(query2);
                        preparedsmt2.setString(1, rollNumber);

                        preparedsmt1.execute();
                        preparedsmt2.execute();
                        JOptionPane.showMessageDialog(new JFrame(), "Roll Number "+rollNumber+" deleted!");
                    }
                    break;
                }
                case "cao":
                {
                    if(!findRollNumber(rollNumber, subject)){
                        JOptionPane.showMessageDialog(new JFrame(), "Record for Roll Number "+rollNumber+" doesn't exist! Press REFRESH button!");
                    }
                    else{
                        String query1 = "DELETE FROM CAO_DATABASE_MARKS WHERE ROLL_NUMBER=?";
                        PreparedStatement preparedsmt1 = connect.prepareStatement(query1);
                        preparedsmt1.setString(1, rollNumber);

                        String query2 = "DELETE FROM CAO_DATABASE_ATTENDANCE WHERE ROLL_NUMBER=?";
                        PreparedStatement preparedsmt2 = connect.prepareStatement(query2);
                        preparedsmt2.setString(1, rollNumber);

                        preparedsmt1.execute();
                        preparedsmt2.execute();
                        JOptionPane.showMessageDialog(new JFrame(), "Roll Number "+rollNumber+" deleted!");
                    }
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public JTable getAttendance(String subject) throws SQLException{
        try {
            createDatabaseConnection();
            
            ArrayList<String[]>  tableData=new ArrayList<>();
            
            String[] columnNames =  {
                "Roll Number", "Attendance", "Total Lectures",
            };
            switch(subject)
            {
                case "se":{ 
                    rs = stateObj.executeQuery("SELECT * FROM SE_DATABASE_ATTENDANCE ORDER BY ROLL_NUMBER");
                    
                    while ( rs.next() ){
                        tableData.add(new String[]{rs.getString("roll_number"), rs.getString("attendance"), rs.getString("total")});
                    }
                    break;
                }
                case "os":{
                    rs = stateObj.executeQuery("SELECT * FROM OS_DATABASE_ATTENDANCE ORDER BY ROLL_NUMBER");

                    while ( rs.next() ){
                        tableData.add(new String[]{rs.getString("roll_number"), rs.getString("attendance"), rs.getString("total")});
                    }
                    break;
                }
                case "ada":{
                    rs = stateObj.executeQuery("SELECT * FROM ADA_DATABASE_ATTENDANCE ORDER BY ROLL_NUMBER");
                    
                    while ( rs.next() ){
                        tableData.add(new String[]{rs.getString("roll_number"), rs.getString("attendance"), rs.getString("total")});
                    }
                    break;
                }
                case "wt":{
                    rs = stateObj.executeQuery("SELECT * FROM WT_DATABASE_ATTENDANCE ORDER BY ROLL_NUMBER");

                    while ( rs.next() ){
                        tableData.add(new String[]{rs.getString("roll_number"), rs.getString("attendance"), rs.getString("total")});
                    }
                    break;
                }
                case "cao":{
                    rs = stateObj.executeQuery("SELECT * FROM CAO_DATABASE_ATTENDANCE ORDER BY ROLL_NUMBER");

                    while ( rs.next() ){
                        tableData.add(new String[]{rs.getString("roll_number"), rs.getString("attendance"), rs.getString("total")});
                    }
                    break;
                }
            }
            String[][] tableRows = tableData.toArray(new String[tableData.size()][]); // convert the ArrayList to a regular Array
            JTable table = new JTable( tableRows, columnNames );   // thats how you put the data into the JTable
            return table;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try
            {
                connect.close();
                stateObj.close();
            }
            catch(SQLException se)
            {
                        
            }
        }
        return null;        
    }
    
    public JTable makeTable(String subject) throws SQLException{
        try {
            createDatabaseConnection();
            
            ArrayList<String[]>  tableData=new ArrayList<>();
            
            String[] columnNames =  {
                "Roll Number", "Attendance", "Total Lectures", "Sessional", "Quiz", "Attendance Marks", "Semester",
            };
            
            switch(subject)
            {
                case "se":{ 
                    rs = stateObj.executeQuery("SELECT * FROM SE_DATABASE_MARKS NATURAL JOIN SE_DATABASE_ATTENDANCE ORDER BY ROLL_NUMBER");
                    
                    while ( rs.next() ){
                        tableData.add(new String[]{rs.getString("roll_number"), rs.getString("attendance"), rs.getString("total"), rs.getString("sessional"), rs.getString("quiz"), rs.getString("attendance_marks"), rs.getString("semester")});
                    }
                    break;
                }
                case "os":{
                    rs = stateObj.executeQuery("SELECT * FROM OS_DATABASE_MARKS NATURAL JOIN OS_DATABASE_ATTENDANCE ORDER BY ROLL_NUMBER");

                    while ( rs.next() ){
                        tableData.add(new String[]{rs.getString("roll_number"), rs.getString("attendance"), rs.getString("total"), rs.getString("sessional"), rs.getString("quiz"), rs.getString("attendance_marks"), rs.getString("semester")});
                    }
                    break;
                }
                case "ada":{
                    rs = stateObj.executeQuery("SELECT * FROM ADA_DATABASE_MARKS NATURAL JOIN ADA_DATABASE_ATTENDANCE ORDER BY ROLL_NUMBER");
                    while ( rs.next() ){
                        tableData.add(new String[]{rs.getString("roll_number"), rs.getString("attendance"), rs.getString("total"), rs.getString("sessional"), rs.getString("quiz"), rs.getString("attendance_marks"), rs.getString("semester")});
                    }
                    break;
                }
                case "wt":{
                    rs = stateObj.executeQuery("SELECT * FROM WT_DATABASE_MARKS NATURAL JOIN WT_DATABASE_ATTENDANCE ORDER BY ROLL_NUMBER");

                    while ( rs.next() ){
                        tableData.add(new String[]{rs.getString("roll_number"), rs.getString("attendance"), rs.getString("total"), rs.getString("sessional"), rs.getString("quiz"), rs.getString("attendance_marks"), rs.getString("semester")});
                    }
                    break;
                }
                case "cao":{
                    rs = stateObj.executeQuery("SELECT * FROM CAO_DATABASE_MARKS NATURAL JOIN CAO_DATABASE_ATTENDANCE ORDER BY ROLL_NUMBER");

                    while ( rs.next() ){
                        tableData.add(new String[]{rs.getString("roll_number"), rs.getString("attendance"), rs.getString("total"), rs.getString("sessional"), rs.getString("quiz"), rs.getString("attendance_marks"), rs.getString("semester")});
                    }
                    break;
                }
            }
            String[][] tableRows = tableData.toArray(new String[tableData.size()][]); // convert the ArrayList to a regular Array
            JTable table = new JTable( tableRows, columnNames );   // thats how you put the data into the JTable
            return table;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try
            {
                connect.close();
                stateObj.close();
            }
            catch(SQLException se)
            {
                        
            }
        }        
        return null;
    }
    
    public boolean findRollNumber(String rollNumber, String subject) throws SQLException{
        switch(subject)
        {
            case "se":{
                rs = stateObj.executeQuery("SELECT ROLL_NUMBER FROM SE_DATABASE_MARKS WHERE ROLL_NUMBER='" + rollNumber + "'");
                if(rs.next())
                {
                    if (rs.getString("ROLL_NUMBER").equals(rollNumber))
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                return false;
            }
            case "os":{
                rs = stateObj.executeQuery("SELECT ROLL_NUMBER FROM OS_DATABASE_MARKS WHERE ROLL_NUMBER='" + rollNumber + "'");
                if(rs.next())
                {
                    if (rs.getString("ROLL_NUMBER").equals(rollNumber))
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                return false;}
            case "ada":{
                rs = stateObj.executeQuery("SELECT ROLL_NUMBER FROM ADA_DATABASE_MARKS WHERE ROLL_NUMBER='" + rollNumber + "'");
                if(rs.next())
                {
                    if (rs.getString("ROLL_NUMBER").equals(rollNumber))
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                return false;}
            case "wt":{
                rs = stateObj.executeQuery("SELECT ROLL_NUMBER FROM WT_DATABASE_MARKS WHERE ROLL_NUMBER='" + rollNumber + "'");
                if(rs.next())
                {
                    if (rs.getString("ROLL_NUMBER").equals(rollNumber))
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                return false;}
            case "cao":{
                rs = stateObj.executeQuery("SELECT ROLL_NUMBER FROM CAO_DATABASE_MARKS WHERE ROLL_NUMBER='" + rollNumber + "'");
                if(rs.next())
                {
                    if (rs.getString("ROLL_NUMBER").equals(rollNumber))
                    {
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                return false;}
        }
        return false;
    }
    
    public void updateData(String subject, Marks marks) throws SQLException{
        try {
            createDatabaseConnection();
            String rollNumber;
            float sessional, quiz, attendanceMarks, semester;
            int attendance, totalLectures;
            rollNumber = marks.rollNumberField.getText();
            sessional = Float.parseFloat(marks.sessionalField.getText());
            quiz = Float.parseFloat(marks.quizField.getText());
            attendanceMarks = Float.parseFloat(marks.attendanceMarksField.getText());
            semester = Float.parseFloat(marks.semesterField.getText());
            attendance = Integer.parseInt(marks.attendanceField.getText());
            totalLectures = Integer.parseInt(marks.totalLecturesField.getText());
            if(sessional > 30 || quiz > 15 || attendanceMarks > 5 || semester > 50)
            {
                JOptionPane.showMessageDialog(new JFrame(), "Sessional <= 30, Quiz <= 15, Attendance Marks <= 5 and Semester <= 50");
            }
            else
            {
                switch(subject){
                case "se":{
                    if(findRollNumber(rollNumber, subject)){
                        String query = "UPDATE SE_DATABASE_MARKS SET SESSIONAL=?, QUIZ=?, ATTENDANCE_MARKS=?, SEMESTER=? WHERE ROLL_NUMBER=?";
                        String query2 = "UPDATE `se_database_attendance` SET `roll_number`=?, `attendance`=?, `total`=?";
                        PreparedStatement preparedsmt = connect.prepareStatement(query);
                        
                        preparedsmt.setFloat(1, sessional);
                        preparedsmt.setFloat(2, quiz);
                        preparedsmt.setFloat(3, attendanceMarks);
                        preparedsmt.setFloat(4, semester);
                        preparedsmt.setString(5, rollNumber);
                        preparedsmt.execute();
                        
                        PreparedStatement preparedsmt1 = connect.prepareStatement(query2);
                        preparedsmt1.setString(1, rollNumber);
                        preparedsmt1.setInt(2, attendance);
                        preparedsmt1.setInt(3, totalLectures);
                        preparedsmt1.execute();
                        
                        JOptionPane.showMessageDialog(new JFrame(), "Roll Number " +rollNumber+ " record updated!");
                    }
                    else{
                        JOptionPane.showMessageDialog(new JFrame(), "Roll Number doesn't exist! Press INSERT to enter new student!");
                    }
                    break;}
                case "ada":{
                    if(findRollNumber(rollNumber, subject)){
                        String query = "UPDATE ADA_DATABASE_MARKS SET SESSIONAL=?, QUIZ=?, ATTENDANCE_MARKS=?, SEMESTER=? WHERE ROLL_NUMBER=?";
                        String query2 = "UPDATE `ada_database_attendance` SET `roll_number`=?, `attendance`=?, `total`=?";
                        PreparedStatement preparedsmt = connect.prepareStatement(query);
                        
                        preparedsmt.setFloat(1, sessional);
                        preparedsmt.setFloat(2, quiz);
                        preparedsmt.setFloat(3, attendanceMarks);
                        preparedsmt.setFloat(4, semester);
                        preparedsmt.setString(5, rollNumber);
                        preparedsmt.execute();
                        
                        PreparedStatement preparedsmt1 = connect.prepareStatement(query2);
                        preparedsmt1.setString(1, rollNumber);
                        preparedsmt1.setInt(2, attendance);
                        preparedsmt1.setInt(3, totalLectures);
                        preparedsmt1.execute();
                        
                        JOptionPane.showMessageDialog(new JFrame(), "Roll Number " +rollNumber+ " record updated!");
                    }
                    else{
                        JOptionPane.showMessageDialog(new JFrame(), "Roll Number doesn't exist! Press INSERT to enter new student!");
                    }
                    break;}
                case "os":{
                    if(findRollNumber(rollNumber, subject)){
                        String query = "UPDATE OS_DATABASE_MARKS SET SESSIONAL=?, QUIZ=?, ATTENDANCE_MARKS=?, SEMESTER=? WHERE ROLL_NUMBER=?";
                        String query2 = "UPDATE `os_database_attendance` SET `roll_number`=?, `attendance`=?, `total`=?";
                        PreparedStatement preparedsmt = connect.prepareStatement(query);
                        
                        preparedsmt.setFloat(1, sessional);
                        preparedsmt.setFloat(2, quiz);
                        preparedsmt.setFloat(3, attendanceMarks);
                        preparedsmt.setFloat(4, semester);
                        preparedsmt.setString(5, rollNumber);
                        preparedsmt.execute();
                        
                        PreparedStatement preparedsmt1 = connect.prepareStatement(query2);
                        preparedsmt1.setString(1, rollNumber);
                        preparedsmt1.setInt(2, attendance);
                        preparedsmt1.setInt(3, totalLectures);
                        preparedsmt1.execute();
                        
                        JOptionPane.showMessageDialog(new JFrame(), "Roll Number " +rollNumber+ " record updated!");
                    }
                    else{
                        JOptionPane.showMessageDialog(new JFrame(), "Roll Number doesn't exist! Press INSERT to enter new student!");
                    }
                    break;}    
                case "wt":{
                    if(findRollNumber(rollNumber, subject)){
                        String query = "UPDATE WT_DATABASE_MARKS SET SESSIONAL=?, QUIZ=?, ATTENDANCE_MARKS=?, SEMESTER=? WHERE ROLL_NUMBER=?";
                        String query2 = "UPDATE `wt_database_attendance` SET `roll_number`=?, `attendance`=?, `total`=?";
                        PreparedStatement preparedsmt = connect.prepareStatement(query);
                        
                        preparedsmt.setFloat(1, sessional);
                        preparedsmt.setFloat(2, quiz);
                        preparedsmt.setFloat(3, attendanceMarks);
                        preparedsmt.setFloat(4, semester);
                        preparedsmt.setString(5, rollNumber);
                        preparedsmt.execute();
                        
                        PreparedStatement preparedsmt1 = connect.prepareStatement(query2);
                        preparedsmt1.setString(1, rollNumber);
                        preparedsmt1.setInt(2, attendance);
                        preparedsmt1.setInt(3, totalLectures);
                        preparedsmt1.execute();
                        
                        JOptionPane.showMessageDialog(new JFrame(), "Roll Number " +rollNumber+ " record updated!");
                    }
                    else{
                        JOptionPane.showMessageDialog(new JFrame(), "Roll Number doesn't exist! Press INSERT to enter new student!");
                    }
                    break;}
                case "cao":{
                    if(findRollNumber(rollNumber, subject)){
                        String query = "UPDATE CAO_DATABASE_MARKS SET SESSIONAL=?, QUIZ=?, ATTENDANCE_MARKS=?, SEMESTER=? WHERE ROLL_NUMBER=?";
                        String query2 = "UPDATE `cao_database_attendance` SET `roll_number`=?, `attendance`=?, `total`=?";
                        PreparedStatement preparedsmt = connect.prepareStatement(query);
                        
                        preparedsmt.setFloat(1, sessional);
                        preparedsmt.setFloat(2, quiz);
                        preparedsmt.setFloat(3, attendanceMarks);
                        preparedsmt.setFloat(4, semester);
                        preparedsmt.setString(5, rollNumber);
                        preparedsmt.execute();
                        
                        PreparedStatement preparedsmt1 = connect.prepareStatement(query2);
                        preparedsmt1.setString(1, rollNumber);
                        preparedsmt1.setInt(2, attendance);
                        preparedsmt1.setInt(3, totalLectures);
                        preparedsmt1.execute();
                        
                        JOptionPane.showMessageDialog(new JFrame(), "Roll Number " +rollNumber+ " record updated!");
                    }
                    else{
                        JOptionPane.showMessageDialog(new JFrame(), "Roll Number doesn't exist! Press INSERT to enter new student!");
                    }
                    break;}
            }
            
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try
            {
                connect.close();
                stateObj.close();
            }
            catch(SQLException se)
            {
                        
            }
        }
    }
    
    public void insertData(String subject, Marks marks) throws SQLException{
        try {
            createDatabaseConnection();
            String rollNumber;
            float sessional, quiz, attendanceMarks, semester;
            int attendance, totalLectures;
            rollNumber = marks.rollNumberField.getText();
            sessional = Float.parseFloat(marks.sessionalField.getText());
            quiz = Float.parseFloat(marks.quizField.getText());
            attendanceMarks = Float.parseFloat(marks.attendanceMarksField.getText());
            semester = Float.parseFloat(marks.semesterField.getText());
            attendance = Integer.parseInt(marks.attendanceField.getText());
            totalLectures = Integer.parseInt(marks.totalLecturesField.getText());
            if(sessional > 30 || quiz > 15 || attendanceMarks > 5 || semester > 50)
            {
                JOptionPane.showMessageDialog(new JFrame(), "Sessional <= 30, Quiz <= 15, Attendance Marks <= 5 and Semester <= 50");
            }
            else
            {
                switch(subject){
                case "se":{
                    if(!findRollNumber(rollNumber, subject)){
                        String query1 = "INSERT INTO `se_database_marks`(`roll_number`, `sessional`, `quiz`, `attendance_marks`, `semester`) VALUES (?, ?, ?, ?, ?)";
                        String query2 = "INSERT INTO `se_database_attendance` (`roll_number`, `attendance`, `total`) VALUES (?, ?, ?)";
                        PreparedStatement preparedsmt = connect.prepareStatement(query1);
                        
                        preparedsmt.setString(1, rollNumber);
                        preparedsmt.setFloat(2, sessional);
                        preparedsmt.setFloat(3, quiz);
                        preparedsmt.setFloat(4, attendanceMarks);
                        preparedsmt.setFloat(5, semester);
                        preparedsmt.execute();
                        
                        
                        PreparedStatement preparedsmt1 = connect.prepareStatement(query2);
                        preparedsmt1.setString(1, rollNumber);
                        preparedsmt1.setInt(2, attendance);
                        preparedsmt1.setInt(3, totalLectures);
                        preparedsmt1.execute();
                        
                        JOptionPane.showMessageDialog(new JFrame(), "Roll Number " +rollNumber+ " added!");
                    }
                    else{
                        JOptionPane.showMessageDialog(new JFrame(), "Roll Number already exists! Press UPDATE to update record!");
                    }
                    break;}
                case "ada": {
                    if(!findRollNumber(rollNumber, subject)){
                        String query1 = "INSERT INTO `ada_database_marks`(`roll_number`, `sessional`, `quiz`, `attendance_marks`, `semester`) VALUES (?, ?, ?, ?, ?)";
                        String query2 = "INSERT INTO `ada_database_attendance` (`roll_number`, `attendance`, `total`) VALUES (?, ?, ?)";
                        PreparedStatement preparedsmt = connect.prepareStatement(query1);
                        
                        preparedsmt.setString(1, rollNumber);
                        preparedsmt.setFloat(2, sessional);
                        preparedsmt.setFloat(3, quiz);
                        preparedsmt.setFloat(4, attendanceMarks);
                        preparedsmt.setFloat(5, semester);
                        preparedsmt.execute();
                        
                        
                        PreparedStatement preparedsmt1 = connect.prepareStatement(query2);
                        preparedsmt1.setString(1, rollNumber);
                        preparedsmt1.setInt(2, attendance);
                        preparedsmt1.setInt(3, totalLectures);
                        preparedsmt1.execute();
                        
                        JOptionPane.showMessageDialog(new JFrame(), "Roll Number " +rollNumber+ " added!");
                    }
                    else{
                        JOptionPane.showMessageDialog(new JFrame(), "Roll Number already exists! Press UPDATE to update record!");
                    }
                    break;}
                case "os":{
                    if(!findRollNumber(rollNumber, subject)){
                        String query1 = "INSERT INTO `os_database_marks`(`roll_number`, `sessional`, `quiz`, `attendance_marks`, `semester`) VALUES (?, ?, ?, ?, ?)";
                        String query2 = "INSERT INTO `os_database_attendance` (`roll_number`, `attendance`, `total`) VALUES (?, ?, ?)";
                        PreparedStatement preparedsmt = connect.prepareStatement(query1);
                        
                        preparedsmt.setString(1, rollNumber);
                        preparedsmt.setFloat(2, sessional);
                        preparedsmt.setFloat(3, quiz);
                        preparedsmt.setFloat(4, attendanceMarks);
                        preparedsmt.setFloat(5, semester);
                        preparedsmt.execute();
                        
                        
                        PreparedStatement preparedsmt1 = connect.prepareStatement(query2);
                        preparedsmt1.setString(1, rollNumber);
                        preparedsmt1.setInt(2, attendance);
                        preparedsmt1.setInt(3, totalLectures);
                        preparedsmt1.execute();
                        
                        JOptionPane.showMessageDialog(new JFrame(), "Roll Number " +rollNumber+ " added!");                        
                    }
                    else{
                        JOptionPane.showMessageDialog(new JFrame(), "Roll Number already exists! Press UPDATE to update record!");   
                    }
                    break;}
                case "wt":{
                    if(!findRollNumber(rollNumber, subject)){
                        String query1 = "INSERT INTO `wt_database_marks`(`roll_number`, `sessional`, `quiz`, `attendance_marks`, `semester`) VALUES (?, ?, ?, ?, ?)";
                        String query2 = "INSERT INTO `wt_database_attendance` (`roll_number`, `attendance`, `total`) VALUES (?, ?, ?)";
                        PreparedStatement preparedsmt = connect.prepareStatement(query1);
                        
                        preparedsmt.setString(1, rollNumber);
                        preparedsmt.setFloat(2, sessional);
                        preparedsmt.setFloat(3, quiz);
                        preparedsmt.setFloat(4, attendanceMarks);
                        preparedsmt.setFloat(5, semester);
                        preparedsmt.execute();
                        
                        
                        PreparedStatement preparedsmt1 = connect.prepareStatement(query2);
                        preparedsmt1.setString(1, rollNumber);
                        preparedsmt1.execute();
                        
                        JOptionPane.showMessageDialog(new JFrame(), "Roll Number " +rollNumber+ " added!");                       
                    }
                    else{
                        JOptionPane.showMessageDialog(new JFrame(), "Roll Number already exists! Press UPDATE to update record!");
                    }
                    break;}
                case "cao":{
                    if(!findRollNumber(rollNumber, subject)){
                        String query1 = "INSERT INTO `cao_database_marks`(`roll_number`, `sessional`, `quiz`, `attendance_marks`, `semester`) VALUES (?, ?, ?, ?, ?)";
                        String query2 = "INSERT INTO `cao_database_attendance` (`roll_number`, `attendance`, `total`) VALUES (?, 0, 0)";
                        PreparedStatement preparedsmt = connect.prepareStatement(query1);
                        
                        preparedsmt.setString(1, rollNumber);
                        preparedsmt.setFloat(2, sessional);
                        preparedsmt.setFloat(3, quiz);
                        preparedsmt.setFloat(4, attendanceMarks);
                        preparedsmt.setFloat(5, semester);
                        preparedsmt.execute();
                        
                        
                        PreparedStatement preparedsmt1 = connect.prepareStatement(query2);
                        preparedsmt1.setString(1, rollNumber);
                        preparedsmt1.setInt(2, attendance);
                        preparedsmt1.setInt(3, totalLectures);
                        preparedsmt1.execute();
                        
                        JOptionPane.showMessageDialog(new JFrame(), "Roll Number " +rollNumber+ " added!");
                    }
                    else{
                        JOptionPane.showMessageDialog(new JFrame(), "Roll Number already exists! Press UPDATE to update record!");
                    }
                    break;}
            }
            }            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try
            {
                connect.close();
                stateObj.close();
            }
            catch(SQLException se)
            {
                        
            }
        }
    }
    
    public int verifyUser(String username, String password) throws ClassNotFoundException
    {
        try
        {
            createDatabaseConnection();
            System.out.println("username: "+username+", password: "+password);
            rs = stateObj.executeQuery("SELECT PASSWORD FROM USERS WHERE USERNAME = '" + username + "'");
            if (rs.next())
            {
                System.out.println(rs.getString("PASSWORD"));
                if (rs.getString("PASSWORD").equals(password))
                {
                    //awesome
                    return 1;
                } 
                else
                {
                    //false password
                    return 0;
                }
            } 
            else
            {
                //no records found
                return 2;
            }
        } catch (SQLException se) {

        } finally {
            try
            {
                connect.close();
                stateObj.close();
            }
            catch(SQLException se)
            {
                        
            }
        }
        return 0;
    }
}