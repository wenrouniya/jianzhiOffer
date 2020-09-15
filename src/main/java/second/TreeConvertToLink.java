package second;

/**
 * 二叉搜索树转换为排序后的双向链表
 * <p>
 * 思路分析 ：递归
 */
public class TreeConvertToLink {

    private static TreeNode pre = null;
    private static TreeNode head = null;

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(10);
        TreeNode treeNode1 = new TreeNode(6);
        TreeNode treeNode2 = new TreeNode(14);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(8);
        TreeNode treeNode5 = new TreeNode(12);
        TreeNode treeNode6 = new TreeNode(16);

        treeNode.left=treeNode1;
        treeNode.right=treeNode2;
        treeNode1.left=treeNode3;
        treeNode1.right=treeNode4;
        treeNode2.left=treeNode5;
        treeNode2.right=treeNode6;
        TreeNode link = getLink(treeNode);
        System.out.println(link);
    }
    public static TreeNode getLink(TreeNode node) {
        convert(node);
        return head;
    }

    private static void convert(TreeNode node) {
        if (node == null) {
            return;
        }

        convert(node.left);
        node.left = pre;
        if (pre != null) {
            pre.right = node;
        }
        if (head == null) {
            head = node;
        }
        pre = node;
        convert(node.right);

    }


}

