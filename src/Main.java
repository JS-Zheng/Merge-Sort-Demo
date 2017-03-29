import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    public static void main(String[] args) {

        int n, k;
        boolean debug;

        Permutation permutation = new Permutation(); // 排列
        SortingAlgorithm sorter = new MergeSort(); // 排序演算法
        Scanner sc = new Scanner(System.in);

        String inputPrompt1 = "輸入欲排序 n 位數: ";
        String inputPrompt2 = "輸入欲塞選的 inversion count: ";
        String inputPrompt3 = "是否檢視排序過程 (1)y (2)n:";

        n = getInputInteger(sc, inputPrompt1); // 1,2,3,4...
        k = getInputInteger(sc, inputPrompt2); // inversion 次數
        debug = getInputBoolean(sc, inputPrompt3); // 是否檢視過程

        System.out.println("\n------------");

        List<int[]> list = permutation.permute(n);
        List<int[]> result = new ArrayList<>();

        for (int[] arr : list) {
            SortingNumber sortingNumber = sorter.sort(arr, debug);

            if (sortingNumber.getInvCount() == k) {
                result.add(arr);
            }
        }

        System.out.println("\nAns: " + result.size());
        for (int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }

    }

    private static int getInputInteger(Scanner sc, String prompt) {

        System.out.println(prompt);

        while (!sc.hasNextInt()) {
            System.out.println("輸入錯誤，請重新輸入");
            System.out.println(prompt);
            sc.next();
        }
        return sc.nextInt();
    }

    private static boolean getInputBoolean(Scanner sc, String prompt) {

        String TRUE_PATTERN = "y|yes|1|好";
        String FALSE_PATTERN = "n|no|2|不";
        String BOOLEAN_PATTERN = TRUE_PATTERN + "|" + FALSE_PATTERN;

        Pattern tp = Pattern.compile(TRUE_PATTERN,
                Pattern.CASE_INSENSITIVE);
        Pattern bp = Pattern.compile(BOOLEAN_PATTERN,
                Pattern.CASE_INSENSITIVE);

        System.out.println(prompt);

        while (!sc.hasNext(bp)) {
            System.out.println("輸入錯誤，請重新輸入");
            System.out.println(prompt);
            sc.next();
        }

        String input = sc.next();
        Matcher matcher = tp.matcher(input);
        return matcher.find();

    }
}



