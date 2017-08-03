/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classerp;

import javax.swing.JTable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aditya Sharma
 */
public class DatabaseTest {
    
    public DatabaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of attendanceManager method, of class Database.
     */
    @Test
    public void testAttendanceManager() throws Exception {
        System.out.println("attendanceManager");
        String subject = "";
        String rollNumber = "";
        int result_2 = 0;
        Database instance = new Database();
        instance.attendanceManager(subject, rollNumber, result_2);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteTable method, of class Database.
     */
    @Test
    public void testDeleteTable() throws Exception {
        System.out.println("deleteTable");
        String subject = "";
        Database instance = new Database();
        instance.deleteTable(subject);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRow method, of class Database.
     */
    @Test
    public void testDeleteRow() throws Exception {
//        System.out.println("deleteRow");
//        String subject = "";
//        String rollNumber = "";
//        Database instance = new Database();
//        instance.deleteRow(subject, rollNumber);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getAttendance method, of class Database.
     */
    @Test
    public void testGetAttendance() throws Exception {
//        System.out.println("getAttendance");
//        String subject = "";
//        Database instance = new Database();
//        JTable expResult = null;
//        JTable result = instance.getAttendance(subject);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of makeTable method, of class Database.
     */
    @Test
    public void testMakeTable() throws Exception {
//        System.out.println("makeTable");
//        String subject = "";
//        Database instance = new Database();
//        JTable expResult = null;
//        JTable result = instance.makeTable(subject);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of findRollNumber method, of class Database.
     */
    @Test
    public void testFindRollNumber() throws Exception {
//        System.out.println("findRollNumber");
//        String rollNumber = "";
//        String subject = "";
//        Database instance = new Database();
//        boolean expResult = false;
//        boolean result = instance.findRollNumber(rollNumber, subject);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of updateData method, of class Database.
     */
    @Test
    public void testUpdateData() throws Exception {
//        System.out.println("updateData");
//        String subject = "";
//        Marks marks = null;
//        Database instance = new Database();
//        instance.updateData(subject, marks);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of insertData method, of class Database.
     */
    @Test
    public void testInsertData() throws Exception {
//        System.out.println("insertData");
//        String subject = "";
//        Marks marks = null;
//        Database instance = new Database();
//        instance.insertData(subject, marks);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of verifyUser method, of class Database.
     */
    @Test
    public void testVerifyUser() throws Exception {
        System.out.println("verifyUser");
        String username = "";
        String password = "";
        Database instance = new Database();
        int expResult = 2;
        int result = instance.verifyUser(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
