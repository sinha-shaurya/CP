package revision;

import java.util.Queue;
import java.util.Arrays;
import java.util.LinkedList;

class Pair {
        int first, second;

        Pair(int a, int b) {
            first = a;
            second = b;
        }

        @Override
        public String toString(){
            return String.format("{%d,%d}", first,second);
        }
    }

public class RottenOranges {

    

    static int rottenOrange(int grid[][]) {
        int count = 0;
        int minutes = 0;
        int rotOranges = 0;
        int r = grid.length;
        int c = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        // count number of oranges and add rotten oranges to queue
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] != 0)
                    count += 1;
                if (grid[i][j] == 2)
                    q.add(new Pair(i, j));
            }
        }
        int dx[]={1,-1,0,0};
        int dy[]={0,0,1,-1};
        // process queue for rotten oranges
        while (!q.isEmpty()) {
            //print queue
            System.out.println(Arrays.toString(q.toArray()));
            rotOranges += q.size();
            int size = q.size();
            // add neighbours of each rotten orange to queue
            for (int i = 0; i < size; i++) {
                Pair currentOrange = q.remove();//peek and pop queue head
                // add neighbours in all 4 directions
                for (int j = 0; j < 4; j++) {
                    int x = currentOrange.first + dx[j];
                    int y= currentOrange.second + dy[j];
                    //check for constraints
                    if(x>=0 && y>=0 && x<r && y<c && grid[x][y]==1){
                        q.add(new Pair(x,y));
                        grid[x][y]=2;//mark orange as rotten
                    }
                }
            }
            //add to time if q is not empty since oranges would have been newly rotten
            if(!q.isEmpty())
                minutes+=1;
        }
        System.out.println(rotOranges+" "+count);
        return rotOranges == count ? minutes : -1;

    }

    public static void main(String args[]) {
        int grid[][] = { {0,2,2} };
        System.out.println(RottenOranges.rottenOrange(grid));
    }
}
