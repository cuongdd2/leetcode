package wc53;

/**
 * Given a non-empty 2D array grid of 0's and 1's,
 * an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.

 Find the maximum area of an island in the given 2D array. (If there is no island, the maximum island is 0.)

 Example 1:
 [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 Example 2:
 [[0,0,0,0,0,0,0,0]]
 Given the above grid, return 0.
 Note: The length of each dimension in the given grid does not exceed 50.
 * */
public class _695MaxAreaIsland {

  public static void main(String[] args) {
    int[][] grid = new int[][] {
        {0,0,1,0,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,1,1,0,1,0,0,0,0,0,0,0,0},
        {0,1,0,0,1,1,0,0,1,0,1,0,0},
        {0,1,0,0,1,1,0,0,1,1,1,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,0,0,0,0,0,0,1,1,0,0,0,0}};
    System.out.println(maxAreaOfIsland(grid));
  }

  static boolean[][] map;

  static public int maxAreaOfIsland(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    map = new boolean[m][n];
    int max = 0;
    for (int y = 0; y < m; y++) {
      for (int x = 0; x < n; x++) {
        if (grid[y][x] == 1) {
          max = Math.max(max, area(grid, y, x));
        }
      }
    }

    return max;
  }

  static int area(int[][] grid, int y, int x) {
    if (y < 0 || x < 0 || y == grid.length || x == grid[y].length) return 0;
    if (grid[y][x] == 0 || map[y][x]) return 0;
    map[y][x] = true;
    int count = 1;
    count += area(grid, y, x + 1);
    count += area(grid, y, x - 1);
    count += area(grid, y + 1, x);
    count += area(grid, y - 1, x);
    return count;
  }
}
