from typing import List

class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        result = []

        result_item = []
        def dfs(index, target):
            if target == 0:
                result.append(result_item[:])
                return True
            if target < 0:
                return True

            for i in range(index, len(candidates)):
                result_item.append(candidates[i])
                if dfs(i, target - candidates[i]):
                    result_item.pop()
                    break
                result_item.pop()

            return False
        dfs(0, target)
        return result
