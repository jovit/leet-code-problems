package jewels.and.stones

class Solution {
    fun numJewelsInStones(J: String, S: String): Int {
        val map = HashMap<Char, Pair<Int, Boolean>>()

        S.toCharArray().forEach { map[it] = Pair((map[it]?.first ?: 0) + 1, false) }
        J.toCharArray().forEach { if (map[it] != null) map[it] = Pair(map[it]?.first ?: 0, true) }

        return map.filter { it.value.second }.map { it.value.first }.sum()
    }
}