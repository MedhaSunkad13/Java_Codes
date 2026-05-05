package JCF;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackBasics {
    public static void main(String[] args) {
        Deque<Integer> st = new ArrayDeque<>();

        //Push
        st.push(12);
        st.push(15);
        st.push(18);

        //Peek
        System.out.println(st.peek());

        //Pop
        st.poll();
        st.pop();

        System.out.println(st);
    }
}
