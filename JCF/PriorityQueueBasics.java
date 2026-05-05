package JCF;

import java.util.*;

public class PriorityQueueBasics {
    public static void main(String[] args) {

                                                //Comparator
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        // Default behaviour of priority queue is less value has more priority, i.e., 10
        // has the highest priority and 40 has the lowest priority
        pq.offer(40);
        pq.offer(10);
        pq.offer(30);
        pq.offer(20);

        System.out.println(pq);

        //Poll
        System.out.println(pq.poll());

        // If u want to change the default behaviour giving highest priority to the highest value the add comparator
        // (a, b) -> b - a
        //Default behaviour of a priority queue is similar to minHeap and after adding comparator it becomes maxHeap
    }
}
