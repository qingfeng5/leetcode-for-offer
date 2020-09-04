package niuke;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/9/4 20:06
 */
public class Test18 {
    //最大公因数
    public int cal_max_common_factor (int[] L) {
        // write code here
        if (L.length < 1){
            return -1;
        }
        int i ,a ,t ;
        a = L[0];
        for (int j = 0; j < L.length-1; j++) {
            t = 0;
            while (L[j+1] != 0){
                t = L[j+1];
                L[j+1] = a % L[j+1];
                a = t;
            }
        }
        return a;
    }
}
