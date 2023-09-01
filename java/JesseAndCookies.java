import java.util.List;
import java.util.PriorityQueue;

public class JesseAndCookies {

    public static int cookies(int k, List<Integer> A) {
        if (A.isEmpty()) {
            return -1;
        }

        PriorityQueue<Integer> sweetnesses = new PriorityQueue<>(A);
        Integer leastSweet = sweetnesses.poll();
        int operations = 0;

        while (leastSweet != null && leastSweet < k) {
            Integer secondLeastSweet = sweetnesses.poll();

            if (secondLeastSweet == null) {
                return -1;
            }

            sweetnesses.add(leastSweet + (secondLeastSweet * 2));
            operations++;
            leastSweet = sweetnesses.poll();
        }

        return operations;
    }
}
