import java.util.Arrays;

public class bubblesort {

    public static void main(String[] args) {
        int[] arr = {1};
        booblesort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void booblesort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {

                if (arr[j] < arr[j - 1]) {   // ascending order
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
