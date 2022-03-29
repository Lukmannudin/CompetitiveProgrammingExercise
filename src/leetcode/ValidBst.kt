package leetcode

object ValidBst {
    @JvmStatic
    fun main(args: Array<String>) {
//        [-2147483648,null,2147483648]
//        [2147483647,2147483647]

        val node = TreeNode(-2147483648)
        node.left = null
        node.right = TreeNode(2147483647)

        println(isValidBST(node))
    }

    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }



        val max = root.`val`.coerceAtLeast(Int.MAX_VALUE)
        val min = root.`val`.coerceAtMost(Int.MIN_VALUE)

        return checkBst(root.left, min, root.`val`) && checkBst(root.right, root.`val`, max)
    }

    fun checkBst(root: TreeNode?, min: Int, max: Int): Boolean {
        if (root == null) {
            return true
        }

        if (root.left != null && root.left?.`val`!! == root.`val`) {
            return false
        }

        if (root.right != null && root.right?.`val`!! == root.`val`) {
            return false
        }

        if (root.`val` >= max || root.`val` <= min) {
            return false
        }

        return checkBst(root.left, min, root.`val`) && checkBst(root.right, root.`val`, max)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }


}