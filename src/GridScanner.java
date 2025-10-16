public class GridScanner {
    public static void main(String[] args) {
        char[][] grid = {
                {'.','.','#','.'},
                {'a','#','b','2'},
                {'.','.','.','.'}
        };
        int foundRow = -1;
        int foundCol = -1;
        char foundChar = '\0';

        OUTER:  //label for point 2.
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                char ch = grid[i][j];

                if (ch == '#') {
                    continue; // skip to the next column same row
                }

                if (ch >= '0' && ch <= '9') {
                    foundRow = i;
                    foundCol = j;
                    foundChar = ch;
                    break OUTER;
                }

            }
        }

        if (foundRow != -1) {
            System.out.printf("found digit '%c' at (row=%d, col=%d)%n", foundChar, foundRow, foundCol);
        }
        else {
            System.out.println("none");
        }
    }
}
