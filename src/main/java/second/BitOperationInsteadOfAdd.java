package second;

/**
 * 位运算 代替加减法
 * 思路分析
 * 1.将两数相加 记为 x 不记录进位  1+1=0 0+1=1 0+0=0  这与 异或运算相同
 * 2.得到进位  记为y   1+1=10  0+0=0 1+0=0  相当于两个数做与运算 再左移一位
 * 3. 将不进位的数 x和进位的数Y 相加
 * 不断重复 上面的步骤 直到 进位为0
 */
public class BitOperationInsteadOfAdd {


    public static void main(String[] args) {
        int sum = getSum(3, 5);
        System.out.println(sum);
    }
    public static  int getSum(int x,int y){
        int sum,carry;
        do{
            sum=x^y;
            carry=(x&y)<<1;
            x=sum;
            y=carry;
        }while (carry !=0);

        return x;
    }
}
