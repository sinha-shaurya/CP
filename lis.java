
//calculate longest increasing subsequence of a given string
//DP only Solution
import java.io.*;
import java.util.*;

public class lis {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(longestIncreasingSubsequence(a, n));
        in.close();
    }

    // dp solution
    static int longestIncreasingSubsequence(int a[], int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            // at each position i check if it can be included in previous
            // longest increasing subsequence
            // or new subsequence has to be started
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
        }
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
