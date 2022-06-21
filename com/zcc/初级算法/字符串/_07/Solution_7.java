package zcc.初级算法.字符串._07;

import java.awt.*;

/**
 * @author zcc  2022/5/4 0:21
 */
public class Solution_7 {
    public static void main(String[] args) {
        Solution_7 solution_7 = new Solution_7();
        System.out.println("mississippi".indexOf("issipi"));
        System.out.println(solution_7.strStr("mississippi", "issipi"));
    }

    /**
     * JavaAPI实现方式 KMP算法？
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length()){
            return -1;
        }
        char[] str = needle.toCharArray();
        char[] value = haystack.toCharArray();
        char first = str[0];
        int max = (value.length - str.length);
        for (int i = 0; i <= max; i++) {
            // Look for first character.
            if (value[i] != first) {
                while (++i <= max && value[i] != first);
            }
            // Found first character, now look at the rest of value
            if (i <= max) {
                int j = i + 1;
                int end = j + str.length - 1;
                for (int k = 1; j < end && value[j] == str[k]; j++, k++);
                if (j == end) {
                    // Found whole string.
                    return i;
                }
            }
        }
        return -1;
    }
}
