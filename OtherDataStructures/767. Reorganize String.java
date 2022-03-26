class Solution {
    public String reorganizeString(String s) {
        // corner cases
        if (s == null || s.length() == 0)
            return "";
        StringBuilder res = new StringBuilder();
        // Use hashtable to count the frequency
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Build the MaxHeap
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());

        // Have a prev item to keep the highest frequency item
        Map.Entry<Character, Integer> prev = null;

        while (!pq.isEmpty()) {
            // add the most frequency char first
            Map.Entry<Character, Integer> entry = pq.poll();
            res.append((char) entry.getKey());
            entry.setValue(entry.getValue() - 1);
            // put the previous popped item back to the heap
            if (prev != null && prev.getValue() > 0) {
                pq.offer(prev);
            }
            prev = entry;
        }
        return (res.length() == s.length()) ? res.toString() : "";

    }
}