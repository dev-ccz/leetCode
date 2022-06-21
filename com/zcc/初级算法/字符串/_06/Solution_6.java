package zcc.初级算法.字符串._06;

/**
 * @author zcc  2022/5/3 13:05
 */
public class Solution_6 {
    public static void main(String[] args) {
        Solution_6 solution_6 = new Solution_6();
        System.out.println(Integer.MIN_VALUE);
        System.out.println(solution_6.myAtoi("+-12"));
        System.out.println(solution_6.myAto1("-2147483647"));
        System.out.println(solution_6.new1("4193 with words"));
    }

    public int myAtoi(String s) {
        //默认为正数
        int isPositive=1;
        StringBuilder value= new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='-'){
                if(i==s.length()-1){
                    return 0;
                }
                if(!(s.charAt(i+1)<='9'&&s.charAt(i+1)>='0')){
                    return 0;
                }
                value=new StringBuilder();
                isPositive=-1;
                continue;
            }
            if(c=='+'){
                if(i==s.length()-1){
                    return 0;
                }
                if(!(s.charAt(i+1)<='9'&&s.charAt(i+1)>='0')){
                    return 0;
                }
                value=new StringBuilder();
                isPositive=1;
                continue;
            }


            if(c==' '){
                if(value.length()>0){
                    break;
                }
                continue;
            }

            if(c>'9' || c<'0'){
                break;
            }
            value.append(c);

        }
        if(value.length()==0){
            return 0;
        }
        long re=Long.parseLong(value.toString())*isPositive;
        if(re>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(re<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) re;
    }

    /**
     * 正确答案
     * @param s
     * @return
     */
    public int myAto1(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        int currentIndex=0;
        while (currentIndex < length && chars[currentIndex] == ' ') {
            currentIndex++;
        }
        if(currentIndex==length){
            return 0;
        }

        int isPositive=1;
        if(chars[currentIndex]=='+'){
            currentIndex++;
        }else if(chars[currentIndex]=='-'){
            isPositive=-1;
            currentIndex++;
        }
        int integer = 0;
        while (currentIndex<length){

            if(chars[currentIndex]>'9' || chars[currentIndex]<'0'){
                break;
            }

            //提前判断乘以10之后是否超过了最大最小值
            if(integer>Integer.MAX_VALUE/10 || (integer==Integer.MAX_VALUE/10 && (chars[currentIndex]-'0')>Integer.MAX_VALUE%10) ){
                return Integer.MAX_VALUE;
            }
            if(integer<Integer.MIN_VALUE/10 || (integer==Integer.MIN_VALUE/10 && (chars[currentIndex]-'0')> -(Integer.MIN_VALUE%10))){
                return Integer.MIN_VALUE;
            }

            integer=integer*10+(chars[currentIndex++]-'0')*isPositive;

        }

        return integer;
    }

    public int new1(String s){
        int len = s.length();
        char[] charArray = s.toCharArray();

        // 1、去除前导空格
        int index = 0;
        while (index < len && charArray[index] == ' ') {
            index++;
        }

        // 2、如果已经遍历完成（针对极端用例 "      "）
        if (index == len) {
            return 0;
        }

        // 3、如果出现符号字符，仅第 1 个有效，并记录正负
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        // 4、将后续出现的数字字符进行转换
        // 不能使用 long 类型，这是题目说的
        int res = 0;
        while (index < len) {
            char currChar = charArray[index];
            // 4.1 先判断不合法的情况
            if (currChar > '9' || currChar < '0') {
                break;
            }

            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            // 4.2 合法的情况下，才考虑转换，每一步都把符号位乘进去
            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;
    }
}
