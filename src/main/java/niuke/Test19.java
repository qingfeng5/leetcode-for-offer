package niuke;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/9/4 20:21
 */
public class Test19 {
    //打印数字的菱形

    /****
     * *1*
     * 121
     * *1*
     */
    public String print_diamond (int n) {
        // write code here
        if (n < 3 && n % 2 ==0){
            return null;
        }
        for (int i = 1; i < n  ; i++) {
            for (int j = 0; j <=  2*(n-i); j++) {
                System.out.println("*");
            }
            for (int j = 0; j <= i ; j++) {
                System.out.println("*");
            }
            for (int j = i-1; j >0 ; j--) {
                System.out.println(n);;
            }

        }
        for (int i = 0; i <= n-1 ; i++) {
            for (int j = 0; j <= 2*i ; j++) {
                System.out.println("*");
            }
            for (int j = 0; j <= n-i ; j++) {
                System.out.println("*");
            }
            for (int j = n-i-1; j > 0 ; j--) {
                System.out.println(n);
            }
        }
        throw new IllegalArgumentException("Illegal argument numbers");
    }
}
