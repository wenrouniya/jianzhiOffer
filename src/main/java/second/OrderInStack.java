package second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 栈的压入和弹出顺序
 * 输入两个整数序列  第一个序列表示栈的压入顺序 判断第二个序列是否为该栈的弹出顺序 假设所有数字均不相等
 *
 * 思路分析:
 * 如果下一个弹出的数字刚好时栈顶数字 那么直接弹出
 * 如果下一个弹出的数字不是栈顶数字 就把序列中剩下的数字压栈 直到遇到需要弹出的数字 再弹出栈
 * 如果所有数字都压入栈仍然没有可弹出的数字 即不可能位弹出序列
 */
public class OrderInStack {

  public static Stack<Integer> stack=  new Stack<Integer>();

    public static void main(String[] args) {
        ArrayList<Integer> pushList = new ArrayList<Integer>();
        ArrayList<Integer> popList = new ArrayList<Integer>();
        pushList.addAll(Arrays.asList(1,2,3,4,5));
        popList.addAll(Arrays.asList(4,5,3,2,1));
        boolean orderInStack = isOrderInStack(pushList, popList);
        System.out.println(orderInStack);

    }

    public static  boolean isOrderInStack(ArrayList<Integer> pushList,ArrayList<Integer> popList){

        int popIndex=0;
        int pushIndex=0;
        while(pushIndex<pushList.size()){
            stack.push(pushList.get(pushIndex++));

            while(!stack.isEmpty()&& popIndex<popList.size() && stack.peek().equals(popList.get(popIndex))){
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();

    }
}
