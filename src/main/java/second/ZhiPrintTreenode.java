package second;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 之字型打印二叉树
 * 思路分析：
 * 一个队列保存每一层的数据 一个变量保存这层有多少数据 一个变量记录反转的顺序
 */
public class ZhiPrintTreenode {
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
        print(treeNode);
    }

    public static  void print(TreeNode node){
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(node);
        boolean flag=true;//正向
        while(!queue.isEmpty()){
            int cnt=queue.size();
            ArrayList<TreeNode> treeNodes = new ArrayList<TreeNode>();
            while(cnt!=0){
                cnt--;
                TreeNode poll = queue.poll();
                System.out.print(poll.val+" ");
                if(flag){
                    if(poll.left!=null){
                        queue.add(poll.left);
                    }
                    if(poll.right!= null){
                        queue.add(poll.right);
                    }
                }else{
                    if(poll.left!=null){
                       treeNodes.add(poll.left);
                    }
                    if(poll.right!= null){
                        treeNodes.add(poll.right);
                    }
                }
            }
            if(treeNodes.size()>0){
                Collections.reverse(treeNodes);
                for (TreeNode temp:treeNodes){
                         queue.add(temp);
                }
            }
            flag=!flag;

        }
    }
}
