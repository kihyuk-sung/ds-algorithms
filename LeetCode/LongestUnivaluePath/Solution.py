# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def longestUnivaluePath(self, root: TreeNode) -> int:
        self.result = 0
        def dfs(root: TreeNode, parant_value: int) -> int:
            if not root:
                return 0
            
            left = dfs(root.left, root.val)
            right = dfs(root.right, root.val)

            self.result = max(self.result, left + right)
            if root.val != parant_value:
                return 0
            return max(left + 1, right + 1)
        
        dfs(root, None)

        return self.result
