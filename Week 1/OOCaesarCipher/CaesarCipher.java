
import edu.duke.*;

public class CaesarCipher {
 
    /** This method returns a String that has been encrypted using the Caesar Cipher algorithm */
    public String encrypt(String input, int key) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0,key);
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(Character.toUpperCase(currChar));
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                if (currChar == Character.toUpperCase(currChar)){
                    char newChar = shiftedAlphabet.charAt(idx);
                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, newChar);
                }
                else{
                   char newChar = shiftedAlphabet.charAt(idx);
                    //Replace the ith character of encrypted with newChar
                   encrypted.setCharAt(i, Character.toLowerCase(newChar)); 
                }
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    
    /** 
     * This method returns a String that has been encrypted using the following algorithm 
     * key1 is used to encrypt every other character with the Caesar Cipher algorithm, starting with the first character
     * key2 is used to encrypt every other character, starting with the second character
     * */
    public String encryptTwoKeys(String input, int key1, int key2) {
         //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Compute the shifted alphabet
        String shiftedAlphabet1 = alphabet.substring(key1)+alphabet.substring(0,key1);
        String shiftedAlphabet2 = alphabet.substring(key2)+alphabet.substring(0,key2);
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf( Character.toUpperCase(currChar));
            //If currChar is in the alphabet
            
            if(idx != -1 && i%2 ==0){
                //Encrypted by the First key
                //Get the idxth character of shiftedAlphabet (newChar)
                if (currChar == Character.toUpperCase(currChar)){
                    char newChar = shiftedAlphabet1.charAt(idx);
                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, newChar);
                }
                else{
                   char newChar = shiftedAlphabet1.charAt(idx);
                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, Character.toLowerCase(newChar)); 
                }
            }
            if (idx != -1 && i%2 ==1){
                //Encrypted by the second key 
                //Get the idxth character of shiftedAlphabet (newChar)
                if (currChar == Character.toUpperCase(currChar)){
                    char newChar = shiftedAlphabet2.charAt(idx);
                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, newChar);
                }
                else{
                   char newChar = shiftedAlphabet2.charAt(idx);
                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, Character.toLowerCase(newChar)); 
                }
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }

    public void testCaesar() {
        int key = 15;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
        String decrypted = encrypt(encrypted, 26 - key);
        System.out.println(decrypted);
    }
    
    public void testencryptTwoKeys() {
        //int key1 = 8;
        //int key2 = 21;
        //FileResource fr = new FileResource();
        //String message = fr.asString();
        //String encrypted = encryptTwoKeys(message, key1 ,key2);
        //System.out.println("keys are " + key1 + " and "+ key2 + "\n" + encrypted);
        //String decrypted = encryptTwoKeys(encrypted, 26 - key1 ,26 - key2);
        //System.out.println(decrypted);
        String decryptedd = "Top ncmy qkff vi vguv vbg ycpx"; 
        String decrypteddd = encryptTwoKeys(decryptedd,24,6);
        System.out.println(decrypteddd);
    }
}