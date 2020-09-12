package second;

/**
 * 对称的二叉树：
 * 实现一个函数 判断二叉树是不是对称的
 *
 */
public class IsSymmetricalTree {


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(6);
        treeNode.left=treeNode1;
        treeNode.right=treeNode2;
        treeNode1.left=treeNode3;
        treeNode1.right=treeNode4;
        treeNode2.left=treeNode3;
        treeNode2.right=treeNode4;


        boolean symmetrical = isSymmetrical(treeNode);
        System.out.println(symmetrical);
    }
    public  static  boolean isSymmetrical(TreeNode node){
        return  isSymmetricalTree(node,node);
    }

    private static boolean isSymmetricalTree(TreeNode node1, TreeNode node2) {

        if(node1==null && node2 == null){
            return true;
        }
        if(node1 ==null || node2 ==null){
            return false;
        }

        if(node1.val !=node2.val){
            return  false;
        }
        return isSymmetricalTree(node1.left,node2.right) && isSymmetricalTree(node1.right,node2.left);
    }
}


