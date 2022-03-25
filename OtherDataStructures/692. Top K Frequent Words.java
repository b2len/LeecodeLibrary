class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // corner cases
        if (words == null || words.length == 0 || k <= 0)
            return null;
        List<String> result = new LinkedList<>();
        // count the frequency in words
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!map.containsKey(word))
                map.put(word, 1);
            else
                map.put(word, map.get(word) + 1);
        }

        // THIS IS THE KEY: if two string have the same count, then compare their string
        // value, using existing compareTo method
        // if two string have different count, then the higher count is place in the end
        // of queue in the minheap
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (s1, s2) -> s1.getValue() == s2.getValue() ? s2.getKey().compareTo(s1.getKey())
                        : s1.getValue() - s2.getValue());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            // if there's more than k element in the heap, throw out the smallest one (first
            // one in minheap)
            if (pq.size() > k)
                pq.poll();
        }

        while (!pq.isEmpty())
            // Inserts the specified element at the specified position in this list.
            // Shifts the element currently at that position (if any) and any subsequent
            // elements to the right (adds one to their indices).
            result.add(0, pq.poll().getKey());

        return result;
    }
}

/**
 * My own attempt
 * // put the word with k counts in a heap in lexicographical order
 * PriorityQueue<String> queue = new PriorityQueue<>(words.length, new
 * Comparator<String>() {
 * 
 * @Override
 *           public int compare(String s1, String s2) {
 *           for (int i = 0, j = 0; i < s1.length() && j < s2.length(); i++,
 *           j++) {
 *           if (s1.charAt(i) != s2.charAt(j)) {
 *           if (s1.charAt(i) < s2.charAt(j)) return -1;
 *           else return 1;
 *           }
 *           }
 *           return 0;
 *           }
 *           });
 * 
 *           // put all words in lexigraphical order
 *           for (String word : map.keySet()) {
 *           queue.add(word);
 *           }
 *           // put all the ordered words by frequency
 *           PriorityQueue<String> topk = new PriorityQueue<>((s1, s2) ->
 *           map.get(s2) - map.get(s1));
 *           while (!queue.isEmpty()) {
 *           topk.add(queue.poll());
 *           }
 *           // pull the first k to reture to result
 *           List<String> result = new LinkedList<>();
 *           for (int i = 0; i < k; i++) {
 *           result.add(topk.poll());
 *           }
 * 
 *           return result;
 */