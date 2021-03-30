from typing import List

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1

        while left <= right:
            mid = left + (right - left) // 2
            val = nums[mid]
            if val == target:
                return mid
            if val > target:
                right = mid - 1
            if val < target:
                left = mid + 1
        
        return -1
