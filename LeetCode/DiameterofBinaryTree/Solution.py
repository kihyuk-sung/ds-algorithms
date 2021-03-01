# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    longest: int = 0

    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        self.longest = 0
        def dfs(root: TreeNode) -> int:
            if not root:
                return 0

            left, right = 0, 0
            if root.left:
                left = dfs(root.left)
            if root.right:
                right = dfs(root.right)

            self.longest = max(self.longest, left + right)

            return max(left, right) + 1

        dfs(root)

        return self.longest
