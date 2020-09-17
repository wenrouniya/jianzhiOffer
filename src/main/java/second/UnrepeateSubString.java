package second;

import java.util.Arrays;

/**
 * 最长不含重复字符的子字符串
 *
 * 思路分析
 *  如果第i个字符之前没有出现过 则 f(i)=f(i-1)+1；
 *  如果出现过  则与上一次出现字符的距离记位d
 *   若d<=f(i-1) 此时第i个字符上次出现在f(i-1)对应的最长字符串中 因此f(i)=d
 *   若 d>f(i-1) 此时第个字符出现在f(i-1)对应的最长子字符串之前 此时  f(i)=f(i-1)+1
 *
 *   用一个长度位26的数组记录该字符上一次出现的位置
 *
 */
public class UnrepeateSubString {

    public static void main(String[] args) {

        int arabaccfr = getMaxLength("arabaccfr");
        System.out.println(arabaccfr);
    }

    private static  int getMaxLength(String str){
        int[] exits = new int[27];
        Arrays.fill(exits,-1);

        int [] dp=new int[str.length()];

        dp[0]=1;
        for(int i=1; i<str.length();i++){

            char ch=str.charAt(i);
            if(exits[ch-'a'] ==-1){
                dp[i]=dp[i-1]+1;
                exits[ch-'a']=i;
            }else {
                int d=i-exits[ch-'a']+1;
                if(d<=dp[i-1]){
                    dp[i]=d;
                }else{
                    dp[i]=dp[i-1]+1;
                }
            }
        }

        return  dp[str.length()-1];
    }


}
