package zcc.初级算法.字符串._04;

/**
 * @author zcc  2022/5/3 11:13
 */
public class Solution_4 {
    public static void main(String[] args) {
        Solution_4 solution_4 = new Solution_4();
        System.out.println(solution_4.isAnagram("rat", "nagaram"));
    }


    public boolean isAnagram(String s, String t) {

            if(s.length()!=t.length()){
                return false;
            }
            int[] ss=new int[26];

            for (int i = 0; i < s.length(); i++) {
                ss[s.charAt(i)-'a']++;
                ss[t.charAt(i)-'a']--;
            }

            for (int i = 0; i < ss.length; i++) {
                if(ss[i]!=0){
                    return false;
                }
            }

            return true;
    }
}
