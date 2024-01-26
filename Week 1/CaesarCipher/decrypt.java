import edu.duke.*;
public class decrypt
{
    public static void eyeBallDecrypt(String encrypted){
        CaesarCipher cipher = new CaesarCipher();
        for(int i = 0;i < 26;i++){
            String s = cipher.encrypt(encrypted,i);
            System.out.println(i + "\t" + s);
        }
    }
    public static void testEyeBallDecrypt(){
        CaesarCipher test = new CaesarCipher();
        int key = 15;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = test.encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
        eyeBallDecrypt(encrypted);
    }
    public static void main(String[] args) {
        testEyeBallDecrypt();   
    }
}
