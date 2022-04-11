package zcc._4;

import java.lang.invoke.VarHandle;
import java.util.Arrays;

/**
 * @author zcc  2022/4/6 21:20
 * 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_4 {

    public static void main(String[] args) {
        Solution_4 solution_4 = new Solution_4();
        double medianSortedArrays = solution_4.findMedianSortedArrays(new int[]{1,1000}, new int[]{2,100});
        System.out.println(medianSortedArrays);
    }

    /**
     * 解法1 粗暴合并
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 使用第(m+n+1)/2 和第(m+n+2)/2的平均值，可以解决奇偶性的问题 如1,3,5 带入后都是去第2个数的和的平均值,也就是(3+3)/2.0
        if(nums1.length<1){
            return (nums2[(nums2.length+1)/2-1]+nums2[(nums2.length+2)/2-1])/2.0D;
        }
        if(nums2.length<1){
            return (nums1[(nums1.length+1)/2-1]+nums1[(nums1.length+2)/2-1])/2.0D;
        }
        //上面是根据数组长度计算的，如果根据数组的下标，也可以得到
//        if(nums1.length<1){
//            //取最大下标
//            int maxIndex=nums2.length-1;
//            return (nums2[maxIndex/2]+nums2[(maxIndex+1)/2])/2.0D;
//        }
//        if(nums2.length<1){
//            //取最大下标
//            int maxIndex=nums1.length-1;
//            return (nums1[maxIndex/2]+nums1[(maxIndex+1)/2])/2.0D;
//        }
        int length1 = nums1.length;
        int length2 = nums2.length;
        int index1=0,index2=0,index=0;
        int[] ints = new int[length1 + length2];
        while (index<length1+length2){
            if(index1==length1){
                ints[index++]=nums2[index2++];
                continue;
            }
            if(index2==length2){
                ints[index++]=nums1[index1++];
                continue;
            }
            if(nums1[index1]<nums2[index2]){
                ints[index++]=nums1[index1++];
            }else {
                ints[index++]=nums2[index2++];
            }
        }
        System.out.println(Arrays.toString(ints));
        index=ints.length-1;
        return (ints[index/2]+ints[(index+1)/2])/2.0D;
    }
}
