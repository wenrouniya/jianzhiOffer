package second;

import java.util.HashMap;

/**
 * 第一个只出现一次的字符
 *
 * 思路分析：
 * 使用hashmap存储 key 是字符 value是出现的次数
 */
public class FristExitChar {

    public static void main(String[] args) {
        char abccdeff = getFirstExit("aabccdeff");
        System.out.println(abccdeff);
    }

    public static  char getFirstExit(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(map.get(ch) == null){
                map.put(ch,1);
            }else{
                Integer value = map.get(ch);
                map.put(ch,value+1);
            }
        }
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            Integer value = map.get(ch);
            if(value ==1){
                return  ch;
            }

        }
        return ' ';
    }
}
