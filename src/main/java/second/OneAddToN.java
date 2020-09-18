package second;

/**
 * 从1+...+n
 *  不能使用* / —  for while if else switch case 等关键词 及条件判断语句
 *
 *  思路分析：
 *  递归
 *
 *   合理的使用结束条件  如n>0 以及短路 运算符 && 控制递归结束
 */
public class OneAddToN {

    public static void main(String[] args) {
        int sum = getSum(5);
        System.out.println(sum);
    }
    public static int getSum(int n){
        int sum =n;
       boolean b= n>0 && (sum+=getSum(n-1))> 0;
        return sum;
    }
}
