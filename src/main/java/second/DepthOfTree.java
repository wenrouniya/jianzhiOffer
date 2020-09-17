package second;

/**
 * 二叉搜索树的深度
 *
 * 思路分析：
 * 如果左子树不为空 深度为左子树+1
 * 如果右子树不为空 深度为右子树+1
 * 如果既有左子树又有右子树 深度为左右子树深度较大的值+1
 */
public class DepthOfTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(6);
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(9);
        treeNode.left=treeNode1;
        treeNode1.left=treeNode3;
        treeNode.right=treeNode5;
        int depth = getDepth(treeNode);
        System.out.println(depth);
    }
    public  static int getDepth(TreeNode node){
        if(node ==null){
            return 0;
        }
        int left=getDepth(node.left);
        int right=getDepth(node.right);
        return left>right? left+1:right+1;
    }
}
