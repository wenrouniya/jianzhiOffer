package second;

/**
 * 二叉搜索树 后序遍历序列
 * 输入一个整数数组 判断该数组是不是某二叉搜索树的后续遍历结果
 * 如果是则返回true  否则返回false
 *
 * 思路分析:
 * 二叉搜索树的后序遍历 数组的最后一个值是根节点  在前面的数组中
 * 比根节点小的是左子树 比根节点大的是右子树
 * 再依次分析左右子树
 * 如果左子树中出现大于根节点的 或右子树中出现小于根结点的 既不是二叉搜索树
 */
public class VerifySquenceOfBST {


    public static void main(String[] args) {
        int [] nums={7,4,6,5};
        boolean searchTree = isSearchTree(nums, 0, nums.length);
        System.out.println(searchTree);


    }
    //这里end表示长度 start表示起始下标
    public static boolean isSearchTree(int[] nums,int start,int end){

        //边界条件  长度总是比下标多1 所以差值不是0 而是 1
        if(end-start<=1){
            return true;
        }
        int root=nums[end-1];
        int left=start;
        for(;left<end;left++){
            if(nums[left]>root){
                break;
            }
        }
        int right=left;
        for(;right<end;right++){
            if(nums[right]<root){
                return  false;
            }
        }

        return isSearchTree(nums,start,left) && isSearchTree(nums,left,end-1);
    }

}
