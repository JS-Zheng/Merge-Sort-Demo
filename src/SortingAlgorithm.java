/**
 * Created by zhengzhongsheng on 2017/3/28.
 */
public interface SortingAlgorithm {

    SortingNumber sort(int[] array);

    SortingNumber sort(int[] array, boolean debug);

    SortingNumber sort(int[] array, int start, int end, boolean debug);


}
