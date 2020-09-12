package second;

import java.util.concurrent.locks.Condition;

/**
 * 复杂链表的复制
 * 复杂链表定义为 一个指向后面的指针  一个指向任意节点的指针
 *
 * 思路分析：
 * 1.将每个节点复制一个链接在原节点的后方
 * 2. 将每个节点的random指针也复制好
 * 3. 按照奇数偶数对原链表做拆分 奇数节点为原始链表 偶数节点欸复制后的链表
 */
public class CloneComplexLink {

    public static ComplexLinkNode clone(ComplexLinkNode node){
        ComplexLinkNode pre=node;
        //复制节点
        while(pre !=null){
            ComplexLinkNode clone = new ComplexLinkNode(pre.data);
            clone.next=pre.next;
            pre.next=clone;
            pre=clone.next;
        }
        //复制random
        pre=node;
        while(pre !=null){
            ComplexLinkNode clone=pre.next;
            if(pre.random!=null){
                clone.random=pre.random.next;
            }
            pre=clone.next;
        }

        //链表切分
        ComplexLinkNode head=node;
        ComplexLinkNode chead=node.next;
        while(head.next!= null){
            ComplexLinkNode next= head.next;
            head.next=next.next;
            head=next;
        }
        return chead;
    }


}
class ComplexLinkNode{
    int data;
    ComplexLinkNode next;
    ComplexLinkNode random;
    ComplexLinkNode(int data){
        this.data=data;
    }
}
