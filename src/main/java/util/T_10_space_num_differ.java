package util;

import java.util.Scanner;

/**
 * Created by 清风
 * 2020/8/24 10:41

 * 请听题：给定N（可选作为埋伏点的建筑物数）、D（相距最远的两名特工间的距离的最大值）以及可选建筑的坐标，
 * 计算在这次行动中，大锤的小队有多少种埋伏选择。
 * 注意：
 * 1. 两个特工不能埋伏在同一地点
 * 2. 三个特工是等价的：即同样的位置组合(A, B, C) 只算一种埋伏方法，不能因“特工之间互换位置”而重复使用
 *
 * 输入描述:
 * 第一行包含空格分隔的两个数字 N和D(1 ≤ N ≤ 1000000; 1 ≤ D ≤ 1000000)
 *
 * 第二行包含N个建筑物的的位置，每个位置用一个整数（取值区间为[0, 1000000]）表示，
 * 从小到大排列（将字节跳动大街看做一条数轴）
 *
 * 输出描述:
 * 一个数字，表示不同埋伏方案的数量。结果可能溢出，请对 99997867 取模
 *
 * 示例1
 * 输入
 * 4 3
 * 1 2 3 4
 *
 * 输出
 * 4
 *
 * 说明
 * 可选方案 (1, 2, 3), (1, 2, 4), (1, 3, 4), (2, 3, 4)
 *
 * 输入
 * 5 19
 * 1 10 20 30 50
 *
 * 输出
 * 1
 *
 * 说明
 * 可选方案 (1, 10, 20)
 */
public class T_10_space_num_differ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();
        int[] dist = new int[N];
        for (int i = 0; i < N; i++) {
            dist[i] = sc.nextInt();
        }
        long i = new Solution().totalProgram(dist, D);
        System.out.println(i);
    }
}
class Solution {
    private final int mod = 99997867;
    private long ans = 0;
    public long totalProgram(int[] dist, int D) {
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
