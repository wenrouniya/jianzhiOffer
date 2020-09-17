package second;

/**
 * 数组中逆序对
 * 输入一个数组 求这个数组中的逆序对的总数
 *
 * 思路分析：使用归并排序
 *
 */
public class ReservePairInArray {
    public static void main(String[] args) {
        int [] nums={7,5,6,4};
        mergeSort(nums,0,3);
        System.out.println(cnt);
    }

    private static  int cnt=0;

    private  static void mergeSort(int [] nums,int low,int high){
        if (high-low<1){
            return ;
        }
        int mid=low+((high-low)>>1);
        mergeSort(nums,low,mid);
        mergeSort(nums,mid+1,high);
        merge(nums,low,mid,high);
    }

    private static void merge(int[] nums, int low, int mid, int high) {

        int [] temp=new int[high-low+1];
        int index=0;
        int p1=low;
        int p2=mid+1;
        while(p1<=mid && p2<=high){
            if(nums[p1]<=nums[p2]){
                temp[index++]=nums[p1++];
            }else {
                //nums[p1] 大于nums[p2] 说明nums[p1.....mid]都大于nums[p2]
                cnt+=mid-p1+1;
                temp[index++]=nums[p2++];
            }
        }
        while(p1<=mid){
            temp[index++]=nums[p1++];
        }
        while (p2<=high){
            temp[index++]=nums[p2++];
        }
        for(int i=0;i<temp.length;i++){
            nums[low++]=temp[i];
        }
    }
}


