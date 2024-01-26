
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         this.records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
        FileResource f = new FileResource(filename);
        for (String line: f.lines()) {
            LogEntry log = WebLogParser.parseEntry(line);
            records.add(log);
        }
     }
     
     public int countUniqueIPs() {
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        for (LogEntry le: records) {
            String ipAddress = le.getIpAddress();
            if (!uniqueIPs.contains(ipAddress)) {
                uniqueIPs.add(ipAddress);
            }
        }
        return uniqueIPs.size();
    }
    
    public void printAllHigherThanNum (int num) {
        for (LogEntry le: records) {
            if (le.getStatusCode() > num)
                System.out.println(le);
        }
    }
    
    public ArrayList<String> uniqueIPVisitsOnDay(String someday) {
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        for (LogEntry le: records) {
            String ipAddress = le.getIpAddress();
            String accessTime = le.getAccessTime().toString();
            if (someday.equals(accessTime.substring(4, 10))) {
                if (!uniqueIPs.contains(ipAddress)) {
                    uniqueIPs.add(ipAddress);
                }
            }
        }
        return uniqueIPs;
    }
    
    public int numberOfuniqueIPVisitsOnDay(String someday) {
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        for (LogEntry le: records) {
            String ipAddress = le.getIpAddress();
            String accessTime = le.getAccessTime().toString();
            if (someday.equals(accessTime.substring(4, 10))) {
                if (!uniqueIPs.contains(ipAddress)) {
                    uniqueIPs.add(ipAddress);
                }
            }
        }
        return uniqueIPs.size();
    }
    
    public int countUniqueIPsInRange(int low, int high) {
        ArrayList<String> UniqueIPsInRange = new ArrayList<String>();
        for (LogEntry le: records) {
            String ipAddress = le.getIpAddress();
            int Comparison = le.getStatusCode();
            if(low <= Comparison && Comparison <= high) {
                if (!UniqueIPsInRange.contains(ipAddress)) {
                    UniqueIPsInRange.add(ipAddress);
                }
            }
        }
        return UniqueIPsInRange.size();
    }
        
    public void printAll() {
        for (LogEntry le : records) {
            System.out.println(le);
        }
    }
     
     
}
