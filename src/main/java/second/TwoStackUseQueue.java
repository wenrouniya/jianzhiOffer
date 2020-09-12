package second;

import java.util.Stack;

/**
 * 用两个栈实现队列 并实现appendTail 和deleteHead 函数
 */
public class TwoStackUseQueue {

    public static Stack<Integer> in=new Stack<Integer>();
    public static Stack<Integer> out=new Stack<Integer>();

    public static  void  appendTail(int data){
        in.push(data);
    }

    public static  int deleteHead() throws Exception {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }

        if(out.isEmpty()){
            throw new Exception("queue is empty ");
        }
        return out.pop();
    }

}
