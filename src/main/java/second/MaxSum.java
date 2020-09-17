package second;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 连续子数组的最大和
 *
 * 数组中有正数也有负数 输入一个整形数组 求数组中多个整数组成的一个子数组 求所有数组的最大和
 *
 * 思路分析：
 *   如果当前和为负数  则当前和变为现在正在遍历的数字
 *   如果当前和为正数  那么当前和为 f(i-1)+curVal
 *   即
 *   f(i)= nums[i]    i==0 || f(i-1)<=0
 *   f(i)=f(i-1)+nums[i]   i!=0 && f(i-1)>0
 */
public class MaxSum {

    private static int  getMaxSum(int  [] array){
        int curSum =Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<array.length;i++){
            if(curSum<0){
                sum =array[i];
            }else{
                sum+=array[i];

            }
            //curSum 一直保存着最大值
            curSum =sum>curSum? sum:curSum;

        }
        return curSum;
    }

    public static void main(String[] args) {
        int [] nums={2,3,-4,5,6};
        int maxSum = getMaxSum(nums);
        System.out.println(maxSum);
    }
}
