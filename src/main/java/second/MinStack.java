package second;

import java.util.Stack;

/**
 * 包含min函数的栈：
 * 定义栈的数据结构  请在该函数中实现一个能够得到栈的最小元素的min函数
 * 在该栈中，调用min push pop的时间复杂度都是o(1)
 *
 * 思路分析：
 * 使用一个栈去正常的做push 和pop操作
 * 另一个栈栈顶一直保持当前栈内元素的最小值
 */
public class MinStack {

    public static Stack<Integer> stack =new Stack();
    public static Stack<Integer> minStack =new Stack();

    public void   push (int data){
        stack.push(data);
        minStack.push(minStack.isEmpty()?data:Math.min(minStack.peek(),data));
    }

    public int pop(){
        int data=stack.isEmpty()? Integer.MIN_VALUE :stack.pop();
        minStack.pop();
        return data;
    }

    public int getMin(){
        return minStack.peek();
    }
}
