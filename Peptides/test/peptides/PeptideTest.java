package peptides;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class PeptideTest {
    Peptide peptide;

    @Before
    public void init(){
        peptide = new Peptide();
        peptide.setProtein("XYZABCXYZDEFXYZABCXYZDEFXYZABCXYZDEFXYZABCXYZDEF");
        peptide.setLibrary(Arrays.asList("XYZABC", "ABCXYZ", "DEFXYZ"));
    }

    @Test
    public void initializationParameters(){
        assertNotNull(peptide.protein);
        assertEquals(0, peptide.peptideMap.size());
    }

    @Test
    public void testIfHashMapInitialized(){
        peptide.initializePeptideMap(peptide.library);
        assertEquals(peptide.peptideMap.size(), peptide.library.size());
    }

    @Test
    public void testIfFoundCorrectPositions(){
        peptide.initializePeptideMap(peptide.library);
        peptide.findPositionsInProtein(peptide.protein, 6);
        HashMap<String, List<Integer>> temp = new HashMap<>();
        temp.put("XYZABC", List.of(0, 12, 24, 36));
        temp.put("ABCXYZ", List.of(3, 15, 27, 39));
        temp.put("DEFXYZ", List.of(9, 21, 33));
        assertEquals(temp, peptide.peptideMap);
    }
}
