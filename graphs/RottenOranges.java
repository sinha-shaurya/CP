import java.io.*;
import java.util.*;

public class RottenOranges {

    //class to store coordinates 
    static class Pair {
        int first, second;

        Pair(int a, int b) {
            this.first = a;
            this.second = b;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m, n;
        m = in.nextInt();
        n = in.nextInt();
        int a[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = in.nextInt();
            }
        }
        System.out.println(timeRot(a));
        in.close();
    }

    static int timeRot(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int r = grid.length;
        int c = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int count = 0;// count of all oranges
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] != 0)
                    count += 1;
                //push coordinates of all rotten oranges
                if (grid[i][j] == 2)
                    q.add(new Pair(i, j));
            }
        }
        //return 0 when no oranges are present
        if(count==0)
            return 0;
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        int minutes = 0;
        int rotOranges = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            rotOranges += size;
            //for each rotten orange, rot the neighbours 
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                for (int j = 0; j < 4; j++) {
                    int x = p.first + dx[j];
                    int y = p.second + dy[j];
                    if (x < 0 || y < 0 || x >= r || y >= c || grid[x][y] == 0 || grid[x][y] == 2)
                        continue;// do nothing
                    grid[x][y] = 2;
                    q.add(new Pair(x, y));
                }
            }
            if (q.size() != 0)
                minutes += 1;
        }
        return count == rotOranges ? minutes : -1;
    }
}
