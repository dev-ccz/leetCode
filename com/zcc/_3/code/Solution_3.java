package zcc._3.code;


import java.util.HashMap;
import java.util.Map;

/**
 * @author zcc  2022/3/30 17:03
 */
public class Solution_3 {

    public int lengthOfLongestSubstring(String s) {
        if(s.length()<1){
            return 0;
        }
        int max=0; //
        int left=0;
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                left=Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max=Math.max(max,i-left+1);
        }
        return max;
    }
}
