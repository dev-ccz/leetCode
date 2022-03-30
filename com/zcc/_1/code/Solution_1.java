package zcc._1.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 时间复杂度小于O(n^2)
 *
 * @author zhangchangchun
 *
 */
public class Solution_1 {

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
