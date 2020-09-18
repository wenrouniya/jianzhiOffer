package second;

/**
 * 最低公共祖先
 * 思路分析
 * 根据以上定义，若 root 是 p,q 的 最近公共祖先 ，则只可能为以下情况之一：
 *
 * p 和 qq在 root的子树中，且分列 rootroot 的 异侧（即分别在左、右子树中）；
 * p = rootp=root ，且 qq 在 rootroot 的左或右子树中；
 * q = rootq=root ，且 pp 在 rootroot 的左或右子树中；
 *
 * 4递归解析：
 * 终止条件：
 * 当越过叶节点，则直接返回 nullnull ；
 * 当 rootroot 等于 p, qp,q ，则直接返回 rootroot ；
 * 递推工作：
 * 开启递归左子节点，返回值记为 leftleft ；
 * 开启递归右子节点，返回值记为 rightright ；
 * 返回值： 根据 leftleft 和 rightright ，可展开为四种情况；
 * 当 leftleft 和 rightright 同时为空 ：说明 rootroot 的左 / 右子树中都不包含 p,qp,q ，返回 nullnull ；
 * 当 leftleft 和 rightright 同时不为空 ：说明 p, qp,q 分列在 rootroot 的 异侧 （分别在 左 / 右子树），因此 rootroot 为最近公共祖先，返回 rootroot ；
 * 当 leftleft 为空 ，rightright 不为空 ：p,qp,q 都不在 rootroot 的左子树中，直接返回 rightright 。具体可分为两种情况：
 * p,qp,q 其中一个在 rootroot 的 右子树 中，此时 rightright 指向 pp（假设为 pp ）；
 * p,qp,q 两节点都在 rootroot 的 右子树 中，此时的 rightright 指向 最近公共祖先节点 ；
 * 当 leftleft 不为空 ， rightright 为空 ：与情况 3. 同理；
 *
 */
public class LeastCommonRoot {

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null || root == p || root == q) return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if(left == null) return right;
            if(right == null) return left;
            return root;
        }
    }

}
