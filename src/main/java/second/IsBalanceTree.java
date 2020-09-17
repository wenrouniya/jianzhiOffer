package second;


/**
 * 判断一棵树是不是平衡二叉树
 * 思路分析 ：采用后续遍历 可以不重复遍历结点
 * 直接判断左右子树深度差是否<=1
 */
public class IsBalanceTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(6);
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(9);
        TreeNode treeNode6 = new TreeNode(9);

        treeNode.left=treeNode1;
        treeNode1.left=treeNode3;
        treeNode.right=treeNode5;
        treeNode3.left=treeNode6;
        boolean balance = isBalance(treeNode);
        System.out.println(balance);
    }

    static boolean  isBalanced =true;
    public static  boolean isBalance(TreeNode node){

       high(node);
       return isBalanced;
    }

    private static int  high(TreeNode node) {
        if(node ==null ||!isBalanced){
            return 0;
        }
        int left = high(node.left);
        int right = high(node.right);
        if(Math.abs(left-right)>1){
            isBalanced=false;
        }
        return 1+Math.max(left,right);
    }
}
