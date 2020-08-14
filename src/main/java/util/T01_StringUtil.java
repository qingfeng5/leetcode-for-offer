package util;

/**
 * Created by 清风
 * 2020/8/14 16:50
 */
public class T01_StringUtil {

    // TODO: 2020/8/14 驼峰式与下划线字符串转换 
    private final static String UNDERLINE = "_";

    /***
     * 下划线命名转为驼峰命名
     *
     * @param para
     *        下划线命名的字符串
     */

    public  String underlineToHump(String para) {
        StringBuilder result = new StringBuilder();
        String a[] = para.split("_");
        for (String s : a) {
            if (!para.contains("_")) {
                result.append(s);
                continue;
            }
            if (result.length() == 0) {
                result.append(s.toLowerCase());
            } else {
                result.append(s.substring(0, 1).toUpperCase());
                result.append(s.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }

    /***
     * 驼峰命名转为下划线命名
     *
     * @param para
     *        驼峰命名的字符串
     */

    public  String humpToUnderline(String para) {
        StringBuilder sb = new StringBuilder(para);
        int temp = 0;//定位
        if (!para.contains("_")) {
            for (int i = 0; i < para.length(); i++) {
                if (Character.isUpperCase(para.charAt(i))) {
                    //将参数插入到字符串指定位置后并返回
                    sb.insert(i + temp, "_");
                    temp += 1;
                }
            }
        }
        return sb.toString().toUpperCase();
    }

    public static void main(String[] args) {
        String s ="testDadaDad";
        String h ="T_AEST_DADA_SADA";
        System.out.println(new T01_StringUtil().humpToUnderline(s));
        System.out.println(new T01_StringUtil().underlineToHump(h));
    }
}
