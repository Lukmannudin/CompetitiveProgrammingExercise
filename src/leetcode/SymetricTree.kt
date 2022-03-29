package leetcode

object SymetricTree {

    @JvmStatic
    fun main(args: Array<String>) {

    }

    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true

        return checkLeftAndRightNode(root.left, root.right)
    }

    fun checkLeftAndRightNode(leftNode: TreeNode?, rightNode: TreeNode?): Boolean {
        if (leftNode == null && rightNode == null) {
            return true
        }
        if (leftNode == null || rightNode == null) {
            return false
        }
        if (leftNode.`val` != rightNode.`val`) {
            return false
        }

        return checkLeftAndRightNode(leftNode.left, rightNode.right) && checkLeftAndRightNode(leftNode.right, rightNode.left)
    }

    data class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}