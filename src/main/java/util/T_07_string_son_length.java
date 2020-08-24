package util;

import java.util.Scanner;

/**
 * Created by 清风
 * 2020/8/24 10:11
 * 显示两个字符串 s 和 t，根据古老的传说，牛牛需要每次都回答 t 是否是 s 的子序列。
 * 注意，子序列不要求在原字符串中是连续的
 * ，例如串 abc，
 * 它的子序列就有 {空串, a, b, c, ab, ac, bc, abc} 8 种。
 *
 *  输入描述:
 * 每个输入包含一个测试用例。每个测试用例包含两行长度不超过 10 的不包含空格的可见 ASCII 字符串。
 *
 * 输出描述:
 * 输出一行 “Yes” 或者 “No” 表示结果。
 *
 * 示例1
 * 输入
 * x.nowcoder.com
 * ooo
 *
 * 输出
 * Yes
 */
public class T_07_string_son_length {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine(), t = sc.nextLine();
        int i = 0, j = 0;
        while(i < s.length()){
            if(j >= t.length())
                break;
            if(s.charAt(i) == t.charAt(j)) {
                if(j == t.length() - 1){
                    System.out.println("Yes");
                    return;
                }
                i++; j++;
            }
            else i++;
        }
        System.out.println("No");
    }
}
