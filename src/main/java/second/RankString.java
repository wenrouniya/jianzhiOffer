package second;


import java.util.ArrayList;
import java.util.Collections;

/**
 * 字符串的排列
 *  输入一个字符串 打印出该字符串中字符的所有排列
 */
public class RankString {

    public static void main(String[] args) {
        String abc = new String("abc");
        char[] chars = abc.toCharArray();
        ArrayList<String> list = new ArrayList<String>();
        rank(chars, 0, list);
        System.out.println(list);

    }

    /**
     * 二进制算法取每一位
     * @param ins
     * @return
     */
    public static void  rank(char[]  ins,int i,ArrayList<String> list ) {
        if(ins == null){
            return ;
        }
        //如果i指向最后一个字符
        if(i==ins.length -1){
            if(!list.contains(String.valueOf(ins))){
                list.add(String.valueOf(ins));
            }
        }else{
            //i代表 我们做排列操作的第一个字符
            for(int j=i;j<ins.length;j++){
                swap(ins,i,j);//将第一个字符与后面的字符做交换
                rank(ins,i+1,list);//对后面的字符进行全排列
                swap(ins,i,j);//再将之前交换的字符交换回来，以便第一个字符与其他字符进行交换
            }
        }



    }

    private static void swap(char[] ins, int i, int j) {
        char temp=ins[i];
        ins[i]=ins[j];
        ins[j]=temp;
    }
}
