package second;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 和为s的数字
 *
 * 在一个递增序列中返回和为s的一对数字 若有多个返回一对即可
 */
public class SumIsS {

    public static void main(String[] args) {
        ArrayList<Integer> sum = getSum(new int[]{1, 2, 3, 4, 5, 6, 7}, 7);
        System.out.println(sum);
    }

    public  static ArrayList<Integer> getSum(int [] nums,int s){
        ArrayList<Integer> res = new ArrayList<>();
        int  i=0;
        int j=nums.length-1;
        while(i<j){

            if(nums[i]+nums[j] ==s){
                 res.add(nums[i]);
                 res.add(nums[j]);
                 return res;
            }else if(nums[i] +nums[j]<s){
                i++;
            }else {
                j--;
            }
        }
        return  res;
    }
}
