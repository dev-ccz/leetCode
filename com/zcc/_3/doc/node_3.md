这道题是一个典型的滑动窗口题目

滑动窗口其实有一套万能模板，步骤如下

##### 1.定义需要维护的变量们 （对于滑动窗口里题目，这些变量通常是最大长度、最短长度、哈希表等等）

##### 2.定义窗口的首尾段，然后开始滑动窗口

##### 3.更新需要维护的变量，有的变量需要一个if预估去维护. 比如该题目中的left这个变量

##### 4.  待定 ...

##### 5.返回答案

下面分析一下，这道题的题解

```java
public int lengthOfLongestSubstring(String s) {
        if(s.length()<1){ //判断长度，没什么说的，因为题目说字符串不会为null，不用判空
            return 0;
        }
    	//定义需要维护的变量，这里我们定义了最大值，和不重复字符串的最左下标，和一个哈希表  
        int max=0,left=0;
        Map<Character,Integer> map=new HashMap<>();
        //for循环内其实就定义了窗口的首尾段，开始滑动窗口	
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                //更新需要维护的变量，这里是需要保证left值在最右端，至于为什么这么做，
                // 用deedf这个字符串测试一下就知道了，当走到第二个d的时候，其实left在第二个e的位置，
                // 如果不这么干，让left=map.get(s.charAt(i))+1，也就是说上一次该字符出现的后一位，那么left就会倒退到第1个e的位置，不符合题解了
                left=Math.max(left,map.get(s.charAt(i))+1);
            }
            //更新需要维护的变量
            map.put(s.charAt(i),i);
            max=Math.max(max,i-left+1);
        }
    //返回值
        return max;
    }
```









