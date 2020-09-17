package second;

import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 * 思路分析：
 * 将数据元素一份为2  如果有新元素进来 如果是中位数 就在两部分之间
 * 只要保证容器左边的数据都小于右边的数据  即时左右的内部数据没有排序 也可以根据左边的最大数 和右边的最下树得到中位数
 * 用大顶堆实现这个容器 得到最大值的时间是O（1） 插入元素的时间是o(logn)
 *  所以左边部分用大顶堆来记录  右边部分用小顶堆来排序 保证数据平均分配到两个堆中 所以两个堆的数据数目之差不能超过1
 *  为了实现平均分配 可以在数据的总数目是偶数时 总是把新数插入最小堆  否则插入大顶堆
 *   为了保证最大堆中所有数据都小于最小堆  所以当新的数据比最大堆中的一些数据要小时
 *   可以把新数据插入最大堆 接着把最大堆中最大的数字拿出来插入最小堆 这样就保证了最小堆中所有数字都大于最大堆中的数字
 *
 *   同理 要把一个数据插入最大堆 但这个数据大于最小堆里的一些数据  可以先把树插入最小堆 再把最小堆里 最小的值取出来
 *   插入最大堆
 */
public class MidNumInFlu {

    public static void main(String[] args) {
        insert(2);
        insert(3);
        insert(4);
        int mid = getMid();
        System.out.println(mid);
    }
    //大顶堆 用来存左半边数据
    private static PriorityQueue<Integer> maxHeap=new PriorityQueue<>((o1,o2)->o2-o1);
    //小顶堆 用来存右半边数据
    private static  PriorityQueue<Integer> minHeap= new PriorityQueue<>();
    //现在存储的数据个数
    private  static int N=0;


    private  static void insert(int n){
        N++;

        //奇数个时插入大顶堆
        //为了保证大顶堆的全部元素是小于 小顶堆的 所以先将元素插入小顶堆 再将小顶堆的最小值插入大顶堆
        if(N%2 ==1){
            minHeap.offer(n);
            maxHeap.offer(minHeap.poll());
        }else{
            maxHeap.offer(n);
            minHeap.offer(maxHeap.poll());
        }
    }

    private static  int getMid(){
        if(N%2 ==0){
            //数个
            return  maxHeap.peek();
        }else{
            return  (maxHeap.peek()+minHeap.peek())/2;
        }
    }
}
