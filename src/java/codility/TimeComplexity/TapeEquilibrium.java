package codility.TimeComplexity;

public class TapeEquilibrium {
    public int solution(int[] A) {
        // write your code in Java SE 8
        // write your code in Java SE 8
        int total = 0;

        for (int i = 0; i < A.length; i++)
            total += A[i];

        int diff = Integer.MAX_VALUE;
        int prev = 0;
        int next = total;

        for (int p = 1; p < A.length; p++) {
            prev += A[p - 1];
            next = total - prev;
            diff = Math.min(diff, Math.abs(prev - next));
        }

        return diff;
    }
}
