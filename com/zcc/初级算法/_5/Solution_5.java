package zcc.初级算法._5;

/**
 * @author zcc  2022/4/11 22:18
 */
public class Solution_5 {

    public static void main(String[] args) {
        Solution_5 solution_5 = new Solution_5();
        System.out.println(solution_5.singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
