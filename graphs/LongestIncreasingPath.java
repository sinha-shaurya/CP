/***
 * Solution to Longest Increasing Path Problem
 * Link:https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */
import java.util.*;

public class LongestIncreasingPath {
    static public int longestIncreasingPath(int[][] matrix) {
        int len = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                len = Math.max(len, lisp(matrix, m, n, i, j));
            }
        }
        return len;
    }

    // DP Solution
    static int dp[][];

    static int lisp(int[][] a, int m, int n, int x, int y) {
        if (dp[x][y] != 0)
            return dp[x][y];
        int len = 0;
        int dx[] = { 0, 0, -1, 1 };
        int dy[] = { 1, -1, 0, 0 };

        // try all cases
        for (int i = 0; i < dx.length; i++) {
            int xnew = x + dx[i];
            int ynew = y + dy[i];

            if (xnew >= 0 && xnew < m && ynew >= 0 && ynew < n && a[x][y] < a[xnew][ynew])
                len = Math.max(len, lisp(a, m, n, xnew, ynew));
        }
        dp[x][y] = len + 1;
        return len + 1;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int m,n;
        int[][] matrix;
        m=in.nextInt();
        n=in.nextInt();
        matrix=new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                matrix[i][j]=in.nextInt();
            }
        }

        int longestIncreasingPathLength=longestIncreasingPath(matrix);
        System.out.println(longestIncreasingPathLength);
    }
}
