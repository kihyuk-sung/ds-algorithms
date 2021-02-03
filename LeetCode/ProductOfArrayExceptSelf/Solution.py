from typing import List

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        
        result = [1]

        for i in range(len(nums) - 1):
            result.append(result[i] * nums[i])
        
        product = 1
        for i in range(len(nums) - 2, -1, -1):
            product *= nums[i + 1]
            result[i] *= product

        return result

