package second;

import second.pojo.LinkedNode;

/**
 * 合并两个排序链表
 *
 * 思路分析：
 * 双指针
 */
public class MergeTwoSortLink {

    public static void main(String[] args) {
        LinkedNode node = new LinkedNode(1);
        LinkedNode node1 = new LinkedNode(5);
        LinkedNode node2= new LinkedNode(9);
        LinkedNode node3 = new LinkedNode(14);
        LinkedNode node4 = new LinkedNode(25);
        LinkedNode node5 = new LinkedNode(61);
        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;


        LinkedNode tnode = new LinkedNode(0);
        LinkedNode tnode1 = new LinkedNode(2);
        LinkedNode tnode2= new LinkedNode(3);
        LinkedNode tnode3 = new LinkedNode(17);
        LinkedNode tnode4 = new LinkedNode(51);
        LinkedNode tnode5 = new LinkedNode(60);
        tnode.next= tnode1;
        tnode1.next=tnode2;
        tnode2.next=tnode3;
        tnode3.next=tnode4;
        tnode4.next=tnode5;

        LinkedNode merge = merge(node, tnode);
        System.out.println(merge);
    }

    public static LinkedNode merge(LinkedNode node1,LinkedNode node2){

        if(node1 ==null){
            return node2;
        }
        if(node2 ==null){
            return node1;
        }

        LinkedNode head=new LinkedNode(0);
        LinkedNode pre=head;
        while(node1!= null && node2 !=null){

            while(node1!= null && node2 !=null &&node1.data<node2.data){
                pre.next =node1;
                pre=pre.next;
                node1=node1.next;
            }
            while(node1!= null && node2 !=null&& node2.data<node1.data){
                pre.next=node2;
                pre=pre.next;
                node2=node2.next;
            }

        }
        if(node1!=null){
            pre.next=node1;
        }
        if(node2 != null){
            pre.next=node2;
        }

        return head.next;
    }
}
