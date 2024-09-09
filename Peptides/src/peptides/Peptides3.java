package peptides;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Peptides3 {
    String protein;

    List<String> library;
    HashMap<Long,List<Integer>> map = new HashMap<>();

    public Peptides3(String protein, List<String> library) {
        this.protein = protein;
        this.library = library;
        translateLibraryIntoLongHashmap();
    }
    public void translateLibraryIntoLongHashmap(){
        for(String str: library){
            map.put(translateWord(str),new ArrayList<>());
        }
    }
    public void calculate(){
        for (int i = 0; i < protein.length()-8+1; i++) {
            long translatedPeptide = translateWord(protein.substring(i,i+8));
            if(map.containsKey(translatedPeptide)){
                map.get(translatedPeptide).add(i);
            }
        }

    }
    public static long translateWord(String word) {
        long result = 0;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            int letterValue = letter - 'A';
            result <<= 8;
            result |= (letterValue & 0xFF);
        }
        return result;
    }
}
