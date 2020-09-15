package second;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {3, 25, 5, 6, 7};
        sort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int temp = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            //必须在等于的时候也可以移动 不然就会出现 元素重复赋值的问题
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
        sort(nums, i + 1, right);
        sort(nums, left, i - 1);
    }

    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }
}
