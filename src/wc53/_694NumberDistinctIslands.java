package wc53;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty 2D array grid of 0's and 1's,
 * an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.

 Count the number of distinct islands.
 An island is considered to be the same as another if and only if one island
 can be translated (and not rotated or reflected) to equal the other.

 Example 1:
 11000
 11000
 00011
 00011
 Given the above grid map, return 1.
 Example 2:
 11011
 10000
 00001
 11011
 Given the above grid map, return 3.

 Notice that:
 11
 1
 and
 1
 11
 are considered different island shapes, because we do not consider reflection / rotation.
 Note: The length of each dimension in the given grid does not exceed 50.
 * */
public class _694NumberDistinctIslands {

  public static void main(String[] args) {
    _694NumberDistinctIslands me = new _694NumberDistinctIslands();
    int[][] grid = new int[][] {
        {0,0,1,0,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,1,1,0,1,0,0,0,0,0,0,0,0},
        {0,1,0,0,1,1,0,0,1,0,1,0,0},
        {0,1,0,0,1,1,0,0,1,1,1,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,0,0,0,0,0,0,1,1,0,0,0,0}};
    System.out.println(numDistinctIslands(grid));
  }

  static boolean[][] visited;
  static StringBuilder sb;
  static int initY, initX;

  static public int numDistinctIslands(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    visited = new boolean[m][n];
    Set<String> islands = new HashSet<>();
    for (int y = 0; y < m; y++) {
      for (int x = 0; x < n; x++) {
        if (grid[y][x] == 1) {
          sb = new StringBuilder();
          initX = x;
          initY = y;
          if (area(grid, y, x) > 0) islands.add(sb.toString());
        }
      }
    }

    return islands.size();
  }

  static int area(int[][] grid, int y, int x) {
    if (y < 0 || x < 0 || y == grid.length || x == grid[y].length) return 0;
    if (grid[y][x] == 0 || visited[y][x]) return 0;
    visited[y][x] = true;
    int count = 1;
    sb.append(y - initY).append(",").append(x - initX).append("-");
    count += area(grid, y, x + 1);
    count += area(grid, y, x - 1);
    count += area(grid, y + 1, x);
    count += area(grid, y - 1, x);
    return count;
  }
}
