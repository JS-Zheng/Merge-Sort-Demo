/**
 * Created by zhengzhongsheng on 2017/3/29.
 */
public class SortingNumber {

    private int invCount = 0; // 排序翻轉次數

    private int[] number;


    public SortingNumber(int[] num) {
        number = num.clone();
    }


    public void setInversionNum(int inversionNum) {
        this.invCount = inversionNum;
    }

    public int[] getNumber() {
        return number;
    }

    public int getInvCount() {
        return invCount;
    }
}
