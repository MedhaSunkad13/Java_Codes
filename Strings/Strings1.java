package Strings;

// import java.util.*;

class Strings1 {

    public static String reverseWordsInAString(String s) {
        // String newStr = s.strip();
        StringBuilder sb = new StringBuilder();

        int i = s.length()-1;

        while(i >= 0) {
            //Remove trailing spaces
            // To avoid this loop you can use strip method
            while(i >= 0 && s.charAt(i) == ' ') {
                i--;
            }

            int j = i;

            while(j >= 0 && s.charAt(j) != ' ') {
                j--;
            }

            sb.append(s.substring(j+1, i+1));

            //Skip extra spaces
            while(j >= 0 && s.charAt(j) == ' ') {
                j--;
            }

            if(j >= 0) {
                sb.append(' ');
            }

            i = j;
        }

        return sb.toString();
    }

    public static char getMaxOccuringChar(String s) {
        int freq[] = new int[26];
        int maxFreq = Integer.MIN_VALUE;
        char ans = 'a';
        
        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < freq.length; i++) {
            if(freq[i] > maxFreq) {
                maxFreq = freq[i];
                ans = (char)(i + 'a');
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "a good   example";
        System.out.println("Reversed String: " + reverseWordsInAString(str));

        String s = "testsample";
        System.out.println("Most frequent character: " + getMaxOccuringChar(s));
    }
}