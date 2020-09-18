package second;

/**
 * 股票的最大利润
 *  输入一个数组 求其中股票的最大利润
 */
public class BiggestProfitOfStock {

    public static void main(String[] args) {
        int biggestProfit = getBiggestProfit(new int[]{9, 11, 8, 5, 7, 12, 16, 14});
        System.out.println(biggestProfit);
    }

    public  static int getBiggestProfit(int [] nums){
        if(  nums ==null ||nums.length ==0 ){
            return 0;
        }
        int min=nums[0];
        int profit=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]<min){
                min=nums[i-1];
            }
            int temp=nums[i]-min;
            if(temp>profit){
                profit =temp;
            }
        }
        return profit;
    }
}
