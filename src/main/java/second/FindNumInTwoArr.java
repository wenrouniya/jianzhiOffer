package second;

/**
 * 二维数组中的查找
 * 二维数组中 每一行都按照从左到右升序排列  每一列也都按照从上倒下升序排列
 * 输入一个数字 判断二维数组中是否有该数组
 *  思路：
 *  从左下角开始遍历
 *   如果该数字相等 返回true
 *   如果该数字大于数组中的数字 列数+1
 *   如果该数字小于数组中的数字 行数-1
 *
 *   边界条件 : 行数>=0; 列数<=数组的列数
 *
 */
public class FindNumInTwoArr {

    public  static boolean isExist(int [][] nums,int standard){
        int rows=nums.length;//行
        int clos=nums[0].length;//列

        int row=rows-1;
        int clo=0;
        while(clo<clos && row >=0){
            if(nums[row][clo] ==standard){
                return true;
            }else if(nums[row][clo] <standard){
                clo++;
            }else{
                row--;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int [][] nums={{1,2,8,9},{2,4,9,12},{3,4,10,15}};
        boolean exist = isExist(nums, 4);
        System.out.println(exist);
    }
}