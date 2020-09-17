package second;

/**
 * 1~n 整数中 1出现的次数
 * 例如 输入 12  则1~12这些整数中包含1的数字有  1、10、11、12 1一共出现了5次
 *
 * 思路分析：
 * https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/solution/mian-shi-ti-43-1n-zheng-shu-zhong-1-chu-xian-de-2/
 */
public class HasOneCount {

    public int NumberOf1Between1AndN_Solution(int n) {
        int cnt = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m, b = n % m;
            cnt += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        }
        return cnt;
    }
}
