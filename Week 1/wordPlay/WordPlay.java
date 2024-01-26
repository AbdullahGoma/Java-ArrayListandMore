
public class WordPlay
{
    /** This method returns true if ch is a vowel (one of 'a', 'e', 'i', 'o', or 'u' or the uppercase versions) and false otherwise */
    public static boolean isVowel(char ch)
    {
        if("aeiouAEIOU".indexOf(ch) != -1){
            return true;
        }
        return false;
    }

    /** The method returns a String that is the string phrase with all the vowels (uppercase or lowercase) replaced by ch */
    public static String replaceVowels(String phrase, char ch)
    {
        StringBuilder p = new StringBuilder(phrase);
        String replacedphrase="";
        for (int i=0;i<phrase.length();i++)
        {
            if (!isVowel(p.charAt(i)))
            {
                replacedphrase = replacedphrase + p.charAt(i);
            }
            else 
            {
                replacedphrase =  replacedphrase + ch;
            }    
        }
        return replacedphrase;
    }
    
    /** The method returns a String that is the string phrase but with the Char ch (upper- or lowercase) replaced by '*' or '+' */
    public static String emphasize(String phrase, char ch)
    {
        StringBuilder p = new StringBuilder(phrase);
        String emphasizedphrase="";
        for (int i=0;i<phrase.length();i++)
        {
            if (p.charAt(i) == Character.toUpperCase(ch) || p.charAt(i) == Character.toLowerCase(ch))
            {
                if (i%2==0)
                {
                    emphasizedphrase = emphasizedphrase + '*';
                } 
                else 
                    emphasizedphrase = emphasizedphrase + '+'; 
            }
            else 
            {
                emphasizedphrase =  emphasizedphrase + p.charAt(i);
            }    
        }
        return emphasizedphrase;
    }
    public static void testAll() {
        System.out.println(replaceVowels("Hello World", '*'));
        System.out.println(emphasize("dna ctgaaactga", 'a'));
        System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
    }
    public static void main(String[] args) {
        testAll();   
    }
}