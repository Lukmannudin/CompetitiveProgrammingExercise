package leetcode


object MergeTwoSortedLists {
    @JvmStatic
    fun main(args: Array<String>) {
        val list1 = ListNode(1)
        list1.next = ListNode(2)
        list1.next?.next = ListNode(4)

        val list2 = ListNode(1)
        list2.next = ListNode(3)
        list2.next?.next = ListNode(4)

        var treeNode = mergeTwoLists(list1, list2)

        while (treeNode != null) {
            print(treeNode.`val`)
            treeNode = treeNode.next
        }
    }

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var node1: ListNode? = list1
        var node2: ListNode? = list2
        var mergedList: ListNode? = ListNode(-102)
        var head: ListNode? = null

        while (node1 != null || node2 != null) {
            val cur1 = node1?.`val` ?: 101
            val cur2 = node2?.`val` ?: 101

            mergedList?.next = if (cur1 <= cur2) {
                node1 = node1?.next
                ListNode(cur1)
            } else {
                node2 = node2?.next
                ListNode(cur2)
            }

            if (head == null) {
                head = mergedList
            }

            mergedList = mergedList?.next
        }

        return head?.next
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}