package zcc.初级算法.数组._2;

/**
 * @author zcc  2022/4/9 18:51
 * 买股票的最好时机
 */
public class Solution_2 {


    public static void main(String[] args) {
        //贪心算法
        Solution_2 solution_2 = new Solution_2();
        int i = solution_2.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println("贪心算法答案："+i);
        //暴力破解法
        Solution_2 solution_21 = new Solution_2();
        int[] ints = {7, 1, 5, 3, 6, 4};
        solution_21.dfs(ints,0,ints.length,0,0);
        System.out.println("暴力破解答案："+solution_21.maxProfit);

    }

    /**
     * 实际上，只要上升区间求和
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int profit=0;
        for (int i = 0; i < prices.length - 1; i++) {
            profit+=Math.max(prices[i+1]-prices[i],0);
        }
        return profit;
    }

    private int maxProfit=0;

    /**
     *暴力破解法，这种方法，做了很多次无用功，走到第0天需要买入的逻辑，已经浪费了很多时间
     * @param prices
     * @param index
     * @param length
     * @param status 0表示不持有股票，1表示持有股票
     * @param profit
     */
    public void dfs(int[] prices,int index,int length,int status,int profit){
        if(index==length){
            this.maxProfit=Math.max(maxProfit,profit);
            return;
        }
        //什么都不做
        dfs(prices,index+1,length,status,profit);
        //买入
        if(status==0){
            dfs(prices,index+1,length,1,profit-prices[index]);
        }else {
            //卖出
            dfs(prices,index+1,length,0,profit+prices[index]);
        }

    }
}
