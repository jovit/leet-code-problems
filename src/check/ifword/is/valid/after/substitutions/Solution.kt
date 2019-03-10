package check.ifword.`is`.valid.after.substitutions

class Solution {
    val VALID_STRING = "abc"

    fun isValid(s: String): Boolean {
        var s2 = s
        while (s2.contains(VALID_STRING)) {
            s2 = s2.replace(VALID_STRING, "")
        }

        return s2.isEmpty()
    }
}