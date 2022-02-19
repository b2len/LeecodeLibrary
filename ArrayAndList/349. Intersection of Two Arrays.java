class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // create two sets, one to get unique value of one array, the other record the
        // duplicates
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer> intersect = new HashSet<Integer>();

        // put all unique value of nums1 into set
        for (int num : nums1) {
            set.add(num);
        }

        // put all intersect value of nums1 and nums2 into intersect
        for (int num : nums2) {
            if (set.contains(num)) {
                intersect.add(num);
            }
        }

        // create an array and loop through the set to get all element into the array
        int[] result = new int[intersect.size()];
        int i = 0;
        for (int num : intersect) {
            result[i++] = num;
        }

        return result;

    }
}