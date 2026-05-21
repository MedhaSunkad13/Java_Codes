package ProblemSolving;

public class SortingAlgos {

    //T.C = O(n^2) S.C = O(1)
    static void bubbleSort(int arr[]) {

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //T.C = O(n^2) S.C = O(1)
    static void selectionSort(int arr[]) {
        for(int i = 0; i < arr.length-1; i++) {
            int minInd = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[minInd]) {
                    minInd = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minInd];
            arr[minInd] = temp;
        }
    }
    
    //T.C = O(n^2) S.C = O(1)
    static void insertionSort(int arr[]) {
        for(int i = 1; i <= arr.length-1; i++) {
            int curr = i;
            int prev = i - 1;
            int currVal = arr[curr];

            while(prev >= 0 && currVal < arr[prev]) {
                //Shifting
                arr[prev+1] = arr[prev];
                prev--;
            }
            //We have an empty space now
            arr[prev + 1] = currVal;
        }
    }

    public static void main(String[] args) {

        int nums[] = { 4, 1, 5, 2, 3 };

        // bubbleSort(nums);
        // selectionSort(nums);
        insertionSort(nums);

        // System.out.println("Printing the sorted array using bubble sort: ");
        // System.out.println("Printing the sorted array using Selection sort: ");
        System.out.println("Printing the sorted array using Insertion sort: ");

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println();
    }
}