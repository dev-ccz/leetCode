/**
 * @author Zcc
 * created on 22/11/20 0:35
 */
public class Solution {

    private static final Solution instance = new Solution();

    public int removeDuplicates(int[] nums) {
        int notSameIndex = 0, temp = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != temp) {
                temp = nums[i];
                nums[++notSameIndex] = nums[i];
            }
        }
        return ++notSameIndex;
    }

    //实际上就是求递增区间的和
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            sum += Math.max(prices[i + 1] - prices[i], 0);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(instance.removeDuplicates(new int[]{0, 0}));
        ;
    }

}
