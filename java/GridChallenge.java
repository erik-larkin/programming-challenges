/*
 *  https://www.hackerrank.com/challenges/one-week-preparation-kit-grid-challenge/problem
 *  August 29th 2023
 *  By Erik Larkin
 */

import java.util.Arrays;
import java.util.List;

public class GridChallenge 
{
    public static String gridChallenge(List<String> grid) {
        int height = grid.size();
        int width = grid.get(0).length();

        for (int i = 0; i < height; i++) {
            char[] row = grid.get(i).toCharArray();
            Arrays.sort(row);
            grid.set(i, new String(row));
        }

        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height - 1; row++) {
                System.out.printf("Row %d, Col %d%n", row, col);
                char c1 = grid.get(row).charAt(col);
                char c2 = grid.get(row + 1).charAt(col);
                if (c1 > c2)
                    return "NO";
            }
        }

        return "YES";
    }
}
