import java.util.List;

public class NewYearChaos {
    public static void minimumBribes(List<Integer> q) {
        int totalBribes = 0;
        
        for (int i = q.size() - 2; i >= 0; i--) {
            
            int j = i + 1;
            int currentBribes = 0;
            
            while (j < q.size() && q.get(j) < q.get(j - 1)) {
                
                swap(q, j - 1, j);
                
                if (currentBribes >= 2) {
                    System.out.println("Too chaotic");
                    return;
                } else {
                    currentBribes++;
                }
                
                j++;
            }
            
            totalBribes += currentBribes;
        }
        System.out.println(totalBribes);
    }
    
    private static void swap(List<Integer> q, int i, int j) {
        int temp = q.get(i);
        q.set(i, q.get(j));
        q.set(j, temp);
    }
}
