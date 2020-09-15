package second;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 最小的k个数
 * 输入整数n找出其中最小的k个数字
 *
 * 思路分析：
 * 1. 利用快排的思路 移动到第k个位置的就是最小的第k个
 * 如果移动位置的大于k  最小的就在左边  如果移动位置小于k 最小的第k个就在右边
 * 2. 利用大根堆 当堆不到k个数据 直接插入 如果满了
 * 和最大的数据比较 如果比最大的数字大 那肯定不是第k小 如果比大根堆的最大数小 就入堆
 */
public class MinK {

    public static void main(String[] args) {
        int [] nums={3,2,5,8,4,7};
        int minK = getMinK(nums, 3);
       // ArrayList<Integer> list = new ArrayList<Integer>(3);
//        for(int i=0;i<3;i++){
//            list.add(nums[i]);
//        }
//        System.out.println(list);
        ArrayList<Integer> minK2 = getMinK2(nums, 4);
        System.out.println(minK2);
    }

    public  static int getMinK (int []  nums ,int k){

      int kk=  partition(nums,0,nums.length-1);

     while(kk !=k-1){
         if( kk>k-1){
             kk=partition(nums,0,kk-1);
         }else {
           kk=  partition(nums,kk+1,nums.length-1);
         }
     }

      return nums[kk];

    }

    private static int  partition(int[] nums, int start, int end) {

        if(start>end){
            return -1;
        }

         int i=start;
         int j=end;
         int temp=nums[start];
          while (i< j){
              while(i<j && nums[j]>=temp){
                  j--;
              }
              while(i<j && nums[i]<=temp){
                  i++;
              }
              if(i<j){
                  int ll=nums[i];
                  nums[i]=nums[j];
                  nums[j] =ll;
              }
          }
          nums[start]=nums[i];
          nums[i]=temp;
          return i;


    }

    /**
     * 大顶堆的方式
     * @param nums
     * @return
     */
    public  static  ArrayList<Integer> getMinK2(int [] nums,int k){

        //o1-o2 升序
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)-> o2-o1);

        for(int i=0;i<nums.length;i++){
            queue.offer(nums[i]);
            if(queue.size()>k){
                queue.poll();
            }
        }

        return new ArrayList<>(queue);
    }
}
