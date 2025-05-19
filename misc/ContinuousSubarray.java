//Find out number of continuous subarrays with sum K
import java.io.*;
import java.util.*;

public class ContinuousSubarray {
    
    static int getNumberOfSubarrays(int a[], int k) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int sum = 0;
        int n = 0;
        for (int i : a) {
            sum += i;
            if (sum == k)
                n++;
            if (hash.containsKey(sum - k))
                n += hash.get(sum - k);
            Integer count = hash.get(sum);
            if (count == null)
                hash.put(sum, 1);
            else
                hash.put(sum, 1 + count);

        }
        return n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input[] = in.readLine().split("\\s");
        int a[] = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            a[i] = Integer.parseInt(input[i]);
        }
        int k=Integer.parseInt(in.readLine());
        System.out.println(getNumberOfSubarrays(a, k));
    }
}
