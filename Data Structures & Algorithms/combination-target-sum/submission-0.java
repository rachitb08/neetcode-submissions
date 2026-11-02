class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        util(candidates, target, 0, ans, new ArrayList<>());

        return ans;
    }

    public void util(int[] candidates, int target, int index, List<List<Integer>> ans, List<Integer> list) {

        if (index == candidates.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        // pick
        if (candidates[index] <= target) {
            list.add(candidates[index]);
            util(candidates, target - candidates[index], index, ans, list);
            list.remove(list.size() - 1);
        }

        // not pick
        util(candidates, target, index + 1, ans, list);
    }
}