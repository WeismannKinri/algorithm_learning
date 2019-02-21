package codility.CountingElements;

public class FrogRiverOne {
    public int solution(int X, int[] A){
        boolean[] seen = new boolean[X];
        int index = -1;
        for(int i=0;i<A.length;i++){
            if(A[i]<=X && seen[A[i]-1]!=true) {
                seen[A[i]-1] = true;
                index=i;
            }
        }

        for(int j=0;j<X;j++){
            if(seen[j]==false)
                return -1;
        }

        return index;
    }
}
