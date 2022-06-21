package zcc.初级算法.字符串._01;

/**
 * @author Zcc
 * created on 22/6/21 22:36
 * leetCode
 */
public class Solution {

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp;
            temp=s[i];
            s[i]=s[s.length-i-1];
            s[s.length-i-1]=temp;
        }
    }
}
