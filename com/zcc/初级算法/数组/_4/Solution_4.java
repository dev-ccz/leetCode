package zcc.初级算法.数组._4;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zcc  2022/4/11 22:00
 */
public class Solution_4 {

    public static void main(String[] args) {
        Solution_4 solution_4 = new Solution_4();
        System.out.println(solution_4.containsDuplicate(new int[]{1,2,3,4}));
    }
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> integers = new HashSet<>();
        for (int num : nums) {
            if(!integers.add(num)){
                return true;
            }
        }
        return false;
    }
}
