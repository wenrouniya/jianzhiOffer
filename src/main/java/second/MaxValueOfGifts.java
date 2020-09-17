package second;

/**
 * 礼物的最大价值
 * 在m*n的棋盘上都放有一个礼物 每个礼物都有一定的价值 可以从期盼的左上角开始拿 走到最右下角 求能拿到的礼物最大值
 * 思路分析：
 * 动态规划
 * dp[i][j]=Math.max(dp[i-1][j],dp[i,j-1])+dp[i][j];
 *
 * 而计算第i行时 其i-2以及之前的数据都是无效的  只判断左和上即可 用一维数组优化
 * dp[i]=Math.max(dp(i-1)+dp(i）)+value(i,j);  此时dp[i]表示的是上一行的数据
 */
public class MaxValueOfGifts {

    public static void main(String[] args) {
        int [][] values={{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        int maxValue = getMaxValue(values);
        System.out.println(maxValue);
    }

    private static int getMaxValue(int [][] values){
      int [] dp=new int [values[0].length];

      for(int i=0;i<dp.length;i++){
          dp[i]=values[0][i];
      }
      for( int i=1;i<values.length;i++){
          for(int j=0;j<values[0].length;j++){
              if(j>0){
                  dp[j]=values[i][j]+Math.max(dp[j],dp[j-1]);
              }
              else {
                  dp[j]=values[i][j]+dp[j];
              }

          }
      }


      return dp[dp.length-1];
    }
}



