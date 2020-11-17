/*
回溯法：每次可以添加左括号或者右括号，添加过程中如果出现右括号比左括号多的情况，进行剪枝，退出条件为左括号和右括号都用完了


*/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        if(n == 0){
            return res;
        }

        dfs("",n,n,res);
        return res;
    }

    public void dfs(String curStr,int left,int right,List<String> res){
        if(left==0 && right==0){
            res.add(curStr);
            return;
        }

        if(left > right){
            return;
        }
	//注意这里的dfs进行下一步的时候是有条件判断的
        if(left > 0){
            dfs(curStr+"(",left-1,right,res);
        }

        if(right > 0){
            dfs(curStr+")",left,right-1,res);
        }
    }
}