package leetcode_class.T01_Sting;

/**
 * Created by 清风
 * 2020/9/27 17:30
 */
public class SM_01_02_CheckPermutation {
    public boolean CheckPermutation(String s1, String s2) {
        int l1=s1.length(),l2=s2.length();
        if(l1!=l2)
            return false;
        int []index=new int[128];
        for(int i=0;i<l1;i++){
            index[s1.charAt(i)]++;
            index[s2.charAt(i)]--;
        }
        for(int i=0;i<128;i++){
            if(index[i]!=0)
                return false;
        }
        return true;
    }
}
