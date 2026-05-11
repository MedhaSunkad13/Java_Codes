package ProblemSolving;

import java.util.*;

public class ArraysPart3 {

    public static int[] sort0sAnd1s(int arr[]) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            if (arr[low] == 1 && arr[high] == 0) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }

            if (arr[high] == 1) {
                high--;
            }

            if (arr[low] == 0) {
                low++;
            }
        }
        return arr;
    }

    public static int findMissing(int arr[]) {
        int xorSum = 0;
        for (int i = 0; i < arr.length; i++) {
            xorSum = xorSum ^ arr[i];
        }

        for (int i = 0; i <= arr.length; i++) {
            xorSum = xorSum ^ i;
        }

        return xorSum;
    }

    public static int findUniqueElement(int arr[]) {
        int xorSum = 0;
        for (int i = 0; i < arr.length; i++) {
            xorSum ^= arr[i];
        }
        return xorSum;

    }

    public static ArrayList<Integer> sortColors(int arr[]) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> ls = new ArrayList<>();

        // Store frequencies
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // Add elements according to frequency
        for (int key : map.keySet()) {

            int freq = map.get(key);

            for (int i = 0; i < freq; i++) {
                ls.add(key);
            }
        }

        return ls;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 0, 1, 1, 0, 0, 1, 0 };
        System.out.println("Sorted 0's and 1's : " + Arrays.toString(sort0sAnd1s(nums)));

        int arr[] = { 2, 0, 1, 3, 5 };
        System.out.println("Missing element: " + findMissing(arr));

        int ar[] = { 2, 2, 0, 0, 1, 3, 5, 5, 3 };
        System.out.println("Unique Element: " + findUniqueElement(ar));

        int array[] = { 0, 1, 0, 2, 1, 0, 2, 1, 1, 0 };
        System.out.println("Sorting 0's, 1's and 2's: ");
        ArrayList<Integer> ans = sortColors(array);

        for (int val : ans) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
