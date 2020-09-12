package second;

/**
 * 青蛙跳台阶 青蛙每次可以选择跳一个台阶还是两个  那么n阶台阶有几种跳法
 * 思路分析:
 * 一节台阶 一种
 * 两节台阶 两种 1+1 或2
 * 三节台阶  f(3) =f(1)+f(2) =3
 * 四节台阶  f(4) =f(3) +f(2) =3+2=5;
 * 五节台阶  f(5)= f(4)+f(3)=5+3=8
 *
 * 所以f(n)=f(n-1)+f(n-2)
 */
public class JumpFloor {

    public static int getResult(int n){
        if(n<=2){
            return  n;
        }
        int [] res=new int[n+1];
        res[1]=1;
        res[2]=2;
        for(int i=3;i<=n;i++){
            res[i]=res[i-1]+res[i-2];
        }
        return res[n];
    }
    public static void main(String[] args) {
        int result = getResult(5);
        System.out.println(result);
    }
}
