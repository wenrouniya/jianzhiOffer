package second;

/**
 * n个骰子的点数
 * 把n个点子扔在地上 所有的骰子朝上一面的点数之和为s  输入n
 * 打印出s的所有的可能的值出现的概率
 */
public class SumOfDice {
    public static void main(String[] args) {
        printProbilities(3);
    }
//    public static void PrintProbability_1(int number) {
//        if (number < 1) {
//            return;
//        }
//        int[][] pProbabilities = new int[2][6 * number + 1];
//        for (int i = 0; i < 6; i++) {//初始化数组
//            pProbabilities[0][i] = 0;
//            pProbabilities[1][i] = 0;
//        }
//        int flag = 0;
//        for (int i = 1; i <= 6; i++) {//当第一次抛掷骰子时，有6种可能，每种可能出现一次
//            pProbabilities[flag][i] = 1;
//        }
//        for (int k = 2; k <= number; k++) {
//            for (int i = 0; i < k; i++) {//第k次掷骰子，和最小为k，小于k的情况是不可能发生的！所以另不可能发生的次数设置为0！
//                pProbabilities[1 - flag][i] = 0;
//            }
//            for (int i = k; i <= 6 * k; i++) {//第k次掷骰子，和最小为k，最大为6*k
//                pProbabilities[1 - flag][i] = 0;//初始化，因为这个数组要重复使用，上一次的值要清0
//                for (int j = 1; j < i && j <= 6; j++) {   //当前骰子可能出现的值  最大值不能超过i和6
//                    //j>=i 说明另一个骰子出现的是 0 或者负数 显然是不可能的 而当前骰子的值也不可能超过6
//                    pProbabilities[1 - flag][i] += pProbabilities[flag][i - j];
//                }
//            }
//            flag = 1 - flag;
//        }
//        double total = Math.pow(6, number);
//        for (int i = number; i <= 6 * number; i++) {
//            double ratio = pProbabilities[flag][i] / total;
//            System.out.println("sum: " + i + " ratio: " + ratio);
//        }
//    }                                          k9mimju jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjtt      tttttttttttttttttttttt t

    public static void printProbilities(int n) {
        if (n == 1) {
            return;
        }
        int[][] p = new int[2][6 * n+1];
        int flag = 0;

        //对只有一个骰子的进行初始化
        for (int i = 1; i <= 6; i++) {
            p[flag][i] = 1;

        }
        for (int k = 2; k <= n; k++) {
            //对不可能出现的和值清零
            for (int i = 0; i < k; i++) {
                p[1 - flag][i] = 0;
            }
            //开始累加所有出现的可能
            for (int i = k; i <= k * 6; i++) {
                //数组重复用 上一次的要清0
                p[1 - flag][i] = 0;
                //当前骰子可能出现的数字
                for (int j = 1; j <= 6 && j <i; j++) {
                    p[1 - flag][i] += p[flag][i - j];
                }
            }
            flag = 1 - flag;
        }

        double total = Math.pow(6, n);

        for (int i = n; i <= 6 * n; i++) {
            double probility = p[flag][i] / total;
            System.out.println("出现 " + i + "的概率是 " + probility);
        }

    }


}