package zhangyuyao.algorithm;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 2, 2, 2, 0, 0, 0};
        System.out.println("before : " + Arrays.toString(numbers));
        // 排序
        insertSort(numbers);
        System.out.println("after  : " + Arrays.toString(numbers));
    }

    /**
     * 插入排序
     *
     * @param numbers
     */
    public static void insertSort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int index = i;
            for (int j = index - 1; j >= 0; j--) {
                if (numbers[index] < numbers[j]) {
                    swap(numbers, index, j);
                    index = j;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 交换数值
     *
     * @param numbers
     * @param a
     * @param b
     */
    private static void swap(int[] numbers, int a, int b) {
        int c = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = c;
    }
}
