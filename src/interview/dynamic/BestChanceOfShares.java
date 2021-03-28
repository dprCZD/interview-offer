package interview.dynamic;

/**
 * @Author: czd
 * @Date: 2021/3/14 19:54
 */
public class BestChanceOfShares {

    /**
     * @param prices
     * @return
     * @Description: 一次交易 假设你有一个数组，其中第i 个元素是股票在第i 天的价格。
     * 你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。请你设计一个算法来计算可以获得的最大收益。
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        // write code here
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            //当前值如果是最小值，考虑假设当前值买入；
            if (prices[i] < min) {
                min = prices[i];
            }
            //如果当前值不是最小值，考虑当前值卖出是否能利益最大化。
            else {
                max = Math.max(max, prices[i] - min);
            }
        }
        return max;
    }

    /**
     * 假定你知道某只股票每一天价格的变动。
     * 你最多可以同时持有一只股票。但你可以无限次的交易（买进和卖出均无手续费）。
     * 请设计一个函数，计算你所能获得的最大收益。
     * 解法：直接贪心，如果差值为正直接累加。
     *
     * @param prices
     * @return
     */
    public int unlimitMaxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        // write code here
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                max += prices[i] - min;
            }
            min = prices[i];
        }
        return max;
    }

    /**
     * 两次交易
     * 假定你知道某只股票每一天价格的变动。
     * 你最多可以同时持有一只股票。但你最多只能进行两次交易（一次买进和一次卖出记为一次交易。买进和卖出均无手续费）。
     * 请设计一个函数，计算你所能获得的最大收益。
     * 解法：直接根据场景模拟。
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        // write code here
        int buy1 = -prices[0];
        int sell1 = 0;
        int buy2 = -prices[0];
        int sell2 = 0;
        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }


    /**
     * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
     * <p>
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
     * 解法：根据2次交易的逻辑推导得出；dp的纵轴为当前的天数，横轴为 无操作 一次买入 一次卖出 二次买入 二次卖出... k次买入 k次卖出....
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfitK(int k, int[] prices) {
        // write code here

        if (prices.length == 0 || k == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2 * k + 1];
        //初始化，第0天每一次都买入，每一次卖出收益都为0。
        for (int i = 1; i < 2 * k + 1; i += 2) {
            dp[0][i] = -prices[0];
            dp[0][i + 1] = 0;
        }

        for (int i = 1; i < prices.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i][1] + prices[i]);
            for (int j = 1; j < 2 * k + 1; j += 2) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1] - prices[i]);
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i][j] + prices[i]);
            }
        }
        return dp[prices.length - 1][2 * k];
    }

}
