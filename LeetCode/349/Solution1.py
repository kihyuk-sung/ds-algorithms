from typing import List

class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        result = set()

        for num1 in nums1:
            for num2 in nums2:
                if num1 == num2:
                    result.add(num1)

        return result
        