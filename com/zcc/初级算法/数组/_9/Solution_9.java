package zcc.初级算法.数组._9;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zcc  2022/4/27 20:57
 */
public class Solution_9 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
