package JCF;

import java.util.*;

public class ArrayDequeBasics {

    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();

        //Insert
        dq.add(10);
        dq.offer(20);
        dq.offerFirst(5);
        dq.offerLast(35);

        System.out.println(dq);

        dq.pollLast();
        dq.pollFirst();

        //Peek
        System.out.println(dq.peekFirst());
        System.out.println(dq.peekLast());

        System.out.println(dq.size());

        //Clear
        dq.clear();

        System.out.println(dq);
    }
}