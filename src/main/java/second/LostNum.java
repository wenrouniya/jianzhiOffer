package second;

/**
 * 0 ~n-1中缺失的数字
 * <p>
 * 思路分析：
 * 二分查找法  找到第一个下标数字不相等的位置 返回下标 即为 缺失的数字
 */
public class LostNum {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2};
        int lostNum = findLostNum(nums);
        System.out.println(lostNum);
    }

    public static int findLostNum(int[] nums) {
        return findLostNum(nums, 0, nums.length - 1);
    }

    private static int findLostNum(int[] nums, int start, int end) {
        if (start > end) {
            return -1;
        }
        while (start <= end) {
            int mid = (start + end) >> 1;
            int data = nums[mid];
            if (data != mid){
                if (mid == 0 || mid - 1 == nums[mid - 1]) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            }else{
                start = mid + 1;

            }

        }

        if(start ==nums.length){
            return  start;
        }
        return -1;
    }

}
