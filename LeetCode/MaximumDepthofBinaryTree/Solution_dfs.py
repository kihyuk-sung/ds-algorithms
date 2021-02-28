# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
            
        max_depth = [0]

        def dfs(root: TreeNode, depth: int):
            if not (root.left or root.right):
                if max_depth[0] < depth:
                    max_depth[0] = depth
                return
            
            if root.left:
                dfs(root.left, depth + 1)

            if root.right:
                dfs(root.right, depth + 1)

        dfs(root, 1)

        return max_depth[0]
