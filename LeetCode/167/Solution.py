from typing import List
class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        left, right = 0, len(numbers) - 1

        while left != right:
            if numbers[left] + numbers[right] == target:
                return [left, right]
            if numbers[left] + numbers[right] > target:
                right -= 1
                continue
            if numbers[left] + numbers[right] < target:
                left += 1
        
        return []
