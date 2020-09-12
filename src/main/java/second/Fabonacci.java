package second;

/**
 * 斐波那契数列
 * 1 1 2 3 5 8 13 21
 */
public class Fabonacci {

    public static  long getFb(int n){
        if(n<=0){
            return  0;
        }
        if(n ==1){
            return 1;
        }
        long a=0;
        long b=1;
        long sum=0;
        for(int i=2;i<=n;i++){
            sum =a+b;
            a=b;
            b=sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        long fb = getFb(8);
        System.out.println(fb);
    }
}
