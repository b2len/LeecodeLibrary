class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        // corner case
        if (nums == null || nums.length == 0)
            return nums;

        // Use Hashmap to keep track of count
        Map<Integer, Integer> table = new HashMap<>();
        // Use a list to track unique nums and then sort them
        List<Integer> list = new ArrayList<>();

        // Loop through the array to get the frequency
        for (int num : nums) {
            if (table.containsKey(num)) {
                table.put(num, table.get(num) + 1);
            } else {
                table.put(num, 1);
            } // Short version: table.put(num, table.getOrDefault(num, 0) + 1);

            // Add uique nums to list
            if (!list.contains(num))
                list.add(num);
        }

        // Sort list by greatest count to least
        Collections.sort(list, (Integer a, Integer b) -> table.get(b) - table.get(a)); // https://howtodoinjava.com/java/sort/collections-sort/

        // convert 0 - k item in the list to array a list containing only up to K
        // elements
        return convertIntegers(list.subList(0, k));
    }

    public int[] convertIntegers(List<Integer> integers) {
        int[] result = new int[integers.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = integers.get(i).intValue();
        }
        return result;
    }

}