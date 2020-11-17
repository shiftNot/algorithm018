 /*
 思路：
 1.创建结果res保存，创建queue用于操作树的结点
 2.特判，将根节点添加到queue中
 3.开始循环：
    队列不为空时，获取每层节点数n，循环n次
        每次将节点弹出，送入level内，遍历左右子节点
        循环结束时将level添加到结果res中
4.返回res
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();

        if(root != null){
            queue.add(root);
        }

        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> level = new ArrayList<>();//特别注意这个level的定义位置，如果写在for循环里面的话，结果就不对了
            for(int i=0;i<n;i++){  
                TreeNode node = queue.poll();
                level.add(node.val);

                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                    
                }            
            }
            res.add(level);
            
        }

        return res;
    }

}