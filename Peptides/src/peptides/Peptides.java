package peptides;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Peptides {

    String protein;
    static int DEFAULT_PEPTIDE_SIZE = 8;
    int peptideSize;

    List<String> library;
    HashMap<String,List<Integer>> map = new HashMap<>();

    public Peptides(int peptideSize, String protein, List<String> library) {
        this.peptideSize = peptideSize;
        this.protein = protein;
        this.library = library;
        prepareLibraryMap(library);
    }

    private void prepareLibraryMap(List<String> library) {
        for(String peptide : library){
            if(!map.containsKey(peptide))
                map.put(peptide,new ArrayList<>());
        }
    }


    public void calculate() {
        for (int i = 0; i < protein.length()- peptideSize+1; i++) {
            String str = protein.substring(i,i+peptideSize);

            if(map.containsKey(str))
                map.get(str).add(i);
        }
    }
}
