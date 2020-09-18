package second;

import java.util.Arrays;

/**
 * 扑克牌中的顺子
 *
 * 五张牌，其中大小鬼为任意数，牌面为0。判断这五张牌是否能组成顺子。
 *  思路分析：
 *  1. 将扑克牌数组排序
 *  2. 统计数组中0的个数
 *  3.统计排序后的数组中相邻数字之间的空缺总数
 *  注意 ：如果其中有对子 肯定不能组成顺子
 *
 *
 */
public class ShunziInPlayingCard {


    public static void main(String[] args) {
        boolean shunzi = isShunzi(new int[]{1, 6, 3, 4, 6});
        System.out.println(shunzi);
    }
    public static boolean isShunzi(int [] nums){
        if(nums.length!=5){
            return false;
        }

        Arrays.sort(nums);
        int zeroNum=0;
        for(int i:nums){
            if( i==0){
                zeroNum++;
            }
        }

        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1] ==nums[i]){
                return false;
            }
            zeroNum-=nums[i+1]-nums[i]-1;
        }
        return zeroNum>=0;
    }
}
