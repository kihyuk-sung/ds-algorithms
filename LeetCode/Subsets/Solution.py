from typing import List

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        result_item = []

        def dfs(index):
            result.append(result_item[:])
            for i in range(index, len(nums)):
                result_item.append(nums[i])
                dfs(i + 1)
                result_item.pop()
            pass
        
        dfs(0)
        return result
