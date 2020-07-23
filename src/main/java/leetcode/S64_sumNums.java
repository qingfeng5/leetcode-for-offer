package leetcode;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/7/23 22:23
 * 剑指 Offer 64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45
 *
 * 逻辑运算符的短路效应：
 * 常见的逻辑运算符有三种，即 “与 \&\&&& ”，“或 ||∣∣ ”，“非 !! ” ；而其有重要的短路效应，如下所示：
 *
 *
 * if(A && B)  // 若 A 为 false ，则 B 的判断不会执行（即短路），直接判定 A && B 为 false
 *
 * if(A || B) // 若 A 为 true ，则 B 的判断不会执行（即短路），直接判定 A || B 为 true
 *
 */
public class S64_sumNums {

    //Java 中，为构成语句，需加一个辅助布尔量 xx ，否则会报错
    int res = 0;
    public int sumNums(int n) {
        //n > 1 && sumNums(n - 1) // 当 n = 1 时 n > 1 不成立 ，此时 “短路” ，终止后续递归
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }

    /**递归,不可取**/
//    public int sumNums(int n) {
//        if(n == 1) return 1;
//        n += sumNums(n - 1);
//        return n;
//    }



    /**迭代，不可取**/
//    public int sumNums(int n) {
//        int res = 0;
//        for(int i = 1; i <= n; i++)
//            res += i;
//        return res;
//    }

}
