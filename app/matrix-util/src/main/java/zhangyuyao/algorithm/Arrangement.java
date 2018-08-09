package zhangyuyao.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 */
public class Arrangement {


    /**
     * @param args
     */
    public static void main(String[] args) {

        // 创建待测试的数据
        List<Integer> result = new LinkedList<>();

        // 创建待排序元素
        List<Integer> elements = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        // 输出排列
        func(result, elements, 0);
    }

    /**
     * @param result
     * @param elements
     * @param index
     * @param <T>
     */
    public static <T> void func(List<T> result, List<T> elements, int index) {
        if (index == elements.size()) {
            printf(result);
            return;
        }

        for (int i = 0; i <= result.size(); i++) {

            // 依次加入到队列中去
            result.add(i, elements.get(index));

            // 递归到下一个数据
            func(result, elements, index + 1);

            // 删除这个元素
            result.remove(i);
        }
    }

    /**
     * 打印结果
     *
     * @param result
     * @param <T>
     */
    private static <T> void printf(List<T> result) {
        StringBuilder sb = new StringBuilder("[");
        for (T t : result) {
            sb.append(t.toString()).append(",");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
