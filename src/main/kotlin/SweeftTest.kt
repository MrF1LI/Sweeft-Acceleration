class SweeftTest {
    fun main(args: Array<String>) {
        val sweeftTest = SweeftTest()

        // Task 1
        val nums = intArrayOf(2, 2, 1, 3, 3, 4, 4)
        val singleNumberResult = sweeftTest.singleNumber(nums)
        println("Task 1 - Single Number: $singleNumberResult")

        // Task 2
        val amount = 76
        val minSplitResult = sweeftTest.minSplit(amount)
        println("Task 2 - Minimum Split: $minSplitResult")

        // Task 3
        val words = arrayOf("extract", "exhale", "excavate")
        val longestPrefixResult = sweeftTest.longestPrefix(words)
        println("Task 3 - Longest Prefix: $longestPrefixResult")

        // Task 4
        val a = "1010"
        val b = "1011"
        val addBinaryResult = sweeftTest.addBinary(a, b)
        println("Task 4 - Binary Sum: $addBinaryResult")

        // Task 5
        val stairsCount = 5
        val countVariantsResult = sweeftTest.countVariants(stairsCount)
        println("Task 5 - Count Variants: $countVariantsResult")

        // Task 6
        val customDataStructure = CustomDataStructure()
        customDataStructure.insert(5)
        customDataStructure.insert(10)
        customDataStructure.insert(15)
        customDataStructure.delete(10)
        customDataStructure.printData()
    }

    // Task 1
    private fun singleNumber(nums: IntArray): Int {
        var result = 0
        for (num in nums) {
            result = result xor num
        }
        return result
    }

    // Task 2
    private fun minSplit(amount: Int): Int {
        var amount1 = amount
        val coins = intArrayOf(50, 20, 10, 5, 1)
        var minCoins = 0

        for (coin in coins) {
            while (amount1 >= coin) {
                amount1 -= coin
                minCoins++
            }
        }

        return minCoins
    }

    // Task 3
    private fun longestPrefix(array: Array<String>): String {
        if (array.isEmpty()) {
            return ""
        }

        var prefix = array[0]
        for (i in 1..< array.size) {
            while (!array[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.lastIndex)
                if (prefix.isEmpty()) {
                    return ""
                }
            }
        }

        return prefix
    }

    // Task 4
    private fun addBinary(a: String, b: String): String {
        var carry = 0
        var i = a.length - 1
        var j = b.length - 1
        val result = StringBuilder()

        while (i >= 0 || j >= 0 || carry > 0) {
            var sum = carry
            if (i >= 0) sum += a[i--] - '0'
            if (j >= 0) sum += b[j--] - '0'
            result.insert(0, sum % 2)
            carry = sum / 2
        }

        return result.toString()
    }


    // Task 5
    private fun countVariants(stairsCount: Int): Int {
        if (stairsCount <= 1) return stairsCount
        var prev = 1
        var curr = 1

        for (i in 2..stairsCount) {
            val next = prev + curr
            prev = curr
            curr = next
        }
        return curr
    }

    // Task 6
    class CustomDataStructure {
        private val set = HashSet<Int>()
        private val map = LinkedHashMap<Int, Int>()

        fun insert(value: Int) {
            if (!set.contains(value)) {
                map[value] = map.size
                set.add(value)
            }
        }

        fun delete(value: Int) {
            if (set.contains(value)) {
                val index = map[value] ?: return
                set.remove(value)
                map.remove(value)
                for ((k, v) in map) {
                    if (v > index) {
                        map[k] = v - 1
                    }
                }
            }
        }

        fun printData() {
            println("Set: $set")
            println("Map: $map")
        }
    }
}
