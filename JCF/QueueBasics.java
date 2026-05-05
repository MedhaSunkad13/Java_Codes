package JCF;

import java.util.*;

public class QueueBasics {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        // Insertion
        q.add(10);
        q.add(20);
        q.add(30);

        //Offer
        q.offer(45);
        q.offer(15);

        //Remove
        q.remove();
        q.poll();
        System.out.println(q.peek());

        System.out.println(q);

    }

}
