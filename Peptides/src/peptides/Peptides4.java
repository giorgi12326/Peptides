package peptides;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Peptides4 {
    String protein;
    List<String> library;
    long[] translatedPeptides;
    int librarySize;
    HashMap<String,List<Integer>> map = new HashMap<>();

    public Peptides4(String protein, List<String> library) {
        this.protein = protein;
        this.library = library;
        this.librarySize = library.size();
        translatedPeptides = new long[librarySize];
        convertLibraryToArray(library);
    }

    private void convertLibraryToArray(List<String> library) {
        int index = 0;
        while(index < translatedPeptides.length){
            translatedPeptides[index] = translateWord(library.getFirst());
            index++;
        }
        Arrays.sort(translatedPeptides);
    }
    public void calculate(){
        for (int i = 0; i < protein.length()-8+1; i++) {
            String nonTranslatedPeptide = protein.substring(i,i+8);
            long peptide = translateWord(nonTranslatedPeptide);
            if(binarySearch(peptide,translatedPeptides) != -1) {
                if (map.containsKey(nonTranslatedPeptide))
                    map.get(nonTranslatedPeptide).add(i);
                else map.put(nonTranslatedPeptide,List.of(i));
            }
        }

    }
    public int binarySearch(long value, long[] arr){
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == value) {
                return mid;
            }
            if (arr[mid] > value) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
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
