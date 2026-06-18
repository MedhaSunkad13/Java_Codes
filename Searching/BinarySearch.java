package Searching;

public class BinarySearch {

    // T.C: O(log n)
    static int binarySearch(int arr[], int target, int low, int high) {
        // int low = 0, high = arr.length-1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // first position where element >= target
    static int getLowerBound(int arr[], int target) {
        int low = 0, high = arr.length - 1;
        // int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= target) {
                // ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
        // return ans;
    }

    // first position where element > target
    static int getUpperBound(int arr[], int target) {
        int low = 0, high = arr.length - 1;

        // int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > target) {
                // ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;

            }
        }
        return low;
    }

    static int countFreq(int[] arr, int target) {
        return getUpperBound(arr, target) - getLowerBound(arr, target);
    }

    static int peakIndexInAMountainArray(int arr[]) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < arr[mid + 1]) {
                // I am at the increasing order part in the array
                low = mid + 1;
            } else {
                // I am at the decreasing order part in the array
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    static int getPivotIndex(int arr[]) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int ans = -1;

        // Sorted Array
        if (arr[low] < arr[high]) {
            return -1;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // We are on the right part of the array (L2)
            if (arr[mid] <= arr[n - 1]) {
                // Move left
                high = mid - 1;
            } else {
                // move right
                ans = mid;
                low = mid + 1;
            }
        }
        return ans; // Or Return high
    }

    static int searchInARotatedSortedArray(int arr[], int target) {
        int pivotIndex = getPivotIndex(arr);

        // If pivotIndex = -1, then array is already sorted
        if (pivotIndex == -1) {
            int ans = binarySearch(arr, target, 0, arr.length - 1);
            return ans;
        } else {
            // If array is rotated and sorted
            int low1 = 0, high1 = pivotIndex;

            if (target >= arr[low1] && target <= arr[high1]) {
                int ans = binarySearch(arr, target, low1, high1);
                return ans;
            }

            // Searching in the L2 part
            int low2 = pivotIndex + 1, high2 = arr.length - 1;

            if (target >= arr[low2] && target <= arr[high2]) {
                int ans = binarySearch(arr, target, low2, high2);
                return ans;
            }
        }
        return -1;
    }

    static int findSqrt(int n) {
        int low = 1, high = n;
        int ans = -1;

        if (n == 0) {
            return 0;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid == n / mid) {
                return mid;
            }

            if (mid > n / mid) {
                high = mid - 1;
            } else {
                ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }

    static boolean isPossible(int arr[], int maxWood, int m) {
        long woodCollected = 0;

        for (int i = 0; i < arr.length; i++) {
            woodCollected += arr[i] - maxWood;

            if (woodCollected >= m) {
                return true;
            }
        }
        return false;
    }

    static int ekoSPOJ(int trees[], int k) {
        int low = 0, high = -1;

        for (int t : trees) {
            high = Math.max(high, t);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(trees, mid, k)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    static boolean isValidAns(int arr[], int totCooks, int totPrata, int timeLimit) {
        int prata_cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            int currCookRank = arr[i];
            int timeTaken = 0;
            int j = 1;

            while (true) {
                timeTaken += currCookRank * j;

                if (timeTaken <= timeLimit) {
                    prata_cnt++;

                    if (prata_cnt >= totPrata) {
                        return true;
                    }

                    j++;
                } else {
                    break;
                }
            }
        }

        return false;
    }

    static int rotiPrata(int cook[], int p, int n) {
        int maxRank = -1;

        for (int i = 0; i < cook.length; i++) {
            maxRank = Math.max(maxRank, cook[i]);
        }

        int low = 0;
        int high = maxRank * (p * (p + 1)) / 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isValidAns(cook, n, p, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    //Brute-Force Approach
    static int rowWithMaximumOnes(int arr[][]) {
        int maxCnt = -1;
        int ans = -1;

        for (int i = 0; i < arr.length; i++) {
            int cnt = 0;
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    cnt++;
                }
            }
            if (cnt > maxCnt) {
                maxCnt = cnt;
                ans = i;
            }
        }
        return ans;
    }

    static int getFirstOccurrenceOf1(int arr[][], int rowInd) {
        int ans = -1;
        // int totRows = arr.length;
        int totCols = arr[0].length;

        //Target = 1;

        //Edge Case: When there are no zeroes inside the row
        // Check the last row of the partcular row and if it is 0 then the whole row has no 1's in it
        if (arr[rowInd][totCols-1] == 0) {
            //To make totCols - firstOccInd zero we need to subtract totCols - totCols so return totcols itself
            return totCols;
        }
        else{
            int low = 0, high = totCols-1;
            while (low <= high) {
                int mid = low + (high - low) / 2;

                if(arr[rowInd][mid] == 1) {
                    ans = mid;
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
        }
       return ans;
    }

    static int rowWithMaximumOnesOptimized(int arr[][]) {
        int totRows = arr.length;
        int totCols = arr[0].length;
        int maxCnt = -1;
        int ans = -1;
        //Go to each row
        //Find first occurrence of 1 in each row using helper function
        //Using first occurrence we can calculate the count of 1 
        //Update the maximum count of 1 in every row by track a variable maxCnt and store row number in ans variable

        for(int i = 0; i < totRows; i++) {
            int firstOccOf1 = getFirstOccurrenceOf1(arr, i);
            //Count the no. of 1's in this row
            int oneCnt = totCols - firstOccOf1;

            if(oneCnt != 0 && oneCnt > maxCnt) {
                maxCnt = oneCnt;
                ans = i;
            }
        }
        return ans;
    }

    //Exponential Search or Doubling Search or Galloping Search
    static int unboundedBinarySearch(int arr[], int target) {
        //If found at first index
        if(arr[0] == target) {
            return 0;
        }

        //Initialize a variable i to 1
        int i = 1;
        while(arr[i] <= target) {
            i *= 2;
        }

        //If arr[i] > target
        if(arr[i] > target) {
            int low = i / 2;
            int high = i;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if(arr[mid] == target) {
                    return mid;
                }
                else if(arr[mid] > target) {
                    //Left mover
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int nums[] = { 1, 4, 7, 9, 11, 15 };
        System.out.println("Target found at " + binarySearch(nums, 4, 0, nums.length - 1));

        int arr[] = { 1, 1, 2, 2, 2, 2, 3 };

        int numbers[] = { 1, 3, 5, 4, 2 };

        System.out.println("Lower bound of the array is: " + getLowerBound(arr, 2));
        System.out.println("Upper bound of the array is: " + getUpperBound(arr, 2));
        System.out.println("Frequency of target element: " + countFreq(arr, 2));
        System.out.println("Peak Element in an array: " + peakIndexInAMountainArray(numbers));

        int a[] = { 50, 60, 70, 10, 20, 30, 40 };
        System.out.println("Pivot index of an array is: " + getPivotIndex(a));

        // Search in rotated sorted array
        System.out.println("Target found at index: " + searchInARotatedSortedArray(a, 10));

        // Square Root
        System.out.println("Square Root of a given number: " + findSqrt(56));

        // Eko SPOJ
        int trees[] = { 20, 15, 10, 17 };
        System.out.println("Maximum Posible answer: " + ekoSPOJ(trees, 7));

        // Roti Prata SPOJ
        int cooks[] = { 1, 2, 3, 4 };
        System.out.println("Total number of parathas: " + rotiPrata(cooks, 10, 4));

        //Debugger
        // System.out.println("Reached here");

        // Row with maximum ones
        int matrix[][] = { { 0, 0, 0, 0, 1, 1 }, { 0, 0, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0, 1 }, {0, 0, 0, 1, 1, 1}, { 0, 1, 1, 1, 1, 1 } };
        // System.out.println("Row with maximum ones: " + rowWithMaximumOnes(matrix));
        System.out.println("Row with maximum ones: " + rowWithMaximumOnesOptimized(matrix));
    }
}
