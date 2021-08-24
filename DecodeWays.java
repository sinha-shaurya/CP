import java.io.*;
import java.util.*;
class DecodeWays {
    static int dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        dp = new int[s.length() + 1];
        Arrays.fill(dp,-1);
        int len=s.length();
        int ways=decodeWays(s, 0, len);
        System.out.println(ways);
    }

    static int decodeWays(String s, int start, int len) {
        if (start >= len)
            return 1;
        if (dp[start] != -1)
            return dp[start];

        int total = 0;
        if(start+1<=len)
        {
            String single=s.substring(start,start+1);
            if(isValid(single))
                total+=decodeWays(s, start+1, len);
        }

        if(start+2 <=len){
            String pair=s.substring(start,start+2);
            if(isValid(pair))
                total+=decodeWays(s, start+2, len);
        }
        dp[start] = total;
        return total;
    }

    static boolean isValid(String s) {
        if (s.length() == 0 || s.startsWith("0"))
            return false;
        int value = Integer.parseInt(s);
        return (value >= 1 && value <= 26);
    }
}