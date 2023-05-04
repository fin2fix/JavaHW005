
/* Задание №4
 * На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
 */

public class s5dz04 {

  static boolean mat[][];

  static int n;

  private static boolean attacked(int x, int y) {
    if (mat[x][y])
      return true;
    for (int i = 1; i <= n; i++) {
      if (y - i >= 1 && mat[x][y - i])
        return true;

      if (y + i <= n && mat[x][y + i])
        return true;

      if (x - i >= 1 && mat[x - i][y])
        return true;

      if (x + i <= n && mat[x + i][y])
        return true;

      if (x - i >= 1 && y - i >= 1 && mat[x - i][y - i])
        return true;

      if (x + i <= n && y + i <= n && mat[x + i][y + i])
        return true;

      if (x + i <= n && y - i >= 1 && mat[x + i][y - i])
        return true;

      if (x - i >= 1 && y + i <= n && mat[x - i][y + i])
        return true;
    }
    return false;
  }

  private static void print() {
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++)
        System.out.print(mat[i][j] ? 1 + " " : 0 + " ");
      System.out.println();
    }
  }

  private static boolean solve(int x) {
    if (x == 0) {
      print();
      return true;
    }
    for (int i = 1; i <= n; i++)
      for (int j = 1; j <= n; j++) {

        if (attacked(i, j))
          continue;
        mat[i][j] = true;

        if (solve(x - 1))
          return true;

        mat[i][j] = false;
      }

    return false;
  }

  public static void main(String[] args) {
    n = 8;
    mat = new boolean[n + 1][n + 1];
    solve(n);
  }
}