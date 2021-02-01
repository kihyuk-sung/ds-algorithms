from typing import List

class Solution:
    def trap(self, height: List[int]) -> int:
        rain_height = []


        cur_height = 0
        max_idx = 0
        for i, h in enumerate(height):
            if cur_height < h:
                cur_height = h
                max_idx = i

            rain_height.append(cur_height)

        cur_height = 0
        for i in range(len(height) - 1, max_idx, -1):
            if cur_height < height[i]:
                cur_height = height[i]
            
            rain_height[i] = cur_height

        result = 0
        for i in range(len(height)):
            result += rain_height[i] - height[i]

        return result