package niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 清风
 * 2020/8/22 18:40
 * 10
 * A B C D E F X H I J
 * A C I X E F J H D B
 *
 * 第一行有n个人，后面两行分别代表跳高排名，跳远排名。总成绩按比重计算（具体比重不知道），求X同学可能的排名。
 * 换而言之，求跳高和跳远都比X排名高的，例题中是AC，所以最好为第三名。都比X低的，例子中是HJ，所以X最差为第八名。
 * 输出3 8，最好和最差的名次。
 */
public class T_01_didi_sort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<String> res = new ArrayList<>();
        for (char a = '1'; a <= '9'; a++) {
            for (char b = '0'; b <= '9'; b++) {
                for (char c = '0'; c <= '9'; c++) {
                    if (a != b && a != c && b != c) {
                        int abc = (a - '0') * 100 + (b - '0') * 10 + (c - '0');
                        int acc = (a - '0') * 100 + (c - '0') * 10 + (c - '0');
                        if ((abc + acc) == n){
                            res.add(abc + " " + acc);
                        }
                    }
                }
            }
        }
        System.out.println(res.size());
//        res.forEach(System.out.println(s));
    }
}
