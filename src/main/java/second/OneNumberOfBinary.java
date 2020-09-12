package second;

/**
 * 计算二进制中 一的个数
 *
 * 思路分析：
 *
 */
public class OneNumberOfBinary {

    public static void main(String[] args) {
        int result = getResult(500);
        System.out.println(result);
    }

    public  static int getResult(int n){

        int flag=1;
        int count =0;
        while (flag !=0 ){
            if((n & flag) !=0){
                count ++;
            }
            flag=flag<<1;
        }
        return count;
    }
}
