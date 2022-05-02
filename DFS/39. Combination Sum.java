/** 
1. If the sum of the current combination is greater than target, then even if we move forward with this combination, the sum will only increase, so there is no fun to moving further with such a combination as we can never achieve the target sum from this. So backtrack from this.
2. If the sum of the current combination is equal to the target, then we have a solution, so store this combination in the answers. Now moving forward with this combnation also will only increase the sum and we can't achieve the target sum again from this ever. So backtrack from here.
3. if we are here then that means the sum of the combination is still less that the target sum, and we have a scope of finding a combination whose sum can be equal to the target.
		i) Now consider all possible options into this combination, one at a time.
		ii) Go check if considering the current option can give us the solution.
		iii) Now when this option backtracks to this place again, now remove this option and try another option. e.g. at [2, 2, _ ] we have 3 options to fill the 3rd place i.e. [2, 3, 5].
		So firstly we will go on with [2, 2, 2]. Then when this backtracks to this place again, remove the last 2 and try the next option which is 3 that means [2, 2, 3].
		When this also backtracks remove 3 to try 5, that means [2, 2, 5].
		Now as all the options are exhausted for [2, 2, _ ], now backtrack to its previous state which is [2, 2], and so on...
        
*/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        // 
        Arrays.sort(candidates);
        dfs(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }
    
    private void dfs(List<List<Integer>> list, List<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < candidates.length; i++) { // try all possible options from the next level 
                tempList.add(candidates[i]);                  // put 1 option into the combination
                // try with this combination, whether it gives a solution or not 
                dfs(list, tempList, candidates, remain - candidates[i], i); // not i + 1 because we can reuse same elements
                // when this option backtrack to here, remove this and go on to the next option
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
/**
(1)sort() method is to check duplicates for convinence. Like [2,2,3], target 5. Step by step like below:
2,2,2 -1 return -> 2,2,2 -1 return -> 2,2,3... Clearly, it calls 2,2,2 twice. In this case (without duplicates), not using it is better.

(2)passing argument 'start' will make sure each combination of num run once. I think combined with sort() method to explain it will be easy to understand.
e.g. Like [3,2,4], after sorted, turn to [2,3,4]. (ignore target, just look for what's going on)
First reached list will be 2,2,2 return --> 2,2,3 return--> 2,2,4 return--> 2,3,3 ...
After 2,2,4 return, it should go to 2,3,3 (due to arg start) instead of 2,3,2. Because 2,2,3 we already reached.

(3)tempList.remove(tempList.size() - 1) do like a pop(). Imagine a recursion tree.
Node1 adds num1 to tempList, and calls backtrack() to go into its child Node2. Once this child return to its parent Node1, tempList.remove() will pop out the num1 it added before, 
and adds num2 to tempList and call backtrack() again.
*/