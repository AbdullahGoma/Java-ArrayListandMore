
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testUniqIP() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("./short-test_log");
        int uniqueIPs = la.countUniqueIPs();
        System.out.println("There are " + uniqueIPs + " IPs");
    }
    
    public void testprintAllHigherThanNum() {
        int num = 200;
        int num1 = 300;
        LogAnalyzer la = new LogAnalyzer();
            la.readFile("./short-test_log");
            la.printAllHigherThanNum(num);
            la.printAllHigherThanNum(num1);
    }
    
    public void testuniqueIPVisitsOnDay() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("./weblog1_log");
        ArrayList<String> IP = la.uniqueIPVisitsOnDay("Mar 24");
        System.out.println(IP.toString());
    }
    
    public void testNumberOfuniqueIPVisitsOnDay() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("./weblog1_log");
        int IP = la.numberOfuniqueIPVisitsOnDay("Mar 24");
        System.out.println(IP);
    }
    
    public void testcountUniqueIPsInRange() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("./weblog1_log");
        int countIPs = la.countUniqueIPsInRange(300,399);
        System.out.println("There are " + countIPs + " unique IP addresses that have a status code from 300 to 399");
    }
    
    public void testLogAnalyzer() {
         LogAnalyzer la = new LogAnalyzer();
         la.readFile("./short-test_log.txt");
         la.printAll();
    }
}
