import java.util.*;
import edu.duke.*;

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
        FileResource fr = new FileResource("./secretmessage2.txt");
        String message = fr.asString().toLowerCase();

        FileResource frd = new FileResource("./dictionaries/English");
        HashSet<String> dictionary = readDictionary(frd);

        String decrypt = breakForLanguage(message, dictionary);

        System.out.println("Valid words are in the decrypted String is " + countWords(decrypt,dictionary));
        System.out.println(decrypt);

        String dec38 = new VigenereCipher(tryKeyLength(message,38,'e')).decrypt(message);
        System.out.println("Valid words are in the \"decrypted\" is " + countWords(dec38,dictionary));
        
    }
    
    public HashSet<String> readDictionary(FileResource fr) {
        HashSet<String> d = new HashSet<>();
        for (String l : fr.lines()) {
            d.add(l.toLowerCase());
        }
        return d;
    }
    
    public int countWords(String message, HashSet<String> dictionary) {
        String[] messageArray = message.split("\\W+");
        int count = 0;

        for (String word : messageArray) {
            if (dictionary.contains(word)) {
                count++;
            }
        }
        return count;
    }
    
     public String breakForLanguage(String encrypted, HashSet<String> dictionary) {
        int max = 0;
        String d = "";
        int keyLong = 0;
        
        //i < encrypted.length() to try all keys, but your program would just take a bit longer to run.
        
        for (int i = 1; i < 100; i++) {
            int[] key;
            key = tryKeyLength(encrypted, i, 'e');
            VigenereCipher vc = new VigenereCipher(key);
            String decrypted = vc.decrypt(encrypted);
            if (countWords(decrypted, dictionary) > max) {
                max = countWords(decrypted, dictionary);
                d = decrypted;
                keyLong = i;
            }
        }
        System.out.println("key length used to encrypt is " + keyLong);
        return d;
    }
}
