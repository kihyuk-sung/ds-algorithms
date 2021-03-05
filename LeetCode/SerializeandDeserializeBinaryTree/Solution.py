from collections import deque

class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Codec:
    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return []
        queue = deque([root])
        result = []
        while queue:
            node: TreeNode = queue.popleft()
            if node:
                result.append(node.val)
                queue.append(node.left)
                queue.append(node.right)
            else:
                result.append(None)
        return result
        
    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if not data:
            return None
        root = TreeNode(data[0])
        queue = deque([root])
        index = 1
        while index < len(data) and queue:
            node: TreeNode = queue.popleft()
            if data[index] is not None:
                node.left = TreeNode(data[index])
                queue.append(node.left)
            index += 1
            if data[index] is not None:
                node.right = TreeNode(data[index])
                queue.append(node.right)
            index += 1
        
        return root
