package second;

/**
 * 实现 pow函数 不要调用函数类库  不必考虑大数问题
 */
public class Power {

    public  static double power(int base,int exponent){
        if(exponent ==0){
            return 1;
        }
        if(exponent ==1){
            return base;
        }
        boolean isNegative =false;
        if(exponent<0){
            isNegative=true;
            exponent=-exponent;
        }

        double pow = power(base * base, exponent / 2);
        if (exponent % 2 != 0)
            pow = pow * base;
        return isNegative ? 1 / pow : pow;

    }

    public static void main(String[] args) {
        double power = power(2, 3);
        System.out.println(power);
    }
}
