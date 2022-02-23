class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int n1 = firstList.length;
        int n2 = secondList.length;
        List<int[]> ans = new ArrayList();
        int i = 0, j = 0;

        while (i < n1 && j < n2) {
            // Check if there's an overlap
            // lo - the start point of the intersection
            // hi - the end point of the intersection

            int lo = Math.max(firstList[i][0], secondList[j][0]);
            int hi = Math.min(firstList[i][1], secondList[j][1]);
            if (lo <= hi) {
                ans.add(new int[] { lo, hi });
            }

            // Remove the interval with the smallest endpoint
            if (firstList[i][1] < secondList[j][1])
                i++;
            else
                j++;
        }
        return ans.toArray(new int[ans.size()][]);
    }

}

/**
 * //corner cases
 * 
 * //merge the two lists together in ascending order
 * int n1 = firstList.length;
 * int n2 = secondList.length;
 * LinkedList<int[]> merged = new LinkedList<>();
 * int i = 0;
 * int j = 0;
 * while (i < n1 && j < n2) {
 * if (firstList[i][0] < secondList[j][0]) {
 * merged.add(firstList[i]);
 * i++;
 * }
 * else if (firstList[i][0] == secondList[j][0]) {
 * if (firstList[i][1] <= secondList[j][1]) {
 * merged.add(firstList[i]);
 * i++;
 * } else {
 * merged.add(secondList[j]);
 * j++;
 * }
 * } else {
 * merged.add(secondList[j]);
 * j++;
 * }
 * }
 * 
 * // add the remaining element
 * while (i < n1) {
 * merged.add(firstList[i]);
 * i++;
 * }
 * while (j < n2) {
 * merged.add(secondList[j]);
 * j++;
 * }
 * 
 * //
 * LinkedList<int[]> result = new LinkedList<>();
 * 
 * for (int index = 0; index < merged.size() - 1; index++) {
 * int k = 1;
 * while (merged.get(index)[1] >= merged.get(index + k)[1] && k <= n1 + n2 -
 * index) {
 * int[] overlap = merged.get(index + k);
 * result.add(overlap);
 * k++;
 * }
 * 
 * if (merged.get(index)[1] >= merged.get(index + 1)[0] && (merged.get(index)[1]
 * < merged.get(index + 1)[1])) {
 * int[] overlap = {merged.get(index + 1)[0], merged.get(index)[1]};
 * result.add(overlap);
 * }
 * }
 * return result.toArray(new int[result.size()][]);
 * }
 * 
 */