from typing import List

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        result = []
        permutation = []
        def dfs(numbers):
            if len(numbers) == 0:
                result.append(permutation[:])
                return

            for number in numbers:
                next_numbers = numbers[:]
                next_numbers.remove(number)
                permutation.append(number)
                dfs(next_numbers)
                permutation.pop()

        dfs(nums)
        return result
