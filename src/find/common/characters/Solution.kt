package find.common.characters

class Solution {
    fun commonChars(A: Array<String>): List<String> {
        val letterMap = HashMap<Char, Int>()

        for (word in A) {
            word.toCharArray().distinct().forEach {
                letterMap[it] = (letterMap[it] ?: 0) + 1
            }
        }


        return letterMap.filter { it.value == A.size }.map {
            val listOfChars = mutableListOf<String>()
            val numOfOccurences = A.map { word ->
                word.filter { c -> c == it.key }.count()
            }.min() ?: 0

            for (i  in 0 until numOfOccurences) {
                listOfChars.add(it.key.toString())
            }

            listOfChars
        }.flatten()
     }
}