package second;

import second.pojo.LinkedNode;

/**
 * 删除重复节点
 * 一个排序链表  如何删除重复结点
 *
 * 思路分析：
 * 在递归中跳过重复的值的结点  只传递不重复的部分
 */
public class DeleteRepeatNode {


    public static LinkedNode deleteRepeatNode(LinkedNode node){
        if (node == null || node.next == null)
            return node;
        LinkedNode next=node.next;
        if (node.data == next.data) {
            //只跳过和当前结点值相同的node
            while (next != null && node.data == next.data)
                next = next.next;
            return deleteRepeatNode(next);
        } else {
            node.next = deleteRepeatNode(node.next);
            return node;
        }

    }

    public static void main(String[] args) {
        LinkedNode node = new LinkedNode(1);
        LinkedNode node1=new LinkedNode(2);
        LinkedNode node2=new LinkedNode(2);
        LinkedNode node3=new LinkedNode(3);
        LinkedNode node4=new LinkedNode(3);
        LinkedNode node5=new LinkedNode(4);
        LinkedNode node6=new LinkedNode(5);
        LinkedNode node7=new LinkedNode(6);
        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next =node5;
        node5.next=node6;
        node6.next=node7;
        node7.next=null;
        LinkedNode node8 = deleteRepeatNode(node);
        System.out.println(node8);


    }
}
