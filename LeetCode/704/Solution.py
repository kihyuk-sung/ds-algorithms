from typing import List

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        def binary_search(left, right) -> int:
            if left > right:
                return -1
            index_mid = left + (right - left) // 2
            mid = nums[index_mid]
            if mid == target:
                return index_mid
            if mid > target:
                return binary_search(left, index_mid - 1)

            return binary_search(index_mid + 1, right)
            
        return binary_search(0, len(nums) - 1)
