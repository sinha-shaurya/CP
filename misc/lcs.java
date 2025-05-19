//compute longest common subsequence for 2 strings
import java.io.*;

class LCS {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String x, y;
        x = in.readLine();
        y = in.readLine();
        System.out.println(lcs(x, y, x.length(), y.length()));
    }

    static int[][] dp = new int[1000][1000];

    // function to calculate length of longest common subsequence
    static int lcs(String x, String y, int lengthx, int lengthy) {
        // check for answer in dp matrix
        if (lengthx == 0 || lengthy == 0)
            return 0;
        //check dp matrix
        if (dp[lengthx][lengthy] != 0)
            return dp[lengthx][lengthy];
        // if last characters are same
        if (x.charAt(lengthx - 1) == y.charAt(lengthy - 1)) {
            // x = x.substring(0, x.length() - 1);
            // y = y.substring(0, y.length() - 1);
            dp[lengthx][lengthy] = 1 + lcs(x, y, lengthx - 1, lengthy - 1);
        } else
            dp[lengthx][lengthy] = Math.max(lcs(x, y, lengthx - 1, lengthy), lcs(x, y, lengthx, lengthy - 1));
        return dp[lengthx][lengthy];
    }
}