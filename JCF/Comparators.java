package JCF;

import java.util.*;

public class Comparators {

    public static void main(String[] args) {

        List<Integer> ls = new ArrayList<>();

        ls.add(13);
        ls.add(9);
        ls.add(4);
        ls.add(15);

        Collections.sort(ls);
        System.out.println(ls);

        Collections.sort(ls, Collections.reverseOrder());
        System.out.println(ls);

        // Student list
        List<College> students = new ArrayList<>();

        students.add(new College(15, "Tapu", 50));
        students.add(new College(15, "Sonu", 45));
        students.add(new College(15, "Goli", 80));
        students.add(new College(15, "Pinku", 60));
        students.add(new College(14, "Gogi", 55));

        // Sort (uses compareTo from College)
        Collections.sort(students);

        System.out.println(students);
    }
}