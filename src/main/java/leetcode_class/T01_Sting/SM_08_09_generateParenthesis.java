package leetcode_class.T01_Sting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 清风
 * 2020/8/28 11:24
 * 面试题 08.09. 括号
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class SM_08_09_generateParenthesis {
    // TODO: 2020/8/28  打印n对括号的所有合法的（例如，开闭一一对应）组合
    public void dfs(List<String> list, String s, int numLeft, int numRight, int total){
        if(s.length() == total){
            //得到一个满足条件的括号串
            String t = s;
            list.add(t);
            return;
        }
        if(2 * numLeft + 1 <= total){
            //左括号的个数 + 1 <= 总括号数 - 左括号的个数,即剩下的位置必须可以容纳足够的右括号
            //可以加左括号
            dfs(list, s + "(", numLeft + 1, numRight, total);
        }
        if(numRight + 1 <= numLeft){
            //右括号的个数不能超过左括号的个数
            //可以加右括号
            dfs(list, s + ")", numLeft, numRight + 1, total);
        }
        return;
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        String s = "";
        int numLeft = 0, numRight = 0;
        dfs(list, s, numLeft, numRight, n * 2);
        return list;
    }
}
