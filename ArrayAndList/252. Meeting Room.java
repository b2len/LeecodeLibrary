/**
 * Definition of Interval:
 * public classs Interval {
 * int start, end;
 * Interval(int start, int end) {
 * this.start = start;
 * this.end = end;
 * }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Corner cases
        if (intervals == null || intervals.size() == 0) {
            return true;
        }
        // Sort the list in ascending order
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        // check if there's overlap;
        for (int i = 0; i < intervals.size() - 1; i++) {
            // special case of meetings start at the same time
            if (intervals.get(i).start == intervals.get(i + 1).start)
                return false;
            // any overlap means it cannot attend all meetings
            if (intervals.get(i).end > intervals.get(i + 1).start)
                return false;
        }
        return true;

    }

}