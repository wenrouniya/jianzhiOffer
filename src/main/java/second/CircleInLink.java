package second;

import jdk.nashorn.api.scripting.ScriptObjectMirror;
import second.pojo.LinkedNode;

/**
 * 链表中环的入口
 *  如果一个链表中包含环 如何找到环的入口
 *
 *  思路分析：
 *  1. 快慢指针找到相遇的结点
 *  2. 相遇的结点一定在环中 让指针再走一圈  即可知道环型链表的长度
 *  3. 如果链表中环有n个结点 指针p1先在链表上移动n步 然后第二个指着以相同的速度一起移动 相遇的就是环的入口
 *
 *  数学属性：
 *  链表起点x 相遇点z 两个指针一起以同样的速度前进 相遇点就是环型入口
 *  分析：
 *  假设环入口节点为 y1，相遇所在节点为 z1。
 * 假设快指针 fast 在圈内绕了 N 圈，则总路径长度为 x+Ny+(N-1)z。z 为 (N-1) 倍是因为快慢指针最后已经在 z1 节点相遇了，后面就不需要再走了。
 * 而慢指针 slow 总路径长度为 x+y。
 * 因为快指针是慢指针的两倍，因此 x+Ny+(N-1)z = 2(x+y)。
 * 我们要找的是环入口节点 y1，也可以看成寻找长度 x 的值，因此我们先将上面的等值分解为和 x 有关：x=(N-2)y+(N-1)z。
 * 上面的等值没有很强的规律，但是我们可以发现 y+z 就是圆环的总长度，因此我们将上面的等式再分解：x=(N-2)(y+z)+z。
 * 这个等式左边是从起点x1 到环入口节点 y1 的长度，而右边是在圆环中走过 (N-2) 圈，再从相遇点 z1 再走过长度为 z 的长度。
 * 此时我们可以发现如果让两个指针同时从起点 x1 和相遇点 z1 开始，每次只走过一个距离，那么最后他们会在环入口节点相遇。
 */
public class CircleInLink {
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
        node5.next=node3;
        LinkedNode enter = getEnter(node);
        System.out.println(enter.data);

    }

    public static LinkedNode getEnter(LinkedNode node){
        if(node== null){
            return node;
        }

        LinkedNode meeting = hasCricle(node);
        if(meeting ==null){
            return null;
        }
        int count =0;
        LinkedNode countNode=meeting;
        while(true){
            countNode =countNode.next;
            count++;
            if(countNode ==meeting ){
                break;
            }
        }
        LinkedNode fast=node;
        LinkedNode slow=node;
        while(count !=0){
            count--;
            fast=fast.next;
        }
        while(fast != slow){
            fast=fast.next;
            slow=slow.next;
        }

        return fast;
    }

    /**
     * 返回相遇的结点
     * @param node
     * @return
     */
    private static LinkedNode hasCricle(LinkedNode node) {
        LinkedNode fast=node;
        LinkedNode slow =node;
        while(fast!=null){
            fast=fast.next;
            if(fast != null){
                fast=fast.next;
            }
            slow=slow.next;
            if(fast ==slow){
                return  fast;
            }
        }
        return  null;
    }
}
