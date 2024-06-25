package ds;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class PriorityQueueImpl {

    class TempClass implements Comparable<TempClass> {

        String name;
        int a;

        public TempClass() {
        }

        public TempClass(String name, int a) {
            this.name = name;
            this.a = a;
        }

        @Override
        public int compareTo(TempClass o) {
            int comp = this.a - o.a;
            if (comp != 0) {
                return comp;
            }
            return this.name.compareTo(o.name);
        }

        @Override
        public String toString() {
            String p = String.format("[Tempclass]%s,%d", this.name, this.a);
            return p;
        }

    }

    void createObjectPQ() {
        PriorityQueue<TempClass> pq = new PriorityQueue<>();
        for (int i = 65; i <= 90; i++) {
            TempClass t = new TempClass(String.valueOf((char) i), i);
            pq.add(t);
        }

        // print
        System.out.println(Arrays.toString(pq.toArray()));

    }

    public static void main(String args[]) {
        // implement priority queue in Java
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // add elements to pq
        for (int i = 0; i < 10; i++) {
            pq.add(i);
        }

        // print PQ
        System.out.println(Arrays.toString(pq.toArray()));

        // declare PQ with decreasing order
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 10; i++) {
            pq2.add(i);
        }

        // print PQ
        System.out.println(Arrays.toString(pq2.toArray()));
        new PriorityQueueImpl().createObjectPQ();
    }
}
