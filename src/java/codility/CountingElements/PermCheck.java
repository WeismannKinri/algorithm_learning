package codility.CountingElements;

public class PermCheck {
    public static void main(String[] args) {
        int [] array = new int[]{1,2,1};
        System.out.println(solution(array));
    }

    public static int solution(int[] A){

        boolean[] seen = new boolean[A.length + 1];
        // repeated elements
        for (int i = 0; i < A.length; i++) {
            if(A[i] < 1 || A[i] > A.length) return 0;
            if(seen[A[i]] == true) return 0;
            else seen[A[i]] = true;
        }
        return 1;
    }
}