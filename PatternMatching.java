//Karp Rabin Pattern matching
import java.util.*;

public class PatternMatching {
    static int d = 256;// base value

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s, pattern;
        s = in.nextLine();
        pattern = in.nextLine();
        System.out.println(patternSearch(s, pattern));
        in.close();
    }

    static int patternSearch(String s, String pattern) {
        int q = 257;
        int n = s.length();
        int m = pattern.length();
        int matches = 0;
        int hashString, hashPattern;
        hashString = 0;
        hashPattern = 0;
        int h = 1;

        // Calculate h=Math.pow(d,m-1)%q
        // Using this method in case m is large
        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        // h= (d^m-1)%q
        // calculate hash values of first window
        for (int i = 0; i < m; i++) {
            hashPattern = (d * hashPattern + pattern.charAt(i)) % q;
            hashString = (d * hashString + s.charAt(i)) % q;
        }

        for (int i = 0; i < n - m; i++) {
            if (hashPattern == hashString) {
                /*
                //check character by character
                int j;
                for(j=0;j<m;j++){
                    if(pattern.charAt(j)!=s.charAt(i+j))
                        break;
                }
                if(j==m){
                    matches+=1;
                }*/
                if(s.substring(i,i+m).equals(pattern))
                    matches+=1;
            }
            if (i < n - m) {
                hashString = ((d * (hashString - s.charAt(i) * h)) + s.charAt(i + m)) % q;
                if (hashString < 0)
                    hashString += q;
            }
        }
        return matches;
    }
}
