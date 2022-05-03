package zcc.初级算法.字符串._5;

/**
 * @author zcc  2022/5/3 11:46
 */
public class Solution_5 {

    public static void main(String[] args) {
        String a = "0p";
        System.out.println((int) '0');
        System.out.println((int) '9');
        System.out.println((int) 'z');
        System.out.println((int) 'Z');
        Solution_5 solution_5 = new Solution_5();
        System.out.println(solution_5.isPalindrome(a));
        System.out.println(solution_5.isPalindrome1(a));
    }

    /**
     * 去除无效字符解决
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        char[] ss = new char[s.length()];
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                ss[index++] = (char) (s.charAt(i) + 32);
                continue;
            }
            if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
                ss[index++] = s.charAt(i);
                continue;
            }
            if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                ss[index++] = s.charAt(i);
            }

        }
        String s1 = String.valueOf(ss);
        s1 = s1.substring(0, index);
        int length = s1.length();
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) != s1.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 双指针
     * @param s
     * @return
     */
    public boolean isPalindrome1(String s) {

        int beginIndex = 0, endIndex = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            if(checkFail(s.charAt(beginIndex))){
                beginIndex++;
                continue;
            }
            if(checkFail(s.charAt(endIndex))){
                endIndex--;
                continue;
            }
            if(beginIndex>=endIndex){
                return true;
            }
            if(toLower(s.charAt(beginIndex++))!=toLower(s.charAt(endIndex--))){
                return false;
            }
        }
        return true;
    }

    public boolean checkFail(char i) {
        return (i < 'A' || i > 'Z') && (i < 'a' || i > 'z') && (i < '0' || i > '9');
    }

    public char toLower(char c){
        if(c>='A' && c<='Z'){
            return (char) (c+32);
        }
        return c;
    }
}
