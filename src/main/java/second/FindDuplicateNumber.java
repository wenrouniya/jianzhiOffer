package second;

/**
 * 找出数组中重复的数字
 * 长度为n的数组中所有的数字都在0~n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个是重复的，找出数组中任意一个重复的数字
 *
 * 思路分析： 将每一个数字移动到对应的数组下标上 如果下标上的数字是不等于该下标的 就交换两个数字
 * 如果改下标上的数字等于该下标 说明已经出现重复数字 返回该数字
 *
 * 时间复杂度 O(N) 空间复杂度 O(1)
 * */
public class FindDuplicateNumber {

    public static int findDuplicatie(int [] nums){

        if(nums == null || nums.length ==0){
            return -1;
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i){
                if(nums[nums[i]]==nums[i]){
                    return  nums[i];
                }else{
                    int temp=nums[nums[i]];
                    nums[nums[i]]=nums[i];
                    nums[i]=temp;
                }
            }
        }
        return  -1;
    }

    public static void main(String[] args)  {
        int [] nums={0,2,2,3,5,7};
        int duplicatie = findDuplicatie(nums);
        System.out.println(duplicatie);
    }
}
