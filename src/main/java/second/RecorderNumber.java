package second;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组 实现一个函数来调整该数组中数字的顺序
 * 使所有技术位于数组的前半部分 偶数位于数组的后半部分
 * <p>
 * 思路分析：
 * 两个指针
 */
public class RecorderNumber {

    public static void main(String[] args) {
        int[] nums = {9, 3, 1, 2, 5, 4, 8};
        record(nums);
        for(int i:nums){
            System.out.print(i+" ");

        }
    }

    public static void record(int[] nums) {

        if (nums == null) {
            return;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            while (i < j && (nums[i] & 1) != 0) {
                i++;
            }
            while (i < j && (nums[j] & 1) == 0) {
                j--;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }
}
