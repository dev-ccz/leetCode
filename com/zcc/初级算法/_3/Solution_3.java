package zcc.初级算法._3;

import com.sun.tools.javac.Main;

import java.util.Arrays;

/**
 * @author zcc  2022/4/11 19:56
 */
public class Solution_3 {

    public static void main(String[] args) {
        Solution_3 solution_3 = new Solution_3();
        solution_3.rotate(new int[]{1,2,3,4,5,6,7},3);
        System.out.println(5%2);
        solution_3.rotate2(new int[]{1,2,3,4,5,6,7},3);
    }

    /**
     * 方法1 直接移位置就行
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if(k==0){
            System.out.println(Arrays.toString(nums));
        }
        if(k>nums.length){
            k=k%nums.length;
        }
        int[] ints=new int[nums.length];
        for (int i = k; i >0; i--) {
            ints[k-i]=nums[nums.length-i];
        }
        if (nums.length - k >= 0) System.arraycopy(nums, 0, ints, k, nums.length - k);
        System.arraycopy(ints, 0, nums, 0, nums.length);
    }

    /**
     * 其实是利用了循环队列的思想，这个很常见，要记住
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums,int k){
        int[] ints=new int[nums.length];
        System.arraycopy(nums, 0, ints, 0, nums.length);
        for (int i = 0; i < ints.length; i++) {
            nums[(i+k)%ints.length]=ints[i];
        }
    }

    /**
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums,int k){
        k = k % nums.length;
        int[] rightPart = Arrays.copyOfRange(nums, nums.length - k, nums.length);
        System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(rightPart, 0, nums, 0, k);
    }


    /**
     * @param nums
     * @param k
     *  空间复杂度O(1)表示无论输入数组多长，程序占用的额外内存基本一样，在这个上面代码中就是只有temp、start、end占用额外的内存，这种情况空间复杂度为o(1); 如果用一个新的数组arr[len]来存数组，那复空间杂度就为O(n)，即占用内存随数组长度变化，呈线性递增关系
     */
    public void rotate3(int[] nums,int k){

    }



}
