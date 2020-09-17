package second;

import com.sun.corba.se.impl.naming.cosnaming.InternalBindingValue;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 求滑动窗口的最大值
 * 思路分析：
 * 使用一个大顶堆 大小为滑动窗口的大小
 * 堆中不断维护当前滑动窗口的最大值
 */
public class SlidingWindow {

    public static void main(String[] args) {
        ArrayList<Integer> max = getMax(new int[]{2, 3, 4, 2, 6, 2, 5}, 3);
        System.out.println(max);
    }
    public static ArrayList<Integer> getMax(int [] arr,int k){
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k,(o1,o2)->o2-o1);
        for (int i = 0; i < k; i++)
            heap.add(arr[i]);
        list.add(heap.peek());
        for (int i = 0, j = i + k; j < arr.length; i++, j++) {            /* 维护一个大小为 size 的大顶堆 */
            heap.remove(arr[i]);
            heap.add(arr[j]);
            list.add(heap.peek());
        }
        return  list;
    }
}
