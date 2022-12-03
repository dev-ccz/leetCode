import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

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


    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        byte[] temp = new byte[1001];
        for (int n : nums1) {
            temp[n]++;
        }
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;
        for (int n : nums2) {
            if (temp[n] > 0) {
                result[index++] = n;
                temp[n]--;
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] >= 9) {
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + 1;
                return digits;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public int strStr(String haystack, String needle) {
        int[] next = next(needle);
        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == needle.length()) {
            return i - j;
        }
        return -1;
    }


    private int[] next(String pattern) {
        int[] next = new int[pattern.length()];
        int j = 0, k = -1;
        next[0] = -1;
        while (j < pattern.length() - 1) {
            if (k == -1 || pattern.charAt(j) == pattern.charAt(k)) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]),i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] ints = new int[]{0, 1, 0, 2, 3};
        instance.moveZeroes(ints);
        System.out.println(Arrays.toString(instance.twoSum(new int[]{3,2,4},6)));
    }

}
