/**Solution to Word Break 2
*Link: https://leetcode.com/problems/word-break-ii/
*/
import java.util.*;
import java.io.*;

public class WordBreak {
    public static void main(String[] args) throws IOException {
        String s;
        List<String> wordDict;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        s = in.readLine();
        wordDict = Arrays.asList(in.readLine().split(","));
        List<String> list = wordBreak(s, wordDict);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        List<String> ans = new LinkedList<>();
        dfs(s, dict, "", ans);
        return ans;
    }

    private static void dfs(String s, Set<String> dict, String current, List<String> ans) {
        if (s.length() == 0) {
            // we can traverse no more hence add result to ans
            ans.add(current.trim());// remove trailing space
            return;
        }
        // System.out.println(s);
        // check for prefixes in dict
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (dict.contains(prefix)) {
                dfs(s.substring(i), dict, current + prefix + " ", ans);
            }
        }
    }
}
