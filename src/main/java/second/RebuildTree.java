package second;

import second.pojo.TreeNode;

import java.util.HashMap;

/**
 * 重建二叉树
 * 输入某二叉树前序和中序遍历的结果 重新创建该二叉树
 *
 * 思路： 将中序遍历的结果放在map中 k-v:mid[i],i
 *  通过数字在map中出现的位置 判断左右子树的长度 不断递归 创建左右结点
 *
 * */
public class RebuildTree {


    private static HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();

    /**
     * 构建map
     * @param pre
     * @param mid
     * @return
     */
    public static TreeNode getTre(int [] pre,int [] mid){
        for(int i=0;i<pre.length;i++){
            map.put(mid[i],i);
        }
        return getTre(pre,0,pre.length-1,0);
    }

    private static TreeNode getTre(int[] pre, int preL, int preR, int midL) {
       //超过时说明已经没有子树了
        if(preL>preR){
            return null;
        }
        System.out.println(preL);
        TreeNode treeNode = new TreeNode(pre[preL]);
        //中序遍历中该数字的位置
        int midIndex=map.get(pre[preL]);
        //该位置减去中序遍历当前左边界 即为左子树的长度
        int leftTreeSize=midIndex-midL;
        //        左子树：  前序遍历左边界后移一位   右边界为左边界+左子树长度  中序遍历的左边界不变
        treeNode.left=getTre(pre,preL+1,preL+leftTreeSize,midL);
        //右子树：            前序遍历左边界为左边界+左子树长度再后移一位  右边界不变  中序遍历左边界为原来的左边界+左子树长度+后移一位
        treeNode.right=getTre(pre,preL+leftTreeSize+1,preR,midL+leftTreeSize+1);
        return treeNode;
    }

    public static void main(String[] args) {
        int [] pre={1,2,4,7,3,5,6,8};
        int [] mid={4,7,2,1,5,3,8,6};
        TreeNode tre = getTre(pre, mid);
        System.out.println(tre);

    }


}
