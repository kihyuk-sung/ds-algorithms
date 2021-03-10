class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def rangeSumBST(self, root: TreeNode, low: int, high: int) -> int:
        self.sum = 0

        def inorder(node: TreeNode):
            if not node:
                return
            
            inorder(node.left)
            if low <= node.val <= high:
                self.sum += node.val
            inorder(node.right)
        
        inorder(root)
        return self.sum
        