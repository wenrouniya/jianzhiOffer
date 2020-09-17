package second;

/**
 * 二叉搜索树的第k大结点
 *
 * 思路分析：
 * 通过中序遍历可以直接找到第k大的结点
 */
public class MaxNumInSearchTree {

    static int cnt=0;
    static  TreeNode res;

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(6);
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(9);
        treeNode.left=treeNode1;
        treeNode1.left=treeNode3;
        treeNode.right=treeNode5;

        int maxK = getMaxK(treeNode, 3);
        System.out.println(maxK );
    }
    public  static int getMaxK(TreeNode node,int k){

        getK(node,k);
        return  res.val;
    }

    public  static void getK(TreeNode node,int k){
        if(node ==null|| cnt >k){
            return ;
        }
        getK(node.left,k);
        cnt ++;
        if(cnt ==k){
            res=node;
        }
        getK(node.right,k);
    }
}
