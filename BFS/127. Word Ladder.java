class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord))
            return 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        // q.add(beginWord);
        int changes = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) { // why cannot use q.size() directly in the condition?
                String word = q.poll();
                if (word.equals(endWord))
                    return changes;
                // change each letter one by one
                for (int j = 0; j < word.length(); j++) {
                    for (int k = 'a'; k <= 'z'; k++) { // leverage the char code for alphabets
                        char arr[] = word.toCharArray();
                        arr[j] = (char) k; // create 26 versions of words for each letter
                        // check the newly generated string to see fits
                        String str = new String(arr);
                        if (set.contains(str) && !visited.contains(str)) {
                            q.add(str);
                            visited.add(str);
                        }
                    }
                }
            }
            ++changes;
        }
        return 0;
    }
}