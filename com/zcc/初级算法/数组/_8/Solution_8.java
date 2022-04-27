package zcc.初级算法.数组._8;

/**
 * @author zcc  2022/4/22 0:39
 * 考虑把不等于0的往前移动
 */
public class Solution_8 {
    public static void main(String[] args) {
        Solution_8 solution_8 = new Solution_8();
        solution_8.moveZeroes(new int[]{0,1,0,3,12});
    }

    /**
     * 双指针法  定义一个指针指向下标最大的0的位置，并把后面的数移动到这个位置，当遍历完整个数组时，index的位置就是第一个0的位置
     * 将index和后面的数字置0即可
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int index=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[index]=nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i]=0;
        }
    }
}
