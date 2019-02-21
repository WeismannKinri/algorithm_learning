package codility.CountingElements;

import java.util.LinkedList;
import java.util.List;

public class MaxCounters {
    public static void main(String[] args) {
        int [] array = new int[]{3, 4, 4, 6, 1, 4, 4};
        System.out.println(solution(5,array));
    }
    public static int[] solution(int N, int[] A){
        int P [] = new int [N];
        int max = 0;
        int lastUpdate = 0;

        for (int i=0;i<A.length;i++){
            if (A[i] < N+1){
                if (P[A[i]-1] < lastUpdate){
                    P[A[i]-1] = lastUpdate + 1;
                }else{
                    P[A[i]-1]++;
                }
                max = Math.max(max, P[A[i]-1]);
            }else if (A[i] == N+1){
                lastUpdate = max;
            }
        }

        for(int i = 0; i < N; i++){
            if(P[i] < lastUpdate){
                P[i] = lastUpdate;
            }
        }
        return P;

    }
}
