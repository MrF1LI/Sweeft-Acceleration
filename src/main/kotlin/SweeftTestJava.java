import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class SweeftTestJava {
    public static void main(String[] args) {
        SweeftTestJava sweeftTestJava = new SweeftTestJava();

        // Task 1
        int[] nums = {2, 2, 1};
        int singleNumberResult = sweeftTestJava.singleNumber(nums);
        System.out.println("Task 1 - Single Number: " + singleNumberResult);

        // Task 2
        int amount = 76;
        int minSplitResult = sweeftTestJava.minSplit(amount);
        System.out.println("Task 2 - Minimum Split: " + minSplitResult);

        // Task 3
        String[] words = {"extract", "exhale", "excavate"};
        String longestPrefixResult = sweeftTestJava.longestPrefix(words);
        System.out.println("Task 3 - Longest Prefix: " + longestPrefixResult);

        // Task 4
        String a = "1010";
        String b = "1011";
        String addBinaryResult = sweeftTestJava.addBinary(a, b);
        System.out.println("Task 4 - Binary Sum: " + addBinaryResult);

        // Task 5
        int stairsCount = 5;
        int countVariantsResult = sweeftTestJava.countVariants(stairsCount);
        System.out.println("Task 5 - Count Variants: " + countVariantsResult);

        // Task 6
        CustomDataStructureJava customDataStructure = new CustomDataStructureJava();
        customDataStructure.insert(5);
        customDataStructure.insert(10);
        customDataStructure.insert(15);
        customDataStructure.delete(10);
        customDataStructure.printData();
    }

    // Task 1
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    // Task 2
    public int minSplit(int amount) {
        int[] coins = {50, 20, 10, 5, 1};
        int minCoins = 0;

        for (int coin : coins) {
            while (amount >= coin) {
                amount -= coin;
                minCoins++;
            }
        }

        return minCoins;
    }

    // Task 3
    public String longestPrefix(String[] array) {
        if (array == null || array.length == 0) {
            return "";
        }

        String prefix = array[0];
        for (String word : array) {
            while (!word.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    // Task 4
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            result.insert(0, sum % 2);
            carry = sum / 2;
        }
        return result.toString();
    }

    // Task 5
    public int countVariants(int stairsCount) {
        if (stairsCount <= 1) return 1;
        int prev = 1, curr = 1;
        for (int i = 2; i <= stairsCount; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    // Task 6
    static class CustomDataStructureJava {
        private final Set<Integer> set = new HashSet<>();
        private final Map<Integer, Integer> map = new LinkedHashMap<>();

        public void insert(int value) {
            if (!set.contains(value)) {
                map.put(value, map.size());
                set.add(value);
            }
        }

        public void delete(int value) {
            if (set.contains(value)) {
                int index = map.getOrDefault(value, -1);
                set.remove(value);
                map.remove(value);
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    int key = entry.getKey();
                    int val = entry.getValue();
                    if (val > index) {
                        map.put(key, val - 1);
                    }
                }
            }
        }

        public void printData() {
            System.out.println("Set: " + set);
            System.out.println("Map: " + map);
        }
    }
}
