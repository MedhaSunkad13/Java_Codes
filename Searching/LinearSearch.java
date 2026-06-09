package Searching;

public class LinearSearch {
    
    static int linearSearch(int arr[], int target) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        
        int numbers[] = {9, 4, 2, 6, 1, 8, 3};

        int ans = linearSearch(numbers, 10);
        if(ans != -1) {
            System.out.println("Key found at index " + ans);
        }
        else{
            System.out.println("Key is not present in the array");
        }
    }
}
