package second;

/**
 * 顺时针打印矩阵：
 * 输入一个矩阵 按照从外向里的顺序依次打印出每一个数字
 */
public class PrintArray {
    public static void main(String[] args) {
        int [][] array ={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        print(array);
    }

    public static void print(int [][] array){
        int  rr=0;
        int rows=array.length-1;
        int ll=0;
        int cols=array[0].length-1;

        while(rr<=rows && ll <=cols){
            //列 变行不变
            for(int i=ll;i<=cols;i++){
                System.out.print(array[rr][i]+" ");
            }
            //行变 列不变
            for(int j=rr+1;j<=rows;j++){
                System.out.print(array[j][cols]+" ");
            }
            //列变行不变
            for(int i=cols-1;i>=ll;i--){
                System.out.print(array[rows][i]+" ");
            }
            //行变列不变
            for(int j=rows-1;j>rr;j--){
                System.out.print(array[j][ll]+" ");
            }

            rr++;
            rows--;
            ll++;
            cols--;
        }
    }
}
