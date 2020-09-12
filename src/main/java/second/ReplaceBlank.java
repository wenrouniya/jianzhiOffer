package second;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;

/**
 * 字符串空格替换
 * 将字符串中的空格替换成%20
 *
 * 思路分析：
 * 先遍历一遍字符串 统计出字符串中空格的个数 n
 * 双指针 一个指针指p1在原来字符串的末尾 另一个p2指在原末尾+n*2
 * p1 的字符向p2搬移
 * 遇到空格 就p2就写入%20   p1向前移动
 * 当p1 和p2 相遇时 就表示替换完毕
 * 时间复杂度o（n)
 * */
public class ReplaceBlank {

    public  static String replaceBlank(String str){
        char[] strings = str.toCharArray();
        int count =0;
        for (int i=0;i<strings.length;i++){

            if (strings[i] ==' ') {
                 count ++;
            }
        }
       char [] res= new char[strings.length+count*2];
        int p1=strings.length-1;
        int p2=res.length-1;
        while(p2>=0){
            if(strings[p1]==' '){
                p1--;
                res[p2--]='0';
                res[p2--]='2';
                res[p2--]='%';
            }
            res[p2--]=strings[p1--];
        }

        return  res.toString();
    }

    public static void main(String[] args) {
        String string  = new String("wo ai wo jia");
        String s = replaceBlank(string);
        System.out.println(s);
    }
}
