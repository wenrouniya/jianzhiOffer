package second;

import second.pojo.LinkedNode;

/**
 * 删除链表结点
 * 时间复杂度为o(1)
 *
 *  思路分析: 常规思路删除链表必须知道前驱指针 找到前驱指针需要o(n)的时间复杂度
 *  现在将要删除的结点的后一个节点的值复制过来 然后将当前结点的指针指向后一个结点的后一个结点
 *  当前结点即被删除
 *  若被删除结点是尾结点  只能从头部遍历得到尾部结点的前驱结点 进行删除操作
 *  若链表只有一个结点 被删除结点是头节点（也是尾结点） 此时再删除结点之后  还要把链表的头指针置为null
 *
 */
public class DeleteLinkNode {

    public static LinkedNode deleteNode(LinkedNode head,LinkedNode toBeDelete){

        if(head ==null || toBeDelete == null){
            return null;
        }

        //要删除结点不是尾部结点
        if(toBeDelete.next != null){

            toBeDelete.data=toBeDelete.next.data;
            toBeDelete.next=toBeDelete.next.next;
        }else{
            //链表只有一个结点
            if(head== toBeDelete){
                head =null;
            }
            else{
                //链表是最后一个尾部结点
                LinkedNode pre =head;
                while(pre.next!=toBeDelete){
                    pre=pre.next;
                }
                pre.next=null;
            }
        }


        return head;
    }
}
