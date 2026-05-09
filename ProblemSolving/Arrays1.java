package ProblemSolving;

import java.util.*;

public class Arrays1 {

    public static double findAvg(int arr[]) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        double avg = (sum / arr.length);
        return avg;
    }

    public static int[] multiplyElements(int arr[]) {
        // int orgArr[] = arr;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * 10;
        }

        return arr;
    }

    public static int[] multiplyElements2(int arr[]) {
        int ans[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i] * 10;
        }

        return ans;
    }

    public static int linearSearch(int arr[], int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static int findMax(int arr[]) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];

                // Short Cut
                // max = Math.max(max, arr[i]);
            }
        }

        return max;
    }

    public static int findMin(int arr[]) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {

            // Short Cut
            min = Math.min(min, arr[i]);
        }

        return min;
    }

    public static int[] sumOfPosAndNeg(int arr[]) {
        int negSum = 0;
        int posSum = 0;

        int ans[] = new int[2];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                negSum += arr[i];
            } else {
                posSum += arr[i];
            }
        }

        ans[0] = negSum;
        ans[1] = posSum;

        return ans;
    }

    public static int[] countZeroesAndOnes(int arr[]) {
        int zeroes = 0;
        int ones = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) {
                ones++;
            }
            else{
                zeroes++;
            }
        }

        int ans[] = {zeroes, ones};

        return ans;
    }

    public static int getUnsortedElement(int arr[]) {
        //Incase of Strictly increasing array
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < arr[i-1]) {
                return arr[i];
            }
        }
        return -1;
    }

    public static int[] swapAlternateElements(int arr[]) {
        int temp;
        for(int i = 1; i < arr.length; i+=2) {
            temp = arr[i];
            arr[i] = arr[i-1];
            arr[i-1] = temp;
        }

        return arr;
    }

    public static void findIntersection(int arr1[], int arr2[]) {

        int freq[] = new int[15];

        for(int i = 0; i < arr1.length; i++){
            freq[arr1[i]]++;
        }

        for(int i = 0; i < arr2.length; i++){
            if(freq[arr2[i]] > 0) {
                System.out.print(arr2[i] + " ");
            }
        }
        System.out.println();
    }

    public static int[] alternateExtremeElements(int arr[]) {
        int ans[] = new int[arr.length];

        int low = 0, high = arr.length-1;
        int i = 0, j = i+1;

        while (low < high && j < arr.length) {
            ans[i] = arr[low];
            ans[j] = arr[high];
            i+=2;
            j = i+1;
            low++;
            high--;
        }

        return ans;
    }

    public static void main(String[] args) {

        int nums[] = { 2, 3, 4, 5 };

        System.out.println("Average of array elements: " + findAvg(nums));

        System.out.println("Multiplication of array elements: "
                + Arrays.toString(multiplyElements(nums.clone())));

        // System.out.println("Multiplication using ans array: "
        // + Arrays.toString(multiplyElements2(nums)));

        int res[] = multiplyElements2(nums);
        for (int val : res) {
            System.out.print(val + " ");
        }
        System.out.println();

        int found = linearSearch(nums, 40);

        if (found != -1)
            System.out.println("Element found at index " + found);
        else
            System.out.println("Element not found!");

        System.out.println("Maximum element in an array: " + findMax(nums));

        System.out.println("Minimum element in an array: " + findMin(nums));

        int arr[] = { 2, -5, 7, -1, 0, 4, -9 };
        System.out.println("Sum of positive and negative numbers: " + Arrays.toString(sumOfPosAndNeg(arr)));

        int arr2[] = {0, 0, 1, 1, 0, 1, 0, 0, 1};
        System.out.println("Count of 0's and 1's: " + Arrays.toString(countZeroesAndOnes(arr2)));

        int sortedArr[] = {1, 2, 5, 4, 9, 11};
        System.out.println("Unsorted Element in an array: " + getUnsortedElement(sortedArr));

        System.out.println("Alternately swapped array: " + Arrays.toString(swapAlternateElements(sortedArr)));

        int ar1[] = {1, 2, 4, 5, 7, 9};
        int ar2[] = {2, 5, 4, 6, 9};

        findIntersection(ar1, ar2);

        System.out.println("Alternate Extreme Elements: " + Arrays.toString(alternateExtremeElements(ar1)));
    }
}