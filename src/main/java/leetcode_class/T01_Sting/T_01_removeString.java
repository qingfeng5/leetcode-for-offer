package leetcode_class.T01_Sting;

/**
 * Created by 清风
 * 2020/9/21 20:11
 * 字符串去重
 */
public class T_01_removeString {
    public String removeRepeatChar(String str) {

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < str.length(); i ++) {

            char charWord = str.charAt(i);

            //符串在此实例中的第一个匹配项的从零开始的索引。
            //查某个指定的字符串在字符串首次出现的位置（索引值）（从左往右）
            int firstPosition = str.indexOf(charWord);

            //查某个指定的字符串在字符串最后一次出现的位置（索引值）（从右往左）
            int lastPosition = str.lastIndexOf(charWord);

            //第一次出现等于最后一次出现，说明是只出现过一次
            //或者第一次出现的是否等于索引的位置
            if (firstPosition  == lastPosition || firstPosition == i) {

                sb.append(charWord);

            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "adcaassd";
        System.out.println(new T_01_removeString().removeRepeatChar(str));
    }
}
