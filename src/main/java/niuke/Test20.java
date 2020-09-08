package niuke;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/9/8 17:50
 */
public class Test20 {
    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static List<Integer> pathInZigZagTree(int label) {

        List<Integer> res = new LinkedList<>();

        int level =32;
        int min = 1 << (level -1);

        //计算当前节点所在层
        for (;(min & label) != min; level--){
            min = 1<< (level -2);
        }
        for (; level >1; level--,min >>=1){
            res.add(0,label);
            //当前节点所在曾最大值
            int max = (min << 1) -1;
            if ((level & 1) == 0){
                //偶数层
                label = (min >> 1) + ((max -label) >>1);
            }
            else {
                //奇数层
                label = (max >> 1) - ((label - min) >>1);
            }
        }
        res.add(0,1);
        return res;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        List<Integer> res;

        int _label;
        _label = Integer.parseInt(in.nextLine().trim());

        res = pathInZigZagTree(_label);
        for(int res_i=0; res_i < res.size(); res_i++) {
            System.out.println(String.valueOf(res.get(res_i)));
        }

    }


}
