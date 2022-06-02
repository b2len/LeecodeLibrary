class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        Set<Integer> set = new HashSet<>();
        set.add(0);

        int count = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int k : rooms.get(curr)) {
                if (!set.contains(k)) {
                    set.add(k);
                    q.offer(k);
                }
            }
            count++;
        }
        return count == rooms.size() ? true : false;
    }
}