import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengzhongsheng on 2017/3/29.
 */
public class Permutation {

    private List<int[]> arrayList;

    List<int[]> permute(int[] arr) {
        return permute(arr, 0, arr.length - 1);
    }

    private void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;

    }

    List<int[]> permute(int n) {
        int[] mock = new int[n];

        for (int i = 1; i <= n; i++) {
            mock[i - 1] = i;
        }
        return permute(mock);
    }

    List<int[]> permute(int[] arr, int start, int end) {
        arrayList = new ArrayList<>();
        return doPermute(arr, start, end);
    }


    private List<int[]> doPermute(int[] arr, int start, int end) {

        int i;

        if (start == end) {
            int[] newArr = arr.clone();
            arrayList.add(newArr);
        } else {
            for (i = start; i <= end; i++) {
                swap(arr, start, i);
                doPermute(arr, start + 1, end);
                swap(arr, start, i);
            }
        }

        return arrayList;
    }

}
