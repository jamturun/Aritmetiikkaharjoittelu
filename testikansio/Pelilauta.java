
public class Pelilauta {

    private int[][] taulu = new int[4][4];
    private static int[][] sijainti = new int[4][4];

    public Pelilauta() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sijainti[i][j] = j + 1 + 4 * i;
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                taulu[i][j] = j + 1 + i * 4;
            }
        }
        taulu[3][3] = 0;
    }

    public int haeLuku(int y, int x) {
        if (y < 0 || y > 3 || x < 0 || x > 3) {
            return -1;
        } else {
            return taulu[y][x];
        }
    }

    public String toString() {
        String merkkijono = "+--+--+--+--+\n";
        for (int i = 0; i < 4; i++) {

            merkkijono = merkkijono + "| " + taulu[0][i];
        }
        merkkijono = merkkijono + "|\n+--+--+--+--+\n";
        for (int i = 0; i < 4; i++) {

            merkkijono = merkkijono + "| " + taulu[1][i];
        }
        merkkijono = merkkijono + "|\n+--+--+--+--+\n| ";
        for (int i = 0; i < 4; i++) {
            merkkijono = merkkijono + taulu[2][i] + "|";
        }
        merkkijono = merkkijono + "\n+--+--+--+--+\n|";
        for (int i = 0; i < 3; i++) {
            merkkijono = merkkijono + taulu[3][i] + "|";
        }
        merkkijono = merkkijono + "  |\n+--+--+--+--+\n";

        return merkkijono;
    }

    private static int[][] haeTyhja(int[][] taulukko) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (taulukko[i][j] == 0) {
                    sijainti[i][j] == 0;
               }
          }
        }
        return sijainti;
    }

    public void ylos() {
        int tyhjasijainti = haeTyhja(taulu);
        if(tyhjasijainti > 0 && tyhjasijainti < 13) {
            
        }
    }
            
        
}
