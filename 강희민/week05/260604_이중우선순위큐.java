import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        Map<Integer, Integer> count = new HashMap<>();

        for (String operation : operations) {
            String[] parts = operation.split(" ");

            String command = parts[0];
            int number = Integer.parseInt(parts[1]);

            if (command.equals("I")) {
                minHeap.add(number);
                maxHeap.add(number);

                count.put(number, count.getOrDefault(number, 0) + 1);
            } else {
                if (number == 1) {
                    delete(maxHeap, count);
                } else {
                    delete(minHeap, count);
                }
            }
        }

        clean(minHeap, count);
        clean(maxHeap, count);

        if (minHeap.isEmpty() || maxHeap.isEmpty()) {
            return new int[]{0, 0};
        }

        return new int[]{maxHeap.peek(), minHeap.peek()};
    }

    private void delete(PriorityQueue<Integer> heap, Map<Integer, Integer> count) {
        clean(heap, count);

        if (heap.isEmpty()) {
            return;
        }

        int number = heap.poll();

        count.put(number, count.get(number) - 1);
    }

    private void clean(PriorityQueue<Integer> heap, Map<Integer, Integer> count) {
        while (!heap.isEmpty() && count.getOrDefault(heap.peek(), 0) == 0) {
            heap.poll();
        }
    }
}