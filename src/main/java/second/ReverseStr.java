package second;

/**
 * 反转字符串
 * 思路分析：
 * 先反转单词句子中的所有字符 再反转句子中的单词
 */
public class ReverseStr {

    public static void main(String[] args) {
        String s = new String("i  am a student.");
        String reserve = reserve(s.toCharArray());
        System.out.println(reserve);
    }

    public  static  String reserve(char[]  chars){

        int i=0;
        int j=chars.length-1;
        //反转整个句子
        reserve(chars,i,j);
        //逐个反转单词
        int index=0;
        while(index<=j){
            if (index == j || chars[index] == ' ') {
                reserve(chars,i,index);
                i=index+1;
            }
                index++;
        }
        return new String(chars);
    }

    public  static void reserve(char[] chars, int i, int j) {
        int start=i;
        int end=j;
        while(start<end){
            swap(chars,start,end);
            start++;
            end--;
        }
    }

    private static void swap(char[] chars, int start, int end) {
        char temp=chars[start];
        chars[start] =chars[end];
        chars[end] =temp;
    }
}
