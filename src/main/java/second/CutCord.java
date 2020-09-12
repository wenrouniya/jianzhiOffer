package second;

/**
 * 减绳子： 动态规划版本
 *  给一段长度为n的绳子 请把绳子减成m段  计算这m段长度乘积的最大值
 *
 *  思路分析：
 *  从下到上的解决问题  f(i)=Math.max(f(j)* f(i-j))  其中0<j<i
 *  先计算出基础段绳子最大的乘积  再计算后面的
 *  比如说先计算f(1) f(2) f(3) 再计算f(4) f(5) 直到得到f(n)
 *
 */
public class CutCord {

    public static void main(String[] args) {
        int result = getResult(7);
        System.out.println(result);
    }

    public  static   int getResult(int n){
        if(n<2){
            return 0;
        }
       if(n==2){
           return 1;
       }
       if( n==3){
           return  2;
       }

       //代表被剪成这一段 长的绳子 他能拥有的最大乘积
       int [] cordLength=new int[n+1];
       cordLength[0] =0;
       cordLength[1] =1;
       cordLength[2]=2;
       cordLength[3]=3;
       for(int i=4;i<=n;i++){
       int max=0;
           for(int j=1;j<=i/2;j++){
               int res=cordLength[j]* cordLength[i-j];
               if(res>max){
                   max=res;
               }
           }
           cordLength[i]=max;
       }
       return cordLength[n];

    }
}
