package peptides;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Map;

public class Peptides4Test {

    @Test
    public void testTranslateWord() {
        String peptide = "ABCDEFGH";
        long expected = 0x0001020304050607L;
        assertEquals(expected, Peptides4.translateWord(peptide));
    }

    @Test
    public void testBinarySearchFound() {
        long[] array = {0x0001020304050607L, 0x0002030405060708L, 0x0003040506070809L};
        Peptides4 peptides = new Peptides4("", List.of());
        int index = peptides.binarySearch(0x0002030405060708L, array);
        assertEquals(1, index);
    }



    @Test
    public void testCalculatePeptides() {

        String protein = "ABCDEFGHBCDEFGHIJKLMNOPQRSTUVWXYZ";
        List<String> library = List.of("ABCDEFGH");

        Peptides4 peptides = new Peptides4(protein, library);
        peptides.calculate();

        Map<String, List<Integer>> map = peptides.map;

        assertTrue(map.containsKey("ABCDEFGH"));
        assertEquals(List.of(0), map.get("ABCDEFGH"));



    }
}
