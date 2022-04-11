package zcc.初级算法._1;

/**
 * @author zcc  2022/4/9 18:27
 */
public class Solution_1 {

    public static void main(String[] args) {
        Solution_1 solution_1 = new Solution_1();
        int[] ints = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = solution_1.removeDuplicates(ints);
        System.out.println(i);

    }

    public int removeDuplicates(int[] nums) {

        int currentIndex=0;
        for (int i=0;i<nums.length;i++){
            if(i==0 || nums[i]>nums[currentIndex-1]){
                nums[currentIndex++]=nums[i];
            }
        }
        return currentIndex;

    }
}
