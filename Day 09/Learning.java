import java.util.Arrays;

public class Learning {
    static void main(String[] args) {
        int[] arr = {1,3,2,5,4,7,6};
        cyclicsort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void cyclicsort(int[] arr){
        int i = 0;

        while (i < arr.length) {
            if(arr[i] != i + 1){
                int no  = arr[i];
                int ref = arr[no - 1];
                arr[no - 1] = arr[i];
                arr[i] = ref;
            } else {
                i++;
            }
        }
    }

}
