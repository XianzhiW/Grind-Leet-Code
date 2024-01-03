class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class BinaryTree():
    def __init__(self):
        self.root = None
    
    def add(self, val: int):
        if not self.root:
            self.root = TreeNode(val)
        else:
            self.add_help(val, self.root)

    def add_help(self, val: int, node: TreeNode):
        if val < node.val:
            if node.left:
                self.add_help(val, node.left)
            else:
                node.left = TreeNode(val)
        else:
            if node.right:
                self.add_help(val, node.right)
            else:
                node.right = TreeNode(val)




class Solution():
    def inorderTraversal(self, tree: BinaryTree) -> list[int]:
        result = []
        def inorder(tree:TreeNode):
            if not tree:
                return
            inorder(tree.left)
            result.append(tree.val)
            inorder(tree.right)

        inorder(tree.root)
        return result


