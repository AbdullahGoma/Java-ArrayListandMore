import java.util.*;
import edu.duke.*;
import java.util.Arrays;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        //whichSlice, indicating the index the slice should start from.
        //totalSlices, indicating the length of the key.
        String sliced = "";
        for (int i = whichSlice; i < message.length(); i += totalSlices) {
            sliced += message.charAt(i);
        }
        return sliced;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        //klength that represents the key length.
        //mostCommon that indicates the most common character in the language of the message.
        int[] key = new int[klength];
        CaesarCracker ccr = new CaesarCracker(mostCommon);
        for (int i = 0; i < klength; i++) {
            String m = sliceString(encrypted,i,klength);
            int k = ccr.getKey(m);
            key[i]=k;
        }
        return key;
    }
    
    public void testtryKeyLength(){
        FileResource fr = new FileResource("./athens_keyflute.txt");
        String message = fr.asString();
        int [] array = tryKeyLength(message,5,'e');
        System.out.println(array[1]);
    }

    public void breakVigenere () {
        FileResource fr = new FileResource("./secretmessage1.txt");
        String message = fr.asString();

        int[] key = tryKeyLength(message,4,'e');

        VigenereCipher vc = new VigenereCipher(key);
        
        for (int i : key) {
            System.out.println(i);
        }
        
        System.out.println(vc.decrypt(message));
    }
    
}
