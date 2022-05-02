package zcc.初级算法.字符串._02;

import java.util.Arrays;

/**
 * @author zcc  2022/5/2 0:54
 */
public class Solution_2 {
    public static void main(String[] args) {
        Solution_2 solution_2 = new Solution_2();
        System.out.println(solution_2.reverse(Integer.MIN_VALUE));
        System.out.println(solution_2.re(Integer.MAX_VALUE));
    }

    public int reverse(int x) {
        //翻转后肯定越界，不用判断，直接返回0
        if(x==Integer.MAX_VALUE||x==Integer.MIN_VALUE){
            return 0;
        }

       if(x>=0){
           char[] chars = String.valueOf(x).toCharArray();
           reverse(chars);
           long l = Long.parseLong(String.valueOf(chars));
           if(l>Integer.MAX_VALUE){
               return 0;
           }
           return (int) l;
       }else {
           x=x*-1;
           char[] chars = String.valueOf(x).toCharArray();
           reverse(chars);
           long l = Long.parseLong(String.valueOf(chars))*-1;
           if(l<Integer.MIN_VALUE){
               return 0;
           }
           return (int) l;
       }
    }

    /**
     * 反转可以用辗转除10
     * @param x
     * @return
     */
    public int re(int x){
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return (int) res == res ? (int) res : 0;
    }

    private void reverse(char[] chars) {
        for (int i = 0; i < chars.length / 2; i++) {
            char temp;
            temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
    }
}
