package second;

import java.util.ArrayList;

/**
 * 圆圈中剩下的数字
 * 0-n-1这n个数字排成一个圆圈 从数字0开始 每次从这个圆圈中删除第m个数字 求圆圈中剩下的最后一个数字
 *
 * 思路分析：
 * 方法1：使用环型链表模拟每次被删除的数字
 *
 * 方法2：迭代法
 *  f[1] = 0
 * f[2] = (f{1] + m) % 2
 * f[3] = (f[2] + m) % 3
 * ...
 * f[n] = (f[n-1] + m) % n
 */
public class RemainingNumberInCricle {

    public static void main(String[] args) {
        int lastOne = getLastOne1(5, 3);
        System.out.println(lastOne);
    }
    public static int getLastOne(int n, int m){
        if(n<=0){
            return -1;
        }
        int index=0;
        for(int i=2;i<=n;i++){
            index=(index+m)%i;
        }
        return index;
    }


    public static int getLastOne1(int n,int m){
        if(n<0){
            return -1;
        }
        ArrayList<Integer> list = new ArrayList<>(n);
        for(int i=0;i<n;i++){
            list.add(i);
        }
        int cur=-1;

        while(list.size()>1){
            for(int i=0;i<m;i++){
                cur ++;
                if(cur == list.size()){
                    cur =0;
                }
            }
            list.remove(cur);
            //remove 后 cur会指向list中的下一个元素
            cur --;
        }
        return list.get(0);
    }
}
