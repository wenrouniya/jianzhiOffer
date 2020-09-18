package second;

/**
 * 建立乘积数组
 * 给定一个数组 A[0, 1,..., n-1]，
 * 请构建一个数组 B[0, 1,..., n-1]，
 * 其中 B 中的元素 B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。要求不能使用除法。
 *
 * 思路分析：
 * 将A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1] 划分成两部分
 * A[0]*A[1]*...*A[i-1]      和   A[i+1]*...*A[n-1]
 * 先与1相乘后 再与+1的位置相乘 将当前位置的数字空过去 以此类推
 */
public class BuildProductArray {

    public static void main(String[] args) {
        int[] multiply = multiply(new int[]{ 2, 3, 4, 5});
        for (int i:multiply){
            System.out.print(i+" ");
        }
    }

    public  static  int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        for (int i = 0, product = 1; i < n; product *= A[i], i++)       /* 从左往右累乘 */
            B[i] = product;
        for (int i = n - 1, product = 1; i >= 0; product *= A[i], i--)  /* 从右往左累乘 */
            B[i] *= product;
        return B;
    }
}
