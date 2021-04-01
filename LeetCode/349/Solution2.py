from typing import List, Set
import bisect

class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        result: Set = set()
        nums2.sort()
        for num in nums1:
            index = bisect.bisect_left(nums2, num)
            if index > 0 and nums2[index] == num:
                result.add(num)
        return result
