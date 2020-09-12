package second;

/**
 * 二叉树的镜像
 * 输入一颗二叉树输出他的镜像二叉树
 *
 * 思路分析：
 * 递归
 */
public class MirrorOfTree {

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
        treeNode2.left=treeNode5;
        TreeNode mirror = getMirror(treeNode);
        System.out.println(mirror);
    }

    public static TreeNode getMirror(TreeNode node){
        if(node ==null){
            return null;
        }
       return  createMirrorTree(node);
    }

    private static TreeNode createMirrorTree(TreeNode node) {
        if(node ==null){
            return null;
        }
        TreeNode treeNode = new TreeNode(node.val);
        treeNode.left=createMirrorTree(node.right);
        treeNode.right=createMirrorTree(node.left);
        return  treeNode;
    }
}
