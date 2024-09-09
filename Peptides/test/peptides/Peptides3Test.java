package peptides;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Peptides3Test {
    private Peptides3 peptides3;

    @BeforeEach
    public void setUp() {
        List<String> library = new ArrayList<>();
        library.add("ABCDEFGH");
        library.add("HIJKLMNOP");
        peptides3 = new Peptides3("ABCDEFGHIJKLMNOPQRSTUVWX", library);
        peptides3.translateLibraryIntoLongHashmap();
    }

    @Test
    public void testTranslateWord() {
        assertEquals(0x0001020304050607L, Peptides3.translateWord("ABCDEFGH"));
    }

    @Test
    public void testTranslateLibraryIntoLongHashmap() {
        assertTrue(peptides3.map.containsKey(Peptides3.translateWord("ABCDEFGH")));
        assertTrue(peptides3.map.containsKey(Peptides3.translateWord("HIJKLMNOP")));
    }

    @Test
    public void testCalculate() {
        peptides3.calculate();
        assertFalse(peptides3.map.get(Peptides3.translateWord("ABCDEFGH")).isEmpty());
        assertFalse(peptides3.map.get(Peptides3.translateWord("HIJKLMNOP")).isEmpty());
    }

    @Test
    public void testCalculateWithMatchingPeptides() {
        peptides3 = new Peptides3("ABCDEFGHABCDEFGHHIJKLMNOP", List.of("ABCDEFGH", "HIJKLMNOP"));
        peptides3.translateLibraryIntoLongHashmap();
        peptides3.calculate();

        List<Integer> positions = peptides3.map.get(Peptides3.translateWord("ABCDEFGH"));

        assertNotNull(positions);
        assertTrue(positions.contains(0));
        assertTrue(positions.contains(8));

    }
}
