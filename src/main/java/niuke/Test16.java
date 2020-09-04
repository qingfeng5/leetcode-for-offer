package niuke;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/9/4 19:55
 */
public class Test16 {
    public int[] find_children (int candiesNeed, int[] candies) {
        // write code here
        if (candies.length < 2){
            throw new IllegalArgumentException("Illegal argument numbers");
        }
        int l=0;
        int r=candies.length-1;
        while (l < r){
            if ( candies[l] + candies[r] == candiesNeed){
                int[] res ={l , r};
                return res;
            }
            else if (l<r && candies[l] + candies[r] <candiesNeed ){
                l++;
            }
            else if(candies[l] + candies[r] > candiesNeed) {
                r--;
            }

        }
        throw new IllegalArgumentException("Illegal argument numbers");
    }

}
