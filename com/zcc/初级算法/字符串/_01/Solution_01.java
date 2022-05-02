package zcc.初级算法.字符串._01;


/**
 * @author zcc  2022/5/2 0:43
 */
public class Solution_01 {
    public static void main(String[] args) {
        Solution_01 solution_01 = new Solution_01();
        solution_01.reverseString(new char[]{'0','1','2','3','4','5'});
    }

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp;
            temp=s[i];
            s[i]=s[s.length-i-1];
            s[s.length-i-1]=temp;
        }
    }
}
