package niuke;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by 清风
 * 2020/8/6 16:18
 */
public class S06_input_str_02 {
    public static void main(String[] args) {
        System.out.println("请输入你要判断的字符串");
        Scanner sca=new Scanner(System.in);
        String str=sca.nextLine();
        System.out.println("接受到得字符串"+str);
        int n = new S06_input_str_02().lengthOfLongestSubstring(str);
        System.out.println(n);
    }

    //滑动窗口
    public int lengthOfLongestSubstring(String s) {
        if(s==null||s.isEmpty())
            return 0;
        //将字符串对象中的字符转换为一个字符数组
        char[] cs = s.toCharArray();
        //cMap=int[256]替代了HashMap
        //cMap记录s[r]字符最近出现的位置+1（也即，重复字符取最大的位置+1）,cMap[s[r]] = r+1;
        int[] cMap = new int[256];
        //l,r分别为窗口的左侧和右侧；
        //每次将r向右移动一位，
        int l = 0, r = 0;
        int ans = 0;

        while(r < cs.length){
            //如果cMap[s[r]] <= l表示该字符在l到r的窗口中未出现过,ans 取 r-l+1与ans 的较大值，回到3
            if(cMap[cs[r]] <= l){
                ans = Math.max(r-l+1,ans);}
            else {
                //当cMap[s[r]] > l 表示该字符在l到r的窗口中出现过，令l=cMap[s[r]],则该字符就未在l到r中出现，回到3
                l = cMap[cs[r]];
            }
            cMap[cs[r]] = r+1;
            ++r;
        }
        return ans;
    }
}
