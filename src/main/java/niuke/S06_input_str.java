package niuke;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by 清风
 * 2020/8/6 16:18
 */
public class S06_input_str {
    public static void main(String[] args) {
        System.out.println("请输入你要判断的字符串");
        Scanner sca=new Scanner(System.in);
        String str=sca.nextLine();
        System.out.println("接受到得字符串"+str);
        int n = new S06_input_str().lengthOfLongestSubstring(str);
        System.out.println(n);
    }

    public int lengthOfLongestSubstring(String s) {
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
