package peptides;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BenchmarkTest {
    String protein;
    List<String> library;


    @Before
    public void init(){
        protein = Benchmark.generateProtein(20);
        library = Benchmark.generateLibrary(10);
    }
    @Test
    public void testIfValuesAreAssigned(){
        assertNotNull(protein);
        assertNotNull(library);
    }
    @Test
    public void testIfGeneratesProtein(){
        assertEquals(protein.length(),20);
        for(char c : protein.toCharArray()){
            assertTrue(c >= 'A');
            assertTrue((c <= 'Z'));
        }
    }
    @Test
    public void testIfGeneratesLibrary(){
        assertEquals(library.size(),10);
        for(String str: library)
            for(char c : str.toCharArray()){
                assertTrue(c >= 'A');
                assertTrue((c <= 'Z'));
            }

    }


}