import java.util.*;

public class EditDistance {
    static int min(int x, int y, int z) {
        if (x <= y && x <= z)
            return x;
        if (y <= x && y <= z)
            return y;
        else
            return z;
    }

    static int getEditDistance(String a, String b, int m, int n, int[][] dp) {
        // essentially delete all chars from other string when len of any arg is 0
        if (m == 0)
            return n;
        if (n == 0)
            return m;
        if (dp[m][n] != 0)
            return dp[m][n];
        int ans = 0;
        if (a.charAt(m - 1) == b.charAt(n - 1))
            ans = getEditDistance(a, b, m - 1, n - 1, dp);
        else {
            ans = 1 + min(getEditDistance(a, b, m, n - 1, dp), getEditDistance(a, b, m - 1, n, dp),
                    getEditDistance(a, b, m - 1, n - 1, dp));
        }
        dp[m][n] = ans;
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        int dp[][] = new int[a.length() + 1][b.length() + 1];
        System.out.println(getEditDistance(a, b, a.length(), b.length(), dp));
        in.close();
    }
}
