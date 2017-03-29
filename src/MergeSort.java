/**
 * Created by zhengzhongsheng on 2017/3/29.
 */
public class MergeSort implements SortingAlgorithm {

    private int invCount = 0;

    @Override
    public SortingNumber sort(int[] array) {
        return sort(array, false);
    }

    @Override
    public SortingNumber sort(int[] array, boolean debug) {
        return sort(array, 0, array.length - 1, debug);
    }

    @Override
    public SortingNumber sort(int[] array, int start, int end, boolean debug) {

        this.invCount = 0; // init

        SortingNumber result = recursiveSort(array, start, end);
        result.setInversionNum(invCount);

        if (debug)
            logSortingResult(array, result);

        return result;
    }


    private void logSortingResult(int[] arr, SortingNumber result) {
        System.out.println("排序前:");
        for (int i : arr) System.out.print(i + " ");

        System.out.println("\n");
        System.out.println("排序後:");

        for (int j : result.getNumber()) {
            System.out.print(j + " ");
        }

        System.out.println("\ninversions: " + result.getInvCount());
        System.out.print("------------\n");

    }

    private SortingNumber recursiveSort(int[] array, int start, int end) {

        // 已不可平分 (單個)
        if (start >= end) {

            int[] arr = new int[1];
            arr[0] = array[start];
            return new SortingNumber(arr);
        }

        // 算 中間點
        int mid = (start + end) / 2; // 無條件捨去

        return merge(
                recursiveSort(array, start, mid).getNumber(), // 排序 左邊
                recursiveSort(array, mid + 1, end).getNumber() // 排序 右邊
        );
    }

    /*
     * 合併已排序資料
     */
    private SortingNumber merge(int[] leftDivision, int[] rightDivision) {


        final int L = leftDivision.length;
        final int R = rightDivision.length;
        final int TOTAL_LENGTH = L + R;

        int[] arr = new int[TOTAL_LENGTH];

        int i = 0, j = 0;


        while (i < L || j < R) {
            if (i == L) {
                arr[i + j] = rightDivision[j];
                j++;
            } else if (j == R) {
                arr[i + j] = leftDivision[i];
                i++;
            } else if (leftDivision[i] <= rightDivision[j]) {
                arr[i + j] = leftDivision[i];
                i++;
            } else {
                arr[i + j] = rightDivision[j];
                j++;

                /*
                 * 排序翻轉次數，原理:
                 *
                 * 若 左[i] > 右[j]，
                 * 由於 合併的是 「已」 排好序之陣列，
                 * 左[i+1]、左[i+2]、左[i+3]... 皆會大於 右[j]
                 */
                invCount += L - i;

            }
        }


        return new SortingNumber(arr);
    }


}
