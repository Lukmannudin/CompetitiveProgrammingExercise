package leetcode

object SameTree {

    @JvmStatic
    fun main(args: Array<String>) {
        val p = TreeNode(1)
        p.left = TreeNode(2)
        p.right = TreeNode(3)

        val q = TreeNode(1)
        q.left = TreeNode(2)
        q.right = TreeNode(3)

        q.left?.left = TreeNode(4)

        println(isSameTree(p, q))
    }

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) {
            return true
        }
        if (p != null && q == null) {
            return false
        }
        if (p == null && q != null) {
            return false
        }
        if (p?.`val` != q?.`val`) {
            return false
        }

        return isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
    }

    data class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}