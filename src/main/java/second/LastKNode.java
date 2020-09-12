package second;

import second.pojo.LinkedNode;

/**
 * 链表中的倒数第k个结点
 *
 * 思路分析：
 *  第一个指针先走k步 然后双指针联动
 *  当第一个指针走到空指针时 第一个指针指向倒数第k个结点
 */
public class LastKNode {

    public static void main(String[] args) {
        LinkedNode node = new LinkedNode(1);
        LinkedNode node1 = new LinkedNode(2);
        LinkedNode node2= new LinkedNode(3);
        LinkedNode node3 = new LinkedNode(4);
        LinkedNode node4 = new LinkedNode(5);
        LinkedNode node5 = new LinkedNode(6);
        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        LinkedNode lastK = getLastK(node, 2);
        System.out.println(lastK.data);

    }
    public static LinkedNode getLastK(LinkedNode node,int k){

        if(node ==null ||k <=0){
            return node;
        }
        LinkedNode last=node;
        LinkedNode start=node;
        while (last != null){
            while(k!=0){
                k--;
                last=last.next;
            }
            last=last.next;
            start=start.next;
        }
        return start;
    }
}
