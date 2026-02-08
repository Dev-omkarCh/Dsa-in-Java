package String.Questions;

import java.util.ArrayList;

public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int temp = 0;
        int result = 0;

        for (int digit : digits) {
            result = temp + digit;
            temp = result * 10;
        }
        result += 1;

        int length = (int) Math.log10(result) + 1; // Calculate number of digits
        int[] array = new int[length];

        for (int i = length - 1; i >= 0; i--) {
            array[i] = result % 10;
            result /= 10;
        }

        return array;
    }

    public static void main(String[] args) {
        ArrayList<int[]> testcases = new ArrayList<>();
        ArrayList<int[]> results = new ArrayList<>();

        int[] t1 = { 1, 2, 3 };
        int[] t2 = { 4, 3, 2, 1 };
        int[] t3 = { 9 };

        testcases.add(t1);
        testcases.add(t2);
        testcases.add(t3);

        for (int[] testcase : testcases) {
            results.add(plusOne(testcase));
        }
        ;

        for (int[] result : results) {
            for (int digits : result) {
                System.out.print(digits + " ");
            }
            System.out.println();
        }
    }
}