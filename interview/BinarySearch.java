import java.util.*;

class BinarySearch {

    static int bsearch(int a[], int lo, int hi, int target) {
        if (lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        // System.out.printf("%d %d %d\n",lo,hi,mid);
        if (a[mid] == target)
            return mid;
        else if (a[mid] > target)
            return bsearch(a, lo, mid - 1, target);
        else if (a[mid] < target)
            return bsearch(a, mid + 1, hi, target);
        return -1;
    }

    // iterative binary search
    static int bsearch(int[] a, int target) {
        int lo = 0;
        int hi = a.length - 1;
        int mid = -1;

        while (lo <= hi) {

            mid = lo + (hi - lo) / 2;
            if (a[mid] == target)
                return mid;
            else if (a[mid] < target)
                lo = mid + 1;
            else if (a[mid] > target)
                hi = mid - 1;
        }
        return -1;
    }

    //replace >= with just > for Upper Bound
    static int lowerBound(int a[], int target) {
        int index = a.length;

        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] >= target) {
                index = mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int a[] = { 1, 4, 5, 6, 7 };
        System.out.println(lowerBound(a, 13));
    }
}