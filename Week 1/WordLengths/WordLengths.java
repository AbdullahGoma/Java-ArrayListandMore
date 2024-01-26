import edu.duke.*;
import java.lang.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WordLengths
{
    private HashMap map = new HashMap();
    
    public void countWordLengths(FileResource resource, int[] counts){
        for(String word : resource.words()){
            int wordlength = 0;
            StringBuilder wordd = new StringBuilder(word);
            for (int k = 0;k < wordd.length();k++){
                if (k == 0 && !Character.isLetter(wordd.charAt(k))){
                    wordd.deleteCharAt(k);                    
                }
                else if (k == wordd.length() - 1 && !Character.isLetter(wordd.charAt(k))){
                    wordd.deleteCharAt(k);
                }
                else{
                    wordlength++;
                }
            }
            String resultString = wordd.toString();
            counts[wordlength]++;
            map.put(resultString, wordlength);
        }
        
        for(int index = 0;index < counts.length;index++) {
            if (counts[index] != 0) {
                System.out.print(counts[index] + " words of length " + index + " are: ");
                Set set = map.entrySet();
                //set.forEach(System.out::print);
                Iterator namesIterator = set.iterator();
                //Display elements
                while(namesIterator.hasNext()) {
                    Map.Entry m = (Map.Entry)namesIterator.next();
                    if (m.getValue().equals(index))
                        System.out.print(m.getKey() + " ");
                }
                System.out.println();
            }
        }
    }
    
    //This method returns the index position of the largest element in values
    public int indexOfMax(int[] values){
        int max=0;
        for(int i=0; i< values.length;i++){
            if(values[i]>max){
                max = values[i];
            }  
        }    
        return max;
    }

    public void testCountWordLengths(){
        FileResource resource = new FileResource();
        int[] counts = new int[31];
        countWordLengths(resource, counts);
        //The most common word length
        System.out.println(indexOfMax(counts));
    }
}