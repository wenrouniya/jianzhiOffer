package second;

/**
 * 旋转数组中最小的数字
 * 把一个数组元素最开始的若干个元素搬到数组的末尾  称为旋转数组
 * {1，2，3，4，5}-> {3,4,5,1,2}
 *
 *
 * 思路分析：
 * l头指针 m中间指针 h尾部指针
 * 当nums[m]>= nums[h]    旋转数组在[m+1,h]内  令l=m+1
 * 当nums[m]<nums[h]时  旋转数组在[l,m]内  令h=m;
 * 当nums[l]=nums[m]=nums[h] 时  无法通过上述确定旋转数组的范围 需要顺序查找  eg：{1,1,0,1}
 *
 */
public class MinNumberInArray {
    public static void main(String[] args) {
        int [] nums={1,1,0,1};
        int result = getResult(nums);
        System.out.println(result);
    }

    public  static  int getResult(int [ ]nums){
        int l=0;
        int h=nums.length-1;
        while (l<h){
            int m=(l+h)>>1;
            if(nums[l]== nums[m] && nums[l]== nums[h]){
               return  getResultOneByOne(nums);
            }else if(nums[m]>nums[h]){
                l=m+1;
            }else {
                h=m;
            }
        }
        return nums[l];
    }

    private static int getResultOneByOne(int[] nums) {
        int min=Integer.MAX_VALUE;
        for (int num:nums){
            if(num<min){
                min=num;
            }
        }
        return min;
    }
}
