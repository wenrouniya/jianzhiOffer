package second;

/**
 * 序列化二叉树
 *
 * 将二叉树 序列化成一串字符串 然后再反序列化出这颗二叉树
 *
 * 思路分析：
 *   较快速的方法 前序遍历序列化与反序列化
 *   因为前序遍历是从根节点开始的 那么相应的反序列在根节点的数值读出来的时候就可以开始了
 */
public class SerializeTree {

    private static  String deserializeStr;


    public static String serialize(TreeNode node){
        if (node == null){
            return "#";
        }
        return node.val +" "+serialize(node.left)+" "+serialize(node.right);
    }

    public static  TreeNode deserialize(String str) {
        deserializeStr = str;
        return Deserialize();
    }

    private static  TreeNode Deserialize() {
        if (deserializeStr.length() == 0)
            return null;
        int index = deserializeStr.indexOf(" ");
        String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
        deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
        if (node.equals("#"))
            return null;
        int val = Integer.valueOf(node);
        TreeNode t = new TreeNode(val);
        t.left = Deserialize();
        t.right = Deserialize();
        return t;
    }

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
        String serialize = serialize(treeNode);
        System.out.println(serialize);
        TreeNode deserialize = deserialize(serialize);
        System.out.println(deserialize);
    }
}
