package Practice;

import java.util.*;

public class Practice_1 {
    
	public static int longestSubarraySum(int arr[], int k) {
		int max = -1;
		for(int i = 0; i < arr.length; i++) {
			int sum = 0;

			for(int j = i; j < arr.length; j++) {
				sum += arr[j];

				if(sum == k) {
					max = Math.max(max, j-i+1);
				}
			}
		}
		return max;
	}

	public static int longestSubarraySumOptimized(int[] arr, int k) {
		// code here
		// int prefixSum[] = new int[arr.length];
		int maxLen = 0;
		int currSum = 0;

		// prefixSum[0] = arr[0];

		// for(int i = 1; i < prefixSum.length; i++) {
		//     prefixSum[i] = prefixSum[i-1] + arr[i];
		// }

		HashMap<Integer, Integer> map = new HashMap<>();

		map.put(0, -1);
		for(int i = 0; i < arr.length; i++) {
			currSum += arr[i];
			if(!map.containsKey(currSum)) {
				map.put(currSum, i);
			}

			int needed = currSum - k;

			if(map.containsKey(needed)) {
				maxLen = Math.max(maxLen, i - map.get(needed));
			}
		}
		return maxLen;
	}

	public static int[] sortColors(int arr[]) {
		int low = 0, high = arr.length-1;
		int mid = 0;

		while(mid <= high) {
			if(arr[mid] == 0) {
				int temp = arr[low];
				arr[low] = arr[mid];
				arr[mid] = temp;

				low++;
				mid++;
			}
			else if(arr[mid] == 1) {
				mid++;
			}
			else {
				int temp = arr[mid];
				arr[mid] = arr[high];
				arr[high] = temp;

				// mid--;
				high--;
			}
		}
		return arr;
	}

	//Brute force
	public static ArrayList<Integer> twoSum(int arr[], int target) {
		ArrayList<Integer> ls = new ArrayList<>();
		for(int i = 0; i < arr.length; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i] + arr[j] == target) {
					ls.add(i);
					ls.add(j);
				}
			}
		}
		return ls;
	}

	//Optimal Approach
	public static int[] twoSumOptimized(int nums[], int target) {
		// MyCode
		// HashMap<Integer, Integer> map = new HashMap<>();
		// ArrayList<Integer> ls = new ArrayList<>();

		// for(int i = 0; i < arr.length; i++) {
		//     if(map.containsKey(target - arr[i])) {
		//         ls.add(map.get(target - arr[i]));
		//         ls.add(i);
		//     }
		//     else{
		//         map.put(arr[i], i);
		//     }
		// }
		// return ls;

		Map<Integer, Integer> mpp = new HashMap<>();
		int n = nums.length;

		for(int i = 0; i < n; i++) {
			int num = nums[i];
			int moreNeeded = target - num;

			if(mpp.containsKey(moreNeeded)) {
				return new int[] { mpp.get(moreNeeded), i };
			}

			mpp.put(num, i);
		}
		return new int[] { -1, -1 };
	}

	public static int maxConsecutiveOnes(int arr[]) {
		int cnt = 0;
		int maxLen = 0;

		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 1) {
				cnt++;
			}
			else {
				cnt = 0;
			}

			maxLen = Math.max(maxLen, cnt);
		}
		return maxLen;
	}

	public static int greaterThanNBy2(int arr[]) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for(int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		for(Map.Entry<Integer, Integer> e : map.entrySet()) {
			if(e.getValue() > arr.length / 2) {
				return e.getKey();
			}
		}
		return -1;
	}

	public static int[] moveZeroesToEnd(int arr[]) {
		int ans[] = new int[arr.length];

		int index = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != 0) {
				ans[index] = arr[i];
				index++;
			}
		}
		return ans;
	}

	public static void moveZeroesToEndOptimal(int nums[]) {
		int j = -1;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 0) {
				j = i;
				break;
			}
		}
		if(j == -1) {
			return;
		}

		for(int i = j + 1; i < nums.length; i++) {
			if(nums[i] != 0) {
				//swap;
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				j++;
			}
		}
	}

	public static int singleNumber(int arr[]) {
		if(arr.length == 1) {
			return arr[0];
		}
		int n = arr.length;

		for(int i = 0; i < n; i++) {
			int cnt = 0;

			for(int j = 0; j < n; j++) {
				if(arr[i] == arr[j]) {
					cnt++;
				}
			}

			if(cnt == 1) {
				return arr[i];
			}
		}
		return -1;
	}

	public static int singleNumberBetter(int arr[]) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for(int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		for(Map.Entry<Integer, Integer> e : map.entrySet()) {
			if(e.getValue() == 1) {
				return e.getKey();
			}
		}
		return -1;
	}

	public static int singleNumberOptimized(int arr[]) {
		int xorSum = 0;
		for(int i = 0; i < arr.length; i++) {
			xorSum ^= arr[i];
		}
		return xorSum;
	}

	public static boolean linearSearch(int arr[], int x) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == x) {
				return true;
			}
		}
		return false;
	}

	//Brute-Force
	public static int longestConsecutiveSequence(int arr[]) {
	    int n = arr.length;
        if(n == 0) return 0;
        
		int maxLen = -1;
		for(int i = 0; i < n; i++) {
			int cnt = 1;
			int num = arr[i];
			while(linearSearch(arr, num+1) == true) {
				cnt++;
				num = num+1;
			}
			maxLen = Math.max(cnt, maxLen);
		}
		return maxLen;
	}

	public static int longestConsecutiveSequenceBetter(int arr[]) {
	    int n = arr.length;
        if(n == 0) return 0;
        
		Arrays.sort(arr);
		int maxLen = -1;
		int cnt = 1;
		int lastSmallest = Integer.MIN_VALUE;

		for(int i = 0; i < n; i++) {
			if(arr[i]-1 == lastSmallest) {
				cnt++;
				lastSmallest = arr[i];
			}
			else if(arr[i] == lastSmallest) {
				// cnt = cnt;
			}
			else if(arr[i]-1 != lastSmallest) {
				cnt = 1;
				lastSmallest = arr[i];
			}
			maxLen = Math.max(maxLen, cnt);
		}
		return maxLen;
	}
	// 	Interview link (SquareYards)
	// 	https://dev1-interview.urbanmoney.com/MedhaSunkad4413_ai847d1ec7nodejs
	
	public static int longestConsecutiveSequenceOptimized(int arr[]) {
	    int n = arr.length;
        if(n == 0) return 0;
	    
	    HashSet<Integer> set = new HashSet<>();
	    
	    for(int i : arr) {
	        set.add(i);
	    }
	    
	    //Looping through set
	    int longest = 1;
	    for(int num : set) {
	        if(!set.contains(num - 1)) {
	            int cnt = 1;
	            int x = num;
	            
	            while(set.contains(x+1)) {
	                cnt++;
	                x++;
	            }
	            longest = Math.max(cnt, longest);
	        }
	    }
	    return longest;
	}

	public static void main(String[] args) {
		// 		System.out.println("Hello World");
		int arr[] = {1,-1,5,-2,3};
		int k = 3;

		int ar[] = {2, 0, 1, 1, 2, 0, 1, 0, 1};
		sortColors(ar);

		for(int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + " ");
		}
		System.out.println();

		System.out.println("Longest Subarray sum of size k: " + longestSubarraySum(arr, k));

		System.out.println("Longest Subarray sum of size k: " + longestSubarraySumOptimized(arr, k));

		int a[] = {3, 3};
		System.out.println("Two Sum: " + twoSum(a, 6));

		// System.out.println("Two Sum using HashMap: " + twoSumOptimized(a, 6));
		System.out.println("Two Sum using Map: " + Arrays.toString(twoSumOptimized(a, 6)));

		int nums[] = {1, 0, 1, 1, 0, 1, 1, 1, 1};
		System.out.println("Max Consecutive Ones: " + maxConsecutiveOnes(nums));

		int numbers[] = {1,2,1,1,3,1,1,4};
		System.out.println("Majority Element: " + greaterThanNBy2(numbers));

		int array[] = {1, 2, 3, 4};
		// System.out.println("Moving zeroes to end: " + Arrays.toString(moveZeroesToEnd(array)));
		moveZeroesToEndOptimal(array);
		for(int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();

		int list[] = {4, 1, 2, 1, 2};
		// System.out.println("Single Element in an array: " +singleNumber(list));
		// System.out.println("Single Element in an array using map: " +singleNumberBetter(list));
		System.out.println("Single Element in an array using xor: " + singleNumberOptimized(list));

		//Longest Consecutive Sequence(Brute force)
		int Arr[] = {5, 102, 4, 100, 1, 101, 2, 1, 3};
// 		System.out.println("Length of longest consecutive sequence: " + longestConsecutiveSequence(Arr));
// 		System.out.println("Length of longest consecutive sequence using Better Approach: " + longestConsecutiveSequenceBetter(Arr));
        System.out.println("Length of longest consecutive sequence using Optimal Approach: " + longestConsecutiveSequenceOptimized(Arr));
	}
}