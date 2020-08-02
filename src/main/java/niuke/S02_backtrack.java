package niuke;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 清风
 * 2020/8/2 12:42
 */
public class S02_backtrack {

    // 保存所有组合的数字
    private List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int x = 4;
        System.out.println(" " + ((x>4)?99.9:9));
    }

    public int reletive_7(int[] digit) {
        // write code here
        backtrack(digit, 0, digit.length - 1);
        int count = 0;
        for (int number : list) {
            if (number % 7 == 0) {
                count++;
            }
        }
        return count;
    }

    // 回溯法
    private void backtrack(int[] digit, int m, int n) {
        // 到达末尾
        if (m == n) {
            // 将数组拼接成数字，添加到结果集
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= n; i++) {
                sb.append(digit[i]);
            }
            list.add(Integer.parseInt(sb.toString()));
        } else {
            for (int i = m; i <= n; i++) {
                // 交换数字位置
                swap(digit, m, i);
                backtrack(digit, m + 1, n);
                // 恢复数字位置
                swap(digit, m, i);
            }
        }
    }

    // 交换两位置数字
    private void swap(int[] digit, int i, int j) {
        int temp = digit[i];
        digit[i] = digit[j];
        digit[j] = temp;
    }
}
