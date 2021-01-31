from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i, n in enumerate(nums):
            if (target - n) in nums[i+1:]:
                return [i, nums.index(target - n)]


s = Solution()

print(s.twoSum([3,2,4], 6))