import java.util.Arrays;

public class selectionsort {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 7, 8, 3};

        selection(arr);

        System.out.println(Arrays.toString(arr));
    }

    static void selection(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            int max = findmax(arr, 0, arr.length - i - 1);

            swap(arr, max, arr.length - i - 1);
        }
    }

    static void swap(int[] arr, int max, int small) {
        int temp = arr[small];
        arr[small] = arr[max];
        arr[max] = temp;
    }

    static int findmax(int[] arr, int start, int end) {

        int max = start;

        for (int j = start; j <= end; j++) {
            if (arr[j] > arr[max]) {
                max = j;   // store INDEX not value
            }
        }

        return max;
    }
}
