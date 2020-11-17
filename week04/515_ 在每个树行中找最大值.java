/*
这题的思路和二叉树的层序遍历的思路很像，在逐层遍历的过程中，对节点求最大值，并缓存在max中
*/

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        //首先对二叉树进行层序遍历，这是必须的步骤，也有手动维护一个队列的过程
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int n = queue.size();
            int maxVal = Integer.MIN_VALUE; 
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                maxVal = Math.max(maxVal,node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(maxVal);
        
        }
        return res;
    }
}