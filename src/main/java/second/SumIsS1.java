package second;

import java.util.ArrayList;

/**
 * 输出所有和为 S 的连续正数序列。  序列至少有两个数字
 *
 * 例如和为 100 的连续序列有：
 *
 * [9, 10, 11, 12, 13, 14, 15, 16]
 * [18, 19, 20, 21, 22]。
 *
 * 思路分析：
 * small big双指针
 * 终止条件  big<S   因为序列至少有两个数字 s==big时 必定只会有一个数字
 */
public class SumIsS1 {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> sumS = getSumS(100);
        System.out.println(sumS);
    }
    public  static ArrayList<ArrayList<Integer>> getSumS(int s){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        int start=1;
        int end=2;
        int curSum=3;
        while(end<s){
            if(curSum<s){
                end++;
                curSum+=end;
            }else if(curSum>s){
                curSum-=start;
                start++;
            }else {
                ArrayList<Integer> temp = new ArrayList<>();
                for(int i=start;i<=end;i++){
                    temp.add(i);
                }
                res.add(temp);
                curSum-=start;
                start++;
                end++;
                curSum+=end;
            }
        }
        return res;
    }
}
