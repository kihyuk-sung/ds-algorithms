from typing import List

class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        nums.sort()
        sum = 0
        for i in range(len(nums) // 2):
            sum += nums[2 * i]

        return sum