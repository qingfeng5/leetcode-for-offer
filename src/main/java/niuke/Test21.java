package niuke;

import java.util.Scanner;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/9/8 19:00
 */
public class Test21 {
    //排序扑克牌
    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static String[] pokersort(String[] pokers) {
        for (int i = 0; i <pokers.length-1 ; i++) {
            if (pokers[i] == "2"){
                pokers[i] ="15";
            }
            if (pokers[i] == "J"){
                pokers[i] = "11";
            }
            if (pokers[i] == "Q"){
                pokers[i] = "12";
            }
            if (pokers[i] == "K"){
                pokers[i] = "13";
            }
            if (pokers[i] == "A"){
                pokers[i] = "14";
            }
        }

        for (int i = 0; i < pokers.length-1; i++) {
            for (int j = 0; j < pokers.length-i-1; j++) {
                if (pokers[j].charAt(j) > pokers[j+1].charAt(j+1) ){
                    int temp = pokers[j+1].charAt(j+1);
//                    pokers[j+1].charAt(j+1) =pokers[j].charAt(j);
////                    pokers[j].charAt(j)=  temp;
                }
            }
        }
        return pokers;

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] res;

        int _pokers_size = 0;
        _pokers_size = Integer.parseInt(in.nextLine().trim());
        String[] _pokers = new String[_pokers_size];
        String _pokers_item;
        for(int _pokers_i = 0; _pokers_i < _pokers_size; _pokers_i++) {
            try {
                _pokers_item = in.nextLine();
            } catch (Exception e) {
                _pokers_item = null;
            }
            _pokers[_pokers_i] = _pokers_item;
        }

        res = pokersort(_pokers);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}
