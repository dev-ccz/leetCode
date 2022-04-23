package zcc.初级算法._6;

import java.util.*;

/**
 * @author zcc  2022/4/21 23:54
 * 这个题很迷惑
 */
public class Solution_6 {

    public static void main(String[] args) {
        Solution_6 solution = new Solution_6();
        solution.intersect(new int[]{4,9,5,4},new int[]{9,4,9,8,4,4});
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int len = len1<len2?len1:len2;
        int[] ans = new int[len];
        if(len1 == 0 || len2 == 0){  //处理边界条件
            return ans;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0, j=0, k=0;
        while(i<len1 && j<len2){
            if(nums1[i] == nums2[j]){
                ans[k++] = nums1[i];
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        return Arrays.copyOfRange(ans, 0, k);
    }
}
