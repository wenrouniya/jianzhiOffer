package second;

import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 *
 * 输入一颗二叉树和一个整数 打印处二叉树中节点值的和为输入整数的所有路径 从根节点一直到叶子结点称为一条路径
 *
 * 思路分析：
 * 每个路径上结点要带着现在的数值去遍历现在的节点 如果遍历到叶子节点还不满足key
 * 则说明路径无效 向上返回 并删除当前叶子节点
 */
public class SumOfTreeRoute {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(7);
        TreeNode treeNode5 = new TreeNode(8);
        TreeNode treeNode6 = new TreeNode(9);

        treeNode.left=treeNode1;
        treeNode.right=treeNode2;
        treeNode1.left=treeNode3;
        treeNode1.right=treeNode4;
        treeNode2.left=treeNode5;
        treeNode2.right=treeNode6;
        ArrayList<ArrayList<Integer>> route = getRoute(treeNode, 14);
        System.out.println(route);
    }
      public  static   ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<ArrayList<Integer>> getRoute(TreeNode node,int key){

        getRoute(new ArrayList<Integer>(),node,key);
        return res;

    }

    private static void getRoute(ArrayList<Integer> list, TreeNode node, int key) {
        if(node ==null){
            return ;
    }
        list.add(node.val);
        key-=node.val;
        if(key ==0  && node.left== null && node.right==null){
            res.add(new ArrayList<Integer>(list));
        }else{
            getRoute(list,node.left,key);
            getRoute(list,node.right,key);
        }
        list.remove(list.size()-1);


}

}
