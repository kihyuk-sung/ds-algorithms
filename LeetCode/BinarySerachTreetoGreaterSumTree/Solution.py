# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def bstToGst(self, root: TreeNode) -> TreeNode:
        self.sum = 0
        def inorder(node: TreeNode):
            if not node:
                return
            inorder(node.right)
            self.sum += node.val
            node.val = self.sum
            inorder(node.left)
        inorder(root)
        return root
