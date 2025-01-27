package peptides;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Benchmark {

    private static final int PROTEIN_SIZE = 10_000;
    private static final int LIBRARY_SIZE = 100_000;
    static final byte[] ALPHABET = new byte[26];

    static {
        for (byte c = 'A'; c <= 'Z'; c++) {
            ALPHABET[c-'A'] = c;
        }
    }

    public static void main(String[] args) {
        String protein = generateProtein(PROTEIN_SIZE);
        List<String> library = generateLibrary(LIBRARY_SIZE);

        System.out.println("searching peptides...");

//        Peptides peptides = new Peptides(8, protein, library);
//        Peptides3 peptides = new Peptides3(protein,library);
        Peptides4 peptides = new Peptides4(protein,library);
        long start = System.currentTimeMillis();
        peptides.calculate();
        long stop = System.currentTimeMillis();

        System.out.println("Elapsed: " + (stop - start));
    }

    public static String generateProtein(int proteinSize) {
        Random r = new Random();
        var data = new byte[proteinSize];
        for (int i = 0; i < proteinSize; i++) {
            data[i] = ALPHABET[r.nextInt(4)];
        }
        return new String(data);
    }

    public static List<String> generateLibrary(int librarySize) {
        var library = new ArrayList<String>(librarySize);
        for (int i = 0; i < librarySize; i++) {
            var peptide = generateProtein(Peptides.DEFAULT_PEPTIDE_SIZE);
            library.add(peptide);
        }
        return library;
    }


}