package second.pojo;

/**
 * 变量不写 修饰符 默认是default 只有同一个包内可以访问
 */
public class LinkedNode {

    public int data;
    public LinkedNode next;

    public  LinkedNode(int data){
        this.data=data;
    }
}
