package second;

/**
 * 数字翻译成字符串
 *
 * 给定一个数字，按照如下规则翻译成字符串：1 翻译成“a”，2 翻译成“b”... 26 翻译成“z”。
 * 一个数字有多种翻译可能，例如 12258 一共有 5 种，分别是 abbeh，lbeh，aveh，abyh，lyh。
 * 实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 思路分析：
 * 递归
 * 为了 避免重复子问题 可以从右到左翻译并计算不同翻译的数目
 *
 */
public class NumTransferString {

    public static void main(String[] args) {
        int count = getCount(12258);
        System.out.println(count);
    }
    public static int getCount(int number){
        if(number<0){
            return 0;
        }

        String s = String.valueOf(number);
        int length =s.length();
        int []  counts =new int[length];
        int count =0;
        for(int i=length-1;i>=0;i--){
            count=0;
            if(i<length-1){
                //当前位用一位数表达时
                count=counts[i+1];
            }else{
                count =1;
            }

            if(i<length-1){
                int one=s.charAt(i)-'0';
                int two=s.charAt(i+1)-'0';
                int converted =one*10+two;
                //当前位可以用两位数表达时
                if(converted >=10 && converted<=25){
                    if(i<length-2)
                        count+=counts[i+2];
                    else
                        count+=1;
                }
            }
            counts[i]=count;
        }

        return counts[0];
    }
}
