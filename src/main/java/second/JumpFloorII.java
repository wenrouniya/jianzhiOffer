package second;

import java.util.Arrays;

/**
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级...
 * 它也可以跳上 n 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 思路分析：
 * f(n)=1+f(n-1)+f(n-2)+...+f(1);
 * f(n)=Math(2,n-1);
 */
public class JumpFloorII {

    public static  int getResult(int n){
        int [] res=new int [n+1];
        Arrays.fill(res,1);
        for(int i=1;i<=n;i++){
            for(int j=1;j<i;j++){
                res[i]+=res[j];
            }
        }
        return res[n];
    }

    public static void main(String[] args) {
        int result = getResult(5);
        System.out.println(result);
    }
}
