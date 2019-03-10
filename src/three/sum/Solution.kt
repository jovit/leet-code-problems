package three.sum

class Solution {

    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) {
            return emptyList()
        }

        val solutions = mutableListOf<List<Int>>()
        val numbersMap = HashMap<Int, Int>().withDefault { 0 }
        val takenSolutions = HashMap<List<Int>, Boolean>()
        val sorted = nums.sortedDescending()
        sorted.forEach { numbersMap[it] = numbersMap.getValue(it) + 1 }

        for (i in 0 until sorted.size) {
            var currentSum = sorted[i]

            for (j in i + 1 until sorted.size) {
                if (currentSum + sorted[j] < 0) {
                    break
                }

                currentSum += sorted[j]
                if (numbersMap.getValue(-currentSum) > 0 && takenSolutions[listOf(sorted[i], sorted[j], -currentSum).sorted()] != true) {
                    if (-currentSum == sorted[i] && -currentSum == sorted[j]) {
                        if(numbersMap.getValue(-currentSum) > 2) {
                            solutions.add(listOf(sorted[i], sorted[j], -currentSum).sorted())
                            takenSolutions[listOf(sorted[i], sorted[j], -currentSum).sorted()] = true
                        }
                    } else if (-currentSum == sorted[i] || -currentSum == sorted[j]) {
                        if(numbersMap.getValue(-currentSum) > 1) {
                            solutions.add(listOf(sorted[i], sorted[j], -currentSum).sorted())
                            takenSolutions[listOf(sorted[i], sorted[j], -currentSum).sorted()] = true
                        }
                    } else {
                        solutions.add(listOf(sorted[i], sorted[j], -currentSum).sorted())
                        takenSolutions[listOf(sorted[i], sorted[j], -currentSum).sorted()] = true
                    }
                }

                currentSum -= sorted[j]
            }
        }

        return solutions
    }
}