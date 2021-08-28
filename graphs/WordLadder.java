/**
 * Solution to Word Ladder 2: https://leetcode.com/problems/word-ladder-ii/
 */
import java.io.*;
import java.util.*;

public class WordLadder {
    // container for vertices and their paths from source
    static class node {
        String vertex;
        List<String> path;

        node(String vertex, List<String> list) {
            this.vertex = vertex;
            this.path = list;
        }

        // get path from source
        List<String> getPath() {
            return path;
        }

        void addNode(String loc) {
            path.add(loc);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String beginWord, endWord;
        List<String> wordList;
        beginWord = in.readLine();
        endWord = in.readLine();
        wordList = Arrays.asList(in.readLine().split(","));
        List<List<String>> ans = findLadders(beginWord, endWord, wordList);
        for (List<String> list : ans) {
            System.out.println(Arrays.toString(list.toArray()));
        }

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
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        LinkedList<List<String>> ans = new LinkedList<>();
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
        Queue<node> q = new LinkedList<>();
        HashMap<String, Boolean> visited = new HashMap<>();

        node start = new node(beginWord, new ArrayList<String>());
        start.addNode(beginWord);
        q.add(start);
        visited.put(beginWord, true);
        while (!q.isEmpty()) {
            // System.out.println("Inside BFS");

            // System.out.println();
            node v = q.poll();
            visited.put(v.vertex, true);
            // check for neighbours of q
            if (adj.containsKey(v.vertex)) {
                // System.out.println(Arrays.toString(adj.get(v.vertex).toArray()));
                for (String u : adj.get(v.vertex)) {
                    // if we have reached our end gotta add the solution anyway
                    if (u.equals(endWord)) {
                        List<String> path = new ArrayList<String>(v.getPath());
                        path.add(endWord);
                        // System.out.println(Arrays.toString(path.toArray()));
                        ans.add(path);
                        q.add(new node(u, path));
                    } else {
                        if (!visited.containsKey(u)) {
                            List<String> path = new ArrayList<String>(v.getPath());
                            path.add(u);
                            q.add(new node(u, path));
                            
                        }
                    }
                }
            }
        }
        /*
         * for(List<String> list:ans){
         * System.out.println(Arrays.toString(list.toArray())); }
         */
        int minPathLength = Integer.MAX_VALUE;
        for (List<String> path : ans) {
            minPathLength = Math.min(minPathLength, path.size());
        }
        LinkedList<List<String>> min = new LinkedList<>();
        for (List<String> i : ans) {
            if (i.size() == minPathLength) {
                min.add(i);
            }
        }
         Set<List<String>> set=new HashSet<>(min);
        min=new LinkedList<>(set);
        return min;
    }
}
