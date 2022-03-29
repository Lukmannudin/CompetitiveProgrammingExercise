package leetcode

object MaximumDepthBinaryTree {

    @JvmStatic
    fun main(args: Array<String>) {
        val node = TreeNode(3)
        node.left = TreeNode(9)
        node.right = TreeNode(20)
        node.right?.left = TreeNode(15)
        node.right?.right = TreeNode(7)

        println(maxDepth(node))
    }

    fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        return 1 + maxDepth(root.left).coerceAtLeast(maxDepth(root.right))
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}