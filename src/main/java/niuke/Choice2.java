package niuke;

import java.util.Scanner;

/**
 * @author 清风
 * @date 2020/4/12 16:32
 */

public class Choice2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();
        int[] dist = new int[N];
        for (int i = 0; i < N; i++) {
            dist[i] = sc.nextInt();
        }
        long i = new Choice2().totalProgram(dist, D);
        System.out.println(i);
    }


    public long totalProgram(int[] dist, int D) {

        final int mod = 99997867;
        long ans = 0;
        for (int i = 0,j = 0;i<dist.length;i++){
            while (i >= 2 && (dist[i] - dist[j]) > D)
                j++;
            ans += computeCn(i - j);
        }
        return ans % mod;
    }
    private long computeCn(long n) {
        return n * (n - 1) / 2;
    }
}