package second;

/**
 * 数组中唯一只出现一次的数字
 *
 * 一个数组中除一个数字只出现一次之外 其他数字都出现了三次 请找出那个只出现了一次的数字
 *
 * 思路分析：
 * 把数组中所有数字的二进制表示的每一位都加起来 如果某一位的和能被3整除 那么那个只出现一次的数字二进制表示中
 * 对应的哪一位就是0 否则就是1
 *
 * 用一个32位的整型保存 int 的每一位
 * << 左移
 * >> 右移
 */
public class OnlyOnceNumber1 {

    public static int getSpecial(int [] nums){
        int [] bit=new int[32];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<32;j++){
                // 讲第j位的数字右移到最低位 和1相与 计算该位是否为1
                bit[j]+=(nums[i]>>j)&1;
            }
        }

        int res=0;
        for(int i=0;i<32;i++){
            if(bit[i]%3 ==1){
                //将1左移到固定位置  与res相加
                res+=1<<i;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int special = getSpecial(new int[]{1, 1, 1, 2, 2, 2, 3});
        System.out.println(special);
    }

}
