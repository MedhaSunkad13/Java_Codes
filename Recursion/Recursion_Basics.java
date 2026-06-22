package Recursion;

public class Recursion_Basics {

    public static void printNumbers(int i, int arr[]) {
        if (i == arr.length) {
            return;
        }

        System.out.print(arr[i] + " ");
        printNumbers(i + 1, arr);
    }

    public static void printNumbersReverse(int i, int arr[]) {
        if (i < 0) {
            return;
        }

        System.out.print(arr[i] + " ");
        printNumbersReverse(i - 1, arr);
    }

    public static int calcSum(int i, int arr[]) {
        if (i == arr.length) {
            return 0;
        }

        return arr[i] + calcSum(i + 1, arr);
    }

    public static int calcProduct(int i, int arr[]) {
        if (i == arr.length) {
            return 1;
        }

        return arr[i] * calcProduct(i + 1, arr);
    }

    public static void printName(int n) {
        if (n == 0) {
            return;
        }

        System.out.println("Medha Sunkad");
        printName(n - 1);
    }

    public static void printNumbers1toN(int n) {
        if (n == 0) {
            return;
        }

        printNumbers1toN(n - 1);
        System.out.println(n + " ");

    }

    public static void printNumbersNto1(int n) {
        if (n == 0) {
            return;
        }

        System.out.println(n + " ");
        printNumbersNto1(n - 1);

    }

    //Best Approach to find Max or min
    public static int findMax(int i, int[] arr) {

        if (i == arr.length - 1) {
            return arr[i];
        }

        return Math.max(arr[i], findMax(i + 1, arr));
    }

    public static void findMin(int i, int[] arr, int min) {
        // Base Case
        if (i == arr.length) {
            System.out.println("Min element: " + min);
            return;
        }

        if (arr[i] < min) {
            min = arr[i];
        }

        findMin(i + 1, arr, min);
    }

    //Linear Search
    public static int findElement(int i, int[] arr, int target) {
        //Base Case
        if(i == arr.length) {
            return -1;
        }

        if(arr[i] == target) {
            return i;
        }

        return findElement(i+1, arr, target);
    }

    public static int binarySearch(int low, int high, int[] arr, int target) {
        if(low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        if(arr[mid] == target) {
            return mid;
        }
        else if(arr[mid] > target) {
            return binarySearch(low, mid - 1, arr, target);
        }
        else {
            return binarySearch(mid + 1, high, arr, target);
        }
    }

    // return myContribution + recursiveAnswer;
    public static int countTarget(int i, int[] arr, int target) {
        if(i == arr.length) {
            return 0;
        }

        return (arr[i] == target ? 1 : 0) + countTarget(i + 1, arr, target);
    }

    public static void printDigits(int n) {
        if(n == 0) {
            return;
        }

        int lastDig = n % 10;
       
        printDigits(n/10);

         System.out.print(lastDig + " ");
    }

    public static void main(String[] args) {
        int nums[] = { 2, 5, 8, 0, 3 };
        int arr[] = {10, 20, 10, 30, 40, 50, 10};
        printNumbers(0, nums);
        // printNumbersReverse(nums.length-1, nums);
        System.out.println();
        // System.out.println("Sum: " + calcSum(0, nums));
        // System.out.println("Product: " + calcProduct(0, nums));
        // printName(10);
        printNumbers1toN(5);
        printNumbersNto1(5);
        System.out.println("Maximum Element in an array: " + findMax(0, nums));
        findMin(0, nums, Integer.MAX_VALUE);
        // System.out.println("Element found at index: " + findElement(0, nums, 0));
        System.out.println("Element found at index " + binarySearch(0, nums.length-1, nums, 10));
        System.out.println("Count the target: " + countTarget(0, arr, 10));
        printDigits(1234);
    }
}
