package ProblemSolving;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ArrayManipulation {

    public static int[] reverseArray(int arr[]) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;

            low++;
            high--;
        }

        return arr;
    }

    public static int[] shiftBy1Pos(int arr[]) {
        int lastElement = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            arr[i + 1] = arr[i];
        }

        arr[0] = lastElement;

        return arr;
    }

    public static int findMode(int arr[]) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int maxFreq = -1;
        int mode = -1;

        // Find highest frequency element
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {

            if (e.getValue() > maxFreq) {
                maxFreq = e.getValue();
                mode = e.getKey();
            }
        }

        return mode;
    }

    public static int[] getHighestAndLowestFrequency(int arr[]) {
        int maxFreq = -1, minFreq = 10000;
        int maxVal = -1, minVal = -1;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > maxFreq) {
                maxFreq = e.getValue();
                maxVal = e.getKey();
            }

            if (e.getValue() < minFreq) {
                minFreq = e.getValue();
                minVal = e.getKey();
            }
        }

        int ans[] = { minVal, maxVal };

        return ans;
    }

    public static void reverse(int arr[], int low, int high) {

        while (low < high) {

            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;

            low++;
            high--;
        }
    }

    // Function to rotate an array by k elements in clockwise direction
    public static void rotateRight(int arr[], int k) {

        int n = arr.length;

        k = k % n;

        // Step 1: Reverse last k elements
        reverse(arr, n - k, n - 1);

        // Step 2: Reverse first n-k elements
        reverse(arr, 0, n - k - 1);

        // Step 3: Reverse whole array
        reverse(arr, 0, n - 1);
    }

    // Function to rotate an array by d elements in counter-clockwise direction.
    public static void rotateLeft(int arr[], int d) {
        int n = arr.length;

        d = d % n; // if d>n
        if (d == 0)
            return;

        // Step 1: Reverse first d elements
        reverse(arr, 0, d - 1);

        // Step 2: Reverse remaining n-d elements
        reverse(arr, d, n - 1);

        // Step 3: Reverse the whole array
        reverse(arr, 0, n - 1);
    }

    public static int[] getUnion(int arr1[], int arr2[]) {

        HashSet<Integer> set = new HashSet<>();

        // Add arr1 elements
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        // Add arr2 elements
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }

        int ans[] = new int[set.size()];

        int idx = 0;

        for (int x : set) {
            ans[idx++] = x;
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 4, 7, 5, 9, 11 };

        int numbers[] = { 5, 2, 3, 2, 3, 1, 2, 9, 1, 5 };

        System.out.println("Reversed Array: " + Arrays.toString(reverseArray(nums)));

        System.out.println("Shifted Array: " + Arrays.toString(shiftBy1Pos(nums)));

        System.out.println("Mode in the array: " + findMode(numbers));

        System.out.println(
                "Min and Max Frequency in an Array: " + Arrays.toString(getHighestAndLowestFrequency(numbers)));

        rotateRight(numbers, 2);

        rotateLeft(numbers, 2);

        System.out.println("Union of array elements: " + Arrays.toString(getUnion(nums, numbers)));
    }
}