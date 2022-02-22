class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        LinkedList<int[]> result = new LinkedList<>();

        for (int[] interval : intervals) {

            // if newInterval before the element, insert the newInterval & update the
            // interval as new interval
            if (interval[0] > newInterval[1]) {
                result.add(newInterval);
                newInterval = interval;
            }

            // if interval is lesser than newInterval insert the interval;
            if (interval[1] < newInterval[0])
                result.add(interval);

            // else if means there's an overlap, merge the two but do not insert it yet!

            else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }

        // insert the last newInterval
        result.add(newInterval);

        // convert to int[][] array
        return result.toArray(new int[result.size()][]);

    }
}