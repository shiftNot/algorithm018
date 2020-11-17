import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
/*
思路：
1.特判
2.结果res，保存
	used[] 布尔数组，保存值是否被使用
	path，双端队列，Deque保存临时值
3.dfs(传入数组nums，depth，
		path,used,res)
4.写dfs
	写终止条件：
	if(depth == nums.length){
		res.add(new ArrayList<>(path));
		return;
	}
	for(i从0到nums.length){
		if(!used[i]){
			添加元素；
			used[i] = true;
			
			dfs(  ,depth+1,  );
			
			去除元素；
			used[i] = false;
			
		}
	}
	
	return;

*/
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }

        boolean[] used = new boolean[nums.length];
        Deque<Integer> path = new ArrayDeque<>(nums.length);

        dfs(nums,0,used,path,res);

        return res;

    }

    private void dfs(int[] nums, int depth, boolean[] used, Deque<Integer> path,
                     List<List<Integer>> res) {

        if(depth == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                path.addLast(nums[i]);
                used[i] = true;

                dfs(nums,depth+1,used,path,res);
                path.removeLast();
                used[i] = false;
            }

        }

        return;
    }


}
