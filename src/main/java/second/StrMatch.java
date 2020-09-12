package second;

/**
 * 正则表达式匹配
 * 实现函数用来匹配包含  .和 * 的正则表达式
 * .表示任意一个字符  而* 表示前面的字符可以出现任意多次包括0次
 *
 * 模式串    abc*   匹配串  abcc
 * 思路分析：
 * 字符相等 去匹配下一位置字符
 *  下一个字符遇到.  匹配串和模式串都跳过2个字符
 *  下一个字符遇到*
 *          a.出现0 次  匹配串跳过两个字符 模式串跳过一个
 *          B. 出现1次 模式穿和匹配串都跳过一个字符
 *          c. 出现多次 模式串不动 匹配串跳过一个字符
 * 结束标志：
 *  模式串和匹配串都到达末尾 返回true
 *  模式串到末尾 而匹配串没到达末尾 返回false
 */
public class StrMatch {

    //s 是匹配串 p 是模式串
    public static  boolean  isMatch(String s,String p){
        if(s == null || p ==null){
            return false;
        }
       return  match(s,0,p,0);
    }

    //s 是匹配串 p 是模式串
    private static boolean match(String s, int sIndex, String p, int pIndex) {
        //两个字符串都匹配到末尾表示是匹配的
        if(sIndex == s.length() && p.length() ==pIndex){
            return true;
        }

        //匹配串到头而模式串未到头 不匹配
        if(sIndex!=s.length() && pIndex ==p.length()){
            return false;
        }

       if(pIndex+1<p.length() && p.charAt(pIndex+1)=='*'){
                        //匹配0位
               return match(s,sIndex,p,pIndex+2)||
                       //匹配一位
                       match(s,sIndex+1,p,pIndex+2)||
                       //匹配多个
                       match(s,sIndex+1,p,pIndex);
       }


       //当前这位字符是匹配的  即两个字符串都向后移动一位
       if(s.length()!=sIndex && s.charAt(sIndex)=='.'
       || s.length()!=sIndex && s.charAt(sIndex) ==p.charAt(pIndex)){
          return  match(s,sIndex+1,p,pIndex+1);
       }

       return false;
    }

    public static void main(String[] args) {
        String p = new String("ab*cd");
        String s = new String("acd");
        boolean match = isMatch(s, p);
        System.out.println(match);

    }
}
