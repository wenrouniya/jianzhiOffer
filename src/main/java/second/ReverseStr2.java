package second;

/**
 * 左旋字符串
 * 把若干的字符串 移动到字符串的尾部
 *
 * 思路分析：
 * 1. 将原始字符分成两个部分
 * 2. 分别反转这两个部分
 * 3. 接下来反转整个部分
 */
public class ReverseStr2 {

    public static void main(String[] args) {
        String abcdef = recerse("abcdef", 2);
        System.out.println(abcdef);
    }
    public static  String recerse(String str,int k){
        char[] chars = str.toCharArray();
        ReverseStr.reserve(chars,0,k-1);
        ReverseStr.reserve(chars,k,chars.length-1);
        ReverseStr.reserve(chars,0,chars.length-1);

        return new String(chars);
    }

}
