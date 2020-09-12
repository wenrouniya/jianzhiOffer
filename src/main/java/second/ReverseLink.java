package second;

import second.pojo.LinkedNode;

/**
 * 反转链表
 */
public class ReverseLink {
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
        LinkedNode reserve = reserve(node);
        System.out.println(reserve);
    }

    public static LinkedNode reserve(LinkedNode node){
        if(node.next==null){
            return  node;
        }
        LinkedNode last=reserve(node.next);
        node.next.next=node;
        node.next=null;
        return  last;
    }

}
