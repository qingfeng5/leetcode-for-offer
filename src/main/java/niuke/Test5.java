package niuke;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/8/2 15:05
 */
public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String res = null;
        res = sc.nextLine();
//        for (int i = 0; i < 4; i++) {
//             res = sc.nextLine();
//        }

        int i = new Test5().totalWords(res);
        System.out.println(i);
    }


    public int totalWords(String s) {
        int n = s.length(), res = 0;
        //key出现的字符，value对应的最新的位置
        Map<Character, Integer> map = new HashMap<>();
        // try to extend the range [i, j]
        for (int end = 0, start = 0; end < n; end++) {
            // 指针 j 遍历字符 s ，哈希表统计字符 s[j] 最后一次出现的索引 。
            if (map.containsKey(s.charAt(end))) {
                //更新左指针 i ： 根据上轮左指针 i 和 dic[s[j]]，每轮更新左边界 i ，
                // 保证区间 [i + 1, j]内无重复字符且最大。
                //由于重复的坐标不知道在start的前方还是后方，所以要取个最大值
                start = Math.max(map.get(s.charAt(end)) + 1, start);
            }
            //取上轮 res 和本轮双指针区间 [i + 1,j] 的宽度（即 j - i）中的最大值
            res = Math.max(res, end - start + 1);
            map.put(s.charAt(end), end);
        }
        return res;
    }
}
