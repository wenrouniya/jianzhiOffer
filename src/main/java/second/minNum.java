package second;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 把数组排列成最小的数
 *  输入一个正整数数组 把数组里所有的数字拼接起来排成一个数 打印能拼接出的所有数字中最小的一个
 *  思路分析：
 *  拼接起来的字符串可能存在大数问题
 *  首先将数组中的整数转换成字符串  然后进行大小比较 最后把排好序的数组中的数字一次打印出来
 *
 *  比较两个字符串大小 s1 和s2时 比较的应该时 s1s2拼接起来和s2s1拼接起来的大小 如果s1s2<s2s1
 *  则应该把s1放在前面 否则应该把s2放在前面
 *
 */
public class minNum {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(32);
        list.add(321);
        String minNum = getMinNum(list);
        System.out.println(minNum);
    }

    private  static String getMinNum(ArrayList<Integer> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        String[] arr = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i) + "";
        }
        Arrays.sort(arr, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        String res = "";
        for (String str : arr) {
            res += str;
        }
        return res;
    }
}
