package niuke;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/8/1 16:28
 */
public class Test4 {
    /**
     * 返回亲7数个数
     * @param digit int整型一维数组 组成亲7数的数字数组
     * @return int整型
     */
    public int reletive_7 (int[] digit) {
        // write code here

        int[] num = new int[10001];
        int s= 0;
        for (int i = 0; i <digit.length ; i++) {
            for (int j = 0; j <digit.length ; j++) {
                for (int k = 0; k <digit.length ; k++) {
                    //分别表示个位，十位，百位，
                    int a = digit[i];
                    int b = digit[j];
                    int c = digit[k];
                    s= a + 10*b + 100*c;
                    for (int v = 0; v <num.length ; v++) {
                        num[v++] = s;
                    }
                }
            }
        }

        int count = 0;
        int n= 0;
        for (int i = 0; i <num.length ; i++) {
            if (num[n] != num[i] ){
                n++;
                num[i] =num[n];
            }
        }
        for (int i = 0; i < num.length; i++) {
            if (num[i] % 7 == 0){
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] num = {1,1,2};
        System.out.println(new Test4().reletive_7(num));
    }
}
