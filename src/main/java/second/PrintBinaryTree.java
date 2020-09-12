package second;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下打印二叉树
 * 从上到下打印二叉树的每个结点 同一层的结点按照从左到右的顺序打印  即层次遍历
 *
 *
 * 思路分析：
 *
 * 用一个队列 保存当前节点 再用一个变量 保存当前层的数量
 */
public class PrintBinaryTree {


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
        printTree(treeNode);
    }
    public static void printTree(TreeNode node){

        Queue<TreeNode> list= new LinkedList<TreeNode>();

        list.add(node);
        while (!list.isEmpty()){
            int cnt =list.size();
            while(cnt!=0){
                cnt--;
                TreeNode pre = list.poll();
                System.out.print(pre.val+" ");
                if(pre.left!= null){
                    list.add(pre.left);
                }
                if(pre.right!= null){
                    list.add(pre.right);
                }
            }
        }
    }
}



