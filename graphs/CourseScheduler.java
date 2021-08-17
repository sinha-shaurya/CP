/**
 * Solution to Leetcode course scheduler problem
 * Link: https://leetcode.com/problems/course-schedule/
 * ToDo: Complete IO for this problem
 */
import java.util.*;

class CourseScheduler {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        int n = prerequisites.length;
        if (numCourses == 0 || n == 0)
            return true;
        for (int a[] : prerequisites) {
            if (adj.containsKey(a[1]))
                adj.get(a[1]).add(a[0]);
            else {
                ArrayList<Integer> l = new ArrayList<>();
                l.add(a[0]);
                adj.put(a[1], l);
            }
        }
        //Use Kahn's algorithm to find if there exists a cycle
        List<Integer> topo = new LinkedList<>();
        int indegree[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (adj.containsKey(i)) {
                for (Integer v : adj.get(i)) {
                    indegree[v]++;
                }
            }

        }
        // System.out.print(Arrays.toString(indegree));
        // check for cycle
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }
        while (!q.isEmpty()) {
            int p = q.poll();
            topo.add(p);
            if (adj.containsKey(p)) {
                for (int i : adj.get(p)) {
                    indegree[i]--;
                    if (indegree[i] == 0)
                        q.offer(i);
                }
            }
        }
        return topo.size() == numCourses;
    }
}