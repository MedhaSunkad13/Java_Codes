package JCF;

import java.util.*;

public class HashSetBasics {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        //Insert
        set.add(10);
        set.add(20);
        set.add(10);
        set.add(30);
        set.add(50);
        set.add(30);
        set.add(40);

        System.out.println("Printing HashSet: " + set);

        //LinkedHashSet

        Set<Integer> st = new LinkedHashSet<>();
        
        // Linked HashSet preserves insertion order
        //Insert
        st.add(50);
        st.add(40);
        st.add(20);
        st.add(10);
        st.add(30);
        st.add(20);
        st.add(40);
        

        System.out.println("Printing LinkedHash Set: " + st);

        //TreeSet
        Set<Integer> s = new TreeSet<>();

        //Insertion
        // TreeSet returns the elements in the sorted order
        s.add(10);
        s.add(20);
        s.add(10);
        s.add(30);
        s.add(20);
        s.add(40);
        s.add(50);

        System.out.println("Printing TreeSet: " + s);

        //Retain all
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);

        set2.add(3);
        set2.add(4);
        set2.add(6);
        set2.add(7);

        //Intersection
        // System.out.println(set1.retainAll(set2)); // returns true
        System.out.println(set1);
        set1.retainAll(set2);
        System.out.println(set1);

        System.out.println();

        HashSet<Student> hs = new HashSet<>();

        Student s1 = new Student(1, "Pinda");
        Student s2 = new Student(1, "Pinda");
        Student s3 = new Student(1, "Pinda");

        hs.add(s1);
        hs.add(s2);
        hs.add(s3);

        System.out.println(hs);
    }
}
