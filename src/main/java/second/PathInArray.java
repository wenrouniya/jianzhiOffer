package second;

import java.util.Arrays;

/**
 * 矩阵中的路径
 * 设计一个函数  判断矩阵中是否存在一条包含某字符串的所有路径 每次可以在矩阵中向上下左右移动一格
 * 如果某条路径经过了该矩阵的某一格 则该路径不能再次进入该格子
 *
 * 思路分析：回溯
 * 用一个同等大小的数组去标记这个位置是否被访问过
 * 用一个变量去比较字符串匹配到的位置  字符串匹配到尾部 即为匹配成功
 *
 * 回溯非常适合由多个步骤组成的问题 每个步骤都有非常多的选项 某一步选择了其中一个选项时 就进入下一状态
 * 然后又面临新的选项 一直重复选 直到到达最终的状态
 * 并且每一步选择 要解决的都是同样的问题
 */
public class PathInArray {
    public static boolean hasPath(char [] array,int rows,int cols,String str){
        boolean [] isVisited =new boolean[rows*cols];
        Arrays.fill(isVisited,false);
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(hasPath(array,rows,cols,str,isVisited,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param array  矩阵数组
     * @param rows 行数
     * @param cols 列数
     * @param str 字符串
     * @param isVisited 是否访问过的标记符
     * @param row 当前行
     * @param col 当前列
     * @param index 字符串的第几个字符
     * @return
     */
    private static boolean hasPath(char[] array, int rows, int cols, String str, boolean[] isVisited, int row, int col, int index) {
        if(str.length() ==index){
            return true;
        }
        if(rows<1|| cols<1 ||col>cols || row>rows || col <0 || row<0 || index>str.length() || str.charAt(index)!=array[row*cols +col]){
            return false;
        }
        boolean hasPath =false;
        if(row>=0 && row<rows && col>0 && col<cols && str.charAt(index)== array[row*cols +col] && !isVisited[cols* row +col]){
            index++;
            isVisited[cols* row +col]=true;
            //一个返回true 其他均为短路运算符
            hasPath =hasPath(array,rows,cols,str,isVisited,row+1,col,index) ||
                    hasPath(array,rows,cols,str,isVisited,row,col+1,index) ||
                    hasPath(array,rows,cols,str,isVisited,row-1,col,index)||
                    hasPath(array,rows,cols,str,isVisited,row,col-1,index);

            if(!hasPath){
                index--;
                isVisited[cols++*row+col]=false;
            }
        }

        return hasPath;
    }

    public static void main(String[] args) {
        String str = new String("bcfe");
        char [] array={'a','b','t','g','c','f','c','s','j','d','e','h'};
        boolean b = hasPath(array, 3, 4, str);
        System.out.println(b);

    }

}
