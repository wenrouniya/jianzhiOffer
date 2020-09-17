package second;

/**
 * 丑数  只包含因子为2 3 5 的数称作丑数  习惯上把1当作第1个丑数  按从小到大的顺序 求第一个丑数
 *
 * 思路分析： 以空间换时间
 * 用一个数组把已有的丑数存起来 后面的丑数一定是前面丑数的2 3 5 倍  每次取最小的  直到计算到第N个
 *
 */
public class UglyNumber {
    public static void main(String[] args) {
        int ugly = getUgly(7);
        System.out.println(ugly);
    }

    public static int getUgly(int N){
        if(N< 6){
            return N;
        }
        int [] dp=new int[N];
        dp[0]=1;
        int i2=0;
        int i3=0;
        int i5=0;
        for(int i=1;i<N;i++){
            int next2=dp[i2]*2;
            int next3=dp[i3]*3;
            int next5=dp[i5]*5;
            dp[i]=Math.min(next2,Math.min(next3,next5));
            if(dp[i] ==next2){
                i2++;
            }
            if(dp[i] ==next3){
                i3++;
            }
            if(dp[i] ==next5){
                i5++;
            }
        }
        return dp[N-1];
    }


}
