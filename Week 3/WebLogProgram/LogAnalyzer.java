
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
        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
}
