package leetcode_class.T01_Sting;

/**
 * Created by 清风
 * 2020/8/28 14:21
 * 345. 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。

 * 示例 1：
 *
 * 输入："hello"
 * 输出："holle"
 * 示例 2：
 *
 * 输入："leetcode"
 * 输出："leotcede"
 */
public class SL_345_reverseVowels {
    public String reverseVowels(String s) {
        // 先将字符串转成字符数组（方便操作）
        char[] arr = s.toCharArray();
        int n = arr.length;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            // 从左判断如果当前元素不是元音
            while (l < n && !isVowel(arr[l]) ) {
                l++;
            }
            // 从右判断如果当前元素不是元音
            while (r >= 0 && !isVowel(arr[r]) ) {
                r--;
            }
            // 如果没有元音
            if (l >= r) {
                break;
            }
            // 交换前后的元音
            swap(arr, l, r);
            // 这里要分开写，不要写进数组里面去
            l++;
            r--;
        }
        // 最后返回的时候要转换成字符串输出
        return new String(arr);
    }
    private void swap(char[] arr, int a, int b) {
        char tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    // 判断是不是元音
    private boolean isVowel(char ch) {
        // 这里要直接用 return 语句返回，不要返回 true 或者 false
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                ||ch=='A'|| ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
