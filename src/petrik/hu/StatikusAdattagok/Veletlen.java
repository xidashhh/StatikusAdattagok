package petrik.hu.StatikusAdattagok;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public final class Veletlen {
    private Veletlen() {

    }
    private static final Random RND = new Random();

    private static final List<String> VEZETEK_NEVEK = feltolt("files/veznev.txt");
    private static final List<String> NOI_KERESZT_NEVEK = feltolt("files/noikernev.txt");
    private static final List<String> FERFI_KERESZT_NEVEK = feltolt("files/ferfikernev.txt");



    private static List<String> feltolt(String fajlnev) {
        List<String> lista = new ArrayList<>();
        try {
            Scanner file = new Scanner(new File(fajlnev));
            while (file.hasNext()){
                lista.add(file.nextLine());
            }

            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static int velEgesz(int min, int max){
        if (min > max) {
            throw new IllegalArgumentException("'min' must be <= 'max'");
        }
        else {
            return RND.nextInt(max - min + 1);
        }
    }

    public static char velKarakter(char min, char max){
        return (char) velEgesz(min, max);
    }

    public static String velVezetekNev() {
        return VEZETEK_NEVEK.get(RND.nextInt(VEZETEK_NEVEK.size()));
    }

    /**
     * Véletlen keresztnevet generál a megadott paraméter alapján
     * Paraméter értékétől függően férfi vagy női keresztnevet
     * @param nem A generált név neme. Igaz, ha férfi, hamis ha nő.
     * @return Generált keresztnév
     */
    public static String velKeresztNev(boolean nem) {
        String keresztNev;
        if (nem) {
            keresztNev = velFerfiKeresztNev();
        }
        else {
            keresztNev = velNoiKeresztNev();
        }

        return keresztNev;
    }

    private static String velNoiKeresztNev() {
        return NOI_KERESZT_NEVEK.get(RND.nextInt(NOI_KERESZT_NEVEK.size()));
    }

    private static String velFerfiKeresztNev() {
        return FERFI_KERESZT_NEVEK.get(RND.nextInt(FERFI_KERESZT_NEVEK.size()));
    }

    /**
     * Véletlen nevete generál a megadott paraméter alapján
     * Paraméter értékétől függően férfi vagy női keresztnevet
     * @param nem A generált név neme. Igaz, ha férfi, hamis ha nő.
     * @return Generált teljes név.
     */
    public static String velTeljesNev(boolean nem){
        return velVezetekNev() + " " + velKeresztNev(nem);
    }
}
