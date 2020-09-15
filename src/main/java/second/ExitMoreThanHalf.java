package second;

/**
 * 数组中出现次数超过一半的数字
 * 思路一  基于快排
 * 将数组中的数字排好序  出现次数超过一半的数字肯定出现在n/2的位置
 * 所以找一个基准 进行排序 如果排序好刚好出现在n/2的位置 那么这个数字便是
 * 如果出现的位置大于n/2 那么target则在他的左边
 * 如果出现的位置小于n/2 那么target应该在他的右边
 * <p>
 * <p>
 * 思路二： 基于数组的特点  这个数字出现的次数比其他所有数字出现的次数和还要多
 * 每次保存一个temp 和times
 * 如果这个数字和temp相同 那么times+1
 * 如果数字不同 那么times-1 如果times ==0 则保存下一个数字 并把次数设置位1
 * 最后一个设置这个temp的数字就是我们要找的
 */
public class ExitMoreThanHalf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 5, 4, 2};
        int temp = getTemp(nums);
        System.out.println(temp);
    }


    public static int getTemp(int[] nums) {
        return getTemp(nums, 0, nums.length - 1);
    }

    private static int getTemp(int[] nums, int left, int right) {

        int temp = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && nums[j] >= temp) {
                j--;
            }

            while (i < j && nums[i] <= temp) {
                i++;
            }
            if (i < j) {
                int kk = nums[i];
                nums[i] = nums[j];
                nums[j] = kk;
            }

        }
        nums[left] = nums[i];
        nums[i] = temp;
        if (i == nums.length / 2) {
            return nums[i];
        } else if (i < nums.length / 2) {
            return getTemp(nums, i + 1, right);
        } else {
            return getTemp(nums, left, i - 1);
        }
    }

    public static int getResult(int[] nums) {
        int temp = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; i++) {
            if (times == 0) {
                temp = nums[i];
                times = 1;
            } else if (nums[i] != temp) {
                times--;
            } else {
                times++;
            }
        }
        return temp;
    }
}
