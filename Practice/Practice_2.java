package Practice;

import java.util.*;

class Practice_2 {
    // Brute Force
    public static int lengthOfSmallestSubarray(int arr[], int target) {
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                if (sum >= target) {
                    minLen = Math.min(minLen, j - i + 1);
                }
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return -1;
        }
        return minLen;
    }

    public static int lengthOfSmallestSubarrayOptimized(int arr[], int target) {
        int left = 0, right = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        while (right < arr.length) {
            // Expand
            sum += arr[right];
            // right++;

            // Shrink
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= arr[left];
                left++;
            }
            right++;
        }

        if (minLen == Integer.MAX_VALUE) {
            return -1; // return 0 according to problem statement
        }
        return minLen;
    }

    // Brute Force
    public static int maxSumSubarray(int arr[], int k) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                if (j - i + 1 == k) {
                    maxSum = Math.max(sum, maxSum);
                }
            }
        }
        return maxSum;
    }

    public static int maxSumSubarrayOptimized(int arr[], int k) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int left = 0, right = 0;

        while (right < arr.length) {
            sum += arr[right];

            // Shrink
            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                sum -= arr[left];
                left++;
            }
            right++;
        }
        return maxSum;
    }

    // Brute Force
    public static int subarraySumEqualsK(int arr[], int k) {
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

    // Optimized
    public static int subarraySumEqualsKOptimized(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int currSum = 0;
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];

            int remove = currSum - k;
            if (map.containsKey(remove)) {
                cnt += map.get(remove);
            }

            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        return cnt;
    }

    public static int longestSubstring2DistinctChars(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int maxLen = 0;

        while (right < s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            while (map.size() > 2) {
                char ch = s.charAt(left);

                map.put(ch, map.get(ch) - 1);

                if (map.get(ch) == 0) {
                    map.remove(ch);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }

    public static int longestSubstringKDistinctChars(String s, int K) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int maxLen = 0;

        while (right < s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            while (map.size() > K) {
                char ch = s.charAt(left);

                map.put(ch, map.get(ch) - 1);

                if (map.get(ch) == 0) {
                    map.remove(ch);
                }
                left++;
            }

            if (map.size() == K) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
        }
        return maxLen;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5 };
        int k = 3;
        System.out.println("Maximum sum of any subarray of size exactly k: " + maxSumSubarray(arr, k));
        System.out.println("Maximum sum of any subarray of size exactly k: " + maxSumSubarrayOptimized(arr, k));

        int nums[] = { 5, 1, 1, 2, 4, 4 };
        int target = 7;
        System.out.println("Length of the smallest subarray whose sum is at least " + target + ": "
                + lengthOfSmallestSubarray(nums, target));
        System.out.println("Length of the smallest subarray whose sum is at least " + target + ": "
                + lengthOfSmallestSubarrayOptimized(nums, target));

        int ar[] = { 1, 2, 3, -3, 1, 1, 1, 4, 2, -3 };
        int K = 3;
        System.out.println("Subarray sum equals K: " + subarraySumEqualsK(ar, K));
        System.out.println("Subarray sum equals K: " + subarraySumEqualsKOptimized(ar, K));

        String s = "eceba";
        System.out.println(
                "Longest Substring containing at most 2 distinct characters: " + longestSubstring2DistinctChars(s));

        String str = "aabacbebebe";
        System.out.println(
                "Longest Substring containing exactly K distinct characters: "
                        + longestSubstringKDistinctChars(str, k));
    }
}