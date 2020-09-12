package second;

/**
 * 减绳子 ： 贪心
 * 当绳子长度 大于5 时  将绳子尽可能的剪成3 段
 * 当剩下的绳子长度为4时 就将绳子剪成2段
 * 若剪成3 而剩下1 就步剪成3  留成4剪成2*2 因为2*2 >3*1
 *
 * 贪心和动态规划时不一样的 基于贪心解决问题时间
 * 每一步都可以做出一个贪婪的选择  基于这个选择 我们能够给确定最优解
 * 应用贪心算法时 需要用数学来证明 每次贪婪的选择时正确的
 */
public class CutCord1 {

    public static void main(String[] args) {
        int result = getResult(7);
        System.out.println(result);
    }
    public  static  int getResult(int n){
        if(n<2){
            return 0;
        }
        if(n==2){
            return 1;
        }
        if( n==3){
            return  2;
        }

        int threeTime=n/3;
        if(n-threeTime*3 ==1){
            threeTime--;
        }
        int twoTime=(n-threeTime*3)/2;
        return (int) (Math.pow(2,twoTime)*Math.pow(3,threeTime));

    }
}
