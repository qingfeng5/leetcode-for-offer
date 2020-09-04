package niuke;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname: qingfeng
 * @Author: 清风
 * @Date: 2020/9/4 19:55
 */
public class Test17 {
    //两数之和
    public int[] find_children (int candiesNeed, int[] candies) {
        // write code here
        if (candies.length < 2){
            throw new IllegalArgumentException("Illegal argument numbers");
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <candies.length ; i++) {
             int res = candiesNeed -candies[i];
             if (map.containsKey(res)){
                 return new int[]{map.get(res),i};
             }
             map.put(candies[i],i);
        }

        throw new IllegalArgumentException("Illegal argument numbers");
    }

}
