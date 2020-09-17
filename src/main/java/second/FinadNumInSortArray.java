package second;

/**
 * 在排序数组中查找数字
 *   数字在排序数组中出现的次数
 * 思路分析：
 * 二分查找法  时间复杂度 o(longn)
 */
public class FinadNumInSortArray {


    public static void main(String[] args) {
        int [] nums={1,2,3,3,3,3,4,5};
        int i = find(nums, 3);
        System.out.println(i);
    }
    public static int find(int [] nums,int k){
       int first=findFirst(nums,0,nums.length-1,k);
       int last =findEndIndex(nums,0,nums.length-1,k);
       if(first>-1 && last>-1){
           return last-first+1;
       }
       return  -1;
    }

    private static int findFirst(int[] nums, int start, int end, int k) {
        if(start>end){
            return  -1;
        }
        int mid=(start+end)>>1;
        int data=nums[mid];
        if(data ==k){
            if((mid>0 && nums[mid-1]!=k) || mid ==0)  {
                return  mid;
            }else {
                end=mid-1;
            }
        }else  if(data<k){
            start=mid+1;
        }else {
            end=mid-1;
        }
        return findFirst(nums,start,end,k);
    }

    public static int findEndIndex(int [] arr,int start,int end,int k){

        if(start>end){
            return  -1;
        }
        int mid=(start+end)>>1;
        int data=arr[mid];
        if(data ==k){
            if((mid<arr.length-1 && arr[mid+1]!=k)|| mid ==arr.length-1) {
                return mid;
            }else {
                start=mid+1;
            }
        }else if( data<mid){
            start=mid+1;
        }else {
            end=mid-1;
        }


        return findEndIndex(arr,start,end,k);

    }




}



