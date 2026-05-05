package JCF;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // ArrayList
        ArrayList<Integer> list = new ArrayList<>();

        // Add
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list);

        list.add(40);
        System.out.println(list);

        // Remove
        list.remove(0);
        System.out.println(list);

        // LinkedList
        LinkedList<Integer> ls = new LinkedList<>();
        ls.add(101);
        ls.add(102);
        ls.add(30);

        // addAll
        list.addAll(ls);
        System.out.println(ls);
        System.out.println(list);

        // removeAll
        list.removeAll(ls);
        System.out.println(list);

        // size
        System.out.println(ls.size());

        // clear
        System.out.println("Printing ls: " + ls);
        ls.clear();
        System.out.println("List is cleared! " + ls);
        System.out.println(ls.size());

        // Iterator
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.println("Element: " + it.next());
        }

        // New list
        List<Integer> list2 = new ArrayList<>();
        list2.add(11);
        list2.add(12);
        list2.add(13);

        // get
        System.out.println(list2.get(2));

        // set
        System.out.println("Before Set: " + list2);
        list2.set(1, 15);
        System.out.println("After Set: " + list2);

        // toArray
        Object[] arr = list2.toArray();
        for (Object obj : arr) {
            System.out.println(obj);
        }

        // contains
        boolean isPresent = list2.contains(13);
        System.out.println(isPresent);

        // add more elements
        list.add(60);
        list.add(15);
        list.add(10);
        System.out.println("Printing entire list: " + list);

        // sort descending
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("List after sorting: " + list);

        // ensureCapacity
        ArrayList<Integer> marks = new ArrayList<>();
        marks.ensureCapacity(100);

        System.out.println(list.isEmpty());

        // LinkedList operations again
        ls.addFirst(10);
        ls.addFirst(101);

        ls.addLast(20);
        ls.addLast(111);

        System.out.println(ls);

        ls.removeFirst();
        ls.removeLast();

        System.out.println(ls);

        System.out.println(ls.getFirst());
        System.out.println(ls.getLast());

        System.out.println("Using Peek: " + ls.peek());

        System.out.println("Using Poll: " + ls.poll());

        System.out.println(ls);

        // Stack
        Stack<Integer> st = new Stack<>();
        st.push(25);
        st.push(40);
        st.push(65);

        System.out.println(st);

        System.out.println(st.peek());

        st.pop();

        System.out.println(st.search(30));

        System.out.println(st.isEmpty());

        System.out.println(st);
    }
}