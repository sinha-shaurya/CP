import java.util.*;

public class RodCut {
    static int[] dp;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();
        int a[] = new int[n];
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(maxProfit(a, n));
        in.close();
    }

    // Function to calculate max profit from given profits of cut rod
    //Idea is cut at this length and recursively solve for the remaining length
    static int maxProfit(int price[], int n) {
        //recall from memo table
        if(dp[n]!=-1)
            return dp[n];
        int max=Integer.MIN_VALUE;
        int s=0;
        for(int i=0;i<n;i++)
        {
            if(n-i-1>=0)//handles base case here only
                s=Math.max(s,price[i]+maxProfit(price,n-i-1));
        }
        max=Math.max(max,s);
        dp[n]=max;//memoization step
        return max;
    }
}
