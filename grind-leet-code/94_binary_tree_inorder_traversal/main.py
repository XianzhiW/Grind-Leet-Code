from solution import *

mytree = BinaryTree()
mytree.add(10)
mytree.add(5)
mytree.add(15)
mytree.add(4)
mytree.add(6)

mytree2 = BinaryTree()
#1
mytree2.add(8)
#2
mytree2.add(3)
mytree2.add(10)
#4
mytree2.add(1)
mytree2.add(6)
###
mytree2.add(14)
#8
###
###
mytree2.add(4)
mytree2.add(7)
###
###
mytree2.add(13)
###

# Function Call
mysoln = Solution()
print(mysoln.inorderTraversal(mytree))
print("---")
print(mysoln.inorderTraversal(mytree2))





