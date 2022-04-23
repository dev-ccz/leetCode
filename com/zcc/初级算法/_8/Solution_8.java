package zcc.初级算法._8;

/**
 * @author zcc  2022/4/22 0:39
 * 考虑把不等于0的往前移动
 */
public class Solution_8 {
    public static void main(String[] args) {
        Solution_8 solution_8 = new Solution_8();
        solution_8.moveZeroes(new int[]{1,1,0,3,12});
    }

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
