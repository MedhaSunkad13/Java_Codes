package Practice;

import java.util.HashMap;

public class Practice_3 {

    public static int countSubarraysSumEqualsK(int arr[], int k) {
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                if (sum == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static int cntSubarrays(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0;
        int cnt = 0;
        // Put 0 and it's count in the map
        map.put(0, 1);

        for (int i = 0; i < arr.length; i++) {

            prefixSum += arr[i];

            if (map.containsKey(prefixSum - k)) {
                cnt += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return cnt;
    }

    public static int longestSubarrayWithSumK(int arr[], int k) {
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                if (sum == k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    public static int longestSubarrayWithSumKOptimized(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;

        // Put 0 and its index -1 in the map
        map.put(0, -1);

        for (int i = 0; i < arr.length; i++) {

            // Calculate sum at every index
            prefixSum += arr[i];

            if (map.containsKey(prefixSum - k)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum - k));
            }

            // Put every prefix sum inside the map
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        return maxLen;
    }

    public static int subarraySumDivisibleByK(int[] arr, int k) {
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                if (sum % k == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static int subCount(int[] arr, int k) {

        HashMap<Long, Integer> map = new HashMap<>();

        int cnt = 0;
        long prefixSum = 0;

        map.put(0L, 1);

        for (int i = 0; i < arr.length; i++) {

            prefixSum += arr[i];

            long rem = prefixSum % k;

            if (rem < 0) {
                rem += k;
            }

            cnt += map.getOrDefault(rem, 0);

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return cnt;
    }

    public static int binarySubarraySum(int[] arr, int k) {
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                if (sum == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static int binarySubarraySumOptimized(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int cnt = 0;
        int prefixSum = 0;

        // Put 0 and 1 in the map
        map.put(0, 1);

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (map.containsKey(prefixSum - k)) {
                cnt += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 2, -2, -20, 10 };
        System.out.println("Count of subarrays whose sum equals k is: " + countSubarraysSumEqualsK(arr, -10));
        System.out.println("Count of subarrays whose sum is equal to K (Optimized Version): " + cntSubarrays(arr, -10));

        int nums[] = { 10, 5, 2, 7, 1, -10 };
        System.out.println("Longest subarray with sum equal to K: " + longestSubarrayWithSumK(nums, 15));
        System.out.println(
                "Longest subarray with sum equal to K (Optimized): " + longestSubarrayWithSumKOptimized(nums, 15));

        int ar[] = { 4, 5, 0, -2, -3, 1 };
        System.out.println("Count of all subarrays whose sum is divisible by k: " + subarraySumDivisibleByK(ar, 5));
        System.out.println("Count of all subarrays whose sum is divisible by k: " + subCount(ar, 5));

        int numbers[] = { 1, 1, 0, 1, 1 };
        System.out.println("Binary Subarray with sum: " + binarySubarraySum(numbers, 2));
        System.out.println("Binary Subarray with sum (Optimized): " + binarySubarraySumOptimized(numbers, 2));
    }
}
