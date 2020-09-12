package second;

/**
 * 树的子结构：
 * 输入两个二叉树 树A树B 判断B是不是A的子结构
 *
 *  思路分析：
 *  分析当前结点是否相等  若相等递归判断左右结点
 *  若不相等 直接判断左右子树（递归）
 *
 *
 */
public class SonOfTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(7);
        TreeNode treeNode5 = new TreeNode(9);
        treeNode.left=treeNode1;
        treeNode.right=treeNode2;
        treeNode1.left=treeNode3;
        treeNode1.right=treeNode4;
        treeNode3.left=treeNode5;
        Boolean subTree = isSubTree(treeNode, new TreeNode(10));
        System.out.println(subTree);

    }

    public static boolean isSubTree(TreeNode parent,TreeNode child){

        if(parent == null || child ==null){
            return false;
        }
        return subTree(parent,child) || subTree(parent.left,child)|| subTree(parent.right,child);
    }

    private static boolean subTree(TreeNode parent, TreeNode child) {

        if(child ==null){
            return  true;
        }
        if(parent ==null){
            return  false;
        }

        if(parent.val == child.val){
            return subTree(parent.left,child.left) && subTree(parent.right,child.right);
        }
        return  false;
    }


}
