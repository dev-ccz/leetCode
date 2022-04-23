package zcc.初级算法._7;

import java.util.Arrays;

/**
 * @author zcc  2022/4/22 0:21
 */
public class Solution_7 {
    public static void main(String[] args) {
        Solution_7 solution7 = new Solution_7();
        System.out.println(Arrays.toString(solution7.plusOne(new int[]{8,9, 9, 9})));
    }

    public int[] plusOne(int[] digits) {
        int carry=0;
        for (int i = digits.length-1; i >=0; i--) {
            if(digits[i]+1<10){
                digits[i]+=1;
                carry=0;
                break;
            }else {
                carry=1;
                digits[i]=0;
            }
        }
        if(carry>0){
            int[] ints = new int[digits.length + 1];
            ints[0]=carry;
            System.arraycopy(digits, 0, ints, 1, digits.length);
            return ints;
        }
        return digits;
    }

    public int[] plusOne2(int[] digits){
        for (int i = digits.length-1; i >=0; i--) {
            if(digits[i]!=9){
                digits[i]+=1;
                return digits;
            }else {
                digits[i]=0;
            }
        }

        int[] ints = new int[digits.length + 1];
        ints[0]=1;
        return ints;
    }
}
