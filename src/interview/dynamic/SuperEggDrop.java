package interview.dynamic;

/**
 * @Author: czd
 * @Description: 扔鸡蛋问题
 * 给你 k 枚相同的鸡蛋，并可以使用一栋从第 1 层到第 n 层共有 n 层楼的建筑。
 *
 * 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。
 *
 * 每次操作，你可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
 *
 * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
 *
 * @Date: 2021/4/5 21:26
 */
public class SuperEggDrop {


    /**
     * 逆向思维：思考丢一个鸡蛋最多能丢到几层楼。
     * @param k
     * @param n
     * @return
     */
    public int superEggDrop(int k, int n) {
        if(n == 1){
            return 1;
        }
        //dp的第一维表示操作次数，第二维表示当前剩余几颗鸡蛋，值表示当前可以到达的最高楼层。
        int [][]dp =new int [n+1][k+1];

        //初始状态，当操作数为1时，只能校验1楼。
         for(int i =1; i<=k;i++){
             dp[1][i] = 1;
         }

        //从第二次操作开始。
         for(int i=2;i<=n;i++){
             for(int j =1 ;j<=k;j++){
                 //状态转移方程：当前楼层+如果碎了的楼层+如果没碎的楼层。
                 dp[i][j]= dp[i-1][j-1]+dp[i-1][j]+1;
             }
             //当dp超过楼层数时，返回结果。
             if(dp[i][k]>=n){
                 return i;
             }
         }

         return 0;


    }
}
