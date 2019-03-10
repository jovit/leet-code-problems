package container.with.most.water

class Solution {
    tailrec fun maxArea(height: IntArray, maxValue: Int = 0): Int {
        return if (height.size == 2) {
             Math.max(Math.min(height[0], height[1]), maxValue)
        } else {
            val edgesTank = Math.min(height[0], height[height.size - 1]) * (height.size - 1)

            if (height[0] > height[height.size - 1]) {
                 maxArea(height.take(height.size - 1).toIntArray(), Math.max(maxValue, edgesTank))
            } else {
                 maxArea(height.takeLast(height.size - 1).toIntArray(), Math.max(maxValue, edgesTank))
            }
        }
    }
}