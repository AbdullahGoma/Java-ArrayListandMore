import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
         LogAnalyzer la = new LogAnalyzer();
         la.readFile("./weblog2_log");
         la.printAll();
    }
    
    public void testUniqIP() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("./weblog2_log");
        int uniqueIPs = la.countUniqueIPs();
        System.out.println("There are " + uniqueIPs + " IPs");
    }
    
    public void testprintAllHigherThanNum() {
        int num = 200;
        LogAnalyzer la = new LogAnalyzer();
            la.readFile("./weblog2_log");
            la.printAllHigherThanNum(num);
    }
    
    public void testuniqueIPVisitsOnDay() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("./weblog2_log");
        ArrayList<String> IP = la.uniqueIPVisitsOnDay("Sep 27");
        System.out.println(IP.toString());
    }
    
    public void testcountUniqueIPsInRange() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("./weblog2_log");
        int countIPs = la.countUniqueIPsInRange(200,299);
        System.out.println("There are " + countIPs + " unique IP addresses that have a status code from 200 to 299");
    }
    
    public void testCounts() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("./weblog2_log");
        HashMap<String, Integer> counts = la.countVisitsPerIP();
        System.out.println(counts);
    }
    
    public void testcountVisitsPerIP() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("./weblog2_log");
        System.out.println(la.countVisitsPerIP());
    }
    
    public void testmostNumberVisitsByIP() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("./weblog2_log");
        System.out.println(la.mostNumberVisitsByIP(la.countVisitsPerIP()));
    }
    
    public void testiPsMostVisits() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("./weblog2_log");
        ArrayList<String> list = la.iPsMostVisits(la.countVisitsPerIP());
        for (int i=0; i< list.size();i++) 
            System.out.print(list.get(i) + " ");
        System.out.println();
    }
    
    public void testiPsForDays() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("./weblog2_log");
        HashMap<String, ArrayList<String>> map = la.iPsForDays();
        for (Map.Entry<String, ArrayList<String>> e : map.entrySet()) {
            System.out.println(e.getKey() + " maps to " + e.getValue().size() + " IP address(es)");
        }
    }
    
    public void testdayWithMostIPVisits() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("./weblog2_log");
        HashMap<String, ArrayList<String>> map = la.iPsForDays();
        System.out.println(la.dayWithMostIPVisits(map));
    }
    
    public void testiPsWithMostVisitsOnDay() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("./weblog2_log");
        HashMap<String, ArrayList<String>> map = la.iPsForDays();
        System.out.println(la.iPsWithMostVisitsOnDay(map, "Mar 17"));
    }
}