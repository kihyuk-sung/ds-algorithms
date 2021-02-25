from typing import List
from collections import defaultdict

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        graph = defaultdict(list)
        for x, y in prerequisites:
            graph[x].append(y)
        
        traced = set()
        def dfs(i):
            if i in traced:
                return False
            traced.add(i)
            for next in graph[i]:
                if not dfs(next):
                    return False
            
            traced.remove(i)
            return True

        for x in list(graph):
            if not dfs(x):
                return False
        
        return True

