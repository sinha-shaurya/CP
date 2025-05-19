import java.util.*;

public class SlidingWindow {
    static List<Integer> SlidingWindowMaximum(int a[], int k) {
        List<Integer> max = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        int currMax = a[0];
        // find currMax
        for (int i = 0; i < k; i++) {
            currMax = Math.max(currMax, a[i]);
            q.offer(a[i]);
        }
        max.add(currMax);
        // iterate over rest of array
        for (int i = k; i < a.length; i++) {
            int x = q.poll();
            q.add(a[i]);
            // case 1 : max is removed,recompute max
            if (currMax == x) {
                currMax = getMaxQueue(q);
                max.add(currMax);
            } else {
                currMax = Math.max(currMax, a[i]);
                max.add(currMax);
            }
            System.out.println(Arrays.toString(max.toArray()));
        }
        return max;
    }

    // utility function to calculate max in queue
    static int getMaxQueue(Queue<Integer> queue) {
        int max = Integer.MIN_VALUE;
        for (int i : queue) {
            max = Math.max(max, i);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        /*
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        */
        int n=8;
        int k=3;
        int a[]={1,2,3,1,4,5,2,3,6};
        System.out.println(Arrays.toString(SlidingWindowMaximum(a, k).toArray()));

        in.close();
    }
}
