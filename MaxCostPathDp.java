import java.util.*;

public class MaxCostPathDp {
    static int[][] dp = new int[1000][1000];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, m;
        //Inputs
        /*
         * n = in.nextInt();
         * rows m = in.nextInt();// cols int cost[][] = new
         * int[n][m]; for (int i = 0; i < n; i++) { for (int j = 0; j < m; j++) {
         * cost[i][j] = in.nextInt(); } }
         */
        n = 4;
        m = 4;
        // int[][] cost = { { 1, 3, 1, 2, 6 }, { 9, 2, 5, 4, 15 }, { 8, 9, 6, 7, 1 }, {
        // 2, 7, 1, 5, 3 },
        // { 8, 2, 6, 1, 9 } };
        int cost[][] = { { 5, 6, 1, 7 }, { -2, 10, 8, -1 }, { 3, -7, -9, 11 }, { 12, -4, 2, 6 } };
        System.out.println(maxCostPath(cost, n, m));
        /*
         * for(int i=0;i<10;i++){ for(int j=0;j<10;j++){ if(dp[i][j]!=0)
         * System.out.print(dp[i][j]+" "); } System.out.println(); }
         */

        in.close();
    }

    static int maxCostPath(int cost[][], int n, int m) {
        int minCost = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            minCost = Math.max(minCost, getCost(cost, n, m, 0, i));
            // System.err.println(cost[0][i]);
        }
        return minCost;
    }

    static int getCost(int a[][], int row, int col, int x, int y) {
        if (x == row - 1)
            return a[x][y];
        if(dp[x][y]!=0)
            return dp[x][y];
        int maxCost = -(int) (1e9 + 7);
        int dx[] = { 1, 1 };
        int dy[] = { -1, 1 };
        int cost = 0;
        for (int i = 0; i < dx.length; i++) {
            int xfinal = x + dx[i];
            int yfinal = y + dy[i];
            if (xfinal >= 0 && xfinal < row && yfinal < col && yfinal >= 0)
                cost = a[x][y] + getCost(a, row, col, xfinal, yfinal);
        }
        maxCost = Math.max(cost, maxCost);
        dp[x][y]=maxCost;
        return maxCost;

    }
}
