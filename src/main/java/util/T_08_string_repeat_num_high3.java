package util;

import java.util.Scanner;

/**
 * Created by 清风
 * 2020/8/24 10:15

 * 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：
 * 比如 helllo -> hello
 * 2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：
 * 比如 helloo -> hello
 * 3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，
 * 应该优先考虑修复AABB，结果为AABCC
 *
 * 输入描述:
 * 第一行包括一个数字N，表示本次用例包括多少个待校验的字符串。
 * 后面跟随N行，每行为一个待校验的字符串。
 *
 * 输出描述:
 * N行，每行包括一个被修复后的字符串。
 *
 * 示例1
 * 输入
 * 2
 * helloo
 * wooooooow
 *
 * 输出
 * hello
 * woow
 */
public class T_08_string_repeat_num_high3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        StringBuilder[] strs = new StringBuilder[n];
        for (int i=0;i<n;i++){
            strs[i] = new StringBuilder(in.next());
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<=strs[i].length()-4;){
                if (strs[i].charAt(j) == strs[i].charAt(j+1)){         //AA
                    if (strs[i].charAt(j+1) == strs[i].charAt(j+2) ||
                            strs[i].charAt(j+2) == strs[i].charAt(j+3)){    //AAAX或者AABB
                        strs[i].deleteCharAt(j+2);
                        continue;
                    }
                }else{
                    if (strs[i].charAt(j+1) == strs[i].charAt(j+2) &&
                            strs[i].charAt(j+2) == strs[i].charAt(j+3)){      //XAAA
                        strs[i].deleteCharAt(j+2);
                        continue;
                    }
                }
                j++;
            }
        }
        for (int i=0;i<n;i++)
            System.out.println(strs[i].toString());
    }
}
