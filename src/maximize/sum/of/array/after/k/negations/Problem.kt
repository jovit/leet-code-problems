package maximize.sum.of.array.after.k.negations

import java.util.*

class Solution {
    fun largestSumAfterKNegations(A: IntArray, K: Int): Int {
        val priorityQueue = PriorityQueue<Int>()

        priorityQueue.addAll(A.toList())

        for (i in 0 until K) {
            val pop = priorityQueue.poll()
            priorityQueue.add(-pop)
        }

        return priorityQueue.toList().sum()
    }
}