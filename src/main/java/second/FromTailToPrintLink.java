package second;

import java.util.Stack;

/**
 * 从尾到头打印链表
 */
public class FromTailToPrintLink {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(1, new LinkedList(2, new LinkedList(3, new LinkedList(4, new LinkedList(5)))));

        printLink1(list);
    }

    /**
     * 思路分析： 使用栈 让链表逆序
     *
     * @param list
     */
    public static void printLink(LinkedList list) {
        Stack<Integer> stack = new Stack<Integer>();
        while (list != null) {
            stack.push(list.data);
            list = list.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    /**
     * 使用递归让链表逆序
     *
     * @param list
     */
    public static void printLink1(LinkedList list) {

        if (list == null) {
            return;
        }
        printLink1(list.next);
        System.out.print(list.data+" ");
    }
}

class LinkedList{
    int data;
    LinkedList next;
    public  LinkedList(int data){
        this.data=data;
    }
    public  LinkedList(int data ,LinkedList next){
        this.data=data;
        this.next=next;
    }
}

