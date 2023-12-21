import java.util.*;
public class StringAdjacent {
    static class node implements Comparable<node>{
        char c;
        int count;
        node(char c,int count){
            this.c=c;
            this.count=count;
        }

        @Override
        public int compareTo(node other){
            int diff=Integer.compare(this.count, other.count);
            if(diff==0)
                diff=Character.compare(this.c, other.c);
            return -diff;//max Heap
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        HashMap<Character,Integer> hash=new HashMap<>();
        String s=in.nextLine();
        for(int i=0;i<s.length();i++){
            int val=1;
            if(hash.containsKey(s.charAt(i)))
                val=hash.get(s.charAt(i))+1;
            hash.put(s.charAt(i),val);
        }

        PriorityQueue<node> q=new PriorityQueue<>();
        for(Map.Entry<Character,Integer> e:hash.entrySet()){
            q.offer(new node(e.getKey(),e.getValue()));
        }
        //construct word
        String word="";
        char c='\0';
        while(!q.isEmpty()){
            node maxFreq=q.poll();
            char m=maxFreq.c;
            System.out.println(maxFreq.c);
            int f=maxFreq.count;
            word+=m;
            f=f-1;
            if(f>0)
                q.offer(new node(m,f));
            
        }
        System.out.println(word);
        in.close();
    }
}
