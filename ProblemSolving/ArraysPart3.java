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

    public static int[] sortColorsOptimized(int arr[]) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;

                low++;
                mid++;

            } else if (arr[mid] == 1) {
                mid++;

            } else {
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;

                high--;
            }
        }

        return arr;
    }

    public static int[] twoSum(int arr[], int target) {
        int ans[] = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> threeSum(int arr[], int target) {
        Set<List<Integer>> output = new HashSet<>();

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == target) {
                        List<Integer> ls = new ArrayList<>();
                        ls.add(arr[i]);
                        ls.add(arr[j]);
                        ls.add(arr[k]);
                        Collections.sort(ls);
                        output.add(ls);
                    }
                }
            }
        }
        return new ArrayList<>(output);
    }

    public static int findFirstRepeating(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i : arr) {
            if (map.get(i) > 1) {
                return i;
            }
        }

        return -1;
    }

    public static int pivotIndex(int[] nums) {
        int leftSum[] = new int[nums.length];
        int rightSum[] = new int[nums.length];

        leftSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i];
        }

        rightSum[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i];
        }

        for (int i = 0; i < leftSum.length; i++) {
            if (leftSum[i] == rightSum[i]) {
                return i;
            }
        }

        return -1;
    }

    public static int[] getMissingAndRepeating(int arr[]) {

        int freq[] = new int[arr.length + 1];

        // Store frequency
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]]++;
        }

        int missing = -1;
        int repeating = -1;

        // Find missing and repeating
        for (int i = 1; i < freq.length; i++) {

            if (freq[i] > 1) {
                repeating = i;
            }

            if (freq[i] == 0) {
                missing = i;
            }
        }

        int ans[] = { repeating, missing };

        return ans;
    }

    // Optimized
    public static List<Integer> findDisappearedNumbers(int arr[]) {
        List<Integer> ans = new ArrayList<>();
        // Marking
        for (int i = 0; i < arr.length; i++) {
            int val = Math.abs(arr[i]);
            int pos = val - 1;

            // Mark if the number is > 0
            if (arr[pos] > 0) {
                arr[pos] *= -1;
            }
        }

        // Traverse an array and if you encounter positive element, add it to the answer
        // array list
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    public static int maxSubarraySum(int arr[]) {
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];

            if (maxi < sum) {
                maxi = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }
        return maxi;
    }

    public static int maxSubarraySumBrute(int arr[]) {

        int maxi = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            int sum = 0;

            for (int j = i; j < arr.length; j++) {

                sum += arr[j];

                maxi = Math.max(sum, maxi);
            }
        }

        return maxi;
    }

    public static List<Integer> sumOfEachRowInAMatrix(int arr[][]) {
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sum = sum + arr[i][j];
            }
            ls.add(sum);
        }
        return ls;
    }

    public static List<Integer> sumOfEachColInAMatrix(int arr[][]) {
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sum = sum + arr[j][i];
            }
            ls.add(sum);
        }
        return ls;
    }

    public static void wavyMatrix(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[j][i] + " ");
                }
                System.out.println();
            } else {
                for (int j = arr[i].length - 1; j >= 0; j--) {
                    System.out.print(arr[j][i] + " ");
                }
                System.out.println();
            }
        }
    }

    public static int[][] transposeOfAMatrix(int arr[][]) {
        if (arr == null || arr.length == 0) {
            return new int[0][0];
        }

        int n = arr.length;
        int m = arr[0].length;

        int transpose[][] = new int[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                transpose[j][i] = arr[i][j];
            }
        }

        return transpose;
    }

    public static void rotateBy90(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;

        // int ans[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                // ans[i][j] = arr[j][i];
                System.out.print(arr[j][i] + " ");
            }
            System.out.println();
        }

        return;
    }

    // Correct Approach
    public static void rotateBy90Deg(int arr[][], int N) {
        // Step-1 Transpose of a matrix
        // In-place transpose has to be done only for upper triangular matrix
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < N; i++) {
            int start = 0, end = N - 1;
            while (start < end) {
                int temp = arr[i][start];
                arr[i][start] = arr[i][end];
                arr[i][end] = temp;

                start++;
                end--;
            }
        }
    }

    public static List<Integer> spiralMatrix(int[][] arr) {
        int n = arr.length, m = arr[0].length;

        List<Integer> ans = new ArrayList<>();

        int startingRow = 0;
        int endingRow = n - 1;
        int startingCol = 0;
        int endingCol = m - 1;

        while (startingRow <= endingRow && startingCol <= endingCol) {

            // Top
            for (int i = startingCol; i <= endingCol; i++) {
                ans.add(arr[startingRow][i]);
            }
            startingRow++;

            // Right
            for (int i = startingRow; i <= endingRow; i++) {
                ans.add(arr[i][endingCol]);
            }
            endingCol--;

            // Bottom
            if (startingRow <= endingRow) {
                for (int i = endingCol; i >= startingCol; i--) {
                    ans.add(arr[endingRow][i]);
                }
            }
            endingRow--;

            // Left
            if (startingCol <= endingCol) {
                for (int i = endingRow; i >= startingRow; i--) {
                    ans.add(arr[i][startingCol]);
                }
            }
            startingCol++;
        }
        return ans;
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

        System.out.println("Sorting 0's and 1's in optimized manner: " + Arrays.toString(sortColorsOptimized(array)));

        System.out.println("Two Sum: " + Arrays.toString(twoSum(arr, 8)));

        int n[] = { -1, 0, 1, 2, -1, -4 };

        System.out.println("Three Sum: ");
        List<List<Integer>> res = threeSum(n, 0);

        for (List<Integer> i : res) {

            for (int j : i) {
                System.out.print(j + " ");
            }

            System.out.println();
        }

        int num[] = { 1, 7, 3, 6, 5, 6 };

        System.out.println("First Repeating Element: " + findFirstRepeating(n));

        System.out.println("Pivot index is: " + pivotIndex(num));

        int a[] = { 1, 4, 4, 5, 7, 2, 6 };
        System.out.println("Missing and repeating element: " + Arrays.toString(getMissingAndRepeating(a)));

        List<Integer> result = findDisappearedNumbers(a);
        for (int i : result) {
            System.out.println("Disappered Number is " + i + " ");
        }
        System.out.println();

        int newArr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println("Max Subarray sum: " + maxSubarraySum(newArr));

        System.out.println("Maximum Subarray sum: " + maxSubarraySumBrute(newArr));

        int mat[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // List<Integer> answer = sumOfEachRowInAMatrix(mat);
        List<Integer> answer = sumOfEachColInAMatrix(mat);
        for (int i : answer) {
            System.out.print(i + " ");
        }
        System.out.println();

        wavyMatrix(mat);

        int matrix[][] = transposeOfAMatrix(mat);
        System.out.println("Transpose of a matrix: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Rotated matrix: ");
        // rotateBy90(mat);

        int N = 3;
        rotateBy90Deg(mat, 3);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

        List<Integer> ls = spiralMatrix(mat);

        for (int val : ls) {
            System.out.print(val + " ");
        }
    }
}
