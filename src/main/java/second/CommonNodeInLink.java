package second;

import second.pojo.LinkedNode;

import java.util.Stack;

/**
 * 两个链表的第一个公共节点
 *
 * 思路分析：
 * 1. 把两个链表的结点分别放入两个栈  接下来比较栈顶的结点元素是否i昂同
 * 如果相同就比较下一个 直到找到最后一个相同的结点
 */
public class CommonNodeInLink {

    public static void main(String[] args) {
        LinkedNode node1 = new LinkedNode(1);
        LinkedNode node2 = new LinkedNode(2);
        LinkedNode node3 = new LinkedNode(3);
        LinkedNode node4 = new LinkedNode(4);
        LinkedNode node5 = new LinkedNode(5);
        LinkedNode node6 = new LinkedNode(6);
        LinkedNode node7 = new LinkedNode(7);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;

        node7.next=node4;

        int firstCommon = getFirstCommon(node1, node7);
        System.out.println(firstCommon);
    }

    private static Stack<Integer> stack1=new Stack<>();
    private  static  Stack<Integer> stack2=new Stack<>();

    public static int getFirstCommon(LinkedNode node1,LinkedNode node2){
        while(node1!=null){
            stack1.push(node1.data);
            node1=node1.next;
        }
        while(node2!=null){
            stack2.push(node2.data);
            node2=node2.next;
        }
        while(!stack2.isEmpty() && !stack1.isEmpty()){
            int temp1=stack1.pop();
            int temp2=stack2.pop();
            if(temp1 ==temp2 && stack2.peek()!=stack1.peek()){
                return temp1;
            }
        }
        return -1;
    }
}
