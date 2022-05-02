package zcc.初级算法.字符串._03;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zcc  2022/5/2 11:33
 */
public class Solution_3 {

    public static void main(String[] args) {
        Solution_3 solution_3 = new Solution_3();
        System.out.println(solution_3.firstUniqChar("aabb"));
        System.out.println(solution_3.firstUniqChar1("aabb"));
    }

    /**
     * 这个字符，正着和反着出现的位置一样，说明是第一个
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 双次循环，记录次数
     * @param s
     * @return
     */
    public int firstUniqChar1(String s) {
       int[] count =new int[26];
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            count[aChar-'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if(count[chars[i]-'a']==1){
                return i;
            }
        }
        return -1;
    }


}
