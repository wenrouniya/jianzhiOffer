package second;

/**
 * 二叉树的下一个结点
 * 给定一颗二叉树和其中的一个结点 如何找出中序遍历的下一个结点
 * 树中每一个结点除了左右指针还有指向父节点的指针
 *
 * 思路分析：
 * 如果结点存在右子树 那么下一个结点就是右子树中最左的左节点
 * 如果不存在右子树  该结点是父节点的左子树 那么下一个结点就是父节点
 *                   若该结点石父结点的右子树 那么下一个结点就是不断向上遍历  找到某个结点 父节点是该结点的左子树
 *                   该节点就是下一个结点 如果不存在则没有下一个结点
 */
public class TreeNextNode {

    public  static TreeNode getNext(TreeNode node){
        if(node.right!=null){
           TreeNode pnode= node.right;
            while(pnode!= null){
                pnode=pnode.left;
            }
            return pnode;
        }else{
            while(node.next!=null){
                TreeNode parent=node.next;
                if(parent.left==node){
                    return  parent;
                }
                node=parent.next;
            }
        }


        return null;
    }


}

class TreeNode {

    int val;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode next = null; // 指向父结点的指针

    TreeNode(int val) {
        this.val = val;
    }
}
