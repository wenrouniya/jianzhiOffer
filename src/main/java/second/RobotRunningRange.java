package second;

import java.util.Arrays;

/**
 * 机器人运动范围
 *  有一个m行n列的方格 机器人从坐标（0，0）的格子开始移动 每次可以向上下左右移动一格
 *  但不能进入行坐标和列坐标位数之和大于k
 *  的格子  请问机器人能到达多少个格子
 *
 *  思路分析：回溯
 *  去到（m，n）的格子 判断能否到达  能返回1 不能返回0  将返回结果相加
 *  同样可以用一个同等大小的数组判断是否访问过 避免重复计算 也避免结果重复相加
 */
public class RobotRunningRange {

    public static void main(String[] args) {
        int resut = getResut(15, 20, 20);
        System.out.println(resut);
    }

    public static  int getResut(int rows,int cols,int k){
        if(rows<1  || cols <1 || k<0){
            return 0;
        }
        boolean [] isVisited =new boolean[rows*cols];

        Arrays.fill(isVisited,false);

        return  getResut(rows, cols, k, isVisited, 0, 0);


    }

    private static int getResut(int rows, int cols, int k, boolean[] isVisited, int row, int col) {
        if(row<0 || row>=rows || col<0 || col>=cols){
            return 0;
        }
        int count =0;
        if(!isVisited[cols*row +col] && lessThanK(col,row,k)){
            isVisited[cols*row +col]=true;
            count=1+getResut(rows,cols,k,isVisited,row+1,col)
                    +getResut(rows,cols,k,isVisited,row,col+1)
                    +getResut(rows,cols,k,isVisited,row-1,col)
                    +getResut(rows,cols,k,isVisited,row,col-1);
        }
        return count;


    }

    private static boolean lessThanK(int col, int row, int k) {
        int sum =0;
        while(col >0){
            sum+=col%10;
            col/=10;
        }
        while(row>0){
            sum+=row%10;
            row/=10;
        }

        return sum<=k ? true:false;
    }
}
