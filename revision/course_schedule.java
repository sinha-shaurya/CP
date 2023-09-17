

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class CourseSchedule {


    static boolean canComplete(int numCourses, int[][] prerequisites) {
        // generate graph
        LinkedList<Integer> adj[] = new LinkedList[numCourses];
        Queue<Integer> q = new LinkedList<>();
        int indegree[] = new int[numCourses];
        // construct graph
        for (int i = 0; i < numCourses; i++) {
            int next = prerequisites[i][0];
            int prev = prerequisites[i][1];
            System.out.println("Prev" + prev + "Next:" + next);
            if(adj[prev]==null)
                adj[prev]=new LinkedList<>();
            adj[prev].add(next);
        }
        // get indegree
        for (int i = 0; i < numCourses; i++) {
            for (int j : adj[i]) {
                indegree[j]++;
            }
        }
        for (int i : indegree) {
            if (i == 0)
                q.offer(i);
        }
        while (!q.isEmpty()) {
            // add neighbours
            int node = q.remove();
            for (int i : adj[node]) {
                indegree[i]--;
                if (indegree[i] == 0)
                    q.offer(i);
            }
        }
        for (int i : indegree) {
            if (i != 0)
                return false;
        }
        return true;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //construct graph
        List<LinkedList<Integer>> adj=new ArrayList<>(numCourses);
        //initialise graph
        for(int i=0;i<numCourses;i++){
            adj.add(new LinkedList<Integer>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int prev=prerequisites[i][1];
            int next=prerequisites[i][0];
            //add edge to graph
            adj.get(prev).add(next);
        }
        int indegree[]=new int[numCourses];
        LinkedList<Integer> ans=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
                q.offer(i);
        }
        while(!q.isEmpty()){
            int node=q.remove();
            ans.add(node);
            for(int i:adj.get(node)){
                indegree[i]--;
                if(indegree[i]==0)
                    q.offer(i);
            }
        }
        if(ans.isEmpty())
            return new int[0];
        else 
            {
                System.out.println(Arrays.toString(ans.toArray()));
                int result[]=new int[numCourses];
                for(int i=0;i<numCourses;i++){
                    result[i]=ans.get(i);
                }
                return result;
            }
    }
    public static void main(String[] args) {
        int courses[][]={{1,0}};
        int numCourses =2;
        System.out.println(canComplete(numCourses, courses));
    }
}