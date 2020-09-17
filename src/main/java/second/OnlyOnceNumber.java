package second;

/**
 * 只出现一次的数字
 * 数组中除了两个数字之外 其他数字都出现了两次 请找出这种两个只出现一次的数字
 *
 * 思路分析：
 * 两个相同的数字 进行 异或运算 结果为0
 *
 * 我们可以让数组中的每一个数异或一下，最后会得到一个结果ret，
 * 就是两个出现一次的数字的异或结果这个结果肯定是由两个不同数字异或而来，
 * 因此我们找ret二进制中为1的位置i，因为1一定是由0,1异或而来，
 * 因此要求得两个数中，一定有一个数的二进制中的第i个位置为1， 一个为0.
 *
 * 如何找到位置i？可用i = ret ^ (-ret)
 * 因为计算机用补码存取二进制数，而负数的补码为反码+1，举个例子
 * 假如ret = 1110 ， -ret = 0010 , 所以 i = 0010
 * 所以，再异或一遍即可得到答案。
 */
public class OnlyOnceNumber {

    public static void main(String[] args) {
        int [] nums={1,1,2,2,3,4};
        int [] res1=new int[1];
        int [] res2=new int[1];
        getSpecial(nums,res1,res2);
        System.out.println("   ");
    }

    public static void getSpecial(int [] nums,int[] res1,int [] res2){
        int bit=0;
        for(int temp:nums){
            bit^=temp;
        }
        //找到最右侧第一个为1 的位置
        bit&= -bit;

        for(int temp: nums){
            if((temp &bit) ==1){
                res1[0]^=temp;
            }else {
                res2[0]^=temp;
            }
        }
    }
}
