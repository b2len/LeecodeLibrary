class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort the intervals by their start value,
        // then each set of intervals that can be merged will appear as a contiguous
        // "run" in the sorted list

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Use a linkedlist data structure to record the merged result
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged interval is empty or if the current interval does not
            // overlap with the previous
            // simple just append it
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}