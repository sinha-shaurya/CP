import java.io.*;
import java.util.*;

public class WordLadder {
    // container for vertices and their paths from source
    static class node {
        int vertex;
        List<Integer> path;

        node(int vertex, List<Integer> list) {
            this.vertex = vertex;
            this.path = list;
        }

        // get path from source
        List<Integer> getPath() {
            return path;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String beginWord, endWord;
        List<String> wordList;
        beginWord = in.readLine();
        endWord = in.readLine();
        wordList = Arrays.asList(in.readLine().split(","));
        // List<List<String>> ans =
        findLadders(beginWord, endWord, wordList);
        /*
         * for (List<String> l : ans) {
         * System.out.println(Arrays.toString(l.toArray())); }
         */
    }

    // utility function to give diff between strings
    static boolean diff(String a, String b) {
        if (a.length() != b.length())
            return true;
        int d = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                d += 1;
            if (d == 2)
                return false;
        }
        return true;
    }

    // Get list of word ladders for given beginWord and endWord
    public static void findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans;
        // construct adj list
        HashMap<String, LinkedList<String>> adj = new HashMap<>();
        // first add beginWord
        for (int j = 0; j < wordList.size() - 1; j++) {
            String v = wordList.get(j);
            if (!adj.containsKey(beginWord))
                adj.put(beginWord, new LinkedList<>());
            if (!adj.containsKey(v))
                adj.put(v, new LinkedList<>());
            // Bidirectional graph
            if (diff(beginWord, v)) {
                adj.get(beginWord).add(v);
                adj.get(v).add(beginWord);
            }
        }
        for (int i = 0; i < wordList.size(); i++) {
            String u = wordList.get(i);
            for (int j = i + 1; j < wordList.size(); j++) {
                String v = wordList.get(j);
                if (!adj.containsKey(u))
                    adj.put(u, new LinkedList<>());
                if (!adj.containsKey(v))
                    adj.put(v, new LinkedList<>());
                // Bidirectional graph
                if (diff(u, v)) {
                    adj.get(u).add(v);
                    adj.get(v).add(u);
                }
            }
        }
        for (Map.Entry<String, LinkedList<String>> entry : adj.entrySet()) {
            String start = entry.getKey();
            System.out.println(start + ":" + Arrays.toString(entry.getValue().toArray()));
        }

        // return ans;
    }
}
