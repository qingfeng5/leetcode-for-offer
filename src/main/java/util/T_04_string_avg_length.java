package util;

import java.util.Scanner;

/**
 * Created by 清风
 * 2020/8/24 9:31
 * 输出一个整数,表示所有碎片的平均长度,四舍五入保留两位小数。
 *
 * 如样例所示: s = "aaabbaaac"
 * 所有碎片的平均长度 = (3 + 2 + 3 + 1) / 4 = 2.25
 * 输入
 * aaabbaaac
 * 输出
 * 2.25
 */
public class T_04_string_avg_length {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            float len = s.length();//总长
            int count = 1;//个数至少为一个
            for (int i = 0; i < len - 1; i++) {
                if (s.charAt(i) != s.charAt(i + 1)) {
                    count++;
                }
            }
            System.out.println(len / count);
        }
    }
}
