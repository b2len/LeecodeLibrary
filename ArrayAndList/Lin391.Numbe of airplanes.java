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
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        // Scan the array, assign the beginning and ending time with a node, then use
        // cost to indicate taking off and landing
        List<Node> room = new ArrayList<Node>();
        for (int i = 0; i < airplanes.size(); i++) {
            room.add(new Node(airplanes.get(i).start, 1));
            room.add(new Node(airplanes.get(i).end, -1));
        }

        // Collections.sort method is sorting the elements of ArrayList in ascending
        // order
        Collections.sort(room, cNode);
        int ans = 0;
        int tmp = 0;
        // going throgh the list, the tmp will increase by 1 if there's a plane took
        // off, minus by 1 if there's a plance landed
        // use ans to record the largest number of planes in the air
        for (int i = 0; i < room.size(); i++) {
            tmp += room.get(i).cost;
            ans = Math.max(ans, tmp);
        }
        return ans;
    }

    static class Node {
        public int time;
        public int cost;

        public Node() {
        }

        // The beginning time's cost is 1, the ending time's cost is -1
        public Node(int time, int cost) {
            this.time = time;
            this.cost = cost;
        }
    }

    // sort the element by time first, then by cost
    static Comparator<Node> cNode = new Comparator<Node>() {
        public int compare(Node o1, Node o2) {
            if (o1.time != o2.time) {
                return o1.time - o2.time;
            } else {
                return o1.cost - o2.cost;
            }
        }

    };
}