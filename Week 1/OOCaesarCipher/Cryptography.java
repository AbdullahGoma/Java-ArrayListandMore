
import java.util.Arrays;

import edu.duke.*;

public class Cryptography {

    public static void main(String[] args) {
        //Q1:
        OOCaesarCipherOne o1 = new OOCaesarCipherOne(15);
        System.out.println(o1.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?"));
        
        //Q:2
        OOCaesarCipherTwo o2 = new OOCaesarCipherTwo(21, 8);
        System.out.println("\n" + o2.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?" + "\n"));
        
        //Q:4
        //WordLengths w = new WordLengths();
        //FileResource resource = new FileResource("./data/errors.txt");
        //int[] counts = new int[31];
       // w.countWordLengths(resource, counts);
       // System.out.println(w.indexOfMax(counts) +"\n");
        
        //Q:5
        WordLengths w = new WordLengths();
        FileResource resource = new FileResource("./data/lotsOfWords.txt");
        int[] counts = new int[31];
        w.countWordLengths(resource, counts);
        System.out.println(w.indexOfMax(counts));
        
        //Q:6
        OOCaesarCipherTwo o3 = new OOCaesarCipherTwo(14, 24);
        System.out.println("\n" + o3.decrypt("Hfs cpwewloj loks cd Hoto kyg Cyy."));
        
        //Q:7
        CasesarBreaker c = new CasesarBreaker();
        c.decryptTwoKeys("Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!");
        
        //Q:8
        FileResource fr = new FileResource("./data/mysteryTwoKeysPractice.txt");
        String message = fr.asString();
        String s1 = c.halfOfString(message, 0);
        String s2 = c.halfOfString(message, 1);
        int key1 = c.getKey(s1);
        int key2 = c.getKey(s2);
        System.out.println("\nTwo keys found: key1= " + key1 + ", key2= " + key2);
        CaesarCipher cc = new CaesarCipher();
        System.out.println(cc.encryptTwoKeys(message, 26-key1, 26-key2));
        
        
    }

}