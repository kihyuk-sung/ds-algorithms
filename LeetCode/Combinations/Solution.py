from typing import List

class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        result = []
        result_item = []
        def dfs(num, kk):
            if kk == 0:
                result.append(result_item[:])
                return
            
            for i in range(num, kk - 1, -1):
                result_item.append(i)
                dfs(i - 1, kk - 1)
                result_item.pop()

        dfs(n, k)
        return result
